package review.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import review.model.service.ReviewService;
import review.model.vo.Review;

/**
 * Servlet implementation class ReviewUpdateServlet
 */
@WebServlet("/rupdate")
public class ReviewUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. multipart 방식으로 인코딩되어서 전송왔는지 확인
				// 아니면 에러 페이지를 내보냄
				RequestDispatcher view = null;
				if (!ServletFileUpload.isMultipartContent(request)) {
					view = request.getRequestDispatcher("views/common/error.jsp");
					request.setAttribute("message", "form 의 enctype='multipart/form-data' 속성 누락됨.");
					view.forward(request, response);
				}

				// 2. 업로드할 파일의 용량제한 : 10메가바이트로 제한한다면
				int maxSize = 1024 * 1024 * 10;

				// 3. 업로드되는 파일의 저장 폴더 지정
				String savePath = request.getSession().getServletContext().getRealPath("/resources/review_upfiles");

				// 4. request 를 MultipartRequest 로 변환해야 함
				// cos.jar 가 제공하는 클래스를 사용
				// MultipartRequest 객체가 생성되면,
				// 자동으로 폴더에 파일이 저장됨
				MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
						new DefaultFileRenamePolicy());

				
				// mrequest 사용해야 함 (request 사용 못 함)
				Review review = new Review();
				
				review.setReviewName(mrequest.getParameter("reviewname"));
				review.setScore(Integer.parseInt(mrequest.getParameter("score")));
				review.setKeyword(mrequest.getParameter("keyword"));
				review.setReviewContent(mrequest.getParameter("content"));
				review.setReviewCd(Integer.parseInt(mrequest.getParameter("rcd")));


				// 이전 첨부파일에 대한 삭제여부 값 추출
				String deleteFlag = mrequest.getParameter("deleteFlag");

				// 이전 첨부파일의 파일명 추출
				String revieworiginalfile = mrequest.getParameter("ofile");
				String reviewrenamefile = mrequest.getParameter("rfile");

				// 새로운 첨부파일명 추출
				String originalFileName = mrequest.getFilesystemName("upfile");

				// 첨부파일 확인 :
				// 원래 파일과 새로 업로드된 파일의 이름이 같고,
				// 파일 용량도 동일하면 원래 이름 그대로 notice 에 기록함
				// 업로드된 파일의 File 객체 만들기
				File newOriginFile = new File(savePath + "\\" + originalFileName);
				File originFile = new File(savePath + "\\" + reviewrenamefile);

				if(revieworiginalfile != null && originalFileName == null && revieworiginalfile.equals("null")) {
					//원래 첨부파일이 없었는데 파일등록 하지 않은 경우
					review.setReviewOriginalFile(null);
					review.setReviewRenameFile(null);
				}
				
				// 첨부파일이 없었는데 추가된 경우와
				// 첨부파일이 있었는데 변경된 경우 둘 다 해당됨
				else if (originalFileName != null) {
					// 새로 업로드된 파일이 있다면
					review.setReviewOriginalFile(originalFileName);

					// 새로 업로드된 파일의 이름바꾸기
					// 바꿀 파일명에 대한 문자열 만들기
					// 공지글 등록 요청 시점의 날짜정보를 이용함
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

					// 변경할 파일명 만들기
					String renameFileName = sdf.format(new java.sql.Date(System.currentTimeMillis()));
					// 원본 파일의 확장자를 추출해서, 변경 파일명에 붙여줌
					renameFileName += "." + originalFileName.substring(originalFileName.lastIndexOf(".") + 1);

					// 파일명 바꾸기 실행함 : java.io.File 을 이용함			
					File renameFile = new File(
							savePath + "\\" + renameFileName);

					if (!newOriginFile.renameTo(renameFile)) {
						// renameTo() 메소드가 실패한 경우(false)
						// 직접 수동으로 바꾸기함
						// 원본 파일 읽어서 파일복사하고,
						// 원본 파일 삭제로 처리함

						FileInputStream fin = new FileInputStream(newOriginFile);
						FileOutputStream fout = new FileOutputStream(renameFile);

						int data = -1;
						byte[] buffer = new byte[1024];

						while ((data = fin.read(buffer, 0, buffer.length)) != -1) {
							fout.write(buffer, 0, buffer.length);
						}

						fin.close();
						fout.close();
						newOriginFile.delete(); // 새로 업로드된 원본 파일 삭제함
					} // 직접 이름바꾸기

					review.setReviewRenameFile(renameFileName);
					
					//이전 첨부파일이 있었다면 삭제함
					if(revieworiginalfile != null) {
						originFile.delete();
					}
				}

				else if(revieworiginalfile != null && deleteFlag != null 
						&& deleteFlag.equals("yes")) {
					//원래 첨부파일이 있었는데 파일삭제가 선택된 경우
					review.setReviewOriginalFile(null);
					review.setReviewRenameFile(null);
					
					//폴더에 저장된 파일도 삭제함
					originFile.delete();
				}
				

				else if(revieworiginalfile != null && 
						(originalFileName != null || 
								revieworiginalfile.equals(originalFileName) && 
						newOriginFile.length() == originFile.length())) {
					//원래 첨부파일이 있었는데 새로 첨부된 파일과 다르지 않은 경우
					review.setReviewOriginalFile(revieworiginalfile);
					review.setReviewRenameFile(reviewrenamefile);
				}

				else if(revieworiginalfile != null && originalFileName == null) {
					//원래 첨부파일이 있었는데 변경되지 않은 경우
					review.setReviewOriginalFile(revieworiginalfile);
					review.setReviewRenameFile(reviewrenamefile);
				}			

				// 6. 서비스 메소드로 전달하고 결과받기
				int result = new ReviewService().updateReview(review);

				// 7. 받은 결과로 성공/실패 페이지 내보내기
				if (result > 0) {
					response.sendRedirect("rmylist");
				} else {
					view = request.getRequestDispatcher("views/common/error.jsp");
					request.setAttribute("message", 
							review.getReviewName() + "수정 실패!");
					view.forward(request, response);
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

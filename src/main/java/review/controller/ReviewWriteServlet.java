package review.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
 * Servlet implementation class ReviewWriteServlet
 */
@WebServlet("/rwrite")
public class ReviewWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReviewWriteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		request.setCharacterEncoding("utf-8");
		
		RequestDispatcher view = null;
		if(!ServletFileUpload.isMultipartContent(request)) {
			view = request.getRequestDispatcher(
					"views/common/error.jsp");
			request.setAttribute("message", 
				"form 의 enctype='multipart/form-data' 속성 누락됨.");
			view.forward(request, response);
		}
		
		//2. 업로드할 파일의 용량제한 : 10메가바이트로 제한한다면
				int maxSize = 1024 * 1024 * 10;
				
				//3. 업로드되는 파일의 저장 폴더 지정
				String savePath = request.getSession()
						.getServletContext().getRealPath(
								"/resources/review_upfiles");
				
				MultipartRequest mrequest = new MultipartRequest(
						request, savePath, maxSize, "UTF-8", 
						new DefaultFileRenamePolicy());

	
		Review review = new Review();

		String booknm = mrequest.getParameter("bkname");
		review.setReviewName(mrequest.getParameter("reviewname"));
		review.setReviewWriterId(mrequest.getParameter("reviewwriterid"));
		review.setScore(Integer.parseInt(mrequest.getParameter("score")));
		review.setReviewContent(mrequest.getParameter("content"));


		// checkbox 전송형태 :
		// hobby=game&hobby=reading&hobby=cook
		String[] keywords = mrequest.getParameterValues("keyword");
		// 문자열배열을 하나의 String 으로 변환함, 구분자는 "," 사용한다면
		String keyword = String.join(",", keywords);
		review.setKeyword(keyword);
		
		String reviewOriginalFile = mrequest.getFilesystemName("ofile");
		review.setReviewOriginalFile(reviewOriginalFile);
		
		if(reviewOriginalFile != null) {
			//업로드된 파일이 있을 때만 파일명 바꾸기함
			
			//바꿀 파일명에 대한 문자열 만들기
			//공지글 등록 요청 시점의 날짜정보를 이용함
			SimpleDateFormat sdf = new SimpleDateFormat(
					"yyyyMMddHHmmss");
			
			//변경할 파일명 만들기
			String reviewRenameFile = sdf.format(
					new java.sql.Date(System.currentTimeMillis()));
			//원본 파일의 확장자를 추출해서, 변경 파일명에 붙여줌
			reviewRenameFile += "." + reviewOriginalFile.substring(
					reviewOriginalFile.lastIndexOf(".") + 1);
			
			//파일명 바꾸기 실행함 : java.io.File 을 이용함
			File originFile = new File(
					savePath + "\\" + reviewOriginalFile);
			File renameFile = new File(
					savePath + "\\" + reviewRenameFile);
			
			if(!originFile.renameTo(renameFile)) {
				//renameTo() 메소드가 실패한 경우(false)
				//직접 수동으로 바꾸기함
				//원본 파일 읽어서 파일복사하고, 
				//원본 파일 삭제로 처리함
				
				FileInputStream fin = new FileInputStream(
						originFile);
				FileOutputStream fout = new FileOutputStream(
						renameFile);
				
				int data = -1;
				byte[] buffer = new byte[1024];
				
				while((data = fin.read(buffer, 0, buffer.length)) != -1) {
					fout.write(buffer, 0, buffer.length);
				}
				
				fin.close();
				fout.close();
				originFile.delete();  //원본 파일 삭제함
			}  //직접 이름바꾸기
			
			review.setReviewRenameFile(reviewRenameFile);
		}  //업로드된 파일이 있다면...
	

		// 3. 서비스쪽 메소드로 값 전달하면서 실행하고, 결과받기
		int result = new ReviewService().insertReview(review, booknm);

		// 4. 받은 결과에 따라 성공/실패 페이지를 내보냄
		if (result > 0) {
			// 로그인 페이지로 이동 처리
			response.sendRedirect("/bookjeok/views/review/ReviewMainView.jsp");
		} else {
			// error.jsp 로 에러메세지를 내보냄
			// 상대경로만 사용할 수 있음.
			view = request.getRequestDispatcher("views/common/error.jsp");

			// 지정한 뷰로 내보낼 정보나 객체가 있다면
			// request 에 기록함 : setAttribute(String key, Object value)
			request.setAttribute("message", "리뷰 등록 실패!");

			// 뷰 내보냄
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

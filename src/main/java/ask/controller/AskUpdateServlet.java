package ask.controller;

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

import ask.model.service.AskService;
import ask.model.vo.Ask;

/**
 * Servlet implementation class AskUpdateServlet
 */
@WebServlet("/aupdate")
public class AskUpdateServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public AskUpdateServlet() {
      super();
      // TODO Auto-generated constructor stub
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // 게시 원글 회원 수정 처리용 컨트롤러
      // 1. multipart/form-data 방식으로 인코딩되어서 전송 확인 아니면 에러 페이저 내보냄
      RequestDispatcher view = null;
      if (!ServletFileUpload.isMultipartContent(request)) {
         view = request.getRequestDispatcher("views/common/error.jsp");
         request.setAttribute("message", "form 의 enctype='multipart/form-data' 속성 누락됨.");
         view.forward(request, response);
      }
      // 2. 업로드할 파일의 용량제한 : 10메가바이트로 제한한다면
      int maxSize = 1024 * 1024 * 10;

      // 3. 업로드되는 파일의 저장 폴더 지정
      String savePath = request.getSession().getServletContext().getRealPath("/resources/ask_upfiles");

      // 4. request 를 MultipartRequest 로 변환 해야 함 cos.jar가 제공하는 클래스를 사용
      // MultipartRequest 객체가 생성되면, 자동으로 폴더에 파일이 저장
      MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
            new DefaultFileRenamePolicy());

      // 5. 데이터베이스 notice 테이블에 기록할 값 추출 mrequest 사용 (request 사용 못함)
      Ask ask = new Ask();

      ask.setAskNum(Integer.parseInt(mrequest.getParameter("askNum")));
      ask.setAskTitle(mrequest.getParameter("title"));
      ask.setAskWriterId(mrequest.getParameter("writer"));
      ask.setAskContent(mrequest.getParameter("content"));

      // 이전 첨부파일에 대한 삭제 여부 값 추출
      String deleteFlag = mrequest.getParameter("deleteFlag");
      //System.out.println("deleteFlag : " + deleteFlag + ", " + deleteFlag.length());

      // 이전 첨부파일의 파일명 추출
      String AskOriginalFile = mrequest.getParameter("afile");
      String AskRenameFile = mrequest.getParameter("rfile");
      System.out.println("afile : " + AskOriginalFile);

      // 새로운 첨부파일명 추출
      String originalFileName = mrequest.getFilesystemName("upfile");

      // 첨부파일 확인 : 본 파일과 새로 업로드 된 파일의 이름이 같고,
      // 파일 용량도 동일하면 본 이름 그대로 ask에 기록 업로드된 파일의 FIle 객체 만들기
      File newOriginFile = new File(savePath + "\\" + originalFileName);
      File originFile = new File(savePath + "\\" + AskRenameFile);

      if (AskOriginalFile != null && deleteFlag != null && deleteFlag.equals("yes")) {
         System.out.println("delete");
         // 원래 첨부파일이 있었는데 파일삭제가 선택된 경우
         ask.setAskOriginalFile(null);
         ask.setAskRenameFile(null);
         // 폴더 저장된 파일도 삭제
         originFile.delete();
      } else if (AskOriginalFile != null && AskOriginalFile.equals("null") && originalFileName == null) {
          System.out.println("nochange");
          // 원래 첨부파일이 없었는데 변경되지 않는 경우
          ask.setAskOriginalFile(null);
          ask.setAskRenameFile(null);
      } else if (AskOriginalFile != null && originalFileName == null) {
         System.out.println("nochange");
         // 원래 첨부파일이 있었는데 변경되지 않는 경우
         ask.setAskOriginalFile(AskOriginalFile);
         ask.setAskRenameFile(AskRenameFile);
      } 
      
      if (originalFileName != null) {  // 첨부파일이 없었는데 추가된 경우와 첨부파일이 있었는데 변경된 경우 둘다 해당
         ask.setAskOriginalFile(originalFileName);// 새로 업로드된 파일이 있다면

         // 새로 업로드된 파일의 이름바꾸기 바꿀 파일명에 대한 문자열 만들기 공지글 등록 요청 시점의 날짜정보 이용
         SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

         // 변경할 파일명 만들기
         String renameFileName = sdf.format(new java.sql.Date(System.currentTimeMillis()));

         // 원본 파일의 확장자를 추출해서, 변경 파일명에 붙여줌
         renameFileName += "." + originalFileName.substring(originalFileName.lastIndexOf(".") + 1);

         // 파일명 바꾸기 실행 : java.io.File 이용
         File renameFile = new File(savePath + "\\" + renameFileName);

         if (!newOriginFile.renameTo(renameFile)) {
            // renameTo() 메소드가 실패한 경우 (false) 직접 수동으로 변경 원본 파일에서 읽어서 파일복사 후 원본파일 삭제 처리
            FileInputStream fin = new FileInputStream(newOriginFile);
            FileOutputStream fout = new FileOutputStream(renameFile);

            int data = -1;
            byte[] buffer = new byte[1024];
            
            while ((data = fin.read(buffer, 0, buffer.length)) != -1) {
               fout.write(buffer, 0, buffer.length);
            }
            fin.close();
            fout.close();
            newOriginFile.delete(); // 새로 업로드된 원본 파일 삭제
         } // 직접 이름 바꾸기
         ask.setAskRenameFile(renameFileName);

         // 이전 첨부파일이 있었다면 삭제
         if (AskOriginalFile != null) {
            originFile.delete();
         }else if (AskOriginalFile != null && (AskRenameFile != null || AskRenameFile.equals(originalFileName) && newOriginFile.length() == originFile.length())) {
            System.out.println("equals");
            // 본 첨부파일이 있었는데 새로 첨부된 파일과 다르지 않는 경우
            ask.setAskOriginalFile(AskOriginalFile);
            ask.setAskRenameFile(AskRenameFile);
         }
      }
      
      // 6. 서비스 메소드로 전달하고 결과받기
      int result = new AskService().updateAsk(ask);

      // 7. 받은 결과로 성공/실패 페이지 내보내기
      if (result > 0) {
         response.sendRedirect("alist");
      } else {
         view = request.getRequestDispatcher("views/common/error.jsp");
         request.setAttribute("message", ask.getAskNum() + "번 공지글 수정 실패!");
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
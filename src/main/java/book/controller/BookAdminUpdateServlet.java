package book.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import book.model.service.BookService;
import book.model.vo.Book;

/**
 * Servlet implementation class BookAdminInsertServlet
 */
@WebServlet("/bkupdate.ad")
public class BookAdminUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookAdminUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 상품 수정 처리용 컨트롤러
		
		// 파일업로드가 있는 전송인 경우임
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
		String savePath = request.getSession().getServletContext().getRealPath("/resources/book_img");

		// 4. request 를 MultipartRequest 로 변환해야 함
		// cos.jar 가 제공하는 클래스를 사용
		// MultipartRequest 객체가 생성되면,
		// 자동으로 폴더에 파일이 저장됨
		MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
				new DefaultFileRenamePolicy());

		// 5. 데이터베이스 book 테이블에 기록할 값 추출
		// mrequest 사용해야 함 (request 사용 못 함)
		Book book = new Book();

		book.setBookId(Integer.parseInt(mrequest.getParameter("bookid")));
		book.setBookCateCd(Integer.parseInt(mrequest.getParameter("bookcatecd")));
		book.setBookTypeNum(Integer.parseInt(mrequest.getParameter("booktypenum")));
		book.setBookLocNum(Integer.parseInt(mrequest.getParameter("booklocnum")));

		book.setBookNm(mrequest.getParameter("booknm"));
		book.setIsbn(Integer.parseInt(mrequest.getParameter("isbn")));
		book.setRanking(Integer.parseInt(mrequest.getParameter("ranking")));
		book.setBookIntro(mrequest.getParameter("bookintro"));
		book.setAuthor(mrequest.getParameter("author"));
		book.setAuthorIntro(mrequest.getParameter("authorintro"));
		book.setBookPrice(Integer.parseInt(mrequest.getParameter("bookprice")));
		book.setAvgScore(Integer.parseInt(mrequest.getParameter("avgscore")));
		book.setPublisher(mrequest.getParameter("publisher"));
		book.setPublishDate(Date.valueOf(mrequest.getParameter("publishdate")));
		book.setBookIndex(mrequest.getParameter("bookindex"));
		
		// 이전 첨부파일의 파일명 추출
		String BookOriginalFile = mrequest.getParameter("bfile");
		System.out.println("bfile : " + BookOriginalFile);

		// 새로운 첨부파일명 추출
		String originalFileName = mrequest.getFilesystemName("bookimg");
		
		if(BookOriginalFile != null && originalFileName == null) {
			// 원래 첨부파일 있고, 새로운 첨부파일 없을 때
			book.setBookImg(BookOriginalFile);
		} else if(BookOriginalFile == null && originalFileName != null) {
			// 원래 첨부파일 없고, 새로운 첨부파일 있을 때
			book.setBookImg(originalFileName);
		} else if(BookOriginalFile != null && originalFileName != null) {
			// 원래 첨부파일 있고, 새로운 첨부파일 있을 때
			book.setBookImg(originalFileName);
		} else if(BookOriginalFile != null && originalFileName != null && BookOriginalFile.equals(originalFileName)) {
			// 원래 첨부파일 없고, 새로운 첨부파일 있을 때
			book.setBookImg(originalFileName);
		}

		// 6. 서비스 메소드로 전달하고 결과받기
		int result = new BookService().updateAdminBook(book);

		// 7. 받은 결과로 성공/실패 페이지 내보내기
		if (result > 0) {
			response.sendRedirect("/bookjeok/bklist.ad");
		} else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "도서 등록 실패!");
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

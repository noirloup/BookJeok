package review.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.model.service.BookService;
import book.model.vo.Book;

/**
 * Servlet implementation class ReviewCertificationServlet
 */
@WebServlet("/rcerti")
public class ReviewCertificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReviewCertificationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 전송온 값에 한글이 있다면 인코딩처리함
		request.setCharacterEncoding("utf-8");

		// 2. 전송온 값 꺼내서, 변수 또는 객체에 기록 저장
		String book_nm = request.getParameter("book_nm");
		int isbn = Integer.parseInt(request.getParameter("isbn"));

		// 3. 서비스쪽 메소드로 값 전달하면서 실행하고, 결과받기
		Book book = new BookService().certificate(book_nm, isbn);

		// 4. 받은 결과에 따라 성공/실패 페이지를 내보냄
		if (book != null && book.getBookNm().equals(book_nm)) {
			RequestDispatcher view = request.getRequestDispatcher("views/review/ReviewWriteForm.jsp");
			request.setAttribute("book_nm", book_nm);
			view.forward(request, response);
//			response.sendRedirect("/bookjeok/views/review/ReviewWriteForm.jsp");

		} else { 
			// 뷰로 내보낼 메세지 지정과 뷰 파일 지정

			// 상대경로만 사용할 수 있음.
			// 모든 서블릿을 root 에서 실행됨
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");


			// 요청한 클라이언트로 응답 처리함
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

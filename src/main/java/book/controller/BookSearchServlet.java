package book.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.model.service.BookService;
import book.model.vo.Book;

/**
 * Servlet implementation class BookSearchServlet
 */
@WebServlet("/bksearch")
public class BookSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
		
			String action = request.getParameter("action");
			String keyword = request.getParameter("keyword");

			BookService bservice = new BookService();
			ArrayList<Book> list = null;

			switch (action) {
			case "booknm":
				list = bservice.selectPBookSearchBookName(keyword);
				break;
			case "author":
				list = bservice.selectPBookSearchAuthor(keyword);
				break;
			}

			RequestDispatcher view = null;
			if (list.size() > 0) {
				view = request.getRequestDispatcher("views/book/ProductListView.jsp");
				request.setAttribute("list", list);
				view.forward(request, response);
			} else {
				view = request.getRequestDispatcher("views/common/error.jsp");
				request.setAttribute("message", action + " 검색에 대한 " + keyword + "의 페이퍼북 결과가 존재하지 않습니다.");
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

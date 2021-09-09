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
 * Servlet implementation class ProductListAdminSearch
 */
@WebServlet("/plistsearch")
public class ProductListSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				request.setCharacterEncoding("utf-8");
				BookService bservice = new BookService();
				ArrayList<Book> list = null;

				String action = request.getParameter("action");
				String keyword = request.getParameter("keyword");
				
				if(request.getParameter("category") != null && Integer.parseInt(request.getParameter("category"))>0) {
					int category = Integer.parseInt(request.getParameter("category"));
	
					switch (action) {
					case "booknm":
						list = bservice.selectProductSearchBookName1(category, keyword);
						break;
					case "author":
						list = bservice.selectProductSearchAuthor1(category, keyword);
						break;
					}
					
					RequestDispatcher view = null;
					if (list.size() > 0) {
						view = request.getRequestDispatcher("views/book/ProductListView.jsp");
						request.setAttribute("list", list);
						request.setAttribute("category", category);
						view.forward(request, response);
					} 
					else {
						view = request.getRequestDispatcher("views/common/error.jsp");
						request.setAttribute("message", action + " 검색에 대한 " + keyword + " 결과가 존재하지 않습니다.");
						view.forward(request, response);
					}
					
					
				}else if(request.getParameter("location") != null && Integer.parseInt(request.getParameter("location"))>0) {
					int location = Integer.parseInt(request.getParameter("location"));
					
					switch (action) {
					case "booknm":
						list = bservice.selectProductSearchBookName2(location, keyword);
						break;
					case "author":
						list = bservice.selectProductSearchAuthor2(location, keyword);
						break;
					}
					
					RequestDispatcher view = null;
					if (list.size() > 0) {
						view = request.getRequestDispatcher("views/book/ProductListView.jsp");
						request.setAttribute("list", list);
						request.setAttribute("location", location);
						view.forward(request, response);
					} else {
						view = request.getRequestDispatcher("views/common/error.jsp");
						request.setAttribute("message", action + " 검색에 대한 " + keyword + " 결과가 존재하지 않습니다.");
						view.forward(request, response);
					}
				}else if(request.getParameter("location") != null && request.getParameter("category") != null && Integer.parseInt(request.getParameter("location"))>0 && Integer.parseInt(request.getParameter("category"))>0) {
					int location = Integer.parseInt(request.getParameter("location"));
					int category = Integer.parseInt(request.getParameter("category"));
					
					switch (action) {
					case "booknm":
						list = bservice.selectProductSearchBookName3(location, category, keyword);
						break;
					case "author":
						list = bservice.selectProductSearchAuthor3(location, category, keyword);
						break;
					}
					
					RequestDispatcher view = null;
					if (list.size() > 0) {
						view = request.getRequestDispatcher("views/book/ProductListView.jsp");
						request.setAttribute("list", list);
						request.setAttribute("location", location);
						request.setAttribute("category", location);
						view.forward(request, response);
					} else {
						view = request.getRequestDispatcher("views/common/error.jsp");
						request.setAttribute("message", action + " 검색에 대한 " + keyword + " 결과가 존재하지 않습니다.");
						view.forward(request, response);
					}
				
				}else {
					switch (action) {
					case "booknm":
						list = bservice.selectProductSearchBookName4(keyword);
						break;
					case "author":
						list = bservice.selectProductSearchAuthor4(keyword);
						break;
					}
					
					RequestDispatcher view = null;
					if (list.size() > 0) {
						view = request.getRequestDispatcher("views/book/ProductListView.jsp");
						request.setAttribute("list", list);
						view.forward(request, response);
					} else {
						view = request.getRequestDispatcher("views/common/error.jsp");
						request.setAttribute("message", action + " 검색에 대한 " + keyword + " 결과가 존재하지 않습니다.");
						view.forward(request, response);
					}
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

package usedshop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.model.vo.Book;
import usedshop.model.service.UsedShopService;

/**
 * Servlet implementation class UsedAuctionWrtieBookSearchServlet
 */
@WebServlet("/usauwritebooksearsh")
public class UsedAuctionWriteBookSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsedAuctionWriteBookSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = null;
		request.setCharacterEncoding("utf-8");
		
		String bookname = request.getParameter("bookname");
		
		UsedShopService usservice = new UsedShopService();
		
		Book book = usservice.selectBookNameSearch(bookname);
		
		if(request.getParameter("bookname") != null) {
			view = request.getRequestDispatcher("views/usedshop/UsedShopAuctionWriteView.jsp");
			request.setAttribute("book", book);
			view.forward(request, response);
		} else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", bookname + " 이라는 이름의 도서가 없습니다.");
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

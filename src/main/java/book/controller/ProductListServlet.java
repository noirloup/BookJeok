package book.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import book.model.service.BookService;
import book.model.vo.Book;

/**
 * Servlet implementation class TestBookListServlet
 */
@WebServlet("/plist")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// 2. 전송 온 값 꺼내서, 변수 또는 객체에 기록함
				int location = 0;
				int category = 0;	
				
				if(request.getParameter("location")!=null) {
					location = Integer.parseInt(request.getParameter("location"));
				}
				if(request.getParameter("category") != null) {
					category = Integer.parseInt(request.getParameter("category"));
				}
				
				// 1. 전송 온 값에 한글이 있다면, 인코딩 처리함
				request.setCharacterEncoding("utf-8");

				// 3. 서비스 객체 생성하고, 메소드 실행하고 결과받기
				BookService bservice = new BookService();
				ArrayList<Book> list = null;
				
				list = bservice.selectCategory(location, category);

				// 4. 받은 결과로 성공/실패 페이지 내보내기
				RequestDispatcher view = null;
				if (list.size() > 0) {
					view = request.getRequestDispatcher("views/book/ProductListView.jsp");
					request.setAttribute("list", list);
					request.setAttribute("location", location);
					request.setAttribute("category", category);
					view.forward(request, response);
				} else {
					view = request.getRequestDispatcher("views/common/error.jsp");
					request.setAttribute("message", "해당 도서가 없습니다.");
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

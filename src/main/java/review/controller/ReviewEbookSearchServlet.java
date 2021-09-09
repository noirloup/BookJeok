package review.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.model.service.ReviewService;
import review.model.vo.ReviewList;

/**
 * Servlet implementation class ReviewEbookSearchServlet
 */
@WebServlet("/ebooksearch")
public class ReviewEbookSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewEbookSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 전송 온 값에 한글이 있다면, 인코딩 처리함
		request.setCharacterEncoding("utf-8");
		
		ReviewService rservice = new ReviewService();
		ArrayList<ReviewList> list = null;
		
		// 2. 전송 온 값 꺼내서, 변수 또는 객체에 기록함
		String searchtype = request.getParameter("searchtype");
		String keyword = request.getParameter("keyword");
		
		if(request.getParameter("location") != null && Integer.parseInt(request.getParameter("location")) > 0) {
			int location = Integer.parseInt(request.getParameter("location"));
//			System.out.println(location);
			switch (searchtype) {
			case "bookname":
				list = rservice.selectEbookSearchBookName(keyword, location);
				break;
			case "writerid":
				list = rservice.selectEbookSearchWriterId(keyword, location);
				break;
			}
			
			RequestDispatcher view = null;
			if (list.size() > 0) {
				view = request.getRequestDispatcher("views/review/EBookReviewList.jsp");
				request.setAttribute("list", list);
				request.setAttribute("location", location);
				view.forward(request, response);
			} else {
				view = request.getRequestDispatcher("views/common/error.jsp");
				request.setAttribute("message", searchtype + " 검색에 대한 " + keyword + "결과가 존재하지 않습니다.");
				view.forward(request, response);
			}
			
			
		} else if(request.getParameter("category") != null && Integer.parseInt(request.getParameter("category")) > 0) {
			int category = Integer.parseInt(request.getParameter("category"));
			switch (searchtype) {
			case "bookname":
				list = rservice.selectEbookSearchBookName2(keyword, category);
				break;
			case "writerid":
				list = rservice.selectEbookSearchWriterId2(keyword, category);
				break;
			}
			
			RequestDispatcher view = null;
			if (list.size() > 0) {
				view = request.getRequestDispatcher("views/review/EBookReviewList.jsp");
				request.setAttribute("list", list);
				request.setAttribute("category", category);
				view.forward(request, response);
			} else {
				view = request.getRequestDispatcher("views/common/error.jsp");
				request.setAttribute("message", searchtype + " 검색에 대한 " + keyword + "결과가 존재하지 않습니다.");
				view.forward(request, response);
			}
			
		} else if(request.getParameter("location") != null && request.getParameter("category") != null && Integer.parseInt(request.getParameter("location")) > 0 && Integer.parseInt(request.getParameter("category")) > 0) {
			int location = Integer.parseInt(request.getParameter("location"));
			int category = Integer.parseInt(request.getParameter("category"));
			switch (searchtype) {
			case "bookname":
				list = rservice.selectEbookSearchBookName3(keyword, category, location);
				break;
			case "writerid":
				list = rservice.selectEbookSearchWriterId3(keyword, category, location);
				break;
			}
			
			RequestDispatcher view = null;
			if (list.size() > 0) {
				view = request.getRequestDispatcher("views/review/EBookReviewList.jsp");
				request.setAttribute("list", list);
				request.setAttribute("category", category);
				request.setAttribute("location", location);
				view.forward(request, response);
			} else {
				view = request.getRequestDispatcher("views/common/error.jsp");
				request.setAttribute("message", searchtype + " 검색에 대한 " + keyword + "결과가 존재하지 않습니다.");
				view.forward(request, response);
			}
			
		}else {
			switch (searchtype) {
			case "bookname":
				list = rservice.selectEbookSearchBookName(keyword);
				break;
			case "writerid":
				list = rservice.selectEbookSearchWriterId(keyword);
				break;
			}
			
			RequestDispatcher view = null;
			if (list.size() > 0) {
				view = request.getRequestDispatcher("views/review/EBookReviewList.jsp");
				request.setAttribute("list", list);
				view.forward(request, response);
			} else {
				view = request.getRequestDispatcher("views/common/error.jsp");
				request.setAttribute("message", searchtype + " 검색에 대한 " + keyword + "결과가 존재하지 않습니다.");
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

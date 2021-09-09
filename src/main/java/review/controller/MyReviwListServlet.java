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
import user.model.service.UserService;
import user.model.vo.User;

/**
 * Servlet implementation class MyReviwListServlet
 */
@WebServlet("/rmylist")
public class MyReviwListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyReviwListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// 나의리뷰 목록보기 처리용 컨트롤러
		
				ArrayList<ReviewList> list = new ReviewService().selectList();
				String userid = request.getParameter("userid");
				
				User user = new UserService().selectUser(userid);
				
				RequestDispatcher view = null;
				if(list.size() > 0) {
					view = request.getRequestDispatcher(
							"views/review/MyReview.jsp");
					request.setAttribute("list", list);
					view.forward(request, response);
				}else {
					view = request.getRequestDispatcher(
							"views/common/error.jsp");
					request.setAttribute("message", "나의 리뷰 목록 조회 실패!");
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

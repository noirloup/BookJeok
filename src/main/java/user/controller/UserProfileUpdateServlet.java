package user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.model.service.UserService;
import user.model.vo.User;

/**
 * Servlet implementation class UserProfileUpdateServlet
 */
@WebServlet("/uprofileupdate")
public class UserProfileUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserProfileUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원정보 수정 처리용 컨트롤러
		// 1.
		request.setCharacterEncoding("utf-8");

		// 2.
		User user = new User();

		user.setUserId(request.getParameter("userid"));
		user.setUserNm(request.getParameter("usernm"));
		user.setUserRank(request.getParameter("userrank"));
		user.setPoint(Integer.parseInt(request.getParameter("point")));
		user.setNickName(request.getParameter("nickname"));
		user.setUserIntro(request.getParameter("intro"));
		user.setPreferred(String.join(",", request.getParameterValues("preferred")));

		// 3.
		int result = new UserService().updateUserProfile(user);

		// 4.
		if (result > 0) {
			RequestDispatcher view = request.getRequestDispatcher("views/user/myProfilePage.jsp");
			request.setAttribute("user", user);
			view.forward(request, response);
		} else {
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", user.getUserId() + " 회원 정보 수정 실패!");
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

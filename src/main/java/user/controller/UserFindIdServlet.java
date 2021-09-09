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
 * Servlet implementation class UserFindIdServlet
 */
@WebServlet("/ufindid")
public class UserFindIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserFindIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자 아이디 찾기 컨트롤러
		
		// 1. 전송온 값에 한글이 있다면 인코딩 처리함
		request.setCharacterEncoding("utf-8");
		
		// 2. 전송온 값 꺼내서, 변수 또는 객체에 기록하기
		String username = request.getParameter("username");
		String phone = request.getParameter("phone");
		
		// 3. 서비스 메소드로 전달해서 실행하고 결과받기
		User user = new UserService().selectUserFindId(username, phone);
		
		// 4. 받은 결과에 따라 성공/실패 페이지 내보내기
		RequestDispatcher view = null;
		if (user != null) { // 조회 성공
			view = request.getRequestDispatcher("views/user/userChangePwdPage.jsp");
			request.setAttribute("user", user);
			view.forward(request, response);
		} else { // 로그인 실패
			view = request.getRequestDispatcher("views/common/error.jsp");
			if (user == null) {
				request.setAttribute("message", username + " 님의 회원 정보가 존재하지 않습니다.");
			}
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

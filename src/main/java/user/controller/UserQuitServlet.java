package user.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ask.model.service.AskService;
import review.model.service.ReviewService;
import usedshop.model.service.UsedShopService;
import user.model.service.UserService;

/**
 * Servlet implementation class UserQuitServlet
 */
@WebServlet("/uquit")
public class UserQuitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserQuitServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원 탈퇴 처리용 컨트롤러
		String userid = request.getParameter("userid");
        String userpwd = request.getParameter("userpwd");
        
        String cryptoUserpwd = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			// 패스워드 문자열을 암호문으로 바꾸려면, btye[]로 변환해야 함
			byte[] pwdValues = userpwd.getBytes(Charset.forName("UTF-8"));
			// 암호문으로 바꾸기
			md.update(pwdValues);
			// 암호화된 btye[]을 String으로 바꿈 : 암호문 상태임
			cryptoUserpwd = Base64.getEncoder().encodeToString(pwdValues);
			// 확인
			System.out.println(cryptoUserpwd);
			System.out.println(cryptoUserpwd.length());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		int result1 = new UsedShopService().deleteUsedAuction(userid);
		int result2 = new UsedShopService().deleteUsedNormal(userid);
		int result3 = new ReviewService().deleteReview(userid);
		int result4 = new AskService().deleteAsk(userid);
		int result = new UserService().deleteUser(userid, cryptoUserpwd);

		if (result > 0) {
			// 회원 정보 삭제 성공하면, 자동 로그아웃되게 함
			response.sendRedirect("/bookjeok/ulogout");
		} else {
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", userid + "님의 글이 삭제 되었으나, 경매에 입찰한 상품이 있습니다.\n" + "해당 상품의 다음 입찰 혹은 거래 완료 후 탈퇴를 진행해주세요.");
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

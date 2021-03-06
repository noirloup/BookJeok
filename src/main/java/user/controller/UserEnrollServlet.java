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

import user.model.service.UserService;
import user.model.vo.User;

/**
 * Servlet implementation class UserEnrollServlet
 */
@WebServlet("/uenroll")
public class UserEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEnrollServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원 가입 처리용 컨트롤러
		//1. 전송온 값에 한글이 있다면 인코딩처리함
		request.setCharacterEncoding("utf-8");
				
		//2. 전송온 값 꺼내서, 변수 또는 객체에 기록 저장
		User user = new User();
				
		user.setUserId(request.getParameter("userid"));
		user.setNickName(request.getParameter("nickname"));
		user.setUserNm(request.getParameter("usernm"));
		user.setAge(Integer.parseInt(request.getParameter("age")));
		user.setGender(request.getParameter("gender"));
		user.setPhone(request.getParameter("phone"));
		user.setEmail(request.getParameter("email"));
		user.setPost(Integer.parseInt(request.getParameter("post")));
		user.setAddr(request.getParameter("address1"));
		user.setAddrDetail(request.getParameter("address2"));
		user.setUserIntro(request.getParameter("intro"));
		
		//checkbox 전송형태 : 
		String[] preferredes = request.getParameterValues("preferred");
		//문자열배열을 하나의 String 으로 변환함, 구분자는 "," 사용한다면
		String preferred = String.join(",", preferredes);
		user.setPreferred(preferred);
				
		//패스워드 암호화 처리 적용
		//평문 상태의 회원 패스워드 추출
		String userpwd = request.getParameter("userpwd");
				
		//웹에서는 단방향 알고리즘 적용 : SHA-512
		//단방향 : 암호화만 하고, 복호화가 안되는 알고리즘
		//java.security.MessageDigest 클래스 이용함
		String cryptoUserpwd = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			//패스워드 문자열을 암호문으로 바꾸려면, btye[]로 변환해야 함
			byte[] pwdValues = userpwd.getBytes(Charset.forName("UTF-8"));
			//암호문으로 바꾸기
			md.update(pwdValues);
			//암호화된 btye[]을 String으로 바꿈 : 암호문 상태임
			cryptoUserpwd = Base64.getEncoder().encodeToString(pwdValues);
			//확인
			System.out.println(cryptoUserpwd);
			System.out.println(cryptoUserpwd.length());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
				
		user.setUserPwd(cryptoUserpwd);
		//--------------------------------------------------------
				
		//3. 서비스쪽 메소드로 값 전달하면서 실행하고, 결과받기
		int result = new UserService().insertUser(user);
				
		//4. 받은 결과에 따라 성공/실패 페이지를 내보냄
		if(result > 0) {
			//로그인 페이지로 이동 처리
			response.sendRedirect("/bookjeok/views/user/loginPage.jsp");
		}else {
			//error.jsp 로 에러메세지를 내보냄
			//상대경로만 사용할 수 있음.
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
					
			//지정한 뷰로 내보낼 정보나 객체가 있다면
			//request 에 기록함 : setAttribute(String key, Object value)
			request.setAttribute("message", "회원 가입 실패!");
					
			//뷰 내보냄
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

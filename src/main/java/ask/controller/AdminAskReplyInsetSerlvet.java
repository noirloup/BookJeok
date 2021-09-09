package ask.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ask.model.service.AskService;
import ask.model.vo.Ask;

/**
 * Servlet implementation class AdminAskReplyInsetSerlvet
 */
@WebServlet("/aanswer.ad")
public class AdminAskReplyInsetSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminAskReplyInsetSerlvet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 게시글 댓글 등록 처리용 컨트롤러
		//1. 전송온 값 한글 인코딩 처리
		request.setCharacterEncoding("utf-8");
		//2. 전송온값 꺼내서 객체 또는 변수 담기
		// 댓글에 대한 값 추출해서 객체 저장
		Ask areply = new Ask();
		
		areply.setAskNum(Integer.parseInt(request.getParameter("askNum")));
		areply.setAnswerContent(request.getParameter("answer"));
		areply.setAnswerID(request.getParameter("answerwriterid"));
		
		// 서비스로 메소드 전달 결과받기
		int result = new AskService().updateAnswerContent(areply);
		
		// 받은 결과 성공 / 실패 페이지 내보내기
		RequestDispatcher view = null;
		if(result > 0) {
			response.sendRedirect("/bookjeok/alist.ad");
		}else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "댓글 작성 실패!");
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
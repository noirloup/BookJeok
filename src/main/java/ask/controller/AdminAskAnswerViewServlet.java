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
 * Servlet implementation class AskDetailServlet
 */
@WebServlet("/aanswerview.ad")
public class AdminAskAnswerViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAskAnswerViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 문의글 상세보기 처리용 컨트롤러
		
		int askNum = Integer.parseInt(request.getParameter("askNum"));
		
		// 서비스 객체 메소드 실행하고 결과받기
		AskService aservice = new AskService();
		
		// 해당 게시글 리턴 받음 : select
		Ask ask = aservice.selectAsk(askNum);
		
		RequestDispatcher view = null;
		if(ask != null) {
			view = request.getRequestDispatcher("views/ask/askAdminAnswerView.jsp");
			request.setAttribute("ask", ask);
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", askNum + "번 게시글 상세조회 실패!");
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
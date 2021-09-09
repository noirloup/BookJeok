package notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class AdminNoticeSearchSerlvet
 */
@WebServlet("/nsearch")
public class NoticeSearchSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeSearchSerlvet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 관리자용 공지사항 검색 처리용 컨트롤러
		// 1. 전송온 값이 한글이 있다면 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		
		NoticeService nservice = new NoticeService();
		ArrayList<Notice> list = null;
		
		String action = request.getParameter("action");
		String keyword = request.getParameter("keyword");
		System.out.println(action + keyword);
		// 3. 서비스 객체생성하고, 메소드 실행 결과 받기
		switch (action) {
		case "title":
			list = nservice.selectNoticeListTitle(keyword);	break;
		}
		System.out.println(list.size());
		// 4. 받은 결과로 성공/실패 페이지 보내기
		RequestDispatcher view = null;
		if (list.size() > 0) {
		view = request.getRequestDispatcher("views/notice/NoticeMainView.jsp");
		request.setAttribute("list", list);
		view.forward(request, response);
		} else {
		view = request.getRequestDispatcher("views/common/error.jsp");
		request.setAttribute("message", action + " 검색에 대한 " + keyword + "결과가 존재하지 않습니다.");
		view.forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
package usedshop.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usedshop.model.service.UsedShopService;
import usedshop.model.vo.UsedShopAuctionSelect;

/**
 * Servlet implementation class UsedAuctionWriteServlet
 */
@WebServlet("/usauwrite")
public class UsedAuctionWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsedAuctionWriteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 경매장터 등록 서블릿
		// 1. 전송온 값에 한글이 있다면 인코딩처리함
		request.setCharacterEncoding("utf-8");

		// 2. 전송온 값 꺼내서, 변수 또는 객체에 기록 저장
		UsedShopAuctionSelect usauselect = new UsedShopAuctionSelect();
	
		usauselect.setUserWriterId(request.getParameter("writerid"));
		usauselect.setUsedBookId(Integer.parseInt(request.getParameter("usedbookid")));
		usauselect.setStartBid(Integer.parseInt(request.getParameter("startbid")));
		usauselect.setCurrentBid(Integer.parseInt(request.getParameter("startbid")));
		usauselect.setaCloseDate(Date.valueOf(request.getParameter("closedate")));
		usauselect.setaUsedBookIntro(request.getParameter("usauintro"));
		usauselect.setaQuality(request.getParameter("usauquality"));
		
		// --------------------------------------------------------
		// 3. 서비스쪽 메소드로 값 전달하면서 실행하고, 결과받기

		int result = new UsedShopService().insertUsedAuction(usauselect);

		// 4. 받은 결과에 따라 성공/실패 페이지를 내보냄
		if (result > 0) {
			// 로그인 페이지로 이동 처리
			response.sendRedirect("/bookjeok/views/usedshop/UsedAuctionMainView.jsp");
		} else {
			// error.jsp 로 에러메세지를 내보냄
			// 상대경로만 사용할 수 있음.
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");

			// 지정한 뷰로 내보낼 정보나 객체가 있다면
			// request 에 기록함 : setAttribute(String key, Object value)
			request.setAttribute("message", "경매 글 등록 실패!");

			// 뷰 내보냄
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

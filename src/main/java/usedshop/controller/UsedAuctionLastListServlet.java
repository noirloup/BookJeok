package usedshop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usedshop.model.service.UsedShopService;
import usedshop.model.vo.UsedShopAuctionSelect;

/**
 * Servlet implementation class UsedAuctionLastListServlet
 */
@WebServlet("/usaulastlist")
public class UsedAuctionLastListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsedAuctionLastListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자 중고장터 마감 임박 품목 (마감 임박 상위 Top20) 목록 출력 서블렛

		// 1. 전송 온 값에 한글이 있다면, 인코딩 처리함
		request.setCharacterEncoding("utf-8");

		// 3. 서비스 객체 생성하고, 메소드 실행하고 결과받기
		UsedShopService usservice = new UsedShopService();
		ArrayList<UsedShopAuctionSelect> list = null;

		list = usservice.selectLastDateList();

		// 4. 받은 결과로 성공/실패 페이지 내보내기
		RequestDispatcher view = null;
		if (list.size() > 0) {
			view = request.getRequestDispatcher("views/usedshop/auctionLastListView.jsp");
			request.setAttribute("list", list);
			view.forward(request, response);
		} else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "경쟁 품목이 존재하지 않습니다.");
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

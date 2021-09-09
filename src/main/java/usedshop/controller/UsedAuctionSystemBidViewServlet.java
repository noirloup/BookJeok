package usedshop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usedshop.model.service.UsedShopService;
import usedshop.model.vo.UsedShopAuctionSelect;

/**
 * Servlet implementation class UsedAuctionSystemBidViewServlet
 */
@WebServlet("/usausystembidview")
public class UsedAuctionSystemBidViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsedAuctionSystemBidViewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 경매 목록에서 한 개의 글 번호를 받아, 객체를 읽음, 뷰 이동 서블릿
		int marketcd = 1;
		if (request.getParameter("marketcd") != null) {
			marketcd = Integer.parseInt(request.getParameter("marketcd"));
		}

		UsedShopService usservice = new UsedShopService();
		UsedShopAuctionSelect usauselect = null;

		usauselect = usservice.selectAuctionMarketCd(marketcd);

		RequestDispatcher view = null;
		if (usauselect != null) {
			view = request.getRequestDispatcher("views/usedshop/auctionSystemBidPop.jsp");
			request.setAttribute("usauselect", usauselect);
			view.forward(request, response);
		} else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", marketcd + " 번 경매글을 조회하지 못했습니다.");
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

package usedshop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usedshop.model.service.UsedShopService;
import usedshop.model.vo.UsedShopNormalSelect;

/**
 * Servlet implementation class UsedAuctionUpdateServlet
 */
@WebServlet("/usnmupdate")
public class UsedNormalUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsedNormalUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 경매 장터 수정 컨트롤러
		// 1.
		request.setCharacterEncoding("utf-8");

		// 2.
		UsedShopNormalSelect usnmselect = new UsedShopNormalSelect();

		usnmselect.setnMarketCd(Integer.parseInt(request.getParameter("marketid")));
		usnmselect.setPrice(Integer.parseInt(request.getParameter("price")));
		usnmselect.setRegCount(Integer.parseInt(request.getParameter("salecount")));
		usnmselect.setnUsedBookIntro(request.getParameter("usedintro"));

		// 3.
		int result = new UsedShopService().updateUsedNormal(usnmselect);

		// 4.
		if (result > 0) {
			response.sendRedirect("/bookjeok/views/usedshop/UsedNormalMainView.jsp");
		} else {
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", usnmselect.getnMarketCd() + " 번 경매 글 수정 실패!");
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

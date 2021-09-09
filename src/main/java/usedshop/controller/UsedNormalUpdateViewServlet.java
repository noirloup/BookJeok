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
import usedshop.model.vo.UsedShopNormalSelect;

/**
 * Servlet implementation class UsedAuctionUpdateViewServlet
 */
@WebServlet("/usnmupdateview")
public class UsedNormalUpdateViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsedNormalUpdateViewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 경매 장터 수정 페이지 이동 컨트롤러
		
		// 1. 전송온 값 꺼내서 변수 또는 객체에 기록하기
		int marketid = Integer.parseInt(request.getParameter("marketid"));

		// 3. 서비스 메소드 실행하고 결과받기
		UsedShopNormalSelect usnmselect = new UsedShopService().selectNormalMarketCd(marketid);

		// 4. 받은 결과로 성공/실패에 대한 뷰 내보냄
		RequestDispatcher view = null;
		if (usnmselect != null) {
			view = request.getRequestDispatcher("views/usedshop/UsedShopNormalUpdateView.jsp");
			request.setAttribute("usnmselect", usnmselect);
			view.forward(request, response);
		} else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", marketid + " 번 경매 글 조회 실패!");
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

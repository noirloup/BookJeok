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
 * Servlet implementation class UsedAuctionBidViewServlet
 */
@WebServlet("/usnmdeleteview")
public class UsedNormalDeleteViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsedNormalDeleteViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 경매 목록에서 한 개의 글 번호를 받아, 객체를 읽음, 뷰 이동 서블릿
		int marketid = Integer.parseInt(request.getParameter("marketid"));
		
		UsedShopService usservice = new UsedShopService();
		UsedShopNormalSelect usnmselect = null;
		
		usnmselect = usservice.selectNormalMarketCd(marketid);
		
		RequestDispatcher view = null;
		if (usnmselect != null) {
			view = request.getRequestDispatcher("views/usedshop/normalDeleteView.jsp");
			request.setAttribute("usnmselect", usnmselect);
			view.forward(request, response);
		} else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", marketid + " 번 경매글을 조회하지 못했습니다.");
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

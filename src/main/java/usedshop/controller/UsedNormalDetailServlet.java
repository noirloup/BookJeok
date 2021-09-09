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
 * Servlet implementation class UsedAuctionDetailServlet
 */
@WebServlet("/usnmdetail")
public class UsedNormalDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsedNormalDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 경매 장터 상세보기 처리용 컨트롤러
		
		RequestDispatcher view = null;
		request.setCharacterEncoding("utf-8");
		
		int marketcd = Integer.parseInt(request.getParameter("marketcd"));
		
		UsedShopService usservice = new UsedShopService();
		
		UsedShopNormalSelect usnmselect = usservice.selectNormalMarketCd(marketcd);
		
		if(usnmselect != null) {
			view = request.getRequestDispatcher("views/usedshop/UsedShopNormalDetailView.jsp");
			request.setAttribute("usnmselect", usnmselect);
			view.forward(request, response);
		} else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", marketcd + " 번 장터글 조회 실패.");
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

package review.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.model.service.ReviewService;
import review.model.vo.ReviewList;
import usedshop.model.service.UsedShopService;
import usedshop.model.vo.UsedShopNormalSelect;

/**
 * Servlet implementation class ReviewDeleteViewServlet
 */
@WebServlet("/rdeleteview")
public class ReviewDeleteViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewDeleteViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reviewcd = Integer.parseInt(request.getParameter("reviewcd"));
		
		ReviewService rservice = new ReviewService();
		ReviewList rselect = null;
//		UsedShopService usservice = new UsedShopService();
//		UsedShopNormalSelect usnmselect = null;
		
		rselect = rservice.selectReview(reviewcd);
//		usnmselect = usservice.selectNormalMarketCd(marketid);
		
		RequestDispatcher view = null;
		if (rselect != null) {
			view = request.getRequestDispatcher("views/review/MyReviewDelete.jsp");
			request.setAttribute("rselect", rselect);
			view.forward(request, response);
		} else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", rselect + " 을 조회하지 못했습니다.");
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

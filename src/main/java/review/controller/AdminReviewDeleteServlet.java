package review.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.model.service.ReviewService;

/**
 * Servlet implementation class AdminReviewDeleteServlet
 */
@WebServlet("/rdelete.ad")
public class AdminReviewDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminReviewDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
int reviewcd = Integer.parseInt(request.getParameter("reviewcd"));
		
		int result = new ReviewService().deleteReview(reviewcd);
		
		if(result > 0) {
			//글삭제가 성공하면, 첨부파일이 있었을 경우
			//저장폴더에서 해당 글의 첨부파일도 함께 삭제 처리함
			String renameFileName = request.getParameter("rfile");
			if(renameFileName != null) {
				//삭제된 글의 첨부파일이 있다면 삭제 처리함
				String savePath = request.getSession()
						.getServletContext().getRealPath(
								"/resources/review_upfiles");
				new File(savePath + "\\" + renameFileName).delete();
			}
			
			response.sendRedirect("/bookjeok/rlist.ad");
		}else {
			RequestDispatcher view = 
					request.getRequestDispatcher(
							"views/common/error.jsp");
			request.setAttribute("message", 
					reviewcd + "리뷰 삭제 실패!");
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

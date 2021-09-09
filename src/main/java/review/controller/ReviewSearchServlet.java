package review.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.model.service.ReviewService;
import review.model.vo.ReviewList;

/**
 * Servlet implementation class ReviewSearchServlet
 */
@WebServlet("/rsearch")
public class ReviewSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				// 조회용 서비스 객체 생성
				ReviewService rservice = new ReviewService();

			
		
				//1. 전송 온 값에 한글이 있다면, 인코딩 처리함
				request.setCharacterEncoding("utf-8");
				
				//2. 전송 온 값 꺼내서, 변수 또는 객체에 기록함
				String action = request.getParameter("action");
				String keyword = null, beginDate = null, endDate = null;
						
				if(action.equals("enrolldate")) {
					beginDate = request.getParameter("begin");
					endDate = request.getParameter("end");
				}else {
					keyword = request.getParameter("keyword");
				}
				
				//3. 서비스 객체 생성하고, 메소드 실행하고 결과받기
				ArrayList<ReviewList> list = null;
				
				switch(action) {
				case "id":	 list = rservice.selectSearchUserId(keyword);
						 break;
				case "name":	 list = rservice.selectSearchReviewname(keyword);
				 		break;
				case "enrolldate":	 list = rservice.selectSearchEnrollDate(
									Date.valueOf(beginDate), Date.valueOf(endDate));
				 		 break;

				}
				
				//4. 받은 결과로 성공/실패 페이지 내보내기
				RequestDispatcher view = null;
				if(list.size() > 0) {
					view = request.getRequestDispatcher("views/review/ReviewAdminListView.jsp");
					request.setAttribute("list", list);
					view.forward(request, response);
				}else {
					view = request.getRequestDispatcher("views/common/error.jsp");
					request.setAttribute("message", action + " 검색에 대한 "
							+ keyword + "결과가 존재하지 않습니다.");
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

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
 * Servlet implementation class UseAuctionrMyPageListServlet
 */
@WebServlet("/usaumybidlist")
public class UsedAuctionMyBidListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsedAuctionMyBidListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자 내 장터 나의 입찰 목록 출력 서블렛

		// 출력할 페이지 지정
		int currentPage = 1;
		// 전송온 페이지 값이 있다면 추출함
		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}

		// 한 페이지당 출력할 목록 갯수 지정
		int limit = 5;

		// 1. 전송 온 값 꺼내서, 변수 또는 객체에 기록함
		String userid = request.getParameter("userid");
		
		// 2. 전송 온 값에 한글이 있다면, 인코딩 처리함
		request.setCharacterEncoding("utf-8");

		// 3. 서비스 객체 생성하고, 메소드 실행하고 결과받기
		UsedShopService usservice = new UsedShopService();
		ArrayList<UsedShopAuctionSelect> list = null;

		// 총 페이지수 계산을 위한 목록 갯수 조회
		int listCount = usservice.getAuctionMyBidListCount(userid);
		System.out.println(listCount);
		
		// 요청한 페이지의 출력될 목록의 행번호를 계산
		// 한 페이지에 출력할 목록 갯수가 10개인 경우
		// 3page 가 요청되었다면 행번호는 21 ~ 30행임.
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;

		list = usservice.selectAuctionMyBidList(userid, startRow, endRow);

		// 뷰 페이지로 같이 내보낼 페이지 관련 숫자 계산 처리
		// 총 페이지 수 : 총 목록이 21개인 경우
		// 한 페이지에 출력할 목록이 10개이면, 페이지는 3임
		int maxPage = (int) ((double) listCount / limit + 0.9);

		// 뷰에 출력할 페이지그룹의 시작 페이지 지정
		// 뷰 목록 아래쪽에 페이지 숫자를 10를 출력한다면..
		// 현재 페이지가 3페이지이면, 페이지 그룹은 1 ~10 이 됨
		// 현재 페이지가 15페이지이면, 페이지 그룹은 11~20 이 됨
		int startPage = (((int) ((double) currentPage / limit + 0.9)) - 1) * limit + 1;
		int endPage = startPage + limit - 1;

		// 총페이수 숫자와 페이지 그룹의 마지막 숫자 조정
		if (maxPage < endPage) {
			endPage = maxPage;
		}

		// 4. 받은 결과로 성공/실패 페이지 내보내기
		RequestDispatcher view = null;
		if (list.size() > 0) {
			view = request.getRequestDispatcher("views/usedshop/UsedMyBidListView.jsp");
			request.setAttribute("list", list);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("listCount", listCount);
			view.forward(request, response);
		} else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", userid + " 님의 등록된 글이 존재하지 않습니다.");
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

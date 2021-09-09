package notice.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;

/**
 * Servlet implementation class AdminNoticeDeleteServlet
 */
@WebServlet("/ndelete.ad")
public class AdminNoticeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminNoticeDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 관리자용 공지글 삭제 처리용 컨트롤러
		
		int noticeNum = Integer.parseInt(request.getParameter("noticeNum"));
		
		int result = new NoticeService().deleteNotice(noticeNum);
		
		if(result > 0) {
			// 글삭제가 성공하면, 첨부파일이 있었을 경우
			// 저장폴더에서 해당글의 첨부파일도 함께 삭제 처리
			String renameFileName = request.getParameter("rfile");
			if(renameFileName != null) {
				// 삭제된 글의 첨부파일이 있다면 삭제 처리함
				String savePath = request.getSession().getServletContext().getRealPath("/resources/notice_upfiles");
				new File(savePath + "\\" + renameFileName).delete();
			}
			response.sendRedirect("/bookjeok/nlist.ad");
			}else {
				RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
				request.setAttribute("message", noticeNum + "번 공지글 삭제 실패!");
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

package book.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import book.model.service.BookService;
import book.model.service.OtherSiteService;
import book.model.vo.Book;
import book.model.vo.OtherSite;

/**
 * Servlet implementation class OtherSiteServlet
 */
@WebServlet("/osite")
public class OtherSiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OtherSiteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		ArrayList<OtherSite> list = new OtherSiteService().selectSiteList(bookid);
		
			JSONArray jarr = new JSONArray();
		
			for(OtherSite othersite : list) {
				JSONObject job = new JSONObject();
			
				job.put("sitecd", othersite.getSiteCd());
				job.put("sitebookid", othersite.getSiteBookId());
				job.put("sitenm", othersite.getSiteNm());
				job.put("siteprice", othersite.getSitePrice());
			
				jarr.add(job);
		}
			JSONObject sendJson = new JSONObject();
			sendJson.put("list", jarr);
		
			response.setContentType("application/json; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.write(sendJson.toJSONString());
			out.flush();
			out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

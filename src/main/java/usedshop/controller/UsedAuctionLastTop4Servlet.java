package usedshop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import book.model.service.BookService;
import book.model.vo.Book;
import usedshop.model.service.UsedShopService;
import usedshop.model.vo.UsedShopAuction;
import usedshop.model.vo.UsedShopAuctionSelect;

/**
 * Servlet implementation class UsedShopNewTop6Servlet
 */
@WebServlet("/usaulasttop")
public class UsedAuctionLastTop4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsedAuctionLastTop4Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<UsedShopAuctionSelect> list = new UsedShopService().selectUsedAuctionLastTop4List();
		
		JSONArray jarr = new JSONArray();
		for(UsedShopAuctionSelect usauctiontop : list) {
			JSONObject job = new JSONObject();
			
			job.put("amarketcd", usauctiontop.getaMarketCd());
			job.put("bookimg", usauctiontop.getBookimg());
			job.put("booknm", usauctiontop.getBookNm());
			job.put("currentbid", usauctiontop.getCurrentBid());
			job.put("aregdate", usauctiontop.getaRegDate().toString());
			job.put("aclosedate", usauctiontop.getaCloseDate().toString());
			
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

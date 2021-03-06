package book.controller;

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
import book.model.vo.OtherSite;

/**
 * Servlet implementation class BestSellerListServlet
 */
@WebServlet("/bkbest4")
public class BookBestTop4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookBestTop4Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Book> list = new BookService().selectBestTop4();
		
		JSONArray jarr = new JSONArray();
		
		for(Book book : list) {
			JSONObject job = new JSONObject();
			
			job.put("bookid", book.getBookId());
			job.put("booknm",book.getBookNm());
			job.put("bookimg", book.getBookImg());
			job.put("author", book.getAuthor());
			job.put("ranking", book.getRanking());
			
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

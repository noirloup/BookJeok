package review.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import review.model.service.ReviewService;
import review.model.vo.Review;

/**
 * Servlet implementation class ReviewTopPaperServlet
 */
@WebServlet("/rtoppaper")
public class ReviewTopPaperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewTopPaperServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Review> list = new ReviewService().selectTopPaper();

		// list 를 옮겨 기록할 JSON 배열 생성
		JSONArray jarr = new JSONArray();

		// list 애서 review 객체 하나씩 꺼내서 json 배열에
		// json 객체로 값 옮겨 기록하기
		for (Review review : list) {
			// notice 저장용 json 객체 생성
			JSONObject job = new JSONObject();

//			job.put("rcd", review.getReviewCd());
			job.put("rname", URLEncoder.encode(review.getReviewName(), "utf-8"));
//			job.put("rkey1", URLEncoder.encode(review.getKeyword1(), "utf-8"));
//			job.put("rkey2", URLEncoder.encode(review.getKeyword2(), "utf-8"));
//			job.put("rkey3", URLEncoder.encode(review.getKeyword3(), "utf-8"));
//			job.put("rkey4", URLEncoder.encode(review.getKeyword4(), "utf-8"));
			job.put("rid", URLEncoder.encode(review.getReviewWriterId(), "utf-8"));
			job.put("rdate", review.getReviewRegDate().toString());
			job.put("rcon", URLEncoder.encode(review.getReviewContent(), "utf-8"));
			job.put("bimg", URLEncoder.encode(review.getBookImg(), "utf-8"));
			job.put("bname", URLEncoder.encode(review.getBookNm(), "utf-8"));
			

			jarr.add(job);
		}

		// 전송용 json 객체 생성
		JSONObject sendJson = new JSONObject();
		sendJson.put("list", jarr);

		// 요청자에게 보내기
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

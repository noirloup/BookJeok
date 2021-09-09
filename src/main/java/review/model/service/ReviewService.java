package review.model.service;

import static common.JDBCTemp.close;
import static common.JDBCTemp.commit;
import static common.JDBCTemp.getConnection;
import static common.JDBCTemp.rollback;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import notice.model.vo.Notice;
import review.model.dao.ReviewDao;
import review.model.vo.Review;
import review.model.vo.ReviewList;
import usedshop.model.vo.UsedShopAuctionSelect;
import usedshop.model.vo.UsedShopNormalSelect;
import user.model.vo.User;

public class ReviewService {
	private ReviewDao rdao = new ReviewDao();
	
	public ArrayList<ReviewList> selectList()	{ 
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectList(conn);
		close(conn);
		return list;

	}
	
	public Review selectOne(String reviewname) {
		Connection conn = getConnection();
		Review review = rdao.selectOne(conn, reviewname);
		close(conn);
		return review;
	}

	public ReviewList selectReview(String bookNm) {
		Connection conn = getConnection();
		ReviewList review = rdao.selectReview(conn, bookNm);
		close(conn);
		return review;
	}
	
	public int insertReview(Review review, String booknm) {
		Connection conn = getConnection();
		int result = rdao.insertReview(conn, review, booknm);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int updateReview(Review review) {
		Connection conn = getConnection();
		int result = rdao.updateReview(conn, review);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}		
		close(conn);
		return result;
	}
	
	public int deleteReview(int reviewcd) {
		Connection conn = getConnection();
		int result = rdao.deleteReview(conn, reviewcd);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}		
		close(conn);
		return result;
	}
	
	public ArrayList<Review> selectTop6()	{
		Connection conn = getConnection();
		ArrayList<Review> list = rdao.selectTop6(conn);
		close(conn);
		return list;
	}
	
	public ArrayList<Review> selectTopPaper(){
		Connection conn = getConnection();
		ArrayList<Review> list = rdao.selectTopPaper(conn);
		close(conn);
		return list;
	}
	


	public ArrayList<Review> selectTopEbook() {
		Connection conn = getConnection();
		ArrayList<Review> list = rdao.selectTopEbook(conn);
		close(conn);
		return list;
	}

	public ArrayList<Review> selectTopAudio() {
		Connection conn = getConnection();
		ArrayList<Review> list = rdao.selectTopAudio(conn);
		close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectPaperList() {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectPaperList(conn);
		close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectEBookList() {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectEBookList(conn);
		close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectAudioList() {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectAudioList(conn);
		close(conn);
		return list;
	}

	
	public ArrayList<ReviewList> selectPaperDetailList(String bookNm) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectPaperDetailList(conn, bookNm);
		close(conn);
		return list;
	}


	public ArrayList<ReviewList> selectEBookDetailList(String bookNm) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectEBookDetailList(conn, bookNm);
		close(conn);
		return list;
	}

	public int getListCountA(String bookNm) {
		Connection conn = getConnection();
		int listCount = rdao.getListCountA(conn, bookNm);
		close(conn);
		return listCount;
	}

	public ArrayList<ReviewList> selectAudioDetailList(String bookNm) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectAudioDetailList(conn, bookNm);
		close(conn);
		return list;
	}


	public ArrayList<ReviewList> selectCategoryP(int location, int category) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectCategoryP(conn, location, category);
		close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectCategoryE(int location, int category) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectCategoryE(conn, location, category);
		close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectCategoryA(int location, int category) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectCategoryA(conn, location, category);
		close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectMyList(String reviewname) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectMyList(conn, reviewname);
		close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectAdminList() {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectAdminList(conn);
		close(conn);
		return list;
	}


	public ArrayList<ReviewList> selectSearchUserId(String keyword) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectSearchUserId(conn, keyword);
		close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectSearchReviewname(String keyword) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectSearchReviewname(conn, keyword);
		close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectSearchEnrollDate(Date begin, Date end) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectSearchEnrollDate(conn, begin, end);
		close(conn);
		return list;
	}

	public ReviewList selectReview(int reviewcd) {
		Connection conn = getConnection();
		ReviewList rselect = rdao.selectReview(conn, reviewcd);
		close(conn);
		return rselect;
	}


	public ArrayList<ReviewList> selectPaperSearchBookName(String keyword) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectPaperSearchBookName(conn, keyword);
		close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectPaperSearchWriterId(String keyword) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectPaperSearchWriterId(conn, keyword);
		close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectEbookSearchBookName(String keyword) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectEbookSearchBookName(conn, keyword);
		close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectEbookSearchWriterId(String keyword) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectEbookSearchWriterId(conn, keyword);
		close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectAudioSearchBookName(String keyword) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectAudioSearchBookName(conn, keyword);
		close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectAudioSearchWriterId(String keyword) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectAudioSearchWriterId(conn, keyword);
		close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectAllSearchBookName(String keyword) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectAllSearchBookName(conn, keyword);
		close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectAllSearchWriterId(String keyword) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectAllSearchWriterId(conn, keyword);
		close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectAllDetailList(String bookNm) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectAllDetailList(conn, bookNm);
		close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectEbookSearchBookName(String keyword, int location) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectEbookSearchBookName(conn, keyword, location);
		close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectEbookSearchWriterId(String keyword, int location) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectEbookSearchWriterId(conn, keyword, location);
		close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectEbookSearchBookName2(String keyword, int category) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectEbookSearchBookName2(conn, keyword, category);
		close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectEbookSearchWriterId2(String keyword, int category) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectEbookSearchWriterId2(conn, keyword, category);
		close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectEbookSearchBookName3(String keyword, int category, int location) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectEbookSearchBookName3(conn, keyword, category, location);
		close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectEbookSearchWriterId3(String keyword, int category, int location) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectEbookSearchWriterId3(conn, keyword, category, location);
		close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectPaperSearchBookName(String keyword, int location) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectPaperSearchBookName(conn, keyword, location);
		close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectPaperSearchWriterId(String keyword, int location) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectPaperSearchWriterId(conn, keyword, location);
		close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectPaperSearchBookName2(String keyword, int category) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectPaperSearchBookName2(conn, keyword, category);
		close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectPaperSearchWriterId2(String keyword, int category) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectPaperSearchWriterId2(conn, keyword, category);
		close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectPaperSearchBookName3(String keyword, int category, int location) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectPaperSearchBookName3(conn, keyword, location, category);
		close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectPaperSearchWriterId3(String keyword, int category, int location) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectPaperSearchWriterId3(conn, keyword, location, category);
		close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectAudioSearchBookName(String keyword, int location) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectAudioSearchBookName(conn, keyword, location);
		close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectAudioSearchWriterId(String keyword, int location) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectAudioSearchWriterId(conn, keyword, location);
		close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectAudioSearchBookName2(String keyword, int category) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectAudioSearchBookName2(conn, keyword, category);
		close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectAudioSearchWriterId2(String keyword, int category) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectAudioSearchWriterId2(conn, keyword, category);
		close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectAudioSearchBookName3(String keyword, int category, int location) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectAudioSearchBookName3(conn, keyword, location, category);
		close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectAudioSearchWriterId3(String keyword, int category, int location) {
		Connection conn = getConnection();
		ArrayList<ReviewList> list = rdao.selectAudioSearchWriterId3(conn, keyword, location, category);
		close(conn);
		return list;
	}
	
	public ArrayList<Review> selectTop4() {
		Connection conn = getConnection();
		ArrayList<Review> list = rdao.selectTop4(conn);
		close(conn);
		return list;
	}
	
	public Review selectOne(int bookId) {
	      Connection conn = getConnection();
	      Review review = rdao.selectOne(conn, bookId);
	      close(conn);
	      return review;
	   }

	   public Review selectNmOne(String bookNm) {
	      Connection conn = getConnection();
	      Review review = rdao.selectNmOne(conn, bookNm);
	      close(conn);
	      return review;
	   }

	   public Review selectEOne(int bookId) {
	      Connection conn = getConnection();
	      Review review = rdao.selectEOne(conn, bookId);
	      close(conn);
	      return review;
	   }

	   public Review selectENmOne(String bookNm) {
	      Connection conn = getConnection();
	      Review review = rdao.selectENmOne(conn, bookNm);
	      close(conn);
	      return review;
	   }

	   public Review selectAOne(int bookId) {
	      Connection conn = getConnection();
	      Review review = rdao.selectAOne(conn, bookId);
	      close(conn);
	      return review;
	   }

	   public Review selectANmOne(String bookNm) {
	      Connection conn = getConnection();
	      Review review = rdao.selectANmOne(conn, bookNm);
	      close(conn);
	      return review;
	   }
	   
	   public int deleteReview(String userid) {
		      Connection conn = getConnection();
		      int result = rdao.deleteReview(conn, userid);
		      if(result > 0) {
		         commit(conn);
		      }else {
		         rollback(conn);
		      }      
		      close(conn);
		      return result;
		   }

	public Review selectAdminOne(int bookId) {
		Connection conn = getConnection();
		Review review = rdao.selectAdminOne(conn, bookId);
		close(conn);
		return review;
	}
	
	public Review selectAllOne(int bookId) {
	      Connection conn = getConnection();
	      Review review = rdao.selectAllOne(conn, bookId);
	      close(conn);
	      return review;
	}
	
}

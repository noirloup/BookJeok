package review.model.dao;

import static common.JDBCTemp.close;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import notice.model.vo.Notice;
import review.model.vo.Review;
import review.model.vo.ReviewList;
import usedshop.model.vo.UsedShopNormalSelect;
import user.model.vo.User;

public class ReviewDao {
	public ArrayList<ReviewList> selectList(Connection conn){ 
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "SELECT REVIEW_NAME, REVIEW_REG_DATE, REVIEW_MODIFY_DATE, REVIEW_WRITER_ID "
						+  "FROM TB_REVIEW ORDER BY REVIEW_CD";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				ReviewList review = new ReviewList();
//				User user = new User();	
				
				review.setReviewName(rset.getString("review_name"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewModifyDate(rset.getDate("review_modify_date"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
//				user.setUserId(rset.getString("user_id"));
				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}
	
	public ReviewList selectReview(Connection conn, String bookNm) {
		ReviewList review = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM( SELECT BOOK_NM, AUTHOR, PUBLISHER, PUBLISH_DATE, KEYWORD, "
				+ " 				(SELECT ROUND(AVG(SCORE), 1) FROM TB_REVIEW "
				+ "				WHERE REVIEW_BOOK_ID = (SELECT REVIEW_BOOK_ID FROM TB_REVIEW "
				+ "														JOIN TB_BOOK ON TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "														WHERE TB_BOOK.BOOK_NM = ? AND ROWNUM = 1)) AVG_SCORE "
				+ "                                   FROM (SELECT * "
				+ "                                              FROM TB_REVIEW "
				+ "                                              JOIN TB_BOOK "
				+ "                                              ON TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "                                              WHERE BOOK_NM=? "
				+ "											   ORDER BY SCORE DESC) "
				+ "												WHERE ROWNUM = 1)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookNm);
			pstmt.setString(2, bookNm);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				review = new ReviewList();
				
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublisher(rset.getString("publisher"));
				review.setPublishDate(rset.getDate("publish_date"));
//				book.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setAvgScore(rset.getDouble("avg_score"));
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return review;
	}
	
	public int insertReview(Connection conn, Review review, String booknm) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "INSERT INTO TB_REVIEW VALUES((SELECT MAX(REVIEW_CD) + 1 FROM TB_REVIEW), ?, "
				+ "(SELECT BOOK_ID FROM TB_BOOK WHERE BOOK_NM= ?), ?, sysdate, sysdate, "
				+ "?, ?, ?, ?, ?)";

		
		try {
		
			pstmt = conn.prepareStatement(query);
//			pstmt.setInt(1, review.getReviewCd());
			pstmt.setString(1, review.getReviewWriterId());
			pstmt.setString(2, booknm);
			pstmt.setString(3, review.getReviewName());
			pstmt.setString(4, review.getReviewOriginalFile());
			pstmt.setString(5, review.getReviewRenameFile());
			pstmt.setString(6, review.getReviewContent());
			pstmt.setInt(7, review.getScore());
			pstmt.setString(8, review.getKeyword());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}		
		
		return result;
	}
	
	public int updateReview(Connection conn, Review review) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update tb_review set "
				+ "REVIEW_NAME = ?, "
				+ "REVIEW_MODIFY_DATE = sysdate, REVIEW_ORIGINAL_FILE = ?, "
				+ "REVIEW_RENAME_FILE = ?, REVIEW_CONTENT = ?, "
				+ "SCORE = ?, KEYWORD = ? "
				+ "WHERE REVIEW_CD = ?";
		
		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, review.getReviewName());

			pstmt.setString(2, review.getReviewOriginalFile());
			pstmt.setString(3, review.getReviewRenameFile());
			pstmt.setString(4, review.getReviewContent());
			pstmt.setInt(5, review.getScore());
			pstmt.setString(6, review.getKeyword());
			pstmt.setInt(7, review.getReviewCd());
			
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int deleteReview(Connection conn, int reviewcd) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from tb_review where review_cd = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reviewcd);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Review> selectTop6(Connection conn){
		ArrayList<Review> list = new ArrayList<Review>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "SELECT REVIEW_NAME, SCORE, KEYWORD, "
				+ "			REVIEW_CONTENT, REVIEW_REG_DATE, BOOK_IMG, BOOK_NM "
				+ "FROM (SELECT * "
				+ "			FROM TB_REVIEW "
				+  "           JOIN TB_BOOK "
				+  "           ON TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "			ORDER BY SCORE DESC) "
				+ "WHERE ROWNUM = 1";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
					
			while(rset.next()) {
				Review review = new Review();
				
				review.setScore(rset.getInt("score"));
				review.setReviewName(rset.getString("review_name"));
				review.setKeyword(rset.getString("keyword"));
				review.setReviewContent(rset.getString("review_content"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setBookImg(rset.getString("book_img"));
				review.setBookNm(rset.getString("book_nm"));
				
				list.add(review);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}
	
	public ArrayList<Review> selectTopPaper(Connection conn) {
		ArrayList<Review> list = new ArrayList<Review>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "SELECT REVIEW_NAME, REVIEW_WRITER_ID, REVIEW_REG_DATE, REVIEW_CONTENT, BOOK_IMG, BOOK_NM "
			+	"              FROM (SELECT * "
			+  "                         FROM TB_REVIEW "
			+  "                         JOIN TB_BOOK "
			+  "                         ON TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
			+  "                         WHERE BOOK_TYPE_NUM = 1 "
			+  "                         ORDER BY SCORE DESC) "
			+  "               WHERE ROWNUM <= 3";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
					
			while(rset.next()) {
				Review review = new Review();
				
//				review.setReviewCd(rset.getInt("review_cd"));
				review.setReviewName(rset.getString("review_name"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewContent(rset.getString("review_content"));
				review.setBookImg(rset.getString("book_img"));
				review.setBookNm(rset.getString("book_nm"));
				
				list.add(review);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}
	
	public ArrayList<Review> selectTopEbook(Connection conn) {
		ArrayList<Review> list = new ArrayList<Review>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "SELECT REVIEW_NAME, REVIEW_WRITER_ID, REVIEW_REG_DATE, REVIEW_CONTENT, BOOK_IMG, BOOK_NM "
			+	"              FROM (SELECT * "
			+  "                         FROM TB_REVIEW "
			+  "                         JOIN TB_BOOK "
			+  "                         ON TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
			+  "                         WHERE BOOK_TYPE_NUM = 2 "
			+  "                         ORDER BY SCORE DESC) "
			+  "               WHERE ROWNUM <= 3";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
					
			while(rset.next()) {
				Review review = new Review();
				
//				review.setReviewCd(rset.getInt("review_cd"));
				review.setReviewName(rset.getString("review_name"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewContent(rset.getString("review_content"));
				review.setBookImg(rset.getString("book_img"));
				review.setBookNm(rset.getString("book_nm"));
				
				list.add(review);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}

	public ArrayList<Review> selectTopAudio(Connection conn) {
		ArrayList<Review> list = new ArrayList<Review>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "SELECT REVIEW_NAME, REVIEW_WRITER_ID, REVIEW_REG_DATE, REVIEW_CONTENT, BOOK_IMG, BOOK_NM "
			+	"              FROM (SELECT * "
			+  "                         FROM TB_REVIEW "
			+  "                         JOIN TB_BOOK "
			+  "                         ON TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
			+  "                         WHERE BOOK_TYPE_NUM = 3 "
			+  "                         ORDER BY SCORE DESC) "
			+  "               WHERE ROWNUM <= 3";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
					
			while(rset.next()) {
				Review review = new Review();
				
//				review.setReviewCd(rset.getInt("review_cd"));
				review.setReviewName(rset.getString("review_name"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewContent(rset.getString("review_content"));
				review.setBookImg(rset.getString("book_img"));
				review.setBookNm(rset.getString("book_nm"));
				
				list.add(review);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}

	public ArrayList<ReviewList> selectPaperList(Connection conn) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM(SELECT ROWNUM RNUM, BOOK_NM, AUTHOR, PUBLISHER, PUBLISH_DATE, SCORE, KEYWORD, REVIEW_WRITER_ID, REVIEW_CONTENT, REVIEW_REG_DATE "
				+ "	   								FROM (SELECT * "
				+ "   											   FROM TB_REVIEW "
				+ " 			 								    JOIN TB_BOOK "
				+ " 			    								 ON TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "			    								 WHERE BOOK_TYPE_NUM = 1)) ";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();

				
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublisher(rset.getString("publisher"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewContent(rset.getString("review_content"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));

				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<ReviewList> selectEBookList(Connection conn) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM(SELECT BOOK_NM, AUTHOR, PUBLISHER, PUBLISH_DATE, SCORE, KEYWORD, REVIEW_WRITER_ID, REVIEW_CONTENT, REVIEW_REG_DATE "
				+ "	   								FROM (SELECT * "
				+ "   											   FROM TB_REVIEW "
				+ " 			 								    JOIN TB_BOOK "
				+ " 			    								 ON TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "			    								 WHERE BOOK_TYPE_NUM = 2)) ";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();

				
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublisher(rset.getString("publisher"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewContent(rset.getString("review_content"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));

				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<ReviewList> selectAudioList(Connection conn) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM(SELECT BOOK_NM, AUTHOR, PUBLISHER, PUBLISH_DATE, SCORE, KEYWORD, REVIEW_WRITER_ID, REVIEW_CONTENT, REVIEW_REG_DATE "
				+ "	   								FROM (SELECT * "
				+ "   											   FROM TB_REVIEW "
				+ " 			 								    JOIN TB_BOOK "
				+ " 			    								 ON TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "			    								 WHERE BOOK_TYPE_NUM = 3)) ";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();

				
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublisher(rset.getString("publisher"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewContent(rset.getString("review_content"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));

				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}


	public ArrayList<ReviewList> selectPaperDetailList(Connection conn, String bookNm) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM(SELECT BOOK_NM, AUTHOR, PUBLISHER, PUBLISH_DATE, SCORE, KEYWORD, REVIEW_WRITER_ID, REVIEW_CONTENT, REVIEW_REG_DATE, "
				+ "									REVIEW_ORIGINAL_FILE, REVIEW_RENAME_FILE "	
				+ "	   								FROM (SELECT * "
				+ "   											   FROM TB_REVIEW "
				+ " 			 								    JOIN TB_BOOK "
				+ " 			    								 ON TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "			    								 WHERE BOOK_TYPE_NUM = 1 AND BOOK_NM = ?)) ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookNm);

			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();

				
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublisher(rset.getString("publisher"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewContent(rset.getString("review_content"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewOriginalFile(rset.getString("review_original_file"));
				review.setReviewRenameFile(rset.getString("review_rename_file"));
				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}


	public ArrayList<ReviewList> selectEBookDetailList(Connection conn, String bookNm) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM(SELECT BOOK_NM, AUTHOR, PUBLISHER, PUBLISH_DATE, SCORE, KEYWORD, REVIEW_WRITER_ID, REVIEW_CONTENT, REVIEW_REG_DATE, "
				+ " 								REVIEW_ORIGINAL_FILE, REVIEW_RENAME_FILE "
				+ "	   								FROM (SELECT * "
				+ "   											   FROM TB_REVIEW "
				+ " 			 								    JOIN TB_BOOK "
				+ " 			    								 ON TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "			    								 WHERE BOOK_TYPE_NUM = 2 AND BOOK_NM = ?)) ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookNm);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();

				
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublisher(rset.getString("publisher"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewContent(rset.getString("review_content"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewOriginalFile(rset.getString("review_original_file"));
				review.setReviewRenameFile(rset.getString("review_rename_file"));

				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int getListCountA(Connection conn, String bookNm) {
		int listCount = 0;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String query = "select count(*) "
				+ "	   FROM (SELECT * "
				+ "   				 FROM TB_REVIEW "
				+ " 			     JOIN TB_BOOK "
				+ " 			     ON TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "			     WHERE BOOK_TYPE_NUM = 3 AND WHERE BOOK_NM = ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookNm);
			rset = pstmt.executeQuery();
			 
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}

	public ArrayList<ReviewList> selectAudioDetailList(Connection conn, String bookNm) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM(SELECT BOOK_NM, AUTHOR, PUBLISHER, PUBLISH_DATE, SCORE, KEYWORD, REVIEW_WRITER_ID, REVIEW_CONTENT, REVIEW_REG_DATE, "
				+ "									REVIEW_ORIGINAL_FILE, REVIEW_RENAME_FILE "
				+ "	   								FROM (SELECT * "
				+ "   											   FROM TB_REVIEW "
				+ " 			 								    JOIN TB_BOOK "
				+ " 			    								 ON TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "			    								 WHERE BOOK_TYPE_NUM = 3 AND BOOK_NM = ?)) ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookNm);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();

				
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublisher(rset.getString("publisher"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewContent(rset.getString("review_content"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewOriginalFile(rset.getString("review_original_file"));
				review.setReviewRenameFile(rset.getString("review_rename_file"));

				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<ReviewList> selectCategoryP(Connection conn, int location, int category) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM(SELECT BOOK_NM, AUTHOR, PUBLISHER, PUBLISH_DATE, SCORE, KEYWORD, REVIEW_WRITER_ID, REVIEW_CONTENT, REVIEW_REG_DATE "
				+ "	   								FROM (SELECT * "
				+ "   											   FROM TB_REVIEW "
				+ " 			 								    JOIN TB_BOOK "
				+ " 			    								 ON TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "			    								 WHERE BOOK_TYPE_NUM = 1 ";
			
				if(location > 0 && category == 0) {
					query += "AND BOOK_LOC_NUM = ?)) ";
				} else if(category > 0 && location == 0) {
					query += "AND BOOK_CATE_CD = ?)) ";
				} else if(location > 0 && category > 0) {
					query += "AND BOOK_LOC_NUM = ? AND BOOK_CATE_CD = ?)) ";
				} else {
					query += ")) ";
				}
		try {
			pstmt = conn.prepareStatement(query);
			
			if(location >0 && category == 0) {
				pstmt.setInt(1, location);
			} else if(category > 0 && location == 0) {
				pstmt.setInt(1, category);
			} else if(location > 0 && category > 0) {
				pstmt.setInt(1, location);
				pstmt.setInt(2, category);
			} else {
				
			}
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();
				
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublisher(rset.getString("publisher"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewContent(rset.getString("review_content"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));

	
				list.add(review);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(rset);
				close(pstmt);
		}
		
		return list;
	}

	public ArrayList<ReviewList> selectCategoryE(Connection conn, int location, int category) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM(SELECT BOOK_NM, AUTHOR, PUBLISHER, PUBLISH_DATE, SCORE, KEYWORD, REVIEW_WRITER_ID, REVIEW_CONTENT, REVIEW_REG_DATE "
				+ "	   								FROM (SELECT * "
				+ "   											   FROM TB_REVIEW "
				+ " 			 								    JOIN TB_BOOK "
				+ " 			    								 ON TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "			    								 WHERE BOOK_TYPE_NUM = 2 ";
			
				if(location > 0 && category == 0) {
					query += "AND BOOK_LOC_NUM = ?)) ";
				} else if(category > 0 && location == 0) {
					query += "AND BOOK_CATE_CD = ?)) ";
				} else if(location > 0 && category > 0) {
					query += "AND BOOK_LOC_NUM = ? AND BOOK_CATE_CD = ?)) ";
				} else {
					query += ")) ";
				}
		try {
			pstmt = conn.prepareStatement(query);
			
			if(location >0 && category == 0) {
				pstmt.setInt(1, location);
			} else if(category > 0 && location == 0) {
				pstmt.setInt(1, category);
			} else if(location > 0 && category > 0) {
				pstmt.setInt(1, location);
				pstmt.setInt(2, category);
			} else {
				
			}
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();
				
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublisher(rset.getString("publisher"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewContent(rset.getString("review_content"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));

	
				list.add(review);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(rset);
				close(pstmt);
		}
		
		return list;
	}

	public ArrayList<ReviewList> selectCategoryA(Connection conn, int location, int category) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM(SELECT BOOK_NM, AUTHOR, PUBLISHER, PUBLISH_DATE, SCORE, KEYWORD, REVIEW_WRITER_ID, REVIEW_CONTENT, REVIEW_REG_DATE "
				+ "	   								FROM (SELECT * "
				+ "   											   FROM TB_REVIEW "
				+ " 			 								    JOIN TB_BOOK "
				+ " 			    								 ON TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "			    								 WHERE BOOK_TYPE_NUM = 3 ";
			
				if(location > 0 && category == 0) {
					query += "AND BOOK_LOC_NUM = ?)) ";
				} else if(category > 0 && location == 0) {
					query += "AND BOOK_CATE_CD = ?)) ";
				} else if(location > 0 && category > 0) {
					query += "AND BOOK_LOC_NUM = ? AND BOOK_CATE_CD = ?)) ";
				} else {
					query += ")) ";
				}
		try {
			pstmt = conn.prepareStatement(query);
			
			if(location >0 && category == 0) {
				pstmt.setInt(1, location);
			} else if(category > 0 && location == 0) {
				pstmt.setInt(1, category);
			} else if(location > 0 && category > 0) {
				pstmt.setInt(1, location);
				pstmt.setInt(2, category);
			} else {
				
			}
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();
				
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublisher(rset.getString("publisher"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewContent(rset.getString("review_content"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));

	
				list.add(review);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(rset);
				close(pstmt);
		}
		
		return list;
	}


	public ArrayList<ReviewList> selectMyList(Connection conn, String reviewname) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM(SELECT REVIEW_CD, BOOK_NM, REVIEW_NAME, SCORE, KEYWORD, REVIEW_WRITER_ID, REVIEW_CONTENT, REVIEW_REG_DATE, REVIEW_MODIFY_DATE "
				+ "	   								FROM (SELECT * "
				+ "   											   FROM TB_REVIEW "
				+ " 			 								    JOIN TB_BOOK "
				+ " 			    								 ON TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "											   WHERE REVIEW_NAME = ?)) ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, reviewname);

			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();
//				User user = new User();	
				
				review.setReviewCd(rset.getInt("review_cd"));
				review.setBookNm(rset.getString("book_nm"));
				review.setReviewName(rset.getString("review_name"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setReviewContent(rset.getString("review_content"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewModifyDate(rset.getDate("review_modify_date"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
//				user.setUserId(rset.getString("user_id"));
				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public Review selectOne(Connection conn, String reviewname) {
		Review review = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_review where review_name = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, reviewname);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				review = new Review();
				
				review.setReviewName(rset.getString("review_name"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewModifyDate(rset.getDate("review_modify_date"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewCd(rset.getInt("review_cd"));
				review.setReviewBookId(rset.getInt("review_book_id"));
				review.setReviewOriginalFile(rset.getString("review_original_file"));
				review.setReviewRenameFile(rset.getString("review_rename_file"));
				review.setReviewContent(rset.getString("review_content"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return review;
	}

	public ArrayList<ReviewList> selectAdminList(Connection conn) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from (SELECT REVIEW_CD, REVIEW_WRITER_ID, REVIEW_BOOK_ID, REVIEW_NAME, REVIEW_REG_DATE, REVIEW_MODIFY_DATE, "
              + " REVIEW_ORIGINAL_FILE, REVIEW_RENAME_FILE, REVIEW_CONTENT, SCORE, KEYWORD "
              +   "from tb_review " 
              + "order by review_cd desc) ";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();
				
				review.setReviewCd(rset.getInt("review_cd"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewBookId(rset.getInt("review_book_id"));
				review.setReviewName(rset.getString("review_name"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewModifyDate(rset.getDate("review_modify_date"));
				review.setReviewOriginalFile(rset.getString("review_original_file"));
				review.setReviewRenameFile(rset.getString("review_rename_file"));
				review.setReviewContent(rset.getString("review_content"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;

	}


	public ArrayList<ReviewList> selectSearchUserId(Connection conn, String keyword) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_review "
				+ "where review_writer_id like ?"; // '%'||?||'%' : 에러
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				review.setReviewCd(rset.getInt("review_cd"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewBookId(rset.getInt("review_book_id"));
				review.setReviewName(rset.getString("review_name"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewModifyDate(rset.getDate("review_modify_date"));
				review.setReviewOriginalFile(rset.getString("review_original_file"));
				review.setReviewRenameFile(rset.getString("review_rename_file"));
				review.setReviewContent(rset.getString("review_content"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<ReviewList> selectSearchReviewname(Connection conn, String keyword) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_review "
				+ "where review_name like ?"; // '%'||?||'%' : 에러
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				review.setReviewCd(rset.getInt("review_cd"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewBookId(rset.getInt("review_book_id"));
				review.setReviewName(rset.getString("review_name"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewModifyDate(rset.getDate("review_modify_date"));
				review.setReviewOriginalFile(rset.getString("review_original_file"));
				review.setReviewRenameFile(rset.getString("review_rename_file"));
				review.setReviewContent(rset.getString("review_content"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<ReviewList> selectSearchEnrollDate(Connection conn, Date begin, Date end) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_review "
				+ "where review_reg_date between ? and ?"; 
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setDate(1, begin);
			pstmt.setDate(2, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();
				
				review.setReviewCd(rset.getInt("review_cd"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewBookId(rset.getInt("review_book_id"));
				review.setReviewName(rset.getString("review_name"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewModifyDate(rset.getDate("review_modify_date"));
				review.setReviewOriginalFile(rset.getString("review_original_file"));
				review.setReviewRenameFile(rset.getString("review_rename_file"));
				review.setReviewContent(rset.getString("review_content"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));

				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ReviewList selectReview(Connection conn, int reviewcd) {
		ReviewList rselect = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select REVIEW_CD, REVIEW_WRITER_ID, REVIEW_BOOK_ID, REVIEW_NAME, REVIEW_REG_DATE, REVIEW_MODIFY_DATE, REVIEW_ORIGINAL_FILE, REVIEW_RENAME_FILE, "
				+ "           REVIEW_CONTENT, SCORE, KEYWORD "
				+ "from tb_review "
				+ "where review_cd = ?";				
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reviewcd);			
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				rselect = new ReviewList();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				rselect.setReviewCd(rset.getInt("review_cd"));
				rselect.setReviewWriterId(rset.getString("review_writer_id"));
			    rselect.setReviewBookId(rset.getInt("review_book_id"));
			    rselect.setReviewName(rset.getString("review_name"));
			    rselect.setReviewRegDate(rset.getDate("review_reg_date"));
			    rselect.setReviewModifyDate(rset.getDate("review_modify_date"));
			    rselect.setReviewOriginalFile(rset.getString("review_original_file"));
			    rselect.setReviewRenameFile(rset.getString("review_rename_file"));
			    rselect.setReviewContent(rset.getString("review_content"));
			    rselect.setScore(rset.getInt("score"));
			    rselect.setKeyword(rset.getString("keyword"));

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return rselect;
	}

	public ArrayList<ReviewList> selectPaperSearchBookName(Connection conn, String keyword) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_review join tb_book on  TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "where tb_book.book_nm like ? and tb_book.book_type_num = 1"; // '%'||?||'%' : 에러
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				review.setReviewCd(rset.getInt("review_cd"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewBookId(rset.getInt("review_book_id"));
				review.setReviewName(rset.getString("review_name"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewModifyDate(rset.getDate("review_modify_date"));
				review.setReviewContent(rset.getString("review_content"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setPublisher(rset.getString("publisher"));
				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<ReviewList> selectPaperSearchWriterId(Connection conn, String keyword) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_review join tb_book on  TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "where review_writer_id like ? and tb_book.book_type_num = 1"; // '%'||?||'%' : 에러
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				review.setReviewCd(rset.getInt("review_cd"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewBookId(rset.getInt("review_book_id"));
				review.setReviewName(rset.getString("review_name"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewModifyDate(rset.getDate("review_modify_date"));
				review.setReviewContent(rset.getString("review_content"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setPublisher(rset.getString("publisher"));
				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<ReviewList> selectEbookSearchBookName(Connection conn, String keyword) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_review join tb_book on  TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "where tb_book.book_nm like ? and tb_book.book_type_num = 2"; // '%'||?||'%' : 에러
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				review.setReviewCd(rset.getInt("review_cd"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewBookId(rset.getInt("review_book_id"));
				review.setReviewName(rset.getString("review_name"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewModifyDate(rset.getDate("review_modify_date"));
				review.setReviewContent(rset.getString("review_content"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setPublisher(rset.getString("publisher"));
				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<ReviewList> selectEbookSearchWriterId(Connection conn, String keyword) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_review join tb_book on  TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "where review_writer_id like ? and tb_book.book_type_num = 2"; // '%'||?||'%' : 에러
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				review.setReviewCd(rset.getInt("review_cd"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewBookId(rset.getInt("review_book_id"));
				review.setReviewName(rset.getString("review_name"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewModifyDate(rset.getDate("review_modify_date"));
				review.setReviewContent(rset.getString("review_content"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setPublisher(rset.getString("publisher"));
				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<ReviewList> selectAudioSearchBookName(Connection conn, String keyword) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_review join tb_book on  TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "where tb_book.book_nm like ? and tb_book.book_type_num = 3"; // '%'||?||'%' : 에러
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				review.setReviewCd(rset.getInt("review_cd"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewBookId(rset.getInt("review_book_id"));
				review.setReviewName(rset.getString("review_name"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewModifyDate(rset.getDate("review_modify_date"));
				review.setReviewContent(rset.getString("review_content"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setPublisher(rset.getString("publisher"));
				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<ReviewList> selectAudioSearchWriterId(Connection conn, String keyword) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_review join tb_book on  TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "where review_writer_id like ? and tb_book.book_type_num = 3"; // '%'||?||'%' : 에러
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				review.setReviewCd(rset.getInt("review_cd"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewBookId(rset.getInt("review_book_id"));
				review.setReviewName(rset.getString("review_name"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewModifyDate(rset.getDate("review_modify_date"));
				review.setReviewContent(rset.getString("review_content"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setPublisher(rset.getString("publisher"));
				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<ReviewList> selectAllSearchBookName(Connection conn, String keyword) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_review join tb_book on  TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "where tb_book.book_nm like ?"; // '%'||?||'%' : 에러
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				review.setReviewCd(rset.getInt("review_cd"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewBookId(rset.getInt("review_book_id"));
				review.setReviewName(rset.getString("review_name"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewModifyDate(rset.getDate("review_modify_date"));
				review.setReviewContent(rset.getString("review_content"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setPublisher(rset.getString("publisher"));
				review.setBookTypeNum(rset.getInt("book_type_num"));
				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<ReviewList> selectAllSearchWriterId(Connection conn, String keyword) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_review join tb_book on  TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "where review_writer_id like ?"; // '%'||?||'%' : 에러
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				review.setReviewCd(rset.getInt("review_cd"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewBookId(rset.getInt("review_book_id"));
				review.setReviewName(rset.getString("review_name"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewModifyDate(rset.getDate("review_modify_date"));
				review.setReviewContent(rset.getString("review_content"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setPublisher(rset.getString("publisher"));
				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<ReviewList> selectAllDetailList(Connection conn, String bookNm) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM(SELECT BOOK_NM, AUTHOR, PUBLISHER, PUBLISH_DATE, SCORE, KEYWORD, REVIEW_WRITER_ID, REVIEW_CONTENT, REVIEW_REG_DATE, BOOK_TYPE_NUM "
				+ "	   								FROM (SELECT * "
				+ "   											   FROM TB_REVIEW "
				+ " 			 								    JOIN TB_BOOK "
				+ " 			    								 ON TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "			    								 WHERE BOOK_NM = ?)) ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookNm);

			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();

				
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublisher(rset.getString("publisher"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewContent(rset.getString("review_content"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setBookTypeNum(rset.getInt("book_type_num"));

				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<ReviewList> selectEbookSearchBookName(Connection conn, String keyword, int location) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_review join tb_book on  TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "where tb_book.book_nm like ? and tb_book.book_type_num = 2 and tb_book.book_loc_num = ?"; // '%'||?||'%' : 에러
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, location);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				review.setReviewCd(rset.getInt("review_cd"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewBookId(rset.getInt("review_book_id"));
				review.setReviewName(rset.getString("review_name"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewModifyDate(rset.getDate("review_modify_date"));
				review.setReviewContent(rset.getString("review_content"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setPublisher(rset.getString("publisher"));
				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<ReviewList> selectEbookSearchWriterId(Connection conn, String keyword, int location) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_review join tb_book on  TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "where review_writer_id like ? and tb_book.book_type_num = 2 and tb_book.book_loc_num = ?"; // '%'||?||'%' : 에러
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, location);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				review.setReviewCd(rset.getInt("review_cd"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewBookId(rset.getInt("review_book_id"));
				review.setReviewName(rset.getString("review_name"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewModifyDate(rset.getDate("review_modify_date"));
				review.setReviewContent(rset.getString("review_content"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setPublisher(rset.getString("publisher"));
				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<ReviewList> selectEbookSearchBookName2(Connection conn, String keyword, int category) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_review join tb_book on  TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "where tb_book.book_nm like ? and tb_book.book_type_num = 2 and tb_book.book_cate_cd = ?"; // '%'||?||'%' : 에러
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, category);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				review.setReviewCd(rset.getInt("review_cd"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewBookId(rset.getInt("review_book_id"));
				review.setReviewName(rset.getString("review_name"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewModifyDate(rset.getDate("review_modify_date"));
				review.setReviewContent(rset.getString("review_content"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setPublisher(rset.getString("publisher"));
				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<ReviewList> selectEbookSearchWriterId2(Connection conn, String keyword, int category) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_review join tb_book on  TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "where review_writer_id like ? and tb_book.book_type_num = 2 and tb_book.book_cate_cd = ?"; // '%'||?||'%' : 에러
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, category);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				review.setReviewCd(rset.getInt("review_cd"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewBookId(rset.getInt("review_book_id"));
				review.setReviewName(rset.getString("review_name"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewModifyDate(rset.getDate("review_modify_date"));
				review.setReviewContent(rset.getString("review_content"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setPublisher(rset.getString("publisher"));
				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<ReviewList> selectEbookSearchBookName3(Connection conn, String keyword, int category,
			int location) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_review join tb_book on  TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "where tb_book.book_nm like ? and tb_book.book_type_num = 2 and tb_book.book_cate_cd = ? and tb_book.book_loc_num = ?"; // '%'||?||'%' : 에러
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, category);
			pstmt.setInt(3, location);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				review.setReviewCd(rset.getInt("review_cd"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewBookId(rset.getInt("review_book_id"));
				review.setReviewName(rset.getString("review_name"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewModifyDate(rset.getDate("review_modify_date"));
				review.setReviewContent(rset.getString("review_content"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setPublisher(rset.getString("publisher"));
				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<ReviewList> selectEbookSearchWriterId3(Connection conn, String keyword, int category,
			int location) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_review join tb_book on  TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "where review_writer_id like ? and tb_book.book_type_num = 2 and tb_book.book_cate_cd = ? and tb_book.book_loc_num = ?"; // '%'||?||'%' : 에러
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, category);
			pstmt.setInt(3, location);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				review.setReviewCd(rset.getInt("review_cd"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewBookId(rset.getInt("review_book_id"));
				review.setReviewName(rset.getString("review_name"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewModifyDate(rset.getDate("review_modify_date"));
				review.setReviewContent(rset.getString("review_content"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setPublisher(rset.getString("publisher"));
				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<ReviewList> selectPaperSearchBookName(Connection conn, String keyword, int location) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_review join tb_book on  TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "where tb_book.book_nm like ? and tb_book.book_type_num = 1 and tb_book.book_loc_num = ?"; // '%'||?||'%' : 에러
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, location);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				review.setReviewCd(rset.getInt("review_cd"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewBookId(rset.getInt("review_book_id"));
				review.setReviewName(rset.getString("review_name"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewModifyDate(rset.getDate("review_modify_date"));
				review.setReviewContent(rset.getString("review_content"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setPublisher(rset.getString("publisher"));
				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<ReviewList> selectPaperSearchWriterId(Connection conn, String keyword, int location) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_review join tb_book on  TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "where review_writer_id like ? and tb_book.book_type_num = 1 and tb_book.book_loc_num = ?"; // '%'||?||'%' : 에러
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, location);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				review.setReviewCd(rset.getInt("review_cd"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewBookId(rset.getInt("review_book_id"));
				review.setReviewName(rset.getString("review_name"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewModifyDate(rset.getDate("review_modify_date"));
				review.setReviewContent(rset.getString("review_content"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setPublisher(rset.getString("publisher"));
				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<ReviewList> selectPaperSearchBookName2(Connection conn, String keyword, int category) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_review join tb_book on  TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "where tb_book.book_nm like ? and tb_book.book_type_num = 1 and tb_book.book_cate_cd = ?"; // '%'||?||'%' : 에러
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, category);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				review.setReviewCd(rset.getInt("review_cd"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewBookId(rset.getInt("review_book_id"));
				review.setReviewName(rset.getString("review_name"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewModifyDate(rset.getDate("review_modify_date"));
				review.setReviewContent(rset.getString("review_content"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setPublisher(rset.getString("publisher"));
				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<ReviewList> selectPaperSearchWriterId2(Connection conn, String keyword, int category) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_review join tb_book on  TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "where review_writer_id like ? and tb_book.book_type_num = 1 and tb_book.book_cate_cd = ?"; // '%'||?||'%' : 에러
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, category);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				review.setReviewCd(rset.getInt("review_cd"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewBookId(rset.getInt("review_book_id"));
				review.setReviewName(rset.getString("review_name"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewModifyDate(rset.getDate("review_modify_date"));
				review.setReviewContent(rset.getString("review_content"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setPublisher(rset.getString("publisher"));
				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<ReviewList> selectPaperSearchBookName3(Connection conn, String keyword, int location,
			int category) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_review join tb_book on  TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "where tb_book.book_nm like ? and tb_book.book_type_num = 1 and tb_book.book_loc_num = ? and tb_book.book_cate_cd = ?"; // '%'||?||'%' : 에러
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, location);
			pstmt.setInt(3, category);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				review.setReviewCd(rset.getInt("review_cd"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewBookId(rset.getInt("review_book_id"));
				review.setReviewName(rset.getString("review_name"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewModifyDate(rset.getDate("review_modify_date"));
				review.setReviewContent(rset.getString("review_content"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setPublisher(rset.getString("publisher"));
				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<ReviewList> selectPaperSearchWriterId3(Connection conn, String keyword, int location,
			int category) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_review join tb_book on  TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "where review_writer_id like ? and tb_book.book_type_num = 1 and tb_book.book_loc_num = ? and tb_book.book_cate_cd = ?"; // '%'||?||'%' : 에러
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, location);
			pstmt.setInt(3, category);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				review.setReviewCd(rset.getInt("review_cd"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewBookId(rset.getInt("review_book_id"));
				review.setReviewName(rset.getString("review_name"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewModifyDate(rset.getDate("review_modify_date"));
				review.setReviewContent(rset.getString("review_content"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setPublisher(rset.getString("publisher"));
				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<ReviewList> selectAudioSearchBookName(Connection conn, String keyword, int location) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_review join tb_book on  TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "where tb_book.book_nm like ? and tb_book.book_type_num = 3 and tb_book.book_loc_num = ?"; // '%'||?||'%' : 에러
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, location);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				review.setReviewCd(rset.getInt("review_cd"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewBookId(rset.getInt("review_book_id"));
				review.setReviewName(rset.getString("review_name"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewModifyDate(rset.getDate("review_modify_date"));
				review.setReviewContent(rset.getString("review_content"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setPublisher(rset.getString("publisher"));
				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<ReviewList> selectAudioSearchWriterId(Connection conn, String keyword, int location) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_review join tb_book on  TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "where review_writer_id like ? and tb_book.book_type_num = 3 and tb_book.book_loc_num = ?"; // '%'||?||'%' : 에러
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, location);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				review.setReviewCd(rset.getInt("review_cd"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewBookId(rset.getInt("review_book_id"));
				review.setReviewName(rset.getString("review_name"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewModifyDate(rset.getDate("review_modify_date"));
				review.setReviewContent(rset.getString("review_content"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setPublisher(rset.getString("publisher"));
				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<ReviewList> selectAudioSearchBookName2(Connection conn, String keyword, int category) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_review join tb_book on  TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "where tb_book.book_nm like ? and tb_book.book_type_num = 3 and tb_book.book_cate_cd = ?"; // '%'||?||'%' : 에러
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, category);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				review.setReviewCd(rset.getInt("review_cd"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewBookId(rset.getInt("review_book_id"));
				review.setReviewName(rset.getString("review_name"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewModifyDate(rset.getDate("review_modify_date"));
				review.setReviewContent(rset.getString("review_content"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setPublisher(rset.getString("publisher"));
				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<ReviewList> selectAudioSearchWriterId2(Connection conn, String keyword, int category) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_review join tb_book on  TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "where review_writer_id like ? and tb_book.book_type_num = 3 and tb_book.book_cate_cd = ?"; // '%'||?||'%' : 에러
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, category);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				review.setReviewCd(rset.getInt("review_cd"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewBookId(rset.getInt("review_book_id"));
				review.setReviewName(rset.getString("review_name"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewModifyDate(rset.getDate("review_modify_date"));
				review.setReviewContent(rset.getString("review_content"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setPublisher(rset.getString("publisher"));
				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<ReviewList> selectAudioSearchBookName3(Connection conn, String keyword, int location,
			int category) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_review join tb_book on  TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "where tb_book.book_nm like ? and tb_book.book_type_num = 3 and tb_book.book_loc_num = ? and tb_book.book_cate_cd = ?"; // '%'||?||'%' : 에러
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, location);
			pstmt.setInt(3, category);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				review.setReviewCd(rset.getInt("review_cd"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewBookId(rset.getInt("review_book_id"));
				review.setReviewName(rset.getString("review_name"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewModifyDate(rset.getDate("review_modify_date"));
				review.setReviewContent(rset.getString("review_content"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setPublisher(rset.getString("publisher"));
				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<ReviewList> selectAudioSearchWriterId3(Connection conn, String keyword, int location,
			int category) {
		ArrayList<ReviewList> list = new ArrayList<ReviewList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_review join tb_book on  TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID "
				+ "where review_writer_id like ? and tb_book.book_type_num = 3 and tb_book.book_loc_num = ? and tb_book.book_cate_cd = ?"; // '%'||?||'%' : 에러
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, location);
			pstmt.setInt(3, category);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewList review = new ReviewList();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				review.setReviewCd(rset.getInt("review_cd"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewBookId(rset.getInt("review_book_id"));
				review.setReviewName(rset.getString("review_name"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setReviewModifyDate(rset.getDate("review_modify_date"));
				review.setReviewContent(rset.getString("review_content"));
				review.setScore(rset.getInt("score"));
				review.setKeyword(rset.getString("keyword"));
				review.setBookNm(rset.getString("book_nm"));
				review.setAuthor(rset.getString("author"));
				review.setPublishDate(rset.getDate("publish_date"));
				review.setPublisher(rset.getString("publisher"));
				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

public ArrayList<Review> selectTop4(Connection conn) {
		ArrayList<Review> list = new ArrayList<Review>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "SELECT REVIEW_NAME, SCORE, KEYWORD, REVIEW_WRITER_ID, REVIEW_CONTENT, REVIEW_REG_DATE, BOOK_IMG, BOOK_NM "
				+ "FROM (SELECT * "
				+ "        FROM TB_REVIEW "
				+ "        JOIN TB_BOOK ON (TB_REVIEW.REVIEW_BOOK_ID = TB_BOOK.BOOK_ID) "
				+ "		   JOIN TB_USER ON (TB_REVIEW.REVIEW_WRITER_ID = TB_USER.USER_ID) "
				+ "        ORDER BY SCORE DESC) "
				+ "WHERE ROWNUM BETWEEN 1 AND 4";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
					
			while(rset.next()) {
				Review review = new Review();
				
				review.setScore(rset.getInt("score"));
				review.setReviewName(rset.getString("review_name"));
				review.setReviewWriterId(rset.getString("REVIEW_WRITER_ID"));
				review.setKeyword(rset.getString("keyword"));
				review.setReviewContent(rset.getString("review_content"));
				review.setReviewRegDate(rset.getDate("review_reg_date"));
				review.setBookImg(rset.getString("book_img"));
				review.setBookNm(rset.getString("book_nm"));
				
				list.add(review);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}


public Review selectOne(Connection conn, int bookId) {
    Review review = null;
    PreparedStatement pstmt = null;
    ResultSet rset = null;
    
    String query = "select *from tb_review "
          + "join tb_book on review_book_id = book_id "
          + "where BOOK_TYPE_NUM = 1 and  rownum =1 and book_id = ?";
    
    try {
       pstmt = conn.prepareStatement(query);
       pstmt.setInt(1, bookId);
       rset = pstmt.executeQuery();

       if(rset.next()) {
          review = new Review();
          
          review.setReviewCd(rset.getInt("review_cd"));
          review.setReviewWriterId(rset.getString("review_writer_id"));
          review.setReviewBookId(rset.getInt("review_book_id"));
          review.setReviewName(rset.getString("review_name"));
          review.setScore(rset.getInt("score"));
          review.setReviewContent(rset.getString("review_content"));
 
       }
       
    } catch (Exception e) {
       e.printStackTrace();
    } finally {
       close(rset);
       close(pstmt);
    }
    
    return review;
 }

 public Review selectNmOne(Connection conn, String bookNm) {
    Review review = null;
    PreparedStatement pstmt = null;
    ResultSet rset = null;
    
    String query = "select *from tb_review "
          + "join tb_book on review_book_id = book_id "
          + "where BOOK_TYPE_NUM = 1 and  rownum =1 and book_nm = ?";
    
    try {
       pstmt = conn.prepareStatement(query);
       pstmt.setString(1, bookNm);
       rset = pstmt.executeQuery();

       if(rset.next()) {
          review = new Review();
          
          review.setReviewCd(rset.getInt("review_cd"));
          review.setReviewWriterId(rset.getString("review_writer_id"));
          review.setReviewBookId(rset.getInt("review_book_id"));
          review.setReviewName(rset.getString("review_name"));
          review.setScore(rset.getInt("score"));
          review.setReviewContent(rset.getString("review_content"));
       
       }
       
    } catch (Exception e) {
       e.printStackTrace();
    } finally {
       close(rset);
       close(pstmt);
    }
    
    return review;
 }

 public Review selectEOne(Connection conn, int bookId) {
    Review review = null;
    PreparedStatement pstmt = null;
    ResultSet rset = null;
 
    String query = "select *from  tb_book "
          + "join tb_review on book_id = review_book_id "
          + "where BOOK_TYPE_NUM = 2 and  rownum =1 and book_id = ?";
    
    try {
       pstmt = conn.prepareStatement(query);
       pstmt.setInt(1, bookId);
       rset = pstmt.executeQuery();

       if(rset.next()) {
          review = new Review();
          
          review.setReviewCd(rset.getInt("review_cd"));
          review.setReviewWriterId(rset.getString("review_writer_id"));
          review.setReviewBookId(rset.getInt("review_book_id"));
          review.setReviewName(rset.getString("review_name"));
          review.setScore(rset.getInt("score"));
          review.setReviewContent(rset.getString("review_content"));   
       }
       
    } catch (Exception e) {
       e.printStackTrace();
    } finally {
       close(rset);
       close(pstmt);
    }
    
    return review;
 }

 public Review selectENmOne(Connection conn, String bookNm) {
    Review review = null;
    PreparedStatement pstmt = null;
    ResultSet rset = null;
    
    String query = "select *from  tb_book "
                   + "join tb_review on book_id = review_book_id "
                   + "where BOOK_TYPE_NUM = 2 and  rownum =1 and book_nm = ?";
    
    try {
       pstmt = conn.prepareStatement(query);
       pstmt.setString(1, bookNm);
       rset = pstmt.executeQuery();

       if(rset.next()) {
          review = new Review();
          
          review.setReviewCd(rset.getInt("review_cd"));
          review.setReviewWriterId(rset.getString("review_writer_id"));
          review.setReviewBookId(rset.getInt("review_book_id"));
          review.setReviewName(rset.getString("review_name"));
          review.setScore(rset.getInt("score"));
          review.setReviewContent(rset.getString("review_content"));
       
       }
       
    } catch (Exception e) {
       e.printStackTrace();
    } finally {
       close(rset);
       close(pstmt);
    }
    
    return review;
 }

 public Review selectAOne(Connection conn, int bookId) {
    Review review = null;
    PreparedStatement pstmt = null;
    ResultSet rset = null;
 
    String query = "select *from  tb_book "
          + "join tb_review on book_id = review_book_id "
          + "where BOOK_TYPE_NUM = 3 and  rownum =1 and book_id = ?";
    
    try {
       pstmt = conn.prepareStatement(query);
       pstmt.setInt(1, bookId);
       rset = pstmt.executeQuery();

       if(rset.next()) {
          review = new Review();
          
          review.setReviewCd(rset.getInt("review_cd"));
          review.setReviewWriterId(rset.getString("review_writer_id"));
          review.setReviewBookId(rset.getInt("review_book_id"));
          review.setReviewName(rset.getString("review_name"));
          review.setScore(rset.getInt("score"));
          review.setReviewContent(rset.getString("review_content"));   
       }
       
    } catch (Exception e) {
       e.printStackTrace();
    } finally {
       close(rset);
       close(pstmt);
    }
    
    return review;
 }

 public Review selectANmOne(Connection conn, String bookNm) {
    Review review = null;
    PreparedStatement pstmt = null;
    ResultSet rset = null;
    
    String query = "select *from  tb_book "
                   + "join tb_review on book_id = review_book_id "
                   + "where BOOK_TYPE_NUM = 3 and  rownum =1 and book_nm = ?";
    
    try {
       pstmt = conn.prepareStatement(query);
       pstmt.setString(1, bookNm);
       rset = pstmt.executeQuery();

       if(rset.next()) {
          review = new Review();
          
          review.setReviewCd(rset.getInt("review_cd"));
          review.setReviewWriterId(rset.getString("review_writer_id"));
          review.setReviewBookId(rset.getInt("review_book_id"));
          review.setReviewName(rset.getString("review_name"));
          review.setScore(rset.getInt("score"));
          review.setReviewContent(rset.getString("review_content"));
       
       }
       
    } catch (Exception e) {
       e.printStackTrace();
    } finally {
       close(rset);
       close(pstmt);
    }
    
    return review;

 }
 
 public int deleteReview(Connection conn, String userid) {
     int result = 0;
     PreparedStatement pstmt = null;
     
     String query = "delete from tb_review where REVIEW_WRITER_ID = ?";
     
     try {
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, userid);
        
        result = pstmt.executeUpdate();
        
     } catch (Exception e) {
        e.printStackTrace();
     } finally {
        close(pstmt);
     }
     
     return result;
  }

	public Review selectAdminOne(Connection conn, int bookId) {
		Review review = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from tb_review " + "join tb_book on (tb_review.review_book_id = tb_book.book_id) "
				+ "where rownum =1 and book_id = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookId);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				review = new Review();

				review.setReviewCd(rset.getInt("review_cd"));
				review.setReviewWriterId(rset.getString("review_writer_id"));
				review.setReviewBookId(rset.getInt("review_book_id"));
				review.setReviewName(rset.getString("review_name"));
				review.setScore(rset.getInt("score"));
				review.setReviewContent(rset.getString("review_content"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return review;
	}

	public Review selectAllOne(Connection conn, int bookId) {
	      Review review = null;
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;

	      String query = "select * from tb_review " + "join tb_book on (tb_review.review_book_id = tb_book.book_id) "
	            + "where rownum =1 and book_id = ?";

	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setInt(1, bookId);
	         rset = pstmt.executeQuery();

	         if (rset.next()) {
	            review = new Review();

	            review.setReviewCd(rset.getInt("review_cd"));
	            review.setReviewWriterId(rset.getString("review_writer_id"));
	            review.setReviewBookId(rset.getInt("review_book_id"));
	            review.setReviewName(rset.getString("review_name"));
	            review.setScore(rset.getInt("score"));
	            review.setReviewContent(rset.getString("review_content"));

	         }

	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         close(pstmt);
	      }

	      return review;
	}

}

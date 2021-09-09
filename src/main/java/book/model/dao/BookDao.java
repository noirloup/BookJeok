package book.model.dao;

import static common.JDBCTemp.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import book.model.vo.Book;
import book.model.vo.OtherSite;
import review.model.vo.Review;

public class BookDao {

	public ArrayList<Book> selectBookList(Connection conn) {
		ArrayList<Book> list = new ArrayList<Book>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_book order by book_id ";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Book book = new Book();
				
				book.setBookId(rset.getInt("book_id"));
				book.setBookCateCd(rset.getInt("book_cate_cd"));
				book.setBookTypeNum(rset.getInt("book_type_num"));
				book.setBookLocNum(rset.getInt("book_loc_num"));
				book.setBookImg(rset.getString("book_img"));
				book.setBookNm(rset.getString("book_nm"));
				book.setIsbn(rset.getInt("isbn"));
				book.setRanking(rset.getInt("ranking"));
				book.setBookIntro(rset.getString("book_intro"));
				book.setAuthor(rset.getString("author"));
				book.setAuthorIntro(rset.getString("author_intro"));
				book.setBookPrice(rset.getInt("book_price"));
				book.setAvgScore(rset.getInt("avg_score"));
				book.setPublisher(rset.getString("publisher"));
				book.setPublishDate(rset.getDate("publish_date"));
				book.setBookIndex(rset.getString("book_index"));	
				
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	// 페이퍼북 베스트셀러 조회
		public ArrayList<Book> selectBestTop10(Connection conn) {
			ArrayList<Book> list = new ArrayList<Book>();
			Statement stmt = null;
			ResultSet rset = null;
			String query = "select book_id, book_nm, book_img, author, ranking from tb_book "
					+ "where book_type_num =1 and ranking<=10 "
					+ "order by ranking";
			try {
				stmt = conn.createStatement();
				rset = stmt.executeQuery(query);
				
				while(rset.next()) {
					Book book = new Book();
					
					book.setBookId(rset.getInt("book_id"));
					book.setBookNm(rset.getString("book_nm"));
					book.setBookImg(rset.getString("book_img"));
					book.setAuthor(rset.getString("author"));
					book.setRanking(rset.getInt("ranking"));
					
					list.add(book);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
					close(rset);
					close(stmt);
			}
			
			return list;
		}
		

		// 페이퍼북 신규 조회
		public ArrayList<Book> selectNewTop10(Connection conn) {
			ArrayList<Book> list = new ArrayList<Book>();
			Statement stmt = null;
			ResultSet rset = null;
			String query = "select book_id, book_nm, book_img, author, ranking from tb_book "
					+ "where book_type_num =1 and rownum <=12 order by publish_date desc";
			try {
				stmt = conn.createStatement();
				rset = stmt.executeQuery(query);
				
				while(rset.next()) {
					Book book = new Book();
					
					book.setBookId(rset.getInt("book_id"));
					book.setBookNm(rset.getString("book_nm"));
					book.setBookImg(rset.getString("book_img"));
					book.setAuthor(rset.getString("author"));
					
					list.add(book);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
					close(rset);
					close(stmt);
			}
			
			return list;
		}
		
		//E-Book 신규도서 조회
		public ArrayList<Book> selectNewETop10(Connection conn) {
			ArrayList<Book> list = new ArrayList<Book>();
			Statement stmt = null;
			ResultSet rset = null;
			String query = "select book_id, book_nm, author, book_img, ranking from tb_book "
					+ "where book_type_num =2 and rownum <=12 order by publish_date desc";
			try {
				stmt = conn.createStatement();
				rset = stmt.executeQuery(query);
				
				while(rset.next()) {
					Book book = new Book();
					
					book.setBookId(rset.getInt("book_id"));
					book.setBookNm(rset.getString("book_nm"));
					book.setBookImg(rset.getString("book_img"));
					book.setAuthor(rset.getString("author"));
					
					list.add(book);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
					close(rset);
					close(stmt);
			}
			
			return list;
		}
		
		//E-Book 베스트 조회 
		public ArrayList<Book> selectBestETop10(Connection conn) {
			ArrayList<Book> list = new ArrayList<Book>();
			Statement stmt = null;
			ResultSet rset = null;
			String query = "select book_id, book_nm, book_img, author, ranking from tb_book "
					+ "where book_type_num =2 and ranking<=10 "
					+ "order by ranking";
			try {
				stmt = conn.createStatement();
				rset = stmt.executeQuery(query);
				
				while(rset.next()) {
					Book book = new Book();
					
					book.setBookId(rset.getInt("book_id"));
					book.setBookNm(rset.getString("book_nm"));
					book.setBookImg(rset.getString("book_img"));
					book.setAuthor(rset.getString("author"));
					book.setRanking(rset.getInt("ranking"));
					
					list.add(book);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
					close(rset);
					close(stmt);
			}
			
			return list;
		}
		
		//오디오북 베스트 조회
		public ArrayList<Book> selectBestATop10(Connection conn) {
			ArrayList<Book> list = new ArrayList<Book>();
			Statement stmt = null;
			ResultSet rset = null;
			String query = "select book_id, book_nm, author, book_img, ranking from tb_book "
					+ "where ranking<=10 and book_type_num =3 "
					+ "order by ranking";
			try {
				stmt = conn.createStatement();
				rset = stmt.executeQuery(query);
				
				while(rset.next()) {
					Book book = new Book();
					
					book.setBookId(rset.getInt("book_id"));
					book.setBookNm(rset.getString("book_nm"));
					book.setBookImg(rset.getString("book_img"));
					book.setAuthor(rset.getString("author"));
					book.setRanking(rset.getInt("ranking"));
					
					list.add(book);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
					close(rset);
					close(stmt);
			}
			
			return list;
		}

		//오디오북 신규조회
		public ArrayList<Book> selectNewATop10(Connection conn) {
			ArrayList<Book> list = new ArrayList<Book>();
			Statement stmt = null;
			ResultSet rset = null;
			String query = "select book_id, book_nm, author, book_img, ranking from tb_book "
					+ "where book_type_num =3 and rownum <=12 order by publish_date desc";
			try {
				stmt = conn.createStatement();
				rset = stmt.executeQuery(query);
				
				while(rset.next()) {
					Book book = new Book();
					
					book.setBookId(rset.getInt("book_id"));
					book.setBookNm(rset.getString("book_nm"));
					book.setBookImg(rset.getString("book_img"));
					book.setAuthor(rset.getString("author"));
					
					list.add(book);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
					close(rset);
					close(stmt);
			}
			
			return list;
		}
	
	// 아이디로 페이퍼북 상세보기 조회
		public Book selectOneDetail(Connection conn, int bookId) {
			Book book = null;
			Review review = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String query = "select * from tb_book "
					+ "where book_id = ? and book_type_num =1";
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, bookId);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					book = new Book();
					book.setBookId(rset.getInt("book_id"));
					book.setBookCateCd(rset.getInt("book_cate_cd"));
					book.setBookNm(rset.getString("book_nm"));
					book.setBookImg(rset.getString("book_img"));
					book.setIsbn(rset.getInt("isbn"));
					book.setRanking(rset.getInt("ranking"));
					book.setBookIntro(rset.getString("book_intro"));
					book.setAuthor(rset.getString("author"));
					book.setAuthorIntro(rset.getString("author_intro"));
					book.setBookPrice(rset.getInt("book_price"));
					book.setAvgScore(rset.getInt("avg_score"));
					book.setPublisher(rset.getString("publisher"));
					book.setPublishDate(rset.getDate("publish_date"));
					book.setBookIndex(rset.getString("book_index"));
//					review.setScore(rset.getInt("score"));
//					review.setReviewContent(rset.getString("review_content"));
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return book;
		} 
	
	public ArrayList<Book> selectBestBookList(Connection conn) {
		ArrayList<Book> list = new ArrayList<Book>();
		Statement stmt = null;
		ResultSet rset = null;
		return list;
	}
	
	
	public ArrayList<Book> selectNewBookList(Connection conn) {
		ArrayList<Book> list = new ArrayList<Book>();
		return list;
	}
	public ArrayList<Book> selectBookStoreList(Connection conn) {
		ArrayList<Book> list = new ArrayList<Book>();
		return list;
		
	}
	
	public int selectBookDetail(Connection conn, int bookId){
		int result = 0;
		return result;
		
	}
	
	//도서명으로 페이퍼북 상세조회
	public Book selectOneBookNmDetail(Connection conn, String booknm) {
		Book book = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_book "
				+ "where book_nm = ? and book_type_num =1";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, booknm);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				book = new Book();
				
				book.setBookId(rset.getInt("BOOK_ID"));
//				book.setBookCateCd(rset.getInt("BOOK_CATE_CD"));
				book.setBookNm(rset.getString("BOOK_NM"));
				book.setBookImg(rset.getString("book_img"));
//				book.setIsbn(rset.getInt("ISBN"));
				book.setRanking(rset.getInt("RANKING"));
				book.setBookIntro(rset.getString("BOOK_INTRO"));
				book.setAuthor(rset.getString("AUTHOR"));
				book.setAuthorIntro(rset.getString("AUTHOR_INTRO"));
//				book.setBookPrice(rset.getInt("BOOK_PRICE"));
//				book.setAvgScore(rset.getInt("AVG_SCORE"));
				book.setPublisher(rset.getString("PUBLISHER"));
				book.setPublishDate(rset.getDate("PUBLISH_DATE"));
				book.setBookIndex(rset.getString("BOOK_INDEX"));
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return book;
	}
	
	//저자로 페이퍼북 상세조회
	public Book selectOneBookAuthorDetail(Connection conn, String bookauthor) {
		Book book = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_book "
				+ "where Book_Author = ? and book_type_num =1";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookauthor);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				book = new Book();
				
				book.setBookId(rset.getInt("BOOK_ID"));
//				book.setBookCateCd(rset.getInt("book_cate_cd"));
				book.setBookNm(rset.getString("BOOK_NM"));
				book.setBookImg(rset.getString("book_img"));
//				book.setIsbn(rset.getInt("ISBN"));
				book.setRanking(rset.getInt("RANKING"));
				book.setBookIntro(rset.getString("BOOK_INTRO"));
				book.setAuthor(rset.getString("AUTHOR"));
				book.setAuthorIntro(rset.getString("AUTHOR_INTRO"));
//				book.setBookPrice(rset.getInt("BOOK_PRICE"));
//				book.setAvgScore(rset.getInt("AVG_SCORE"));
				book.setPublisher(rset.getString("PUBLISHER"));
				book.setPublishDate(rset.getDate("PUBLISH_DATE"));
				book.setBookIndex(rset.getString("BOOK_INDEX"));
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return book;
	}
	//책아이디로 전자책 상세조회
	public Book selectEOneDetail(Connection conn, int bookId) {
		Book book = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_book where book_id = ? "
								+ "and book_type_num =2";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				book = new Book();
				book.setBookId(rset.getInt("book_id"));
				book.setBookCateCd(rset.getInt("book_cate_cd"));
				book.setBookNm(rset.getString("book_nm"));
				book.setBookImg(rset.getString("book_img"));
				book.setIsbn(rset.getInt("isbn"));
				book.setRanking(rset.getInt("ranking"));
				book.setBookIntro(rset.getString("book_intro"));
				book.setAuthor(rset.getString("author"));
				book.setAuthorIntro(rset.getString("author_intro"));
				book.setBookPrice(rset.getInt("book_price"));
				book.setAvgScore(rset.getInt("avg_score"));
				book.setPublisher(rset.getString("publisher"));
				book.setPublishDate(rset.getDate("publish_date"));
				book.setBookIndex(rset.getString("book_index"));				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return book;
	}
	
	//도서명으로 전자책 상세조회
	public Book selectEOneBookNmDetail(Connection conn, String bookNm) {
		Book book = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_book "
				+ "where Book_Nm = ? and book_type_num =2";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookNm);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				book = new Book();
				
				book.setBookId(rset.getInt("BOOK_ID"));
//				book.setBookCateCd(rset.getInt("book_cate_cd"));
				book.setBookNm(rset.getString("BOOK_NM"));
				book.setBookImg(rset.getString("book_img"));
//				book.setIsbn(rset.getInt("ISBN"));
				book.setRanking(rset.getInt("RANKING"));
				book.setBookIntro(rset.getString("BOOK_INTRO"));
				book.setAuthor(rset.getString("AUTHOR"));
				book.setAuthorIntro(rset.getString("AUTHOR_INTRO"));
//				book.setBookPrice(rset.getInt("BOOK_PRICE"));
//				book.setAvgScore(rset.getInt("AVG_SCORE"));
				book.setPublisher(rset.getString("PUBLISHER"));
				book.setPublishDate(rset.getDate("PUBLISH_DATE"));
				book.setBookIndex(rset.getString("BOOK_INDEX"));
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return book;
	}
	
	//저자로 전자책 상세조회
//	public Book selectEOneBookAuthorDetail(Connection conn, String bookAuthor) {
//		Book book = null;
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		
//		String query = "select * from tb_book "
//				+ "where Book_Author = ?";
//		
//		try {
//			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, bookAuthor);
//			
//			rset = pstmt.executeQuery();
//			
//			if(rset.next()) {
//				book = new Book();
//				
//				book.setBookId(rset.getInt("BOOK_ID"));
////				book.setBookCd(rset.getInt("BOOK_CATE_CD"));
//				book.setBookNm(rset.getString("BOOK_NM"));
////				book.setIsbn(rset.getInt("ISBN"));
//				book.setRanking(rset.getInt("RANKING"));
//				book.setBookIntro(rset.getString("BOOK_INTRO"));
//				book.setAuthor(rset.getString("AUTHOR"));
//				book.setAuthorIntro(rset.getString("AUTHOR_INTRO"));
////				book.setBookPrice(rset.getInt("BOOK_PRICE"));
////				book.setAvgScore(rset.getInt("AVG_SCORE"));
//				book.setPublisher(rset.getString("PUBLISHER"));
//				book.setPublishDate(rset.getDate("PUBLISH_DATE"));
//				book.setBookIndex(rset.getString("BOOK_INDEX"));
//			
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close(rset);
//			close(pstmt);
//		}
//		
//		return book;
//	}
	
	//책아이디로 오디오북 상세조회
	public Book selectAOneDetail(Connection conn, int bookId) {
		Book book = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_book where book_id = ? and book_type_num =3";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				book = new Book();
				book.setBookId(rset.getInt("book_id"));
				book.setBookCateCd(rset.getInt("book_cate_cd"));
				book.setBookNm(rset.getString("book_nm"));
				book.setBookImg(rset.getString("book_img"));
				book.setIsbn(rset.getInt("isbn"));
				book.setRanking(rset.getInt("ranking"));
				book.setBookIntro(rset.getString("book_intro"));
				book.setAuthor(rset.getString("author"));
				book.setAuthorIntro(rset.getString("author_intro"));
				book.setBookPrice(rset.getInt("book_price"));
				book.setAvgScore(rset.getInt("avg_score"));
				book.setPublisher(rset.getString("publisher"));
				book.setPublishDate(rset.getDate("publish_date"));
				book.setBookIndex(rset.getString("book_index"));				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return book;
	}
	
	//도서명으로 오디오북 상세조회
	public Book selectAOneBookNmDetail(Connection conn, String bookNm) {
		Book book = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_book "
				+ "where Book_Nm = ? and book_type_num =3";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookNm);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				book = new Book();
				
				book.setBookId(rset.getInt("BOOK_ID"));
//				book.setBookCateCd(rset.getInt("book_cate_cd"));
				book.setBookNm(rset.getString("BOOK_NM"));
				book.setBookImg(rset.getString("book_img"));
//				book.setIsbn(rset.getInt("ISBN"));
				book.setRanking(rset.getInt("RANKING"));
				book.setBookIntro(rset.getString("BOOK_INTRO"));
				book.setAuthor(rset.getString("AUTHOR"));
				book.setAuthorIntro(rset.getString("AUTHOR_INTRO"));
//				book.setBookPrice(rset.getInt("BOOK_PRICE"));
//				book.setAvgScore(rset.getInt("AVG_SCORE"));
				book.setPublisher(rset.getString("PUBLISHER"));
				book.setPublishDate(rset.getDate("PUBLISH_DATE"));
				book.setBookIndex(rset.getString("BOOK_INDEX"));
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return book;
	}
	
	//저자로 오디오북 상세조회
	public Book selectAOneBookAuthorDetail(Connection conn, String bookAuthor) {
		Book book = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_book "
				+ "where Book_Author = ? and book_type_num =3";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookAuthor);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				book = new Book();
				
				book.setBookId(rset.getInt("BOOK_ID"));
//				book.setBookCateCd(rset.getInt("book_cate_cd"));
				book.setBookNm(rset.getString("BOOK_NM"));
//				book.setIsbn(rset.getInt("ISBN"));
				book.setRanking(rset.getInt("RANKING"));
				book.setBookIntro(rset.getString("BOOK_INTRO"));
				book.setAuthor(rset.getString("AUTHOR"));
				book.setAuthorIntro(rset.getString("AUTHOR_INTRO"));
//				book.setBookPrice(rset.getInt("BOOK_PRICE"));
//				book.setAvgScore(rset.getInt("AVG_SCORE"));
				book.setPublisher(rset.getString("PUBLISHER"));
				book.setPublishDate(rset.getDate("PUBLISH_DATE"));
				book.setBookIndex(rset.getString("BOOK_INDEX"));
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return book;
	}

	//상품리스트 
	public ArrayList<Book> selectCategory(Connection conn, int location, int category) {
		ArrayList<Book> list = new ArrayList<Book>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select book_id, book_nm, book_img, book_cate_cd, book_loc_num, ranking, author, avg_score, publisher, book_intro "
				+ "from tb_book join tb_category on book_cate_cd = cate_cd ";
				
				if(location>0 && category == 0) {
					query+= "where book_loc_num = ?";
				}else if(location == 0 && category >0) {
					query+= "where book_cate_cd = ?";
				}else if(location >0 && category >0) {
					query+= "where BOOK_LOC_NUM = ? and book_cate_cd = ?";
				}
			
		try {
			pstmt = conn.prepareStatement(query);
			if(location>0 && category == 0) {
				pstmt.setInt(1, location);
			}else if(location == 0 && category >0) {
				pstmt.setInt(1, category);
			}else if(location >0 && category >0) {
				pstmt.setInt(1, location);
				pstmt.setInt(2, category);
			}else {
				
			}
			
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Book book = new Book();
				
				book.setBookId(rset.getInt("book_id"));
				book.setBookNm(rset.getString("book_nm"));
				book.setBookImg(rset.getString("book_img"));
				book.setBookCateCd(rset.getInt("book_cate_cd"));
				book.setBookLocNum(rset.getInt("book_loc_num"));
				book.setRanking(rset.getInt("ranking"));
				book.setAuthor(rset.getString("author"));
				book.setAvgScore(rset.getInt("avg_score"));
				book.setPublisher(rset.getString("publisher"));
				book.setBookIntro(rset.getString("book_intro"));
	
				list.add(book);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(rset);
				close(pstmt);
		}
		
		return list;
	
	}

	public int getBookListCount(Connection conn, int location, int category) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from tb_book where BOOK_LOC_NUM=? and book_cate_cd=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, location);
			pstmt.setInt(2, category);
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
	
	//관리자 도서 등록
	public int insertAdminBook(Connection conn, Book book) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO TB_BOOK VALUES "
				+ "((SELECT MAX(BOOK_ID) + 1 FROM TB_BOOK), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
		
			pstmt = conn.prepareStatement(query);
//			pstmt.setInt(1, book.getBookId());  
			pstmt.setInt(1, book.getBookCateCd()); 		
			pstmt.setInt(2, book.getBookTypeNum());
			pstmt.setInt(3, book.getBookLocNum());
			pstmt.setString(4, book.getBookImg());
			pstmt.setString(5, book.getBookNm());
			pstmt.setInt(6, book.getIsbn());
			pstmt.setInt(7, book.getRanking());
			pstmt.setString(8, book.getBookIntro());
			pstmt.setString(9, book.getAuthor());
			pstmt.setString(10, book.getAuthorIntro());
			pstmt.setInt(11, book.getBookPrice());
			pstmt.setInt(12, book.getAvgScore());
			pstmt.setString(13, book.getPublisher());
			pstmt.setDate(14, book.getPublishDate());
			pstmt.setString(15, book.getBookIndex());

			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}		
		
		return result;
	}
	
	
	public int getBookTotalListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from tb_book";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			 
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}
	
	//상품리스트에서 도서명검색
	public ArrayList<Book> selectProductSearchBookName(Connection conn, int location, int category, String keyword) {
		ArrayList<Book> list = new ArrayList<Book>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select book_id, book_nm, book_cate_cd, book_loc_num, book_img, book_category, ranking, author, avg_score, publisher, book_intro "
				+ "from tb_book join tb_category on book_cate_cd = cate_cd "
				+ "where BOOK_LOC_NUM = ? and book_cate_cd = ? and book_nm like ? order by book_id";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, location);
			pstmt.setInt(2, category);
			pstmt.setString(3, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Book book = new Book();
				
				book.setBookId(rset.getInt("book_id"));
				book.setBookCateCd(rset.getInt("book_cate_cd"));
				book.setBookTypeNum(rset.getInt("book_type_num"));
				book.setBookLocNum(rset.getInt("book_loc_num"));
				book.setBookImg(rset.getString("book_img"));
				book.setBookNm(rset.getString("book_nm"));
				book.setIsbn(rset.getInt("isbn"));
				book.setRanking(rset.getInt("ranking"));
				book.setBookIntro(rset.getString("book_intro"));
				book.setAuthor(rset.getString("author"));
				book.setAuthorIntro(rset.getString("author_intro"));
				book.setBookPrice(rset.getInt("book_price"));
				book.setAvgScore(rset.getInt("avg_score"));
				book.setPublisher(rset.getString("publisher"));
				book.setPublishDate(rset.getDate("publish_date"));
				book.setBookIndex(rset.getString("book_index"));	
				
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;

	}
	
	//상품리스트에서 저자검색
	public ArrayList<Book> selectProductSearchAuthor(Connection conn, int location, int category, String keyword) {
		ArrayList<Book> list = new ArrayList<Book>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select book_id, book_nm, book_cate_cd, book_loc_num, book_img, book_category, ranking, author, avg_score, publisher, book_intro "
				+ "from tb_book join tb_category on book_cate_cd = cate_cd "
				+ "where BOOK_LOC_NUM = ? and book_cate_cd = ? and author like ? order by book_id";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, location);
			pstmt.setInt(2, category);
			pstmt.setString(3, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Book book = new Book();
				
				book.setBookId(rset.getInt("book_id"));
				book.setBookCateCd(rset.getInt("book_cate_cd"));
				book.setBookTypeNum(rset.getInt("book_type_num"));
				book.setBookLocNum(rset.getInt("book_loc_num"));
				book.setBookImg(rset.getString("book_img"));
				book.setBookNm(rset.getString("book_nm"));
				book.setIsbn(rset.getInt("isbn"));
				book.setRanking(rset.getInt("ranking"));
				book.setBookIntro(rset.getString("book_intro"));
				book.setAuthor(rset.getString("author"));
				book.setAuthorIntro(rset.getString("author_intro"));
				book.setBookPrice(rset.getInt("book_price"));
				book.setAvgScore(rset.getInt("avg_score"));
				book.setPublisher(rset.getString("publisher"));
				book.setPublishDate(rset.getDate("publish_date"));
				book.setBookIndex(rset.getString("book_index"));	
				
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	//관리자 상품리스트 도서명검색
	public ArrayList<Book> selectProductAdminSearchBookName(Connection conn, String keyword) {
		ArrayList<Book> list = new ArrayList<Book>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_book where book_nm like ? "
								+ "order by book_id";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Book book = new Book();
				
				book.setBookId(rset.getInt("book_id"));
				book.setBookCateCd(rset.getInt("book_cate_cd"));
				book.setBookTypeNum(rset.getInt("book_type_num"));
				book.setBookLocNum(rset.getInt("book_loc_num"));
				book.setBookImg(rset.getString("book_img"));
				book.setBookNm(rset.getString("book_nm"));
				book.setIsbn(rset.getInt("isbn"));
				book.setRanking(rset.getInt("ranking"));
				book.setBookIntro(rset.getString("book_intro"));
				book.setAuthor(rset.getString("author"));
				book.setAuthorIntro(rset.getString("author_intro"));
				book.setBookPrice(rset.getInt("book_price"));
				book.setAvgScore(rset.getInt("avg_score"));
				book.setPublisher(rset.getString("publisher"));
				book.setPublishDate(rset.getDate("publish_date"));
				book.setBookIndex(rset.getString("book_index"));	
				
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	//관리자 상품리스트 저자검색
	public ArrayList<Book> selectProductAdminSearchAuthor(Connection conn, String keyword) {
		ArrayList<Book> list = new ArrayList<Book>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_book where author like ? order by book_id ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Book book = new Book();
				
				book.setBookId(rset.getInt("book_id"));
				book.setBookCateCd(rset.getInt("book_cate_cd"));
				book.setBookTypeNum(rset.getInt("book_type_num"));
				book.setBookLocNum(rset.getInt("book_loc_num"));
				book.setBookImg(rset.getString("book_img"));
				book.setBookNm(rset.getString("book_nm"));
				book.setIsbn(rset.getInt("isbn"));
				book.setRanking(rset.getInt("ranking"));
				book.setBookIntro(rset.getString("book_intro"));
				book.setAuthor(rset.getString("author"));
				book.setAuthorIntro(rset.getString("author_intro"));
				book.setBookPrice(rset.getInt("book_price"));
				book.setAvgScore(rset.getInt("avg_score"));
				book.setPublisher(rset.getString("publisher"));
				book.setPublishDate(rset.getDate("publish_date"));
				book.setBookIndex(rset.getString("book_index"));	
				
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	//관리자 상품리스트 출판사검색
	public ArrayList<Book> selectProductAdminSearchPublisher(Connection conn, String keyword) {
		ArrayList<Book> list = new ArrayList<Book>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_book where publisher like ? order by book_id ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Book book = new Book();
				
				book.setBookId(rset.getInt("book_id"));
				book.setBookCateCd(rset.getInt("book_cate_cd"));
				book.setBookTypeNum(rset.getInt("book_type_num"));
				book.setBookLocNum(rset.getInt("book_loc_num"));
				book.setBookImg(rset.getString("book_img"));
				book.setBookNm(rset.getString("book_nm"));
				book.setIsbn(rset.getInt("isbn"));
				book.setRanking(rset.getInt("ranking"));
				book.setBookIntro(rset.getString("book_intro"));
				book.setAuthor(rset.getString("author"));
				book.setAuthorIntro(rset.getString("author_intro"));
				book.setBookPrice(rset.getInt("book_price"));
				book.setAvgScore(rset.getInt("avg_score"));
				book.setPublisher(rset.getString("publisher"));
				book.setPublishDate(rset.getDate("publish_date"));
				book.setBookIndex(rset.getString("book_index"));	
				
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	//페이퍼북 메인에서 페이퍼북 도서명 검색
	public ArrayList<Book> selectPBookSearchBookName(Connection conn, String keyword) {
		ArrayList<Book> list = new ArrayList<Book>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_book where book_type_num = 1 and book_nm like ? order by book_id";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Book book = new Book();
				
				book.setBookId(rset.getInt("book_id"));
				book.setBookCateCd(rset.getInt("book_cate_cd"));
				book.setBookTypeNum(rset.getInt("book_type_num"));
				book.setBookLocNum(rset.getInt("book_loc_num"));
				book.setBookImg(rset.getString("book_img"));
				book.setBookNm(rset.getString("book_nm"));
				book.setIsbn(rset.getInt("isbn"));
				book.setRanking(rset.getInt("ranking"));
				book.setBookIntro(rset.getString("book_intro"));
				book.setAuthor(rset.getString("author"));
				book.setAuthorIntro(rset.getString("author_intro"));
				book.setBookPrice(rset.getInt("book_price"));
				book.setAvgScore(rset.getInt("avg_score"));
				book.setPublisher(rset.getString("publisher"));
				book.setPublishDate(rset.getDate("publish_date"));
				book.setBookIndex(rset.getString("book_index"));	
				
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	//페이퍼북 메인에서 페이퍼북 저자 검색
	public ArrayList<Book> selectPBookSearchAuthor(Connection conn, String keyword) {
		ArrayList<Book> list = new ArrayList<Book>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_book where book_type_num = 1 and author like ? order by book_id ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Book book = new Book();
				
				book.setBookId(rset.getInt("book_id"));
				book.setBookCateCd(rset.getInt("book_cate_cd"));
				book.setBookTypeNum(rset.getInt("book_type_num"));
				book.setBookLocNum(rset.getInt("book_loc_num"));
				book.setBookImg(rset.getString("book_img"));
				book.setBookNm(rset.getString("book_nm"));
				book.setIsbn(rset.getInt("isbn"));
				book.setRanking(rset.getInt("ranking"));
				book.setBookIntro(rset.getString("book_intro"));
				book.setAuthor(rset.getString("author"));
				book.setAuthorIntro(rset.getString("author_intro"));
				book.setBookPrice(rset.getInt("book_price"));
				book.setAvgScore(rset.getInt("avg_score"));
				book.setPublisher(rset.getString("publisher"));
				book.setPublishDate(rset.getDate("publish_date"));
				book.setBookIndex(rset.getString("book_index"));	
				
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	//전자책메인에서 전자책 도서명 검색
	public ArrayList<Book> selectEBookSearchBookName(Connection conn, String keyword) {
		ArrayList<Book> list = new ArrayList<Book>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_book where book_type_num = 2 and book_nm like ? order by book_id";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Book book = new Book();
				
				book.setBookId(rset.getInt("book_id"));
				book.setBookCateCd(rset.getInt("book_cate_cd"));
				book.setBookTypeNum(rset.getInt("book_type_num"));
				book.setBookLocNum(rset.getInt("book_loc_num"));
				book.setBookImg(rset.getString("book_img"));
				book.setBookNm(rset.getString("book_nm"));
				book.setIsbn(rset.getInt("isbn"));
				book.setRanking(rset.getInt("ranking"));
				book.setBookIntro(rset.getString("book_intro"));
				book.setAuthor(rset.getString("author"));
				book.setAuthorIntro(rset.getString("author_intro"));
				book.setBookPrice(rset.getInt("book_price"));
				book.setAvgScore(rset.getInt("avg_score"));
				book.setPublisher(rset.getString("publisher"));
				book.setPublishDate(rset.getDate("publish_date"));
				book.setBookIndex(rset.getString("book_index"));	
				
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	//전자책메인에서 전자책 저자 검색
	public ArrayList<Book> selectEBookSearchAuthor(Connection conn, String keyword) {
		ArrayList<Book> list = new ArrayList<Book>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_book where book_type_num = 2 and author like ? order by book_id ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Book book = new Book();
				
				book.setBookId(rset.getInt("book_id"));
				book.setBookCateCd(rset.getInt("book_cate_cd"));
				book.setBookTypeNum(rset.getInt("book_type_num"));
				book.setBookLocNum(rset.getInt("book_loc_num"));
				book.setBookImg(rset.getString("book_img"));
				book.setBookNm(rset.getString("book_nm"));
				book.setIsbn(rset.getInt("isbn"));
				book.setRanking(rset.getInt("ranking"));
				book.setBookIntro(rset.getString("book_intro"));
				book.setAuthor(rset.getString("author"));
				book.setAuthorIntro(rset.getString("author_intro"));
				book.setBookPrice(rset.getInt("book_price"));
				book.setAvgScore(rset.getInt("avg_score"));
				book.setPublisher(rset.getString("publisher"));
				book.setPublishDate(rset.getDate("publish_date"));
				book.setBookIndex(rset.getString("book_index"));	
				
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Book> selectABookSearchBookName(Connection conn, String keyword) {
		ArrayList<Book> list = new ArrayList<Book>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_book where book_type_num = 3 and book_nm like ? order by book_id";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Book book = new Book();
				
				book.setBookId(rset.getInt("book_id"));
				book.setBookCateCd(rset.getInt("book_cate_cd"));
				book.setBookTypeNum(rset.getInt("book_type_num"));
				book.setBookLocNum(rset.getInt("book_loc_num"));
				book.setBookImg(rset.getString("book_img"));
				book.setBookNm(rset.getString("book_nm"));
				book.setIsbn(rset.getInt("isbn"));
				book.setRanking(rset.getInt("ranking"));
				book.setBookIntro(rset.getString("book_intro"));
				book.setAuthor(rset.getString("author"));
				book.setAuthorIntro(rset.getString("author_intro"));
				book.setBookPrice(rset.getInt("book_price"));
				book.setAvgScore(rset.getInt("avg_score"));
				book.setPublisher(rset.getString("publisher"));
				book.setPublishDate(rset.getDate("publish_date"));
				book.setBookIndex(rset.getString("book_index"));	
				
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Book> selectABookSearchAuthor(Connection conn, String keyword) {
		ArrayList<Book> list = new ArrayList<Book>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_book where book_type_num = 3 and author like ? order by book_id ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Book book = new Book();
				
				book.setBookId(rset.getInt("book_id"));
				book.setBookCateCd(rset.getInt("book_cate_cd"));
				book.setBookTypeNum(rset.getInt("book_type_num"));
				book.setBookLocNum(rset.getInt("book_loc_num"));
				book.setBookImg(rset.getString("book_img"));
				book.setBookNm(rset.getString("book_nm"));
				book.setIsbn(rset.getInt("isbn"));
				book.setRanking(rset.getInt("ranking"));
				book.setBookIntro(rset.getString("book_intro"));
				book.setAuthor(rset.getString("author"));
				book.setAuthorIntro(rset.getString("author_intro"));
				book.setBookPrice(rset.getInt("book_price"));
				book.setAvgScore(rset.getInt("avg_score"));
				book.setPublisher(rset.getString("publisher"));
				book.setPublishDate(rset.getDate("publish_date"));
				book.setBookIndex(rset.getString("book_index"));	
				
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	//상품리스트에서 카테고리만 선택후 도서명검색
	public ArrayList<Book> selectProductSearchBookName1(Connection conn, int category, String keyword) {
		ArrayList<Book> list = new ArrayList<Book>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from tb_book join tb_category on book_cate_cd = cate_cd "
				+ "where book_cate_cd = ? and book_nm like ? order by book_id";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, category);
			pstmt.setString(2, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Book book = new Book();
				
				book.setBookId(rset.getInt("book_id"));
				book.setBookCateCd(rset.getInt("book_cate_cd"));
				book.setBookLocNum(rset.getInt("book_loc_num"));
				book.setBookImg(rset.getString("book_img"));
				book.setBookNm(rset.getString("book_nm"));
				book.setIsbn(rset.getInt("isbn"));
				book.setRanking(rset.getInt("ranking"));
				book.setBookIntro(rset.getString("book_intro"));
				book.setAuthor(rset.getString("author"));
				book.setAuthorIntro(rset.getString("author_intro"));
				book.setBookPrice(rset.getInt("book_price"));
				book.setAvgScore(rset.getInt("avg_score"));
				book.setPublisher(rset.getString("publisher"));
				book.setPublishDate(rset.getDate("publish_date"));
				book.setBookIndex(rset.getString("book_index"));	
				
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	//상품리스트에서 카테고리만 선택후 저자검색
	public ArrayList<Book> selectProductSearchAuthor1(Connection conn, int category, String keyword) {
		ArrayList<Book> list = new ArrayList<Book>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from tb_book "
				+ "where book_cate_cd = ? and author like ? order by book_id";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, category);
			pstmt.setString(2, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Book book = new Book();
				
				book.setBookId(rset.getInt("book_id"));
				book.setBookCateCd(rset.getInt("book_cate_cd"));
				book.setBookTypeNum(rset.getInt("book_type_num"));
				book.setBookLocNum(rset.getInt("book_loc_num"));
				book.setBookImg(rset.getString("book_img"));
				book.setBookNm(rset.getString("book_nm"));
				book.setIsbn(rset.getInt("isbn"));
				book.setRanking(rset.getInt("ranking"));
				book.setBookIntro(rset.getString("book_intro"));
				book.setAuthor(rset.getString("author"));
				book.setAuthorIntro(rset.getString("author_intro"));
				book.setBookPrice(rset.getInt("book_price"));
				book.setAvgScore(rset.getInt("avg_score"));
				book.setPublisher(rset.getString("publisher"));
				book.setPublishDate(rset.getDate("publish_date"));
				book.setBookIndex(rset.getString("book_index"));	
				
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	//상품리스트에서 국내외만 선택후 도서명검색
	public ArrayList<Book> selectProductSearchBookName2(Connection conn, int location, String keyword) {
		ArrayList<Book> list = new ArrayList<Book>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_book "
							+ "join tb_category on book_cate_cd = cate_cd "
							+ "where book_loc_num = ? and book_nm like ? order by book_id";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, location);
			pstmt.setString(2, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Book book = new Book();
				
				book.setBookId(rset.getInt("book_id"));
				book.setBookCateCd(rset.getInt("book_cate_cd"));
				book.setBookLocNum(rset.getInt("book_loc_num"));
				book.setBookImg(rset.getString("book_img"));
				book.setBookNm(rset.getString("book_nm"));
				book.setIsbn(rset.getInt("isbn"));
				book.setRanking(rset.getInt("ranking"));
				book.setBookIntro(rset.getString("book_intro"));
				book.setAuthor(rset.getString("author"));
				book.setAuthorIntro(rset.getString("author_intro"));
				book.setBookPrice(rset.getInt("book_price"));
				book.setAvgScore(rset.getInt("avg_score"));
				book.setPublisher(rset.getString("publisher"));
				book.setPublishDate(rset.getDate("publish_date"));
				book.setBookIndex(rset.getString("book_index"));	
				
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	//상품리스트에서 카테고리만 선택후 저자검색
	public ArrayList<Book> selectProductSearchAuthor2(Connection conn, int location, String keyword) {
		ArrayList<Book> list = new ArrayList<Book>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_book "
							+ "join tb_category on book_cate_cd = cate_cd "
							+ "where book_loc_num = ? and author like ? order by book_id";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, location);
			pstmt.setString(2, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Book book = new Book();
				
				book.setBookId(rset.getInt("book_id"));
				book.setBookCateCd(rset.getInt("book_cate_cd"));
				book.setBookTypeNum(rset.getInt("book_type_num"));
				book.setBookLocNum(rset.getInt("book_loc_num"));
				book.setBookImg(rset.getString("book_img"));
				book.setBookNm(rset.getString("book_nm"));
				book.setIsbn(rset.getInt("isbn"));
				book.setRanking(rset.getInt("ranking"));
				book.setBookIntro(rset.getString("book_intro"));
				book.setAuthor(rset.getString("author"));
				book.setAuthorIntro(rset.getString("author_intro"));
				book.setBookPrice(rset.getInt("book_price"));
				book.setAvgScore(rset.getInt("avg_score"));
				book.setPublisher(rset.getString("publisher"));
				book.setPublishDate(rset.getDate("publish_date"));
				book.setBookIndex(rset.getString("book_index"));	
				
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	//상품리스트에서 카테고리와 국내외 선택후 도서명검색
	public ArrayList<Book> selectProductSearchBookName3(Connection conn, int location, int category, String keyword) {
		ArrayList<Book> list = new ArrayList<Book>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from tb_book join tb_category on book_cate_cd = cate_cd "
				+ "where book_loc_num = ? and book_cate_cd = ? and book_nm like ? order by book_id";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, location);
			pstmt.setInt(2, category);
			pstmt.setString(3, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Book book = new Book();
				
				book.setBookId(rset.getInt("book_id"));
				book.setBookCateCd(rset.getInt("book_cate_cd"));
				book.setBookLocNum(rset.getInt("book_loc_num"));
				book.setBookImg(rset.getString("book_img"));
				book.setBookNm(rset.getString("book_nm"));
				book.setIsbn(rset.getInt("isbn"));
				book.setRanking(rset.getInt("ranking"));
				book.setBookIntro(rset.getString("book_intro"));
				book.setAuthor(rset.getString("author"));
				book.setAuthorIntro(rset.getString("author_intro"));
				book.setBookPrice(rset.getInt("book_price"));
				book.setAvgScore(rset.getInt("avg_score"));
				book.setPublisher(rset.getString("publisher"));
				book.setPublishDate(rset.getDate("publish_date"));
				book.setBookIndex(rset.getString("book_index"));	
				
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	//상품리스트에서 카테고리와 국내외 선택후 저자검색
	public ArrayList<Book> selectProductSearchAuthor3(Connection conn, int location, int category, String keyword) {
		ArrayList<Book> list = new ArrayList<Book>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from tb_book join tb_category on book_cate_cd = cate_cd "
				+ "where book_loc_num = ? and book_cate_cd = ? and author like ? order by book_id";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, location);
			pstmt.setInt(2, category);
			pstmt.setString(3, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Book book = new Book();
				
				book.setBookId(rset.getInt("book_id"));
				book.setBookCateCd(rset.getInt("book_cate_cd"));
				book.setBookTypeNum(rset.getInt("book_type_num"));
				book.setBookLocNum(rset.getInt("book_loc_num"));
				book.setBookImg(rset.getString("book_img"));
				book.setBookNm(rset.getString("book_nm"));
				book.setIsbn(rset.getInt("isbn"));
				book.setRanking(rset.getInt("ranking"));
				book.setBookIntro(rset.getString("book_intro"));
				book.setAuthor(rset.getString("author"));
				book.setAuthorIntro(rset.getString("author_intro"));
				book.setBookPrice(rset.getInt("book_price"));
				book.setAvgScore(rset.getInt("avg_score"));
				book.setPublisher(rset.getString("publisher"));
				book.setPublishDate(rset.getDate("publish_date"));
				book.setBookIndex(rset.getString("book_index"));	
				
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	//상품리스트에서 카테고리와 국내외 선택안하고 도서명검색
	public ArrayList<Book> selectProductSearchBookName4(Connection conn, String keyword) {
		ArrayList<Book> list = new ArrayList<Book>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from tb_book join tb_category on book_cate_cd = cate_cd "
				+ "where book_nm like ? order by book_id";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Book book = new Book();
				
				book.setBookId(rset.getInt("book_id"));
				book.setBookCateCd(rset.getInt("book_cate_cd"));
				book.setBookLocNum(rset.getInt("book_loc_num"));
				book.setBookImg(rset.getString("book_img"));
				book.setBookNm(rset.getString("book_nm"));
				book.setIsbn(rset.getInt("isbn"));
				book.setRanking(rset.getInt("ranking"));
				book.setBookIntro(rset.getString("book_intro"));
				book.setAuthor(rset.getString("author"));
				book.setAuthorIntro(rset.getString("author_intro"));
				book.setBookPrice(rset.getInt("book_price"));
				book.setAvgScore(rset.getInt("avg_score"));
				book.setPublisher(rset.getString("publisher"));
				book.setPublishDate(rset.getDate("publish_date"));
				book.setBookIndex(rset.getString("book_index"));	
				
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	//상품리스트에서 카테고리와 국내외 선택안하고 저자검색
	public ArrayList<Book> selectProductSearchAuthor4(Connection conn, String keyword) {
		ArrayList<Book> list = new ArrayList<Book>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from tb_book join tb_category on book_cate_cd = cate_cd "
				+ "where author like ? order by book_id";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Book book = new Book();
				
				book.setBookId(rset.getInt("book_id"));
				book.setBookCateCd(rset.getInt("book_cate_cd"));
				book.setBookTypeNum(rset.getInt("book_type_num"));
				book.setBookLocNum(rset.getInt("book_loc_num"));
				book.setBookImg(rset.getString("book_img"));
				book.setBookNm(rset.getString("book_nm"));
				book.setIsbn(rset.getInt("isbn"));
				book.setRanking(rset.getInt("ranking"));
				book.setBookIntro(rset.getString("book_intro"));
				book.setAuthor(rset.getString("author"));
				book.setAuthorIntro(rset.getString("author_intro"));
				book.setBookPrice(rset.getInt("book_price"));
				book.setAvgScore(rset.getInt("avg_score"));
				book.setPublisher(rset.getString("publisher"));
				book.setPublishDate(rset.getDate("publish_date"));
				book.setBookIndex(rset.getString("book_index"));	
				
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public ArrayList<Book> selectBestTop4(Connection conn) {
		ArrayList<Book> list = new ArrayList<Book>();
		Statement stmt = null;
		ResultSet rset = null;
		String query = "select * "
				+ "from(select rownum rnum, book_id, book_nm, book_img, author, ranking "
				+ "from (select * "
				+ "from tb_book "
				+ "where book_type_num = 1 "
				+ "order by ranking)) "
				+ "where rnum between 1 and 4";
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Book book = new Book();
				
				book.setBookId(rset.getInt("book_id"));
				book.setBookNm(rset.getString("book_nm"));
				book.setBookImg(rset.getString("book_img"));
				book.setAuthor(rset.getString("author"));
				book.setRanking(rset.getInt("ranking"));
				
				list.add(book);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(rset);
				close(stmt);
		}
		
		return list;
	}

	public int updateAdminBook(Connection conn, Book book) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "UPDATE TB_BOOK "
				+ "SET BOOK_CATE_CD = ?, BOOK_TYPE_NUM = ?, BOOK_LOC_NUM = ?, ";
		
				if(book.getBookImg() != null) {
					query += "BOOK_IMG = ?, ";
				}
				
				query += "BOOK_NM = ?, ISBN = ?, "
				+ "RANKING = ?, BOOK_INTRO = ?, AUTHOR = ?, AUTHOR_INTRO = ?, BOOK_PRICE = ?, AVG_SCORE = ?, "
				+ "PUBLISHER = ?, PUBLISH_DATE = ?, BOOK_INDEX = ? "
				+ "WHERE BOOK_ID = ?";
		
		try {
		
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, book.getBookCateCd()); 		
			pstmt.setInt(2, book.getBookTypeNum());
			pstmt.setInt(3, book.getBookLocNum());
			pstmt.setString(4, book.getBookImg());
			pstmt.setString(5, book.getBookNm());
			pstmt.setInt(6, book.getIsbn());
			pstmt.setInt(7, book.getRanking());
			pstmt.setString(8, book.getBookIntro());
			pstmt.setString(9, book.getAuthor());
			pstmt.setString(10, book.getAuthorIntro());
			pstmt.setInt(11, book.getBookPrice());
			pstmt.setInt(12, book.getAvgScore());
			pstmt.setString(13, book.getPublisher());
			pstmt.setDate(14, book.getPublishDate());
			pstmt.setString(15, book.getBookIndex());
			pstmt.setInt(16, book.getBookId());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}		
		
		return result;
	}

	public int deleteBook(Connection conn, int bookId) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from tb_book where BOOK_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookId);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public Book certificate(Connection conn, String book_nm, int isbn) {
		Book book = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT * FROM TB_BOOK WHERE BOOK_NM = ? and ISBN = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, book_nm);
			pstmt.setInt(2, isbn);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				book = new Book();

				book.setBookNm(book_nm);
				book.setIsbn(isbn);
//            book.toString().charAt(isbn);
				book.setBookId(rset.getInt("book_id"));
				book.setBookCateCd(rset.getInt("book_cate_cd"));
				book.setRanking(rset.getInt("ranking"));
				book.setBookIntro(rset.getString("book_intro"));
				book.setAuthor(rset.getString("author"));
				book.setAuthorIntro(rset.getString("author_intro"));
				book.setBookPrice(rset.getInt("book_price"));
				book.setAvgScore(rset.getInt("avg_score"));
				book.setPublisher(rset.getString("publisher"));
				book.setPublishDate(rset.getDate("publish_date"));
				book.setBookIndex(rset.getString("book_index"));
				book.setBookLocNum(rset.getInt("book_loc_num"));
				book.setBookTypeNum(rset.getInt("book_type_num"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return book;

	}

	public Book selectAdminOneDetail(Connection conn, int bookId) {
		Book book = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_book "
				+ "where book_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				book = new Book();
				book.setBookId(rset.getInt("book_id"));
				book.setBookCateCd(rset.getInt("book_cate_cd"));
				book.setBookTypeNum(rset.getInt("book_type_num"));
				book.setBookLocNum(rset.getInt("book_loc_num"));
				book.setBookNm(rset.getString("book_nm"));
				book.setBookImg(rset.getString("book_img"));
				book.setIsbn(rset.getInt("isbn"));
				book.setRanking(rset.getInt("ranking"));
				book.setBookIntro(rset.getString("book_intro"));
				book.setAuthor(rset.getString("author"));
				book.setAuthorIntro(rset.getString("author_intro"));
				book.setBookPrice(rset.getInt("book_price"));
				book.setAvgScore(rset.getInt("avg_score"));
				book.setPublisher(rset.getString("publisher"));
				book.setPublishDate(rset.getDate("publish_date"));
				book.setBookIndex(rset.getString("book_index"));
//				review.setScore(rset.getInt("score"));
//				review.setReviewContent(rset.getString("review_content"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return book;
	}

	public Book selectAllOneDetail(Connection conn, int bookId) {
		Book book = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_book "
				+ "where book_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				book = new Book();
				book.setBookId(rset.getInt("book_id"));
				book.setBookCateCd(rset.getInt("book_cate_cd"));
				book.setBookTypeNum(rset.getInt("book_type_num"));
				book.setBookLocNum(rset.getInt("book_loc_num"));
				book.setBookNm(rset.getString("book_nm"));
				book.setBookImg(rset.getString("book_img"));
				book.setIsbn(rset.getInt("isbn"));
				book.setRanking(rset.getInt("ranking"));
				book.setBookIntro(rset.getString("book_intro"));
				book.setAuthor(rset.getString("author"));
				book.setAuthorIntro(rset.getString("author_intro"));
				book.setBookPrice(rset.getInt("book_price"));
				book.setAvgScore(rset.getInt("avg_score"));
				book.setPublisher(rset.getString("publisher"));
				book.setPublishDate(rset.getDate("publish_date"));
				book.setBookIndex(rset.getString("book_index"));

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return book;
	}
}
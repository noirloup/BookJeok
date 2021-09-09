package usedshop.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import book.model.vo.Book;
import usedshop.model.vo.UsedShopNormal;
import usedshop.model.vo.UsedShopNormalSelect;
import usedshop.model.vo.UsedShopAuctionSelect;

public class UsedShopDao {
	// +selectList(Connection):ArrayList
	// +getNewListCount(Connection conn):int
	// +selectUsedAuctionNewList(Connection conn):ArrayList<UsedShop>
	// +getBestListCount(Connection conn):int
	// +selectUsedAuctionBestList(Connection conn):ArrayList<UsedShop>
	// +getTimeLessListCount(Connection conn):int
	// +selectUsedAuctionTimeLessList(Connection conn):ArrayList<UsedShop>
	// +selectUsedNormalNewList(Connection conn):ArrayList<UsedShop>
	// +selectUsedNormalLowPriceList(Connection conn):ArrayList<UsedShop>
	// +selectUsedAuctionList(Connection conn):ArrayList<UsedShop>
	// +selectUsedNormalList(Connection conn):ArrayList<UsedShop>
	// +updateAuctionBid(Connection conn, int marketcd):int
	// +insertUsedAuction(Connection conn, UsedShop usedshop):int
	// +insertUsedNormal(Connection conn, UsedShop usedshop):int
	// +selectUsedAuction(Connection conn, int marketcd):UsedShop
	// +selectUsedNormal(Connection conn, int marketcd):UsedShop
	// +updateUsedAuction(Connection conn, UsedShop usedshop):int
	// +updateUsedNormal(Connection conn, UsedShop usedshop):int
	// +deleteUsedAuction(Connection conn, int marketcd):int
	// +deleteUsedNormal(Connection conn, int marketcd):int
	// +getListCount(Connection conn):int
	// +selectUsedAuctionSearchList(Connection conn):ArrayList<UsedShop>
	// +selectUsedNormalSearchList(Connection conn):ArrayList<UsedShop>
	
	public ArrayList<UsedShopNormal> selectList(Connection conn) {
		ArrayList<UsedShopNormal> list = null;
		return list;
	}
	
	public int getNewListCount(Connection conn) {
		int listCount = 0;
		return listCount;
	}

	public ArrayList<UsedShopNormal> selectUsedAuctionNewList(Connection conn) {
		ArrayList<UsedShopNormal> list = null;
		return list;
	}
	
	public int getBestListCount(Connection conn) {
		int listCount = 0;
		return listCount;
	}
	
	public ArrayList<UsedShopNormal> selectUsedAuctionBestList(Connection conn) {
		ArrayList<UsedShopNormal> list = null;
		return list;
	}
	
	public int getTimeLessListCount(Connection conn) {
		int listCount = 0;
		return listCount;
	}
	
	public ArrayList<UsedShopNormal> selectUsedAuctionTimeLessList(Connection conn) {
		ArrayList<UsedShopNormal> list = null;
		return list;
	}
	
	public ArrayList<UsedShopNormal> selectUsedNormalNewList(Connection conn) {
		ArrayList<UsedShopNormal> list = null;
		return list;
	}
	
	public ArrayList<UsedShopNormal> selectUsedNormalLowPriceList(Connection conn) {
		ArrayList<UsedShopNormal> list = null;
		return list;
	}
	
	public ArrayList<UsedShopAuctionSelect> selectUsedAuctionList(Connection conn) {
		ArrayList<UsedShopAuctionSelect> list = new ArrayList<UsedShopAuctionSelect>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from (select rownum rnum, a_market_cd, book_cate_cd, book_img, book_nm, book_price, author, publisher, "
				+ "        publish_date, a_user_writer_id, user_rank, a_quality, START_BID, CURRENT_BID, "
				+ "        A_REG_DATE, A_CLOSE_DATE "
				+ "        from (select * "
				+ "                from tb_used_auction us "
				+ "                left join tb_book b on (us.a_used_book_id = b.book_id) "
				+ "                left join tb_user u on (us.a_user_writer_id = u.user_id) "
				+ "                order by a_market_cd DESC))";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				UsedShopAuctionSelect usauselect = new UsedShopAuctionSelect();
				
				usauselect.setaMarketCd(rset.getInt("a_market_cd"));
				usauselect.setBookCateCd(rset.getInt("book_cate_cd"));
				usauselect.setBookimg(rset.getString("book_img"));
				usauselect.setBookNm(rset.getString("book_nm"));
				usauselect.setBookPrice(rset.getInt("book_price"));
				usauselect.setAuthor(rset.getString("author"));
				usauselect.setPublisher(rset.getString("publisher"));
				usauselect.setPublishDate(rset.getDate("publish_date"));
				usauselect.setUserWriterId(rset.getString("a_user_writer_id"));
				usauselect.setUserRank(rset.getString("user_rank"));
				usauselect.setaQuality(rset.getString("a_quality"));
				usauselect.setStartBid(rset.getInt("START_BID"));
				usauselect.setCurrentBid(rset.getInt("CURRENT_BID"));
				usauselect.setaRegDate(rset.getDate("A_REG_DATE"));
				usauselect.setaCloseDate(rset.getDate("A_CLOSE_DATE"));
				
				list.add(usauselect);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(rset);
				close(pstmt);
		}
		
		return list;
	}
	
	public ArrayList<UsedShopNormalSelect> selectUsedNormalList(Connection conn) {
		ArrayList<UsedShopNormalSelect> list = new ArrayList<UsedShopNormalSelect>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from (select rownum rnum, N_MARKET_CD, book_cate_cd, book_img, book_nm, book_price, author, publisher, "
				+ "                publish_date, N_USER_WRITER_ID, user_rank, N_QUALITY, PRICE, "
				+ "                N_REG_DATE, REG_COUNT, SALE_COUNT "
				+ "        from (select * "
				+ "                from tb_used_normal nm "
				+ "                left join tb_book b on (nm.n_used_book_id = b.book_id) "
				+ "                left join tb_user u on (nm.n_user_writer_id = u.user_id) "
				+ "                order by n_market_cd DESC))";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				UsedShopNormalSelect usnmselect = new UsedShopNormalSelect();
				
				usnmselect.setnMarketCd(rset.getInt("N_MARKET_CD"));
				usnmselect.setBookCateCd(rset.getInt("book_cate_cd"));
				usnmselect.setBookimg(rset.getString("BOOK_IMG"));
				usnmselect.setBookNm(rset.getString("book_nm"));
				usnmselect.setBookPrice(rset.getInt("book_price"));
				usnmselect.setAuthor(rset.getString("author"));
				usnmselect.setPublisher(rset.getString("publisher"));
				usnmselect.setPublishDate(rset.getDate("publish_date"));
				usnmselect.setUserId(rset.getString("N_USER_WRITER_ID"));
				usnmselect.setUserRank(rset.getString("user_rank"));
				usnmselect.setnQuality(rset.getString("N_QUALITY"));
				usnmselect.setPrice(rset.getInt("PRICE"));
				usnmselect.setnRegDate(rset.getDate("N_REG_DATE"));
				usnmselect.setRegCount(rset.getInt("REG_COUNT"));
				usnmselect.setSaleCount(rset.getInt("SALE_COUNT"));
				
				list.add(usnmselect);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(rset);
				close(pstmt);
		}
		
		return list;
	}
	
	public int updateAuctionBid(Connection conn, UsedShopAuctionSelect usauselect) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update tb_used_auction "
				+ "set bid_count = bid_count + 1, current_bid = ?, A_BID_USER = ? "
				+ "where a_market_cd = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, usauselect.getCurrentBid());
			pstmt.setString(2, usauselect.getBidUserId());
			pstmt.setInt(3, usauselect.getaMarketCd());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int insertUsedAuction(Connection conn, UsedShopAuctionSelect usauselect) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "INSERT INTO TB_USED_AUCTION "
				+ "VALUES((select max(A_MARKET_CD) + 1 from TB_USED_AUCTION), 1, ?, ?, ?, DEFAULT, ?, NULL, SYSDATE, "
				+ "?, DEFAULT, DEFAULT, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, usauselect.getUserWriterId());
			pstmt.setInt(2, usauselect.getUsedBookId());
			pstmt.setInt(3, usauselect.getStartBid());
			pstmt.setInt(4, usauselect.getCurrentBid());
			pstmt.setDate(5, usauselect.getaCloseDate());
			pstmt.setString(6, usauselect.getaUsedBookIntro());
			pstmt.setString(7, usauselect.getaQuality());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}		
		
		return result;
	}
	
	public int insertUsedNormal(Connection conn, UsedShopNormalSelect usnmselect) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "INSERT INTO TB_USED_NORMAL "
				+ "VALUES((SELECT MAX(N_MARKET_CD) + 1 FROM TB_USED_NORMAL), 2, ?, ?, ?, SYSDATE, ?, DEFAULT, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, usnmselect.getUserWriterId());
			pstmt.setInt(2, usnmselect.getUsedBookId());
			pstmt.setInt(3, usnmselect.getPrice());
			pstmt.setInt(4, usnmselect.getRegCount());
			pstmt.setString(5, usnmselect.getnUsedBookIntro());
			pstmt.setString(6, usnmselect.getnQuality());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}		
		
		return result;
	}
	
	public UsedShopNormal selectUsedAuction(Connection conn, int marketcd) {
		UsedShopNormal usedshop = null;
		return usedshop;
	}
	
	public UsedShopNormal selectUsedNormal(Connection conn, int marketcd) {
		UsedShopNormal usedshop = null;
		return usedshop;
	}
	
	public int updateUsedAuction(Connection conn, UsedShopAuctionSelect usauselect) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update tb_used_auction set A_USED_BOOK_INTRO = ? "
				+ "where A_MARKET_CD = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, usauselect.getaUsedBookIntro());
			pstmt.setInt(2, usauselect.getaMarketCd());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int updateUsedNormal(Connection conn, UsedShopNormalSelect usnmselect) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update tb_used_normal set N_USED_BOOK_INTRO = ?, price = ?, reg_count = ?, sale_count = 0 "
				+ "where N_MARKET_CD = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, usnmselect.getnUsedBookIntro());
			pstmt.setInt(2, usnmselect.getPrice());
			pstmt.setInt(3, usnmselect.getRegCount());
			pstmt.setInt(4, usnmselect.getnMarketCd());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int deleteUsedAuction(Connection conn, int marketcd) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from tb_used_auction where a_market_cd = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, marketcd);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int deleteUsedNormal(Connection conn, int marketcd) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from tb_used_normal where n_market_cd = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, marketcd);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int getAuctionListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from tb_used_auction";
		
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

	public int getNormalListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from tb_used_normal";
		
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
	
	public ArrayList<UsedShopNormal> selectUsedAuctionSearchList(Connection conn) {
		ArrayList<UsedShopNormal> list = null;
		return list;
	}
	
	public ArrayList<UsedShopNormal> selectUsedNormalSearchList(Connection conn) {
		ArrayList<UsedShopNormal> list = null;
		return list;
	}

	public ArrayList<UsedShopAuctionSelect> selectUsedAuctionNewTop4List(Connection conn) {
		ArrayList<UsedShopAuctionSelect> list = new ArrayList<UsedShopAuctionSelect>();
		Statement stmt = null;
		ResultSet rset = null;
		String query = "select * "
				+ "		from (select rownum rnum, a_market_cd, book_img, book_nm, CURRENT_BID, A_REG_DATE, A_CLOSE_DATE "
				+ "		        from (select * "
				+ "		                from tb_used_auction "
				+ "		                join tb_book on (a_used_book_id = book_id) "
				+ "		                order by a_reg_date DESC)) "
				+ "		where rnum between 1 and 4";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				UsedShopAuctionSelect usauctiontop = new UsedShopAuctionSelect();
				
				usauctiontop.setaMarketCd(rset.getInt("a_market_cd"));
				usauctiontop.setBookimg(rset.getString("book_img"));
				usauctiontop.setBookNm(rset.getString("book_nm"));
				usauctiontop.setCurrentBid(rset.getInt("current_bid"));
				usauctiontop.setaRegDate(rset.getDate("a_reg_date"));
				usauctiontop.setaCloseDate(rset.getDate("a_close_date"));
				
				list.add(usauctiontop);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(rset);
				close(stmt);
		}
		
		return list;
	}

	public ArrayList<UsedShopAuctionSelect> selectUsedAuctionHotTop4List(Connection conn) {
		ArrayList<UsedShopAuctionSelect> list = new ArrayList<UsedShopAuctionSelect>();
		Statement stmt = null;
		ResultSet rset = null;
		String query = "select * "
				+ "from (select rownum rnum, a_market_cd, book_img, book_nm, book_price, bid_count, CURRENT_BID, A_REG_DATE, A_CLOSE_DATE "
				+ "		from (select * "
				+ "                from tb_used_auction "
				+ "				join tb_book on (a_used_book_id = book_id) "
				+ "				order by bid_count DESC)) "
				+ "where rnum between 1 and 4";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				UsedShopAuctionSelect usauctiontop = new UsedShopAuctionSelect();
				
				usauctiontop.setaMarketCd(rset.getInt("a_market_cd"));
				usauctiontop.setBookimg(rset.getString("book_img"));
				usauctiontop.setBookNm(rset.getString("book_nm"));
				usauctiontop.setBookPrice(rset.getInt("book_price"));
				usauctiontop.setCurrentBid(rset.getInt("current_bid"));
				usauctiontop.setaRegDate(rset.getDate("a_reg_date"));
				usauctiontop.setaCloseDate(rset.getDate("a_close_date"));
				
				list.add(usauctiontop);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(rset);
				close(stmt);
		}
		
		return list;
	}

	public ArrayList<UsedShopAuctionSelect> selectCategoryAuctionList(Connection conn, int category) {
		ArrayList<UsedShopAuctionSelect> list = new ArrayList<UsedShopAuctionSelect>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "        from (select rownum rnum, a_market_cd, book_cate_cd, book_img, book_nm, book_price, author, publisher, "
				+ "                publish_date, a_user_writer_id, user_rank, a_quality, START_BID, CURRENT_BID, "
				+ "				   A_REG_DATE, A_CLOSE_DATE "
				+ "                from (select * "
				+ "                    from tb_used_auction us "
				+ "                    left join tb_book b on (us.a_used_book_id = b.book_id) "
				+ "                    left join tb_user u on (us.a_user_writer_id = u.user_id) "
				+ "                    where book_cate_cd = ? "
				+ "                        order by a_market_cd DESC))";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, category);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				UsedShopAuctionSelect usauselect = new UsedShopAuctionSelect();
				
				usauselect.setaMarketCd(rset.getInt("a_market_cd"));
				usauselect.setBookCateCd(rset.getInt("book_cate_cd"));
				usauselect.setBookimg(rset.getString("book_img"));
				usauselect.setBookNm(rset.getString("book_nm"));
				usauselect.setBookPrice(rset.getInt("book_price"));
				usauselect.setAuthor(rset.getString("author"));
				usauselect.setPublisher(rset.getString("publisher"));
				usauselect.setPublishDate(rset.getDate("publish_date"));
				usauselect.setUserId(rset.getString("a_user_writer_id"));
				usauselect.setUserRank(rset.getString("user_rank"));
				usauselect.setaQuality(rset.getString("a_quality"));
				usauselect.setStartBid(rset.getInt("START_BID"));
				usauselect.setCurrentBid(rset.getInt("CURRENT_BID"));
				usauselect.setaRegDate(rset.getDate("A_REG_DATE"));
				usauselect.setaCloseDate(rset.getDate("A_CLOSE_DATE"));
				
				list.add(usauselect);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(rset);
				close(pstmt);
		}
		
		return list;
	}

	public Book selectBookNameSearch(Connection conn, String bookname) {
		Book book = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * "
				+ "from tb_book b "
				+ "join tb_category c on (b.book_cate_cd = c.cate_cd) "
				+ "where book_nm = ? and book_type_num = 1";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookname);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				book = new Book();

				book.setBookId(rset.getInt("BOOK_ID"));
				book.setBookCateCd(rset.getInt("BOOK_CATE_CD"));
				book.setBookCategory(rset.getString("BOOK_CATEGORY"));
				book.setBookImg(rset.getString("BOOK_IMG"));
				book.setBookNm(rset.getString("BOOK_NM"));
				book.setIsbn(rset.getInt("ISBN"));
				book.setBookIntro(rset.getString("BOOK_INTRO"));
				book.setAuthor(rset.getString("AUTHOR"));
				book.setBookPrice(rset.getInt("BOOK_PRICE"));
				book.setPublisher(rset.getString("PUBLISHER"));
				book.setPublishDate(rset.getDate("PUBLISH_DATE"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return book;

	}

	public UsedShopAuctionSelect selectAuctionMarketCd(Connection conn, int marketcd) {
		UsedShopAuctionSelect usauselect = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select A_MARKET_CD, A_TYPE_NUM, A_USER_WRITER_ID, u.user_rank, A_USED_BOOK_ID, "
				+ "        b.book_nm, book_category, book_img, b.book_price, START_BID, BID_COUNT, "
				+ "		   AUTHOR, PUBLISHER, PUBLISH_DATE, CURRENT_BID, A_REG_DATE, A_CLOSE_DATE, "
				+ "        SALE_STATE, SALE_FIN, A_USED_BOOK_INTRO, A_QUALITY "
				+ "from tb_used_auction us "
				+ "join tb_book b on (us.A_USED_BOOK_ID = b.book_id) "
				+ "join tb_category c on (b.book_cate_cd = c.cate_cd) "
				+ "join tb_user u on (us.a_user_writer_id = u.user_id) "
				+ "where a_market_cd = ?";				
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, marketcd);			
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				usauselect = new UsedShopAuctionSelect();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				usauselect.setaMarketCd(marketcd);
				usauselect.setaTypeNum(rset.getInt("A_TYPE_NUM"));
				usauselect.setUserWriterId(rset.getString("A_USER_WRITER_ID"));
				usauselect.setUsedBookId(rset.getInt("A_USED_BOOK_ID"));
				usauselect.setUserRank(rset.getString("USER_RANK"));
				usauselect.setBookNm(rset.getString("BOOK_NM"));
				usauselect.setBookCategory(rset.getString("BOOK_CATEGORY"));
				usauselect.setAuthor(rset.getString("AUTHOR"));
				usauselect.setPublisher(rset.getString("PUBLISHER"));
				usauselect.setPublishDate(rset.getDate("PUBLISH_DATE"));
				usauselect.setBookimg(rset.getString("BOOK_IMG"));
				usauselect.setBookPrice(rset.getInt("BOOK_PRICE"));
				usauselect.setStartBid(rset.getInt("START_BID"));
				usauselect.setBidCount(rset.getInt("BID_COUNT"));
				usauselect.setCurrentBid(rset.getInt("CURRENT_BID"));
				usauselect.setaRegDate(rset.getDate("a_reg_date"));
				usauselect.setaCloseDate(rset.getDate("a_close_date"));
				usauselect.setSaleState(rset.getString("SALE_STATE"));
				usauselect.setSaleFin(rset.getInt("SALE_FIN"));
				usauselect.setaUsedBookIntro(rset.getString("A_USED_BOOK_INTRO"));
				usauselect.setaQuality(rset.getString("A_QUALITY"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return usauselect;
	}

	public ArrayList<UsedShopAuctionSelect> selectHopBidList(Connection conn) {
		ArrayList<UsedShopAuctionSelect> list = new ArrayList<UsedShopAuctionSelect>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from (select rownum rnum, a_market_cd, book_cate_cd, book_img, book_nm, book_price, author, publisher, "
				+ "                publish_date, a_user_writer_id, user_rank, a_quality, START_BID, CURRENT_BID, "
				+ "				   A_REG_DATE, A_CLOSE_DATE, bid_count "
				+ "        from (select * "
				+ "                from tb_used_auction us "
				+ "                left join tb_book b on (us.a_used_book_id = b.book_id) "
				+ "                left join tb_user u on (us.a_user_writer_id = u.user_id) "
				+ "                order by bid_count DESC))";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				UsedShopAuctionSelect usauselect = new UsedShopAuctionSelect();
				
				usauselect.setaMarketCd(rset.getInt("a_market_cd"));
				usauselect.setBookCateCd(rset.getInt("book_cate_cd"));
				usauselect.setBookimg(rset.getString("book_img"));
				usauselect.setBookNm(rset.getString("book_nm"));
				usauselect.setBookPrice(rset.getInt("book_price"));
				usauselect.setAuthor(rset.getString("author"));
				usauselect.setPublisher(rset.getString("publisher"));
				usauselect.setPublishDate(rset.getDate("publish_date"));
				usauselect.setUserId(rset.getString("a_user_writer_id"));
				usauselect.setUserRank(rset.getString("user_rank"));
				usauselect.setaQuality(rset.getString("a_quality"));
				usauselect.setStartBid(rset.getInt("START_BID"));
				usauselect.setCurrentBid(rset.getInt("CURRENT_BID"));
				usauselect.setaRegDate(rset.getDate("A_REG_DATE"));
				usauselect.setaCloseDate(rset.getDate("A_CLOSE_DATE"));
				
				list.add(usauselect);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(rset);
				close(pstmt);
		}
		
		return list;
	}

	public int getAuctionHotListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) "
				+ "from (select rownum rnum, a_market_cd, a_used_book_id, a_quality, START_BID, CURRENT_BID, "
				+ "                A_REG_DATE, A_CLOSE_DATE, bid_count "
				+ "        from tb_used_auction "
				+ "        order by bid_count desc) "
				+ "where rnum between 1 and 20";
		
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

	public int getAuctionLastListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) "
				+ "from (select rownum rnum, a_market_cd, a_used_book_id, a_quality, START_BID, CURRENT_BID, "
				+ "                A_REG_DATE, A_CLOSE_DATE, bid_count "
				+ "        from tb_used_auction "
				+ "        order by bid_count desc) "
				+ "where rnum between 1 and 20";
		
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

	public ArrayList<UsedShopAuctionSelect> selectLastDateList(Connection conn) {
		ArrayList<UsedShopAuctionSelect> list = new ArrayList<UsedShopAuctionSelect>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from (select rownum rnum, a_market_cd, book_cate_cd, book_img, book_nm, book_price, author, publisher, "
				+ "                publish_date, a_user_writer_id, user_rank, a_quality, START_BID, CURRENT_BID, "
				+ "				   A_REG_DATE, A_CLOSE_DATE, bid_count "
				+ "        from (select * "
				+ "                from tb_used_auction us "
				+ "                left join tb_book b on (us.a_used_book_id = b.book_id) "
				+ "                left join tb_user u on (us.a_user_writer_id = u.user_id)  "
				+ "                order by bid_count DESC))";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				UsedShopAuctionSelect usauselect = new UsedShopAuctionSelect();
				
				usauselect.setaMarketCd(rset.getInt("a_market_cd"));
				usauselect.setBookCateCd(rset.getInt("book_cate_cd"));
				usauselect.setBookimg(rset.getString("book_img"));
				usauselect.setBookNm(rset.getString("book_nm"));
				usauselect.setBookPrice(rset.getInt("book_price"));
				usauselect.setAuthor(rset.getString("author"));
				usauselect.setPublisher(rset.getString("publisher"));
				usauselect.setPublishDate(rset.getDate("publish_date"));
				usauselect.setUserId(rset.getString("a_user_writer_id"));
				usauselect.setUserRank(rset.getString("user_rank"));
				usauselect.setaQuality(rset.getString("a_quality"));
				usauselect.setStartBid(rset.getInt("START_BID"));
				usauselect.setCurrentBid(rset.getInt("CURRENT_BID"));
				usauselect.setaRegDate(rset.getDate("A_REG_DATE"));
				usauselect.setaCloseDate(rset.getDate("A_CLOSE_DATE"));
				
				list.add(usauselect);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(rset);
				close(pstmt);
		}
		
		return list;
	}

	public ArrayList<UsedShopNormalSelect> selectUsedNormalNewTop4List(Connection conn) {
		ArrayList<UsedShopNormalSelect> list = new ArrayList<UsedShopNormalSelect>();
		Statement stmt = null;
		ResultSet rset = null;
		String query = "select * "
				+ "from (select rownum rnum, N_MARKET_CD, BOOK_IMG, BOOK_NM, N_TYPE_NUM, N_USER_WRITER_ID, "
				+ "		   N_USED_BOOK_ID, PRICE, N_REG_DATE, REG_COUNT, SALE_COUNT, N_USED_BOOK_INTRO, N_QUALITY "
				+ "        from (select * "
				+ "                from tb_used_normal "
				+ "                join tb_book on (n_used_book_id = book_id) "
				+ "                order by n_reg_date DESC)) "
				+ "where rnum between 1 and 4";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				UsedShopNormalSelect usnmselect = new UsedShopNormalSelect();
				
				usnmselect.setnMarketCd(rset.getInt("N_MARKET_CD"));
				usnmselect.setBookimg(rset.getString("BOOK_IMG"));
				usnmselect.setBookNm(rset.getString("BOOK_NM"));
				usnmselect.setnTypeNum(rset.getInt("N_TYPE_NUM"));
				usnmselect.setUserId(rset.getString("N_USER_WRITER_ID"));
				usnmselect.setBookId(rset.getInt("N_USED_BOOK_ID"));
				usnmselect.setPrice(rset.getInt("PRICE"));
				usnmselect.setnRegDate(rset.getDate("N_REG_DATE"));
				usnmselect.setRegCount(rset.getInt("REG_COUNT"));
				usnmselect.setSaleCount(rset.getInt("SALE_COUNT"));
				usnmselect.setnUsedBookIntro(rset.getString("N_USED_BOOK_INTRO"));
				usnmselect.setnQuality(rset.getString("N_QUALITY"));
				
				list.add(usnmselect);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(rset);
				close(stmt);
		}
		
		return list;
	}

	public ArrayList<UsedShopNormalSelect> selectUsedNormalLowPriceTop4List(Connection conn) {
		ArrayList<UsedShopNormalSelect> list = new ArrayList<UsedShopNormalSelect>();
		Statement stmt = null;
		ResultSet rset = null;
		String query = "select * "
				+ "from (select rownum rnum, N_MARKET_CD, BOOK_IMG, BOOK_NM, N_TYPE_NUM, N_USER_WRITER_ID, "
				+ "		   N_USED_BOOK_ID, PRICE, N_REG_DATE, REG_COUNT, SALE_COUNT, N_USED_BOOK_INTRO, N_QUALITY "
				+ "        from (select * "
				+ "                from tb_used_normal "
				+ "                join tb_book on (n_used_book_id = book_id) "
				+ "                order by price)) "
				+ "where rnum between 1 and 4";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				UsedShopNormalSelect usnmselect = new UsedShopNormalSelect();
				
				usnmselect.setnMarketCd(rset.getInt("N_MARKET_CD"));
				usnmselect.setBookimg(rset.getString("BOOK_IMG"));
				usnmselect.setBookNm(rset.getString("BOOK_NM"));
				usnmselect.setnTypeNum(rset.getInt("N_TYPE_NUM"));
				usnmselect.setUserId(rset.getString("N_USER_WRITER_ID"));
				usnmselect.setBookId(rset.getInt("N_USED_BOOK_ID"));
				usnmselect.setPrice(rset.getInt("PRICE"));
				usnmselect.setnRegDate(rset.getDate("N_REG_DATE"));
				usnmselect.setRegCount(rset.getInt("REG_COUNT"));
				usnmselect.setSaleCount(rset.getInt("SALE_COUNT"));
				usnmselect.setnUsedBookIntro(rset.getString("N_USED_BOOK_INTRO"));
				usnmselect.setnQuality(rset.getString("N_QUALITY"));
				
				list.add(usnmselect);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(rset);
				close(stmt);
		}
		
		return list;
	}

	public ArrayList<UsedShopNormalSelect> selectCategoryNormalList(Connection conn, int category) {
		ArrayList<UsedShopNormalSelect> list = new ArrayList<UsedShopNormalSelect>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from (select rownum rnum, N_MARKET_CD, book_cate_cd, book_img, book_nm, book_price, author, publisher, "
				+ "        publish_date, N_USER_WRITER_ID, user_rank, N_QUALITY, PRICE, "
				+ "        N_REG_DATE, REG_COUNT, SALE_COUNT "
				+ "        from (select * "
				+ "                from tb_used_normal nm "
				+ "                left join tb_book b on (nm.n_used_book_id = b.book_id) "
				+ "                left join tb_user u on (nm.n_user_writer_id = u.user_id) "
				+ "                where book_cate_cd = ? "
				+ "                order by n_market_cd DESC))";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, category);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				UsedShopNormalSelect usnmselect = new UsedShopNormalSelect();
				
				usnmselect.setnMarketCd(rset.getInt("N_MARKET_CD"));
				usnmselect.setBookCateCd(rset.getInt("book_cate_cd"));
				usnmselect.setBookimg(rset.getString("BOOK_IMG"));
				usnmselect.setBookNm(rset.getString("book_nm"));
				usnmselect.setBookPrice(rset.getInt("book_price"));
				usnmselect.setAuthor(rset.getString("author"));
				usnmselect.setPublisher(rset.getString("publisher"));
				usnmselect.setPublishDate(rset.getDate("publish_date"));
				usnmselect.setUserId(rset.getString("N_USER_WRITER_ID"));
				usnmselect.setUserRank(rset.getString("user_rank"));
				usnmselect.setnQuality(rset.getString("N_QUALITY"));
				usnmselect.setPrice(rset.getInt("PRICE"));
				usnmselect.setnRegDate(rset.getDate("N_REG_DATE"));
				usnmselect.setRegCount(rset.getInt("REG_COUNT"));
				usnmselect.setSaleCount(rset.getInt("SALE_COUNT"));
				
				list.add(usnmselect);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(rset);
				close(pstmt);
		}
		
		return list;
	}

	public int getNormalLowPriceListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) "
				+ "from (select rownum rnum, N_MARKET_CD, N_TYPE_NUM, N_USER_WRITER_ID, N_USED_BOOK_ID, "
				+ "		PRICE, N_REG_DATE, REG_COUNT, SALE_COUNT, N_USED_BOOK_INTRO, N_QUALITY "
				+ "     from tb_used_normal "
				+ "     order by price desc) "
				+ "where rnum between 1 and 20";
		
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

	public ArrayList<UsedShopNormalSelect> selectNormalLowPriceList(Connection conn) {
		ArrayList<UsedShopNormalSelect> list = new ArrayList<UsedShopNormalSelect>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from (select rownum rnum, N_MARKET_CD, book_cate_cd, book_img, book_nm, book_price, author, publisher, "
				+ "                publish_date, N_USER_WRITER_ID, user_rank, N_QUALITY, PRICE, "
				+ "                N_REG_DATE, REG_COUNT, SALE_COUNT "
				+ "        from (select * "
				+ "                from tb_used_normal nm "
				+ "                left join tb_book b on (nm.n_used_book_id = b.book_id) "
				+ "                left join tb_user u on (nm.n_user_writer_id = u.user_id) "
				+ "                order by price)) ";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				UsedShopNormalSelect usnmselect = new UsedShopNormalSelect();
				
				usnmselect.setnMarketCd(rset.getInt("N_MARKET_CD"));
				usnmselect.setBookCateCd(rset.getInt("book_cate_cd"));
				usnmselect.setBookimg(rset.getString("BOOK_IMG"));
				usnmselect.setBookNm(rset.getString("book_nm"));
				usnmselect.setBookPrice(rset.getInt("book_price"));
				usnmselect.setAuthor(rset.getString("author"));
				usnmselect.setPublisher(rset.getString("publisher"));
				usnmselect.setPublishDate(rset.getDate("publish_date"));
				usnmselect.setUserId(rset.getString("N_USER_WRITER_ID"));
				usnmselect.setUserRank(rset.getString("user_rank"));
				usnmselect.setnQuality(rset.getString("N_QUALITY"));
				usnmselect.setPrice(rset.getInt("PRICE"));
				usnmselect.setnRegDate(rset.getDate("N_REG_DATE"));
				usnmselect.setRegCount(rset.getInt("REG_COUNT"));
				usnmselect.setSaleCount(rset.getInt("SALE_COUNT"));
				
				list.add(usnmselect);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(rset);
				close(pstmt);
		}
		
		return list;
	}

	public int getAuctionMyListCount(Connection conn, String userid) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from tb_used_auction where a_user_writer_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);
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

	public ArrayList<UsedShopAuctionSelect> selectAuctionMyList(Connection conn, String userid) {
		ArrayList<UsedShopAuctionSelect> list = new ArrayList<UsedShopAuctionSelect>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from (select rownum rnum, a_market_cd, book_cate_cd, book_img, book_nm, book_price, author, publisher, "
				+ "                publish_date, a_user_writer_id, user_rank, a_quality, START_BID, CURRENT_BID, "
				+ "                A_REG_DATE, A_CLOSE_DATE "
				+ "        from (select * "
				+ "                from tb_used_auction us "
				+ "                left join tb_book b on (us.a_used_book_id = b.book_id) "
				+ "                left join tb_user u on (us.a_user_writer_id = u.user_id) "
				+ "                where a_user_writer_id = ? "
				+ "                order by a_market_cd DESC)) ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				UsedShopAuctionSelect usauselect = new UsedShopAuctionSelect();
				
				usauselect.setaMarketCd(rset.getInt("a_market_cd"));
				usauselect.setBookCateCd(rset.getInt("book_cate_cd"));
				usauselect.setBookimg(rset.getString("book_img"));
				usauselect.setBookNm(rset.getString("book_nm"));
				usauselect.setBookPrice(rset.getInt("book_price"));
				usauselect.setAuthor(rset.getString("author"));
				usauselect.setPublisher(rset.getString("publisher"));
				usauselect.setPublishDate(rset.getDate("publish_date"));
				usauselect.setUserId(rset.getString("a_user_writer_id"));
				usauselect.setUserRank(rset.getString("user_rank"));
				usauselect.setaQuality(rset.getString("a_quality"));
				usauselect.setStartBid(rset.getInt("START_BID"));
				usauselect.setCurrentBid(rset.getInt("CURRENT_BID"));
				usauselect.setaRegDate(rset.getDate("A_REG_DATE"));
				usauselect.setaCloseDate(rset.getDate("A_CLOSE_DATE"));
				
				list.add(usauselect);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(rset);
				close(pstmt);
		}
		
		return list;
	}

	public int getNormalMyListCount(Connection conn, String userid) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from tb_used_normal where n_user_writer_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);
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

	public ArrayList<UsedShopNormalSelect> selectNormalMyList(Connection conn, String userid, int startRow, int endRow) {
		ArrayList<UsedShopNormalSelect> list = new ArrayList<UsedShopNormalSelect>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from (select rownum rnum, N_MARKET_CD, book_cate_cd, book_img, book_nm, book_price, author, publisher, "
				+ "        publish_date, N_USER_WRITER_ID, user_rank, N_QUALITY, PRICE, "
				+ "        N_REG_DATE, REG_COUNT, SALE_COUNT "
				+ "        from (select * "
				+ "                from tb_used_normal nm "
				+ "                left join tb_book b on (nm.n_used_book_id = b.book_id) "
				+ "                left join tb_user u on (nm.n_user_writer_id = u.user_id) "
				+ "                where n_user_writer_id = ? "
				+ "                order by n_market_cd DESC)) "
				+ "where rnum between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				UsedShopNormalSelect usnmselect = new UsedShopNormalSelect();
				
				usnmselect.setnMarketCd(rset.getInt("N_MARKET_CD"));
				usnmselect.setBookCateCd(rset.getInt("book_cate_cd"));
				usnmselect.setBookimg(rset.getString("BOOK_IMG"));
				usnmselect.setBookNm(rset.getString("book_nm"));
				usnmselect.setBookPrice(rset.getInt("book_price"));
				usnmselect.setAuthor(rset.getString("author"));
				usnmselect.setPublisher(rset.getString("publisher"));
				usnmselect.setPublishDate(rset.getDate("publish_date"));
				usnmselect.setUserId(rset.getString("N_USER_WRITER_ID"));
				usnmselect.setUserRank(rset.getString("user_rank"));
				usnmselect.setnQuality(rset.getString("N_QUALITY"));
				usnmselect.setPrice(rset.getInt("PRICE"));
				usnmselect.setnRegDate(rset.getDate("N_REG_DATE"));
				usnmselect.setRegCount(rset.getInt("REG_COUNT"));
				usnmselect.setSaleCount(rset.getInt("SALE_COUNT"));
				
				list.add(usnmselect);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(rset);
				close(pstmt);
		}
		
		return list;
	}

	public int getAuctionMyBidListCount(Connection conn, String userid) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from tb_used_auction where a_bid_user = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);
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

	public ArrayList<UsedShopAuctionSelect> selectAuctionMyBidList(Connection conn, String userid, int startRow, int endRow) {
		ArrayList<UsedShopAuctionSelect> list = new ArrayList<UsedShopAuctionSelect>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from (select rownum rnum, a_market_cd, book_cate_cd, book_img, book_nm, book_price, author, publisher, "
				+ "                publish_date, a_user_writer_id, user_rank, a_quality, START_BID, CURRENT_BID, "
				+ "                A_REG_DATE, A_CLOSE_DATE "
				+ "        from (select * "
				+ "                from tb_used_auction us "
				+ "                left join tb_book b on (us.a_used_book_id = b.book_id) "
				+ "                left join tb_user u on (us.a_user_writer_id = u.user_id) "
				+ "                where a_bid_user = ? "
				+ "                order by a_market_cd DESC)) "
				+ "where rnum between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				UsedShopAuctionSelect usauselect = new UsedShopAuctionSelect();
				
				usauselect.setaMarketCd(rset.getInt("a_market_cd"));
				usauselect.setBookCateCd(rset.getInt("book_cate_cd"));
				usauselect.setBookimg(rset.getString("book_img"));
				usauselect.setBookNm(rset.getString("book_nm"));
				usauselect.setBookPrice(rset.getInt("book_price"));
				usauselect.setAuthor(rset.getString("author"));
				usauselect.setPublisher(rset.getString("publisher"));
				usauselect.setPublishDate(rset.getDate("publish_date"));
				usauselect.setUserId(rset.getString("a_user_writer_id"));
				usauselect.setUserRank(rset.getString("user_rank"));
				usauselect.setaQuality(rset.getString("a_quality"));
				usauselect.setStartBid(rset.getInt("START_BID"));
				usauselect.setCurrentBid(rset.getInt("CURRENT_BID"));
				usauselect.setaRegDate(rset.getDate("A_REG_DATE"));
				usauselect.setaCloseDate(rset.getDate("A_CLOSE_DATE"));
				
				list.add(usauselect);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(rset);
				close(pstmt);
		}
		
		return list;
	}

	public UsedShopNormalSelect selectNormalMarketCd(Connection conn, int marketcd) {
		UsedShopNormalSelect usnmselect = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select N_MARKET_CD, book_cate_cd, book_img, book_nm, book_category, book_price, author, publisher, "
				+ "            publish_date, N_USER_WRITER_ID, user_rank, N_QUALITY, PRICE, "
				+ "            N_REG_DATE, REG_COUNT, SALE_COUNT, n_used_book_intro "
				+ "from tb_used_normal us "
				+ "join tb_book b on (us.N_USED_BOOK_ID = b.book_id) "
				+ "join tb_category c on (b.book_cate_cd = c.cate_cd) "
				+ "join tb_user u on (us.n_user_writer_id = u.user_id) "
				+ "where n_market_cd = ?";				
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, marketcd);			
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				usnmselect = new UsedShopNormalSelect();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				usnmselect.setnMarketCd(rset.getInt("N_MARKET_CD"));
				usnmselect.setBookCateCd(rset.getInt("book_cate_cd"));
				usnmselect.setBookimg(rset.getString("BOOK_IMG"));
				usnmselect.setBookNm(rset.getString("book_nm"));
				usnmselect.setBookCategory(rset.getString("book_category"));
				usnmselect.setBookPrice(rset.getInt("book_price"));
				usnmselect.setAuthor(rset.getString("author"));
				usnmselect.setPublisher(rset.getString("publisher"));
				usnmselect.setPublishDate(rset.getDate("publish_date"));
				usnmselect.setUserWriterId(rset.getString("N_USER_WRITER_ID"));
				usnmselect.setUserRank(rset.getString("user_rank"));
				usnmselect.setnQuality(rset.getString("N_QUALITY"));
				usnmselect.setPrice(rset.getInt("PRICE"));
				usnmselect.setnRegDate(rset.getDate("N_REG_DATE"));
				usnmselect.setRegCount(rset.getInt("REG_COUNT"));
				usnmselect.setSaleCount(rset.getInt("SALE_COUNT"));
				usnmselect.setnUsedBookIntro(rset.getString("n_used_book_intro"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return usnmselect;
	}

	public ArrayList<UsedShopAuctionSelect> selectSearchBookName(Connection conn, String keyword, int startRow, int endRow) {
		ArrayList<UsedShopAuctionSelect> list = new ArrayList<UsedShopAuctionSelect>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from (select ROWNUM RNUM, a_market_cd, book_cate_cd, book_img, book_nm, book_price, author, publisher, "
				+ "                publish_date, a_user_writer_id, user_rank, a_quality, START_BID, CURRENT_BID, "
				+ "                A_REG_DATE, A_CLOSE_DATE "
				+ "        from tb_used_auction us "
				+ "        left join tb_book b on (us.a_used_book_id = b.book_id) "
				+ "        left join tb_user u on (us.a_user_writer_id = u.user_id) "
				+ "        order by a_market_cd DESC)\r\n"
				+ "where book_nm like ? and  RNUM >= ? AND RNUM <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				UsedShopAuctionSelect usauselect = new UsedShopAuctionSelect();
				
				usauselect.setaMarketCd(rset.getInt("a_market_cd"));
				usauselect.setBookCateCd(rset.getInt("book_cate_cd"));
				usauselect.setBookimg(rset.getString("book_img"));
				usauselect.setBookNm(rset.getString("book_nm"));
				usauselect.setBookPrice(rset.getInt("book_price"));
				usauselect.setAuthor(rset.getString("author"));
				usauselect.setPublisher(rset.getString("publisher"));
				usauselect.setPublishDate(rset.getDate("publish_date"));
				usauselect.setUserWriterId(rset.getString("a_user_writer_id"));
				usauselect.setUserRank(rset.getString("user_rank"));
				usauselect.setaQuality(rset.getString("a_quality"));
				usauselect.setStartBid(rset.getInt("START_BID"));
				usauselect.setCurrentBid(rset.getInt("CURRENT_BID"));
				usauselect.setaRegDate(rset.getDate("A_REG_DATE"));
				usauselect.setaCloseDate(rset.getDate("A_CLOSE_DATE"));
				
				list.add(usauselect);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<UsedShopAuctionSelect> selectSearchWriterId(Connection conn, String keyword, int startRow, int endRow) {
		ArrayList<UsedShopAuctionSelect> list = new ArrayList<UsedShopAuctionSelect>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from (select ROWNUM RNUM, a_market_cd, book_cate_cd, book_img, book_nm, book_price, author, publisher, "
				+ "                publish_date, a_user_writer_id, user_rank, a_quality, START_BID, CURRENT_BID, "
				+ "                A_REG_DATE, A_CLOSE_DATE "
				+ "        from tb_used_auction us "
				+ "        left join tb_book b on (us.a_used_book_id = b.book_id) "
				+ "        left join tb_user u on (us.a_user_writer_id = u.user_id) "
				+ "        order by a_market_cd DESC)\r\n"
				+ "where a_user_writer_id like ? and  RNUM >= ? AND RNUM <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				UsedShopAuctionSelect usauselect = new UsedShopAuctionSelect();
				
				usauselect.setaMarketCd(rset.getInt("a_market_cd"));
				usauselect.setBookCateCd(rset.getInt("book_cate_cd"));
				usauselect.setBookimg(rset.getString("book_img"));
				usauselect.setBookNm(rset.getString("book_nm"));
				usauselect.setBookPrice(rset.getInt("book_price"));
				usauselect.setAuthor(rset.getString("author"));
				usauselect.setPublisher(rset.getString("publisher"));
				usauselect.setPublishDate(rset.getDate("publish_date"));
				usauselect.setUserWriterId(rset.getString("a_user_writer_id"));
				usauselect.setUserRank(rset.getString("user_rank"));
				usauselect.setaQuality(rset.getString("a_quality"));
				usauselect.setStartBid(rset.getInt("START_BID"));
				usauselect.setCurrentBid(rset.getInt("CURRENT_BID"));
				usauselect.setaRegDate(rset.getDate("A_REG_DATE"));
				usauselect.setaCloseDate(rset.getDate("A_CLOSE_DATE"));
				
				list.add(usauselect);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<UsedShopNormalSelect> selectNormalSearchBookName(Connection conn, String keyword, int startRow, int endRow) {
		ArrayList<UsedShopNormalSelect> list = new ArrayList<UsedShopNormalSelect>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from (select rownum rnum, N_MARKET_CD, book_cate_cd, book_img, book_nm, book_price, author, publisher, "
				+ "                publish_date, N_USER_WRITER_ID, user_rank, N_QUALITY, PRICE, "
				+ "                N_REG_DATE, REG_COUNT, SALE_COUNT "
				+ "        from (select * "
				+ "                from tb_used_normal nm "
				+ "                left join tb_book b on (nm.n_used_book_id = b.book_id) "
				+ "                left join tb_user u on (nm.n_user_writer_id = u.user_id) "
				+ "                order by n_market_cd DESC)) "
				+ "where book_nm like ? and rnum between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				UsedShopNormalSelect usnmselect = new UsedShopNormalSelect();
				
				usnmselect.setnMarketCd(rset.getInt("N_MARKET_CD"));
				usnmselect.setBookCateCd(rset.getInt("book_cate_cd"));
				usnmselect.setBookimg(rset.getString("BOOK_IMG"));
				usnmselect.setBookNm(rset.getString("book_nm"));
				usnmselect.setBookPrice(rset.getInt("book_price"));
				usnmselect.setAuthor(rset.getString("author"));
				usnmselect.setPublisher(rset.getString("publisher"));
				usnmselect.setPublishDate(rset.getDate("publish_date"));
				usnmselect.setUserId(rset.getString("N_USER_WRITER_ID"));
				usnmselect.setUserRank(rset.getString("user_rank"));
				usnmselect.setnQuality(rset.getString("N_QUALITY"));
				usnmselect.setPrice(rset.getInt("PRICE"));
				usnmselect.setnRegDate(rset.getDate("N_REG_DATE"));
				usnmselect.setRegCount(rset.getInt("REG_COUNT"));
				usnmselect.setSaleCount(rset.getInt("SALE_COUNT"));
				
				list.add(usnmselect);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(rset);
				close(pstmt);
		}
		
		return list;
	}

	public ArrayList<UsedShopNormalSelect> selectNormalSearchWriterId(Connection conn, String keyword, int startRow, int endRow) {
		ArrayList<UsedShopNormalSelect> list = new ArrayList<UsedShopNormalSelect>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from (select rownum rnum, N_MARKET_CD, book_cate_cd, book_img, book_nm, book_price, author, publisher, "
				+ "                publish_date, N_USER_WRITER_ID, user_rank, N_QUALITY, PRICE, "
				+ "                N_REG_DATE, REG_COUNT, SALE_COUNT "
				+ "        from (select * "
				+ "                from tb_used_normal nm "
				+ "                left join tb_book b on (nm.n_used_book_id = b.book_id) "
				+ "                left join tb_user u on (nm.n_user_writer_id = u.user_id) "
				+ "                order by n_market_cd DESC)) "
				+ "where N_USER_WRITER_ID like ? and rnum between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				UsedShopNormalSelect usnmselect = new UsedShopNormalSelect();
				
				usnmselect.setnMarketCd(rset.getInt("N_MARKET_CD"));
				usnmselect.setBookCateCd(rset.getInt("book_cate_cd"));
				usnmselect.setBookimg(rset.getString("BOOK_IMG"));
				usnmselect.setBookNm(rset.getString("book_nm"));
				usnmselect.setBookPrice(rset.getInt("book_price"));
				usnmselect.setAuthor(rset.getString("author"));
				usnmselect.setPublisher(rset.getString("publisher"));
				usnmselect.setPublishDate(rset.getDate("publish_date"));
				usnmselect.setUserId(rset.getString("N_USER_WRITER_ID"));
				usnmselect.setUserRank(rset.getString("user_rank"));
				usnmselect.setnQuality(rset.getString("N_QUALITY"));
				usnmselect.setPrice(rset.getInt("PRICE"));
				usnmselect.setnRegDate(rset.getDate("N_REG_DATE"));
				usnmselect.setRegCount(rset.getInt("REG_COUNT"));
				usnmselect.setSaleCount(rset.getInt("SALE_COUNT"));
				
				list.add(usnmselect);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(rset);
				close(pstmt);
		}
		
		return list;
	}

	public ArrayList<UsedShopAuctionSelect> selectUsedAuctionLastTop4List(Connection conn) {
		ArrayList<UsedShopAuctionSelect> list = new ArrayList<UsedShopAuctionSelect>();
		Statement stmt = null;
		ResultSet rset = null;
		String query = "select * "
				+ "		from (select rownum rnum, a_market_cd, book_img, book_nm, CURRENT_BID, A_REG_DATE, A_CLOSE_DATE "
				+ "		        from (select * "
				+ "		                from tb_used_auction "
				+ "		                join tb_book on (a_used_book_id = book_id) "
				+ "		                order by a_reg_date DESC)) "
				+ "		where rnum between 1 and 4";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				UsedShopAuctionSelect usauctiontop = new UsedShopAuctionSelect();
				
				usauctiontop.setaMarketCd(rset.getInt("a_market_cd"));
				usauctiontop.setBookimg(rset.getString("book_img"));
				usauctiontop.setBookNm(rset.getString("book_nm"));
				usauctiontop.setCurrentBid(rset.getInt("current_bid"));
				usauctiontop.setaRegDate(rset.getDate("a_reg_date"));
				usauctiontop.setaCloseDate(rset.getDate("a_close_date"));
				
				list.add(usauctiontop);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(rset);
				close(stmt);
		}
		
		return list;
	}

	public ArrayList<UsedShopAuctionSelect> selectAuctionList(Connection conn) {
		ArrayList<UsedShopAuctionSelect> list = new ArrayList<UsedShopAuctionSelect>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "        from (select rownum rnum, a_market_cd, book_cate_cd, book_img, book_nm, book_price, author, publisher, "
				+ "                publish_date, a_user_writer_id, user_rank, a_quality, START_BID, CURRENT_BID, "
				+ "				   A_REG_DATE, A_CLOSE_DATE "
				+ "                from (select * "
				+ "                    from tb_used_auction us "
				+ "                    left join tb_book b on (us.a_used_book_id = b.book_id) "
				+ "                    left join tb_user u on (us.a_user_writer_id = u.user_id) "
				+ "                    order by a_market_cd DESC)) ";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				UsedShopAuctionSelect usauselect = new UsedShopAuctionSelect();
				
				usauselect.setaMarketCd(rset.getInt("a_market_cd"));
				usauselect.setBookCateCd(rset.getInt("book_cate_cd"));
				usauselect.setBookimg(rset.getString("book_img"));
				usauselect.setBookNm(rset.getString("book_nm"));
				usauselect.setBookPrice(rset.getInt("book_price"));
				usauselect.setAuthor(rset.getString("author"));
				usauselect.setPublisher(rset.getString("publisher"));
				usauselect.setPublishDate(rset.getDate("publish_date"));
				usauselect.setUserId(rset.getString("a_user_writer_id"));
				usauselect.setUserRank(rset.getString("user_rank"));
				usauselect.setaQuality(rset.getString("a_quality"));
				usauselect.setStartBid(rset.getInt("START_BID"));
				usauselect.setCurrentBid(rset.getInt("CURRENT_BID"));
				usauselect.setaRegDate(rset.getDate("A_REG_DATE"));
				usauselect.setaCloseDate(rset.getDate("A_CLOSE_DATE"));
				
				list.add(usauselect);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(rset);
				close(pstmt);
		}
		
		return list;
	}

	public ArrayList<UsedShopNormalSelect> selectNormalList(Connection conn) {
		ArrayList<UsedShopNormalSelect> list = new ArrayList<UsedShopNormalSelect>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from (select rownum rnum, N_MARKET_CD, book_cate_cd, book_img, book_nm, book_price, author, publisher, "
				+ "        publish_date, N_USER_WRITER_ID, user_rank, N_QUALITY, PRICE, "
				+ "        N_REG_DATE, REG_COUNT, SALE_COUNT "
				+ "        from (select * "
				+ "                from tb_used_normal nm "
				+ "                left join tb_book b on (nm.n_used_book_id = b.book_id) "
				+ "                left join tb_user u on (nm.n_user_writer_id = u.user_id) "
				+ "                order by n_market_cd DESC))";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				UsedShopNormalSelect usnmselect = new UsedShopNormalSelect();
				
				usnmselect.setnMarketCd(rset.getInt("N_MARKET_CD"));
				usnmselect.setBookCateCd(rset.getInt("book_cate_cd"));
				usnmselect.setBookimg(rset.getString("BOOK_IMG"));
				usnmselect.setBookNm(rset.getString("book_nm"));
				usnmselect.setBookPrice(rset.getInt("book_price"));
				usnmselect.setAuthor(rset.getString("author"));
				usnmselect.setPublisher(rset.getString("publisher"));
				usnmselect.setPublishDate(rset.getDate("publish_date"));
				usnmselect.setUserId(rset.getString("N_USER_WRITER_ID"));
				usnmselect.setUserRank(rset.getString("user_rank"));
				usnmselect.setnQuality(rset.getString("N_QUALITY"));
				usnmselect.setPrice(rset.getInt("PRICE"));
				usnmselect.setnRegDate(rset.getDate("N_REG_DATE"));
				usnmselect.setRegCount(rset.getInt("REG_COUNT"));
				usnmselect.setSaleCount(rset.getInt("SALE_COUNT"));
				
				list.add(usnmselect);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(rset);
				close(pstmt);
		}
		
		return list;
	}

	public int deleteUsedAuction(Connection conn, String userid) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from tb_used_auction where a_user_writer_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteUsedNormal(Connection conn, String userid) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from tb_used_normal where n_user_writer_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<UsedShopAuctionSelect> selectAuctionSearchBookName(Connection conn, String keyword) {
		ArrayList<UsedShopAuctionSelect> list = new ArrayList<UsedShopAuctionSelect>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from (select ROWNUM RNUM, a_market_cd, book_cate_cd, book_img, book_nm, book_price, author, publisher, "
				+ "                publish_date, a_user_writer_id, user_rank, a_quality, START_BID, CURRENT_BID, "
				+ "                A_REG_DATE, A_CLOSE_DATE "
				+ "        from tb_used_auction us "
				+ "        left join tb_book b on (us.a_used_book_id = b.book_id) "
				+ "        left join tb_user u on (us.a_user_writer_id = u.user_id) "
				+ "        order by a_market_cd DESC) "
				+ "where book_nm like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				UsedShopAuctionSelect usauselect = new UsedShopAuctionSelect();
				
				usauselect.setaMarketCd(rset.getInt("a_market_cd"));
				usauselect.setBookCateCd(rset.getInt("book_cate_cd"));
				usauselect.setBookimg(rset.getString("book_img"));
				usauselect.setBookNm(rset.getString("book_nm"));
				usauselect.setBookPrice(rset.getInt("book_price"));
				usauselect.setAuthor(rset.getString("author"));
				usauselect.setPublisher(rset.getString("publisher"));
				usauselect.setPublishDate(rset.getDate("publish_date"));
				usauselect.setUserId(rset.getString("a_user_writer_id"));
				usauselect.setUserWriterId(rset.getString("a_user_writer_id"));
				usauselect.setUserRank(rset.getString("user_rank"));
				usauselect.setaQuality(rset.getString("a_quality"));
				usauselect.setStartBid(rset.getInt("START_BID"));
				usauselect.setCurrentBid(rset.getInt("CURRENT_BID"));
				usauselect.setaRegDate(rset.getDate("A_REG_DATE"));
				usauselect.setaCloseDate(rset.getDate("A_CLOSE_DATE"));
				
				list.add(usauselect);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<UsedShopAuctionSelect> selectAuctionSearchWriterId(Connection conn, String keyword) {
		ArrayList<UsedShopAuctionSelect> list = new ArrayList<UsedShopAuctionSelect>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from (select ROWNUM RNUM, a_market_cd, book_cate_cd, book_img, book_nm, book_price, author, publisher, "
				+ "                publish_date, a_user_writer_id, user_rank, a_quality, START_BID, CURRENT_BID, "
				+ "                A_REG_DATE, A_CLOSE_DATE "
				+ "        from tb_used_auction us "
				+ "        left join tb_book b on (us.a_used_book_id = b.book_id) "
				+ "        left join tb_user u on (us.a_user_writer_id = u.user_id) "
				+ "        order by a_market_cd DESC) "
				+ "where a_user_writer_id like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				UsedShopAuctionSelect usauselect = new UsedShopAuctionSelect();
				
				usauselect.setaMarketCd(rset.getInt("a_market_cd"));
				usauselect.setBookCateCd(rset.getInt("book_cate_cd"));
				usauselect.setBookimg(rset.getString("book_img"));
				usauselect.setBookNm(rset.getString("book_nm"));
				usauselect.setBookPrice(rset.getInt("book_price"));
				usauselect.setAuthor(rset.getString("author"));
				usauselect.setPublisher(rset.getString("publisher"));
				usauselect.setPublishDate(rset.getDate("publish_date"));
				usauselect.setUserId(rset.getString("a_user_writer_id"));
				usauselect.setUserWriterId(rset.getString("a_user_writer_id"));
				usauselect.setUserRank(rset.getString("user_rank"));
				usauselect.setaQuality(rset.getString("a_quality"));
				usauselect.setStartBid(rset.getInt("START_BID"));
				usauselect.setCurrentBid(rset.getInt("CURRENT_BID"));
				usauselect.setaRegDate(rset.getDate("A_REG_DATE"));
				usauselect.setaCloseDate(rset.getDate("A_CLOSE_DATE"));
				
				list.add(usauselect);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<UsedShopAuctionSelect> selectAuctionCategorySearchBookName(Connection conn, String keyword, int category) {
		ArrayList<UsedShopAuctionSelect> list = new ArrayList<UsedShopAuctionSelect>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from (select ROWNUM RNUM, a_market_cd, book_cate_cd, book_img, book_nm, book_price, author, publisher, "
				+ "                publish_date, a_user_writer_id, user_rank, a_quality, START_BID, CURRENT_BID, "
				+ "                A_REG_DATE, A_CLOSE_DATE "
				+ "        from tb_used_auction us "
				+ "        left join tb_book b on (us.a_used_book_id = b.book_id) "
				+ "        left join tb_user u on (us.a_user_writer_id = u.user_id) "
				+ "        order by a_market_cd DESC) "
				+ "where book_nm like ? and book_cate_cd = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, category);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				UsedShopAuctionSelect usauselect = new UsedShopAuctionSelect();
				
				usauselect.setaMarketCd(rset.getInt("a_market_cd"));
				usauselect.setBookCateCd(rset.getInt("book_cate_cd"));
				usauselect.setBookimg(rset.getString("book_img"));
				usauselect.setBookNm(rset.getString("book_nm"));
				usauselect.setBookPrice(rset.getInt("book_price"));
				usauselect.setAuthor(rset.getString("author"));
				usauselect.setPublisher(rset.getString("publisher"));
				usauselect.setPublishDate(rset.getDate("publish_date"));
				usauselect.setUserId(rset.getString("a_user_writer_id"));
				usauselect.setUserWriterId(rset.getString("a_user_writer_id"));
				usauselect.setUserRank(rset.getString("user_rank"));
				usauselect.setaQuality(rset.getString("a_quality"));
				usauselect.setStartBid(rset.getInt("START_BID"));
				usauselect.setCurrentBid(rset.getInt("CURRENT_BID"));
				usauselect.setaRegDate(rset.getDate("A_REG_DATE"));
				usauselect.setaCloseDate(rset.getDate("A_CLOSE_DATE"));
				
				list.add(usauselect);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<UsedShopAuctionSelect> selectAuctionCategorySearchWriterId(Connection conn, String keyword, int category) {
		ArrayList<UsedShopAuctionSelect> list = new ArrayList<UsedShopAuctionSelect>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from (select ROWNUM RNUM, a_market_cd, book_cate_cd, book_img, book_nm, book_price, author, publisher, "
				+ "                publish_date, a_user_writer_id, user_rank, a_quality, START_BID, CURRENT_BID, "
				+ "                A_REG_DATE, A_CLOSE_DATE "
				+ "        from tb_used_auction us "
				+ "        left join tb_book b on (us.a_used_book_id = b.book_id) "
				+ "        left join tb_user u on (us.a_user_writer_id = u.user_id) "
				+ "        order by a_market_cd DESC) "
				+ "where a_user_writer_id like ? and book_cate_cd = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, category);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				UsedShopAuctionSelect usauselect = new UsedShopAuctionSelect();
				
				usauselect.setaMarketCd(rset.getInt("a_market_cd"));
				usauselect.setBookCateCd(rset.getInt("book_cate_cd"));
				usauselect.setBookimg(rset.getString("book_img"));
				usauselect.setBookNm(rset.getString("book_nm"));
				usauselect.setBookPrice(rset.getInt("book_price"));
				usauselect.setAuthor(rset.getString("author"));
				usauselect.setPublisher(rset.getString("publisher"));
				usauselect.setPublishDate(rset.getDate("publish_date"));
				usauselect.setUserId(rset.getString("a_user_writer_id"));
				usauselect.setUserWriterId(rset.getString("a_user_writer_id"));
				usauselect.setUserRank(rset.getString("user_rank"));
				usauselect.setaQuality(rset.getString("a_quality"));
				usauselect.setStartBid(rset.getInt("START_BID"));
				usauselect.setCurrentBid(rset.getInt("CURRENT_BID"));
				usauselect.setaRegDate(rset.getDate("A_REG_DATE"));
				usauselect.setaCloseDate(rset.getDate("A_CLOSE_DATE"));
				
				list.add(usauselect);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<UsedShopNormalSelect> selectNormalSearchBookName(Connection conn, String keyword) {
		ArrayList<UsedShopNormalSelect> list = new ArrayList<UsedShopNormalSelect>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from (select rownum rnum, N_MARKET_CD, book_cate_cd, book_img, book_nm, book_price, author, publisher, "
				+ "                publish_date, N_USER_WRITER_ID, user_rank, N_QUALITY, PRICE, "
				+ "                N_REG_DATE, REG_COUNT, SALE_COUNT "
				+ "        from (select * "
				+ "                from tb_used_normal nm "
				+ "                left join tb_book b on (nm.n_used_book_id = b.book_id) "
				+ "                left join tb_user u on (nm.n_user_writer_id = u.user_id) "
				+ "                order by n_market_cd DESC)) "
				+ "where book_nm like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				UsedShopNormalSelect usnmselect = new UsedShopNormalSelect();
				
				usnmselect.setnMarketCd(rset.getInt("N_MARKET_CD"));
				usnmselect.setBookCateCd(rset.getInt("book_cate_cd"));
				usnmselect.setBookimg(rset.getString("BOOK_IMG"));
				usnmselect.setBookNm(rset.getString("book_nm"));
				usnmselect.setBookPrice(rset.getInt("book_price"));
				usnmselect.setAuthor(rset.getString("author"));
				usnmselect.setPublisher(rset.getString("publisher"));
				usnmselect.setPublishDate(rset.getDate("publish_date"));
				usnmselect.setUserId(rset.getString("N_USER_WRITER_ID"));
				usnmselect.setUserRank(rset.getString("user_rank"));
				usnmselect.setnQuality(rset.getString("N_QUALITY"));
				usnmselect.setPrice(rset.getInt("PRICE"));
				usnmselect.setnRegDate(rset.getDate("N_REG_DATE"));
				usnmselect.setRegCount(rset.getInt("REG_COUNT"));
				usnmselect.setSaleCount(rset.getInt("SALE_COUNT"));
				
				list.add(usnmselect);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(rset);
				close(pstmt);
		}
		
		return list;
	}

	public ArrayList<UsedShopNormalSelect> selectNormalSearchWriterId(Connection conn, String keyword) {
		ArrayList<UsedShopNormalSelect> list = new ArrayList<UsedShopNormalSelect>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from (select rownum rnum, N_MARKET_CD, book_cate_cd, book_img, book_nm, book_price, author, publisher, "
				+ "                publish_date, N_USER_WRITER_ID, user_rank, N_QUALITY, PRICE, "
				+ "                N_REG_DATE, REG_COUNT, SALE_COUNT "
				+ "        from (select * "
				+ "                from tb_used_normal nm "
				+ "                left join tb_book b on (nm.n_used_book_id = b.book_id) "
				+ "                left join tb_user u on (nm.n_user_writer_id = u.user_id) "
				+ "                order by n_market_cd DESC)) "
				+ "where N_USER_WRITER_ID like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				UsedShopNormalSelect usnmselect = new UsedShopNormalSelect();
				
				usnmselect.setnMarketCd(rset.getInt("N_MARKET_CD"));
				usnmselect.setBookCateCd(rset.getInt("book_cate_cd"));
				usnmselect.setBookimg(rset.getString("BOOK_IMG"));
				usnmselect.setBookNm(rset.getString("book_nm"));
				usnmselect.setBookPrice(rset.getInt("book_price"));
				usnmselect.setAuthor(rset.getString("author"));
				usnmselect.setPublisher(rset.getString("publisher"));
				usnmselect.setPublishDate(rset.getDate("publish_date"));
				usnmselect.setUserId(rset.getString("N_USER_WRITER_ID"));
				usnmselect.setUserRank(rset.getString("user_rank"));
				usnmselect.setnQuality(rset.getString("N_QUALITY"));
				usnmselect.setPrice(rset.getInt("PRICE"));
				usnmselect.setnRegDate(rset.getDate("N_REG_DATE"));
				usnmselect.setRegCount(rset.getInt("REG_COUNT"));
				usnmselect.setSaleCount(rset.getInt("SALE_COUNT"));
				
				list.add(usnmselect);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(rset);
				close(pstmt);
		}
		
		return list;
	}

	public ArrayList<UsedShopNormalSelect> selectNormalCategorySearchBookName(Connection conn, String keyword, int category) {
		ArrayList<UsedShopNormalSelect> list = new ArrayList<UsedShopNormalSelect>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from (select rownum rnum, N_MARKET_CD, book_cate_cd, book_img, book_nm, book_price, author, publisher, "
				+ "                publish_date, N_USER_WRITER_ID, user_rank, N_QUALITY, PRICE, "
				+ "                N_REG_DATE, REG_COUNT, SALE_COUNT "
				+ "        from (select * "
				+ "                from tb_used_normal nm "
				+ "                left join tb_book b on (nm.n_used_book_id = b.book_id) "
				+ "                left join tb_user u on (nm.n_user_writer_id = u.user_id) "
				+ "                order by n_market_cd DESC)) "
				+ "where book_nm like ? and book_cate_cd = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, category);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				UsedShopNormalSelect usnmselect = new UsedShopNormalSelect();
				
				usnmselect.setnMarketCd(rset.getInt("N_MARKET_CD"));
				usnmselect.setBookCateCd(rset.getInt("book_cate_cd"));
				usnmselect.setBookimg(rset.getString("BOOK_IMG"));
				usnmselect.setBookNm(rset.getString("book_nm"));
				usnmselect.setBookPrice(rset.getInt("book_price"));
				usnmselect.setAuthor(rset.getString("author"));
				usnmselect.setPublisher(rset.getString("publisher"));
				usnmselect.setPublishDate(rset.getDate("publish_date"));
				usnmselect.setUserId(rset.getString("N_USER_WRITER_ID"));
				usnmselect.setUserRank(rset.getString("user_rank"));
				usnmselect.setnQuality(rset.getString("N_QUALITY"));
				usnmselect.setPrice(rset.getInt("PRICE"));
				usnmselect.setnRegDate(rset.getDate("N_REG_DATE"));
				usnmselect.setRegCount(rset.getInt("REG_COUNT"));
				usnmselect.setSaleCount(rset.getInt("SALE_COUNT"));
				
				list.add(usnmselect);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(rset);
				close(pstmt);
		}
		
		return list;
	}

	public ArrayList<UsedShopNormalSelect> selectNormalCategorySearchWriterId(Connection conn, String keyword, int category) {
		ArrayList<UsedShopNormalSelect> list = new ArrayList<UsedShopNormalSelect>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from (select rownum rnum, N_MARKET_CD, book_cate_cd, book_img, book_nm, book_price, author, publisher, "
				+ "                publish_date, N_USER_WRITER_ID, user_rank, N_QUALITY, PRICE, "
				+ "                N_REG_DATE, REG_COUNT, SALE_COUNT "
				+ "        from (select * "
				+ "                from tb_used_normal nm "
				+ "                left join tb_book b on (nm.n_used_book_id = b.book_id) "
				+ "                left join tb_user u on (nm.n_user_writer_id = u.user_id) "
				+ "                order by n_market_cd DESC)) "
				+ "where N_USER_WRITER_ID like ? and book_cate_cd = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, category);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				UsedShopNormalSelect usnmselect = new UsedShopNormalSelect();
				
				usnmselect.setnMarketCd(rset.getInt("N_MARKET_CD"));
				usnmselect.setBookCateCd(rset.getInt("book_cate_cd"));
				usnmselect.setBookimg(rset.getString("BOOK_IMG"));
				usnmselect.setBookNm(rset.getString("book_nm"));
				usnmselect.setBookPrice(rset.getInt("book_price"));
				usnmselect.setAuthor(rset.getString("author"));
				usnmselect.setPublisher(rset.getString("publisher"));
				usnmselect.setPublishDate(rset.getDate("publish_date"));
				usnmselect.setUserId(rset.getString("N_USER_WRITER_ID"));
				usnmselect.setUserRank(rset.getString("user_rank"));
				usnmselect.setnQuality(rset.getString("N_QUALITY"));
				usnmselect.setPrice(rset.getInt("PRICE"));
				usnmselect.setnRegDate(rset.getDate("N_REG_DATE"));
				usnmselect.setRegCount(rset.getInt("REG_COUNT"));
				usnmselect.setSaleCount(rset.getInt("SALE_COUNT"));
				
				list.add(usnmselect);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(rset);
				close(pstmt);
		}
		
		return list;
	}

	public ArrayList<UsedShopAuctionSelect> selectMyAuctionSearchBookName(Connection conn, String userid, String keyword) {
		ArrayList<UsedShopAuctionSelect> list = new ArrayList<UsedShopAuctionSelect>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from (select rownum rnum, a_market_cd, book_cate_cd, book_img, book_nm, book_price, author, publisher, "
				+ "                publish_date, a_user_writer_id, user_rank, a_quality, START_BID, CURRENT_BID, "
				+ "                A_REG_DATE, A_CLOSE_DATE "
				+ "        from (select * "
				+ "                from tb_used_auction us "
				+ "                left join tb_book b on (us.a_used_book_id = b.book_id) "
				+ "                left join tb_user u on (us.a_user_writer_id = u.user_id) "
				+ "                where a_user_writer_id = ? "
				+ "                order by a_market_cd DESC)) "
				+ "where book_nm like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);
			pstmt.setString(2, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				UsedShopAuctionSelect usauselect = new UsedShopAuctionSelect();
				
				usauselect.setaMarketCd(rset.getInt("a_market_cd"));
				usauselect.setBookCateCd(rset.getInt("book_cate_cd"));
				usauselect.setBookimg(rset.getString("book_img"));
				usauselect.setBookNm(rset.getString("book_nm"));
				usauselect.setBookPrice(rset.getInt("book_price"));
				usauselect.setAuthor(rset.getString("author"));
				usauselect.setPublisher(rset.getString("publisher"));
				usauselect.setPublishDate(rset.getDate("publish_date"));
				usauselect.setUserId(rset.getString("a_user_writer_id"));
				usauselect.setUserRank(rset.getString("user_rank"));
				usauselect.setaQuality(rset.getString("a_quality"));
				usauselect.setStartBid(rset.getInt("START_BID"));
				usauselect.setCurrentBid(rset.getInt("CURRENT_BID"));
				usauselect.setaRegDate(rset.getDate("A_REG_DATE"));
				usauselect.setaCloseDate(rset.getDate("A_CLOSE_DATE"));
				
				list.add(usauselect);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(rset);
				close(pstmt);
		}
		
		return list;
	}

	public ArrayList<UsedShopNormalSelect> selectMyNormalSearchBookName(Connection conn, String userid, String keyword) {
		ArrayList<UsedShopNormalSelect> list = new ArrayList<UsedShopNormalSelect>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from (select rownum rnum, N_MARKET_CD, book_cate_cd, book_img, book_nm, book_price, author, publisher, "
				+ "        publish_date, N_USER_WRITER_ID, user_rank, N_QUALITY, PRICE, "
				+ "        N_REG_DATE, REG_COUNT, SALE_COUNT "
				+ "        from (select * "
				+ "                from tb_used_normal nm "
				+ "                left join tb_book b on (nm.n_used_book_id = b.book_id) "
				+ "                left join tb_user u on (nm.n_user_writer_id = u.user_id) "
				+ "                where n_user_writer_id = ? "
				+ "                order by n_market_cd DESC)) "
				+ "where book_nm like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);
			pstmt.setString(2, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				UsedShopNormalSelect usnmselect = new UsedShopNormalSelect();
				
				usnmselect.setnMarketCd(rset.getInt("N_MARKET_CD"));
				usnmselect.setBookCateCd(rset.getInt("book_cate_cd"));
				usnmselect.setBookimg(rset.getString("BOOK_IMG"));
				usnmselect.setBookNm(rset.getString("book_nm"));
				usnmselect.setBookPrice(rset.getInt("book_price"));
				usnmselect.setAuthor(rset.getString("author"));
				usnmselect.setPublisher(rset.getString("publisher"));
				usnmselect.setPublishDate(rset.getDate("publish_date"));
				usnmselect.setUserId(rset.getString("N_USER_WRITER_ID"));
				usnmselect.setUserRank(rset.getString("user_rank"));
				usnmselect.setnQuality(rset.getString("N_QUALITY"));
				usnmselect.setPrice(rset.getInt("PRICE"));
				usnmselect.setnRegDate(rset.getDate("N_REG_DATE"));
				usnmselect.setRegCount(rset.getInt("REG_COUNT"));
				usnmselect.setSaleCount(rset.getInt("SALE_COUNT"));
				
				list.add(usnmselect);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(rset);
				close(pstmt);
		}
		
		return list;
	}

	public ArrayList<UsedShopAuctionSelect> selectMyBidSearchBookName(Connection conn, String userid, String keyword) {
		ArrayList<UsedShopAuctionSelect> list = new ArrayList<UsedShopAuctionSelect>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from (select rownum rnum, a_market_cd, book_cate_cd, book_img, book_nm, book_price, author, publisher, "
				+ "                publish_date, a_user_writer_id, user_rank, a_quality, START_BID, CURRENT_BID, "
				+ "                A_REG_DATE, A_CLOSE_DATE "
				+ "        from (select * "
				+ "                from tb_used_auction us "
				+ "                left join tb_book b on (us.a_used_book_id = b.book_id) "
				+ "                left join tb_user u on (us.a_user_writer_id = u.user_id) "
				+ "                where a_bid_user = ? "
				+ "                order by a_market_cd DESC)) "
				+ "where book_nm like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);
			pstmt.setString(2, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				UsedShopAuctionSelect usauselect = new UsedShopAuctionSelect();
				
				usauselect.setaMarketCd(rset.getInt("a_market_cd"));
				usauselect.setBookCateCd(rset.getInt("book_cate_cd"));
				usauselect.setBookimg(rset.getString("book_img"));
				usauselect.setBookNm(rset.getString("book_nm"));
				usauselect.setBookPrice(rset.getInt("book_price"));
				usauselect.setAuthor(rset.getString("author"));
				usauselect.setPublisher(rset.getString("publisher"));
				usauselect.setPublishDate(rset.getDate("publish_date"));
				usauselect.setUserId(rset.getString("a_user_writer_id"));
				usauselect.setUserRank(rset.getString("user_rank"));
				usauselect.setaQuality(rset.getString("a_quality"));
				usauselect.setStartBid(rset.getInt("START_BID"));
				usauselect.setCurrentBid(rset.getInt("CURRENT_BID"));
				usauselect.setaRegDate(rset.getDate("A_REG_DATE"));
				usauselect.setaCloseDate(rset.getDate("A_CLOSE_DATE"));
				
				list.add(usauselect);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(rset);
				close(pstmt);
		}
		
		return list;
	}
	
}

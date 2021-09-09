package book.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import book.model.vo.OtherSite;

public class OtherSiteDao {

	public ArrayList<OtherSite> selectSiteList(Connection conn, int bookid) {
		ArrayList<OtherSite> list = new ArrayList<OtherSite>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = " select site_cd, site_book_id, site_nm, site_price from tb_other_site "
								+ "join tb_book on site_book_id = book_id where book_id = ? ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookid);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				OtherSite othersite = new OtherSite();
				
				othersite.setSiteCd(rset.getInt("site_cd"));
				othersite.setSiteBookId(rset.getInt("site_book_id"));
				othersite.setSiteNm(rset.getString("site_nm"));
				othersite.setSitePrice(rset.getInt("site_price"));
				
				list.add(othersite);
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

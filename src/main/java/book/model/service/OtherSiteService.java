package book.model.service;
import static common.JDBCTemp.*;
import java.sql.Connection;
import java.util.ArrayList;

import book.model.dao.BookDao;
import book.model.dao.OtherSiteDao;
import book.model.vo.Book;
import book.model.vo.OtherSite;

public class OtherSiteService {
	private OtherSiteDao osdao = new OtherSiteDao();

	public ArrayList<OtherSite> selectSiteList(int bookid) {
		Connection conn = getConnection();
		ArrayList<OtherSite> list = osdao.selectSiteList(conn, bookid);
		close(conn);
		return list;
	}
	
	

}

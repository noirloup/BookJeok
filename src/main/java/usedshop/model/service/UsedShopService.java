package usedshop.model.service;

import static common.JDBCTemp.*;

import java.sql.Connection;
import java.util.ArrayList;

import book.model.vo.Book;
import usedshop.model.dao.UsedShopDao;
import usedshop.model.vo.UsedShopNormal;
import usedshop.model.vo.UsedShopNormalSelect;
import usedshop.model.vo.UsedShopAuctionSelect;

public class UsedShopService {
	// +selectList():ArrayList
	// +selectUsedNormalNewList():ArrayList<UsedShop>
	// +selectUsedNormalLowPriceList():ArrayList<UsedShop>
	// +selectUsedAuctionList():ArrayList<UsedShop>
	// +selectUsedNormalList():ArrayList<UsedShop>
	// +updateAuctionBid(int marketcd):int
	// +insertUsedAuction(Connection conn, UsedShop usedshop):int
	// +insertUsedNormal(Connection conn, UsedShop usedshop):int
	// +selectUsedAuction(int marketcd):UsedShop
	// +selectUsedNormal(int marketcd):UsedShop
	// +updateUsedAuction(UsedShop usedshop):int
	// +updateUsedNormal(UsedShop usedshop):int
	// +deleteUsedAuction(int marketcd):int
	// +deleteUsedNormal(int marketcd):int
	// +getListCount():int
	// +selectUsedAuctionSearchList():ArrayList<UsedShop>
	// +selectUsedNormalSearchList():ArrayList<UsedShop>
	private UsedShopDao usdao = new UsedShopDao();
	
	public ArrayList<UsedShopNormal> selectList() {
		ArrayList<UsedShopNormal> list = null;
		return list;
	}
	
	public ArrayList<UsedShopNormal> selectUsedNormalNewList() {
		ArrayList<UsedShopNormal> list = null;
		return list;
	}
	
	public ArrayList<UsedShopNormal> selectUsedNormalLowPriceList() {
		ArrayList<UsedShopNormal> list = null;
		return list;
	}
	
	public ArrayList<UsedShopAuctionSelect> selectUsedAuctionList() {
		Connection conn = getConnection();
		ArrayList<UsedShopAuctionSelect> list = usdao.selectUsedAuctionList(conn);
		close(conn);
		return list;
	}
	
	public ArrayList<UsedShopNormalSelect> selectUsedNormalList() {
		Connection conn = getConnection();
		ArrayList<UsedShopNormalSelect> list = usdao.selectUsedNormalList(conn);
		close(conn);
		return list;
	}
	
	public int updateAuctionBid(UsedShopAuctionSelect usauselect) {
		Connection conn = getConnection();
		int result = usdao.updateAuctionBid(conn, usauselect);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int insertUsedAuction(UsedShopAuctionSelect usauselect) {
		Connection conn = getConnection();
		int result = usdao.insertUsedAuction(conn, usauselect);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int insertUsedNormal(UsedShopNormalSelect usnmselect) {
		Connection conn = getConnection();
		int result = usdao.insertUsedNormal(conn, usnmselect);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public UsedShopNormal selectUsedAuction(int marketcd) {
		UsedShopNormal usedshop = null;
		return usedshop;
	}
	
	public UsedShopNormal selectUsedNormal(int marketcd) {
		UsedShopNormal usedshop = null;
		return usedshop;
	}

	public int updateUsedAuction(UsedShopAuctionSelect usauselect) {
		Connection conn = getConnection();
		int result = usdao.updateUsedAuction(conn, usauselect);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int updateUsedNormal(UsedShopNormalSelect usnmselect) {
		Connection conn = getConnection();
		int result = usdao.updateUsedNormal(conn, usnmselect);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int deleteUsedAuction(int marketcd) {
		Connection conn = getConnection();
		int result = usdao.deleteUsedAuction(conn, marketcd);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int deleteUsedNormal(int marketcd) {
		Connection conn = getConnection();
		int result = usdao.deleteUsedNormal(conn, marketcd);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int getAuctionListCount() {
		Connection conn = getConnection();
		int listCount = usdao.getAuctionListCount(conn);
		close(conn);
		return listCount;
	}
	
	public int getNormalListCount() {
		Connection conn = getConnection();
		int listCount = usdao.getNormalListCount(conn);
		close(conn);
		return listCount;
	}
	
	public ArrayList<UsedShopNormal> selectUsedAuctionSearchList() {
		ArrayList<UsedShopNormal> list = null;
		return list;
	}
	
	public ArrayList<UsedShopNormal> selectUsedNormalSearchList() {
		ArrayList<UsedShopNormal> list = null;
		return list;
	}

	public ArrayList<UsedShopAuctionSelect> selectUsedAuctionNewTop4List() {
		Connection conn = getConnection();
		ArrayList<UsedShopAuctionSelect> list = usdao.selectUsedAuctionNewTop4List(conn);
		close(conn);
		return list;
	}

	public ArrayList<UsedShopAuctionSelect> selectUsedAuctionHotTop4List() {
		Connection conn = getConnection();
		ArrayList<UsedShopAuctionSelect> list = usdao.selectUsedAuctionHotTop4List(conn);
		close(conn);
		return list;
	}

	public ArrayList<UsedShopAuctionSelect> selectCategoryAuctionList(int category) {
		Connection conn = getConnection();
		ArrayList<UsedShopAuctionSelect> list = usdao.selectCategoryAuctionList(conn, category);
		close(conn);
		return list;
	}
	
	public ArrayList<UsedShopNormalSelect> selectCategoryNormalList(int category) {
		Connection conn = getConnection();
		ArrayList<UsedShopNormalSelect> list = usdao.selectCategoryNormalList(conn, category);
		close(conn);
		return list;
	}

	public Book selectBookNameSearch(String bookname) {
		Connection conn = getConnection();
		Book book = usdao.selectBookNameSearch(conn, bookname);
		close(conn);
		return book;
	}

	public UsedShopAuctionSelect selectAuctionMarketCd(int marketcd) {
		Connection conn = getConnection();
		UsedShopAuctionSelect usauselect = usdao.selectAuctionMarketCd(conn, marketcd);
		close(conn);
		return usauselect;
	}

	public ArrayList<UsedShopAuctionSelect> selectHopBidList() {
		Connection conn = getConnection();
		ArrayList<UsedShopAuctionSelect> list = usdao.selectHopBidList(conn);
		close(conn);
		return list;
	}

	public int getAuctionHotListCount() {
		Connection conn = getConnection();
		int listCount = usdao.getAuctionHotListCount(conn);
		close(conn);
		return listCount;
	}

	public int getAuctionLastListCount() {
		Connection conn = getConnection();
		int listCount = usdao.getAuctionLastListCount(conn);
		close(conn);
		return listCount;
	}

	public ArrayList<UsedShopAuctionSelect> selectLastDateList() {
		Connection conn = getConnection();
		ArrayList<UsedShopAuctionSelect> list = usdao.selectLastDateList(conn);
		close(conn);
		return list;
	}

	public ArrayList<UsedShopNormalSelect> selectUsedNormalNewTop4List() {
		Connection conn = getConnection();
		ArrayList<UsedShopNormalSelect> list = usdao.selectUsedNormalNewTop4List(conn);
		close(conn);
		return list;
	}

	public ArrayList<UsedShopNormalSelect> selectUsedNormalLowPriceTop4List() {
		Connection conn = getConnection();
		ArrayList<UsedShopNormalSelect> list = usdao.selectUsedNormalLowPriceTop4List(conn);
		close(conn);
		return list;
	}

	public int getNormalLowPriceListCount() {
		Connection conn = getConnection();
		int listCount = usdao.getNormalLowPriceListCount(conn);
		close(conn);
		return listCount;
	}

	public ArrayList<UsedShopNormalSelect> selectNormalLowPriceList() {
		Connection conn = getConnection();
		ArrayList<UsedShopNormalSelect> list = usdao.selectNormalLowPriceList(conn);
		close(conn);
		return list;
	}

	public int getAuctionMyListCount(String userid) {
		Connection conn = getConnection();
		int listCount = usdao.getAuctionMyListCount(conn, userid);
		close(conn);
		return listCount;
	}

	public ArrayList<UsedShopAuctionSelect> selectAuctionMyList(String userid) {
		Connection conn = getConnection();
		ArrayList<UsedShopAuctionSelect> list = usdao.selectAuctionMyList(conn, userid);
		close(conn);
		return list;
	}

	public int getNormalMyListCount(String userid) {
		Connection conn = getConnection();
		int listCount = usdao.getNormalMyListCount(conn, userid);
		close(conn);
		return listCount;
	}

	public ArrayList<UsedShopNormalSelect> selectNormalMyList(String userid, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<UsedShopNormalSelect> list = usdao.selectNormalMyList(conn, userid, startRow, endRow);
		close(conn);
		return list;
	}

	public int getAuctionMyBidListCount(String userid) {
		Connection conn = getConnection();
		int listCount = usdao.getAuctionMyBidListCount(conn, userid);
		close(conn);
		return listCount;
	}

	public ArrayList<UsedShopAuctionSelect> selectAuctionMyBidList(String userid, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<UsedShopAuctionSelect> list = usdao.selectAuctionMyBidList(conn, userid, startRow, endRow);
		close(conn);
		return list;
	}

	public UsedShopNormalSelect selectNormalMarketCd(int marketcd) {
		Connection conn = getConnection();
		UsedShopNormalSelect usnmselect = usdao.selectNormalMarketCd(conn, marketcd);
		close(conn);
		return usnmselect;
	}

	public ArrayList<UsedShopAuctionSelect> selectAuctionSearchBookName(String keyword, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<UsedShopAuctionSelect> list = usdao.selectSearchBookName(conn, keyword, startRow, endRow);
		close(conn);
		return list;
	}

	public ArrayList<UsedShopAuctionSelect> selectAuctionSearchWriterId(String keyword, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<UsedShopAuctionSelect> list = usdao.selectSearchWriterId(conn, keyword, startRow, endRow);
		close(conn);
		return list;
	}

	public ArrayList<UsedShopNormalSelect> selectNormalSearchBookName(String keyword, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<UsedShopNormalSelect> list = usdao.selectNormalSearchBookName(conn, keyword, startRow, endRow);
		close(conn);
		return list;
	}

	public ArrayList<UsedShopNormalSelect> selectNormalSearchWriterId(String keyword, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<UsedShopNormalSelect> list = usdao.selectNormalSearchWriterId(conn, keyword, startRow, endRow);
		close(conn);
		return list;
	}

	public ArrayList<UsedShopAuctionSelect> selectUsedAuctionLastTop4List() {
		Connection conn = getConnection();
		ArrayList<UsedShopAuctionSelect> list = usdao.selectUsedAuctionLastTop4List(conn);
		close(conn);
		return list;
	}

	public ArrayList<UsedShopAuctionSelect> selectAuctionList() {
		Connection conn = getConnection();
		ArrayList<UsedShopAuctionSelect> list = usdao.selectAuctionList(conn);
		close(conn);
		return list;
	}

	public ArrayList<UsedShopNormalSelect> selectNormalList() {
		Connection conn = getConnection();
		ArrayList<UsedShopNormalSelect> list = usdao.selectNormalList(conn);
		close(conn);
		return list;
	}

	public int deleteUsedAuction(String userid) {
		Connection conn = getConnection();
		int result = usdao.deleteUsedAuction(conn, userid);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int deleteUsedNormal(String userid) {
		Connection conn = getConnection();
		int result = usdao.deleteUsedNormal(conn, userid);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public ArrayList<UsedShopAuctionSelect> selectAuctionSearchBookName(String keyword) {
		Connection conn = getConnection();
		ArrayList<UsedShopAuctionSelect> list = usdao.selectAuctionSearchBookName(conn, keyword);
		close(conn);
		return list;
	}

	public ArrayList<UsedShopAuctionSelect> selectAuctionSearchWriterId(String keyword) {
		Connection conn = getConnection();
		ArrayList<UsedShopAuctionSelect> list = usdao.selectAuctionSearchWriterId(conn, keyword);
		close(conn);
		return list;
	}

	public ArrayList<UsedShopAuctionSelect> selectAuctionCategorySearchBookName(String keyword, int category) {
		Connection conn = getConnection();
		ArrayList<UsedShopAuctionSelect> list = usdao.selectAuctionCategorySearchBookName(conn, keyword, category);
		close(conn);
		return list;
	}

	public ArrayList<UsedShopAuctionSelect> selectAuctionCategorySearchWriterId(String keyword, int category) {
		Connection conn = getConnection();
		ArrayList<UsedShopAuctionSelect> list = usdao.selectAuctionCategorySearchWriterId(conn, keyword, category);
		close(conn);
		return list;
	}

	public ArrayList<UsedShopNormalSelect> selectNormalSearchBookName(String keyword) {
		Connection conn = getConnection();
		ArrayList<UsedShopNormalSelect> list = usdao.selectNormalSearchBookName(conn, keyword);
		close(conn);
		return list;
	}

	public ArrayList<UsedShopNormalSelect> selectNormalSearchWriterId(String keyword) {
		Connection conn = getConnection();
		ArrayList<UsedShopNormalSelect> list = usdao.selectNormalSearchWriterId(conn, keyword);
		close(conn);
		return list;
	}

	public ArrayList<UsedShopNormalSelect> selectNormalCategorySearchBookName(String keyword, int category) {
		Connection conn = getConnection();
		ArrayList<UsedShopNormalSelect> list = usdao.selectNormalCategorySearchBookName(conn, keyword, category);
		close(conn);
		return list;
	}

	public ArrayList<UsedShopNormalSelect> selectNormalCategorySearchWriterId(String keyword, int category) {
		Connection conn = getConnection();
		ArrayList<UsedShopNormalSelect> list = usdao.selectNormalCategorySearchWriterId(conn, keyword, category);
		close(conn);
		return list;
	}

	public ArrayList<UsedShopAuctionSelect> selectMyAuctionSearchBookName(String userid, String keyword) {
		Connection conn = getConnection();
		ArrayList<UsedShopAuctionSelect> list = usdao.selectMyAuctionSearchBookName(conn, userid, keyword);
		close(conn);
		return list;
	}

	public ArrayList<UsedShopNormalSelect> selectMyNormalSearchBookName(String userid, String keyword) {
		Connection conn = getConnection();
		ArrayList<UsedShopNormalSelect> list = usdao.selectMyNormalSearchBookName(conn, userid, keyword);
		close(conn);
		return list;
	}

	public ArrayList<UsedShopAuctionSelect> selectMyBidSearchBookName(String userid, String keyword) {
		Connection conn = getConnection();
		ArrayList<UsedShopAuctionSelect> list = usdao.selectMyBidSearchBookName(conn, userid, keyword);
		close(conn);
		return list;
	}
	
}

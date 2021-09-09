package notice.model.service;

import static common.JDBCTemp.close;
import static common.JDBCTemp.commit;
import static common.JDBCTemp.getConnection;
import static common.JDBCTemp.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;

public class NoticeService {
		// +InsertNotice(Notice noitce):int													공지 등록(AskedWrite)
		// +listNoitceCount():int 														공지 목록(NoticeList)
		// +deleteNotice(int noticeno):int 													공지 삭제(NoticeDelete)
		// +updateNotice(Notice notice):int												공지 수정(NoticeUpdate)
		// +ArrayList<Notice> selectNoticeSearch(String keywords):ArrayList<Notice>  			공지 검색(NoticeSearch)
		// +ArrayList<Notice> selectNoticeUpdateView(int notice):ArrayList<Notice>  				공지 고정(NoticeImportant)
		// +ArrayList<Notice> selectNoticeUpdateView(Connection conn, int noticenum)			공지 수정페이지(NoticeUpdateView)
	private NoticeDao ndao = new NoticeDao();
	
	// 글 작성 서비스
	public int InsertNotice(Notice noitce) {
		Connection conn = getConnection();
		int result = ndao.InsertNotice(conn, noitce);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	// 공지사항 글 목록 카운트 서비
	public int listNoticeCount(){
		Connection conn = getConnection();
		int listCount = ndao.listNoticeCount(conn);
		close(conn);
		return listCount;
	}
	// 공지사항 글 삭제 서비스
	public int deleteNotice(int noticeno) {
		Connection conn = getConnection();
		int result = ndao.deleteNotice(conn, noticeno);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
		
	}
	// 공지사항 글 수정 서비스
	public int updateNotice(Notice notice) {
		Connection conn = getConnection();
		int result = ndao.updateNotice(conn, notice);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	// 공지사항 상세보기 서비스
	public Notice selectNotice(int noticeNum) {
		Connection conn = getConnection(); 
		Notice notice = ndao.selectNotice(conn, noticeNum);
		 close(conn);
		 return notice;
	}

	// 공지사항 글 목록 서비스
	public ArrayList<Notice> selectNoticeList(){
		Connection conn = getConnection();
		ArrayList<Notice> list = ndao.selectNoticeList(conn);
		close(conn);
		return list;
	}
	// 공지사항 글 상세보기 카운트 서비스
	public int addViewCount(int noticeNum) {
		Connection conn = getConnection();
		int result = ndao.updateViewCount(conn, noticeNum);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}		
		close(conn);
		return result;
	}
	// 공지사항 제목 검색 서비스
	public ArrayList<Notice> selectNoticeListTitle(String keyword){
		Connection conn = getConnection();
		ArrayList<Notice> list = ndao.selectNoticeListTitle(conn, keyword);
		close(conn);
		return list;
	}
}
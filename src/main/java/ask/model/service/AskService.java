package ask.model.service;

import static common.JDBCTemp.*;

import java.sql.Connection;
import java.util.ArrayList;

import ask.model.dao.AskDao;
import ask.model.vo.Ask;

public class AskService {
	private AskDao adao = new AskDao();
	// +insertAsk(Ask ask):int // 문의 등록(AskWrite)
	// +listAskCount():int // 문의 목록(AskList)
	// +selectAskSearch(String keywords):ArrayList<Ask> // 문의 검색(AskSearch)
	// +selectAsk(int asknum):Ask // 문의 상세(AskDetail)
	// +updateAsk(Ask ask):int // 문의 수정(AskUpdate)
	// +updateAskReplyWrite(int asknum):int // 문의 대댓글(AskReplyInsert)
	// +deleteAsk(int asknum):int // 문의 삭제(AskDelete)

	// 문의글 작성 서비스
	public int insertAsk(Ask ask) {
		Connection conn = getConnection();
		int result = adao.insertAsk(conn, ask);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		return result;
	}

	// 문의 목록 카운트 서비스
	public int listAskCount() {
		Connection conn = getConnection();
		int listCount = adao.listAskCount(conn);
		close(conn);
		return listCount;
	}

	// 문의 상세 서비스
	public Ask selectAsk(int askNum) {
		Connection conn = getConnection();
		Ask ask = adao.selectAsk(conn, askNum);
		close(conn);
		return ask;
	}

	// 문의글 수정 서비스
	public int updateAsk(Ask ask) {
		Connection conn = getConnection();
		int result = adao.updateAsk(conn, ask);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	// 문의글 삭제 서비스
	public int deleteAsk(int askNum) {
		Connection conn = getConnection();
		int result = adao.deleteAsk(conn, askNum);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	// 문의 리스트 목록 서비스
	public ArrayList<Ask> selectAsklist() {
		Connection conn = getConnection();
		ArrayList<Ask> list = adao.selectAskList(conn);
		close(conn);
		return list;
	}

	// 문의 제목 검색 서비스
	public ArrayList<Ask> selectAskListTitle(String keyword) {
		Connection conn = getConnection();
		ArrayList<Ask> list = adao.selectAskListTitle(conn, keyword);
		close(conn);
		return list;
	}

	// 문의 답변 삭제 서비스
	public int deleteAsk(String userid) {
		Connection conn = getConnection();
		int result = adao.deleteAsk(conn, userid);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	// 문의 작성 답변 서비스
	public int updateAnswerContent(Ask areply) {
		Connection conn = getConnection();
		int result = adao.updateAnswerContent(conn, areply);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
}
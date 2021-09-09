package ask.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ask.model.vo.Ask;

public class AskDao {

	// 문의글 작성
	public int insertAsk(Connection conn, Ask ask) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "INSERT INTO TB_ASK VALUES((SELECT MAX(ASK_NUM) + 1 FROM TB_ASK), ?, ?, ?, ?, default, ?, ?, null, null, sysdate, null)";

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, ask.getAskWriterId());
			pstmt.setString(2, ask.getAskGroup());
			pstmt.setString(3, ask.getAskTitle());
			pstmt.setString(4, ask.getAskContent());
			pstmt.setString(5, ask.getAskOriginalFile());
			pstmt.setString(6, ask.getAskRenameFile());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 문의 목록 카운트
	public int listAskCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;

		String query = " SELECT COUNT(*) FROM TB_ASK ";

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if (rset.next()) {
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

	// 문의 글 상세
	public Ask selectAsk(Connection conn, int askNum) {
		Ask ask = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT * FROM TB_ASK WHERE ASK_NUM = ? ";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, askNum);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				ask = new Ask();

				ask.setAskNum(rset.getInt("ASK_NUM"));
				ask.setAskWriterId(rset.getString("ASK_WRITE_ID"));
				ask.setAskGroup(rset.getString("ASK_GROUP"));
				ask.setAskTitle(rset.getString("ASK_TITLE"));
				ask.setAskContent(rset.getString("ASK_CONTENT"));
				ask.setAskState(rset.getString("ASK_STATE"));
				ask.setAskOriginalFile(rset.getString("ASK_ORIGINAL_FILE"));
				ask.setAskRenameFile(rset.getString("ASK_RENAME_FILE"));
				ask.setAnswerContent(rset.getString("ANSWER_CONTENT"));
				ask.setWriteDate(rset.getDate("WRITE_DATE"));
				ask.setAnswerDate(rset.getDate("ANSWER_DATE"));
				ask.setAnswerID(rset.getString("ANSWER_ID"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return ask;
	}

	// 문의 원본글 수정
	public int updateAsk(Connection conn, Ask ask) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "UPDATE TB_ASK SET " + "ASK_WRITE_ID  = ?, ASK_TITLE = ?, ASK_CONTENT = ?, "
				+ "ASK_ORIGINAL_FILE = ?, ASK_RENAME_FILE = ?  " + "WHERE ASK_NUM = ? ";
		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, ask.getAskWriterId());
			pstmt.setString(2, ask.getAskTitle());
			pstmt.setString(3, ask.getAskContent());
			pstmt.setString(4, ask.getAskOriginalFile());
			pstmt.setString(5, ask.getAskRenameFile());
			pstmt.setInt(6, ask.getAskNum());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 문의글 삭제
	public int deleteAsk(Connection conn, int askNum) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "DELETE FROM TB_ASK WHERE ASK_NUM = ? ";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, askNum);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 문의 리스트
	public ArrayList<Ask> selectAskList(Connection conn) {
		ArrayList<Ask> list = new ArrayList<Ask>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT * " + "FROM (SELECT ROWNUM RNUM, ASK_NUM, ASK_WRITE_ID, ASK_GROUP, "
				+ "ASK_TITLE, ASK_CONTENT, ASK_STATE, ASK_ORIGINAL_FILE, "
				+ "ASK_RENAME_FILE, ANSWER_ID, ANSWER_CONTENT, WRITE_DATE, ANSWER_DATE " + "FROM TB_ASK "
				+ "ORDER BY ASK_NUM DESC ) ";
		try {
			pstmt = conn.prepareStatement(query);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Ask ask = new Ask();

				ask.setAskNum(rset.getInt("ASK_NUM"));
				ask.setAskWriterId(rset.getString("ASK_WRITE_ID"));
				ask.setAskGroup(rset.getString("ASK_GROUP"));
				ask.setAskTitle(rset.getString("ASK_TITLE"));
				ask.setAskContent(rset.getString("ASK_CONTENT"));
				ask.setAskState(rset.getString("ASK_STATE"));
				ask.setAskOriginalFile(rset.getString("ASK_ORIGINAL_FILE"));
				ask.setAskRenameFile(rset.getString("ASK_RENAME_FILE"));
				ask.setAnswerID(rset.getString("ANSWER_ID"));
				ask.setAnswerContent(rset.getString("ANSWER_CONTENT"));
				ask.setWriteDate(rset.getDate("WRITE_DATE"));
				ask.setAnswerDate(rset.getDate("ANSWER_DATE"));

				list.add(ask);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	// 문의 제목 검색
	public ArrayList<Ask> selectAskListTitle(Connection conn, String keyword) {
		ArrayList<Ask> list = new ArrayList<Ask>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT * FROM TB_ASK WHERE ASK_TITLE LIKE ? ";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Ask ask = new Ask();
				// 컬럼값 꺼내서 필드에 옮겨 기록
				ask.setAskNum(rset.getInt("ask_num"));
				ask.setAskWriterId(rset.getString("ask_write_id"));
				ask.setAskGroup(rset.getString("ask_group"));
				ask.setAskTitle(rset.getString("ask_title"));
				ask.setAskContent(rset.getString("ask_content"));
				ask.setAskState(rset.getString("ask_state"));
				ask.setAskOriginalFile(rset.getString("ask_original_file"));
				ask.setAskRenameFile(rset.getString("ask_rename_file"));
				ask.setAnswerContent(rset.getString("answer_content"));
				ask.setWriteDate(rset.getDate("write_date"));
				ask.setAnswerDate(rset.getDate("answer_date"));

				list.add(ask);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int deleteAsk(Connection conn, String userid) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "DELETE FROM TB_ASK WHERE ASK_WRITE_ID = ? ";

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

	public int updateAnswerContent(Connection conn, Ask areply) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "UPDATE TB_ASK "
				+ "SET ANSWER_CONTENT = ?, ANSWER_ID = ?, ASK_STATE = 'Y', ANSWER_DATE = SYSDATE "
				+ "WHERE ASK_NUM = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, areply.getAnswerContent());
			pstmt.setString(2, areply.getAnswerID());
			pstmt.setInt(3, areply.getAskNum());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
}
package notice.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import notice.model.vo.Notice;

public class NoticeDao {

	// 공지글 작성
	public int InsertNotice(Connection conn, Notice notice) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "INSERT INTO TB_NOTICE VALUES((SELECT MAX(NOTICE_NUM) + 1 FROM TB_NOTICE), ?, ?, ?, ?, ?, ?, SYSDATE, NULL, DEFAULT) ";

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, notice.getNoticeWriterId());
			pstmt.setString(2, notice.getNoticeTitle());
			pstmt.setString(3, notice.getNoticeOriginalFile());
			pstmt.setString(4, notice.getNoticeRenameFile());
			pstmt.setString(5, notice.getNoticeContent());
			pstmt.setString(6, notice.getNoticeGroup());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 공지사항 목록 카운트
	public int listNoticeCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;

		String query = "SELECT COUNT(*) FROM TB_NOTICE";

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

	// 공지사항 삭제
	public int deleteNotice(Connection conn, int noticeNum) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "DELETE FROM TB_NOTICE WHERE NOTICE_NUM = ? ";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNum);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	// 공지사항 글 수정
	public int updateNotice(Connection conn, Notice notice) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = " UPDATE TB_NOTICE SET " + "NOTICE_WRITER_ID  = ?, NOTICE_TITLE = ?, "
				+ "NOTICE_ORIGINAL_FILE = ?, NOTICE_RENAME_FILE = ?, NOTICE_CONTENT = ? " + "WHERE NOTICE_NUM = ? ";
		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, notice.getNoticeWriterId());
			pstmt.setString(2, notice.getNoticeTitle());
			pstmt.setString(3, notice.getNoticeOriginalFile());
			pstmt.setString(4, notice.getNoticeRenameFile());
			pstmt.setString(5, notice.getNoticeContent());
			pstmt.setInt(6, notice.getNoticeNum());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 공지사항 상세보기용
	public Notice selectNotice(Connection conn, int noticeNum) {
		Notice notice = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT * FROM TB_NOTICE WHERE NOTICE_NUM = ? ";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNum);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				notice = new Notice();

				notice.setNoticeNum(rset.getInt("notice_num"));
				notice.setNoticeWriterId(rset.getString("notice_writer_id"));
				notice.setNoticeTitle(rset.getString("notice_title"));
				notice.setNoticeOriginalFile(rset.getString("notice_original_file"));
				notice.setNoticeRenameFile(rset.getString("notice_rename_file"));
				notice.setNoticeContent(rset.getString("notice_content"));
				notice.setNoticeGroup(rset.getString("notice_group"));
				notice.setNoticeRegDate(rset.getDate("notice_reg_date"));
				notice.setNoticeModifyDate(rset.getDate("notice_modify_date"));
				notice.setViewCount(rset.getInt("view_count"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return notice;
	}

	// 공지사항 리스트
	public ArrayList<Notice> selectNoticeList(Connection conn) {
		ArrayList<Notice> list = new ArrayList<Notice>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT * " + "FROM (SELECT ROWNUM RNUM, NOTICE_NUM, NOTICE_WRITER_ID, NOTICE_TITLE, "
				+ "NOTICE_ORIGINAL_FILE, NOTICE_RENAME_FILE, NOTICE_CONTENT, NOTICE_GROUP, "
				+ "NOTICE_REG_DATE, NOTICE_MODIFY_DATE, VIEW_COUNT " + "FROM TB_NOTICE  "
				+ "ORDER BY NOTICE_NUM desc ) ";

		try {
			pstmt = conn.prepareStatement(query);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Notice notice = new Notice();

				notice.setNoticeNum(rset.getInt("notice_num"));
				notice.setNoticeWriterId(rset.getString("notice_writer_id"));
				notice.setNoticeTitle(rset.getString("notice_title"));
				notice.setNoticeOriginalFile(rset.getString("notice_original_file"));
				notice.setNoticeRenameFile(rset.getString("notice_rename_file"));
				notice.setNoticeContent(rset.getString("notice_content"));
				notice.setNoticeGroup(rset.getString("notice_group"));
				notice.setNoticeRegDate(rset.getDate("notice_reg_date"));
				notice.setNoticeModifyDate(rset.getDate("notice_modify_date"));
				notice.setViewCount(rset.getInt("view_count"));

				list.add(notice);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	// 공지사항 상세페이지 카운트
	public int updateViewCount(Connection conn, int noticeNum) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "UPDATE TB_NOTICE SET VIEW_COUNT = VIEW_COUNT + 1 WHERE NOTICE_NUM = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNum);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 공지사항 제목 검색
	public ArrayList<Notice> selectNoticeListTitle(Connection conn, String keyword) {
		ArrayList<Notice> list = new ArrayList<Notice>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT * FROM TB_NOTICE WHERE NOTICE_TITLE LIKE ? ";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Notice notice = new Notice();
				// 컬럼값 꺼내서, 필드에 옮겨 기록
				notice.setNoticeNum(rset.getInt("notice_num"));
				notice.setNoticeTitle(rset.getString("notice_title"));
				notice.setNoticeContent(rset.getString("notice_content"));
				notice.setNoticeWriterId(rset.getString("notice_writer_id"));
				notice.setNoticeOriginalFile(rset.getString("notice_original_file"));
				notice.setNoticeRenameFile(rset.getString("notice_rename_file"));
				notice.setNoticeGroup(rset.getString("notice_group"));
				notice.setNoticeRegDate(rset.getDate("notice_reg_date"));
				notice.setNoticeModifyDate(rset.getDate("notice_modify_date"));
				notice.setViewCount(rset.getInt("view_count"));

				list.add(notice);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
}
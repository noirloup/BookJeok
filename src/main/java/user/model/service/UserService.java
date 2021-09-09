package user.model.service;

import static common.JDBCTemp.close;
import static common.JDBCTemp.commit;
import static common.JDBCTemp.getConnection;
import static common.JDBCTemp.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import user.model.dao.UserDao;
import user.model.vo.User;

public class UserService {
	private UserDao udao = new UserDao();
	
	public int insertUser(User user) {
		Connection conn = getConnection();
		int result = udao.insertUser(conn, user);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int selectCheckID(String userid) {
		Connection conn = getConnection();
		int count = udao.selectCheckID(conn, userid);
		close(conn);
		return count;
	}
	
	public int selectCheckNickName(String nickname) {
		Connection conn = getConnection();
		int count = udao.selectCheckNickName(conn, nickname);
		close(conn);
		return count;
	}
	
	public User selectLogin(String userid, String userpwd) {
		Connection conn = getConnection();
		User user = udao.selectLogin(conn, userid, userpwd);
		close(conn);
		return user;
	}
	
	public int updateUserInfo(User user) {
		Connection conn = getConnection();
		int result = udao.updateUserInfo(conn, user);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public User selectUser(String userid) {
		Connection conn = getConnection();
		User user = udao.selectUser(conn, userid);
		close(conn);
		return user;
	}
	
	public ArrayList<User> selectUserList() {
		Connection conn = getConnection();
		ArrayList<User> list = udao.selectUserList(conn);
		close(conn);
		return list;
	}
	
	public int deleteUser(String userid, String userpwd) {
		Connection conn = getConnection();
		int result = udao.deleteUser(conn, userid, userpwd);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int updateUserProfile(User user) {
		Connection conn = getConnection();
		int result = udao.updateUserProfile(conn, user);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int getListCount() {
		Connection conn = getConnection();
		int listCount = udao.getListCount(conn);
		close(conn);
		return listCount;
	}

	public ArrayList<User> selectSearchUserId(String keyword, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<User> list = udao.selectSearchUserId(conn, keyword, startRow, endRow);
		close(conn);
		return list;
	}

	public ArrayList<User> selectSearchUserNick(String keyword, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<User> list = udao.selectSearchUserNick(conn, keyword, startRow, endRow);
		close(conn);
		return list;
	}

	public ArrayList<User> selectSearchGender(String keyword, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<User> list = udao.selectSearchGender(conn, keyword, startRow, endRow);
		close(conn);
		return list;
	}

	public ArrayList<User> selectSearchAge(int keyword, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<User> list = udao.selectSearchAge(conn, keyword, startRow, endRow);
		close(conn);
		return list;
	}

	public int deleteUser(String userid) {
		Connection conn = getConnection();
		int result = udao.deleteUser(conn, userid);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public User selectUserFindId(String username, String phone) {
		Connection conn = getConnection();
		User user = udao.selectUserFindId(conn, username, phone);
		close(conn);
		return user;
	}

	public int updateUserChangePassword(User user) {
		Connection conn = getConnection();
		int result = udao.updateUserChangePassword(conn, user);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public User selectUserFindPwd(String userid, String username, String phone) {
		Connection conn = getConnection();
		User user = udao.selectUserFindPwd(conn, userid, username, phone);
		close(conn);
		return user;
	}
}

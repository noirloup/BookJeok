package user.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import user.model.vo.User;

public class UserDao {
	public int insertUser(Connection conn, User user) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into tb_user "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default, ?, ?, default, default)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getNickName());
			pstmt.setString(3, user.getUserPwd());
			pstmt.setString(4, user.getUserNm());
			pstmt.setString(5, user.getGender());
			pstmt.setInt(6, user.getAge());
			pstmt.setString(7, user.getPhone());
			pstmt.setString(8, user.getEmail());
			pstmt.setInt(9, user.getPost());
			pstmt.setString(10, user.getAddr());
			pstmt.setString(11, user.getAddrDetail());
			pstmt.setString(12, user.getUserIntro());
			pstmt.setString(13, user.getPreferred());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}		
		
		return result;
	}
	
	public int selectCheckID(Connection conn, String userid) {
		int idCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(user_id) from tb_user "
				+ "where user_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				idCount = rset.getInt(1);
				System.out.println("idCount : " + idCount);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return idCount;
	}
	
	public int selectCheckNickName(Connection conn, String nickname) {
		int idCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(nickname) from tb_user "
				+ "where nickname = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, nickname);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				idCount = rset.getInt(1);
				System.out.println("idCount : " + idCount);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return idCount;
	}
	
	public User selectLogin(Connection conn, String userid, String userpwd) {
		User user = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_user where user_id = ? and user_pwd = ?";				
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);
			pstmt.setString(2, userpwd);		
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				user = new User();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				user.setUserId(userid);
				user.setNickName(rset.getString("nickname"));
				user.setUserPwd(userpwd);
				user.setUserNm(rset.getString("user_nm"));
				user.setGender(rset.getString("gender"));
				user.setAge(rset.getInt("age"));
				user.setPhone(rset.getString("phone"));
				user.setEmail(rset.getString("email"));
				user.setAddr(rset.getString("addr"));
				user.setAddrDetail(rset.getString("addr_detail"));
				user.setPoint(rset.getInt("point"));
				user.setUserIntro(rset.getString("user_intro"));
				user.setPreferred(rset.getString("preferred"));
				user.setUserRank(rset.getString("user_rank"));
				user.setAdmin(rset.getString("admin"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return user;
	}
	
	public int updateUserInfo(Connection conn, User user) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update tb_user set user_pwd = ?, user_nm = ?, gender = ?, age = ?, phone = ?, email = ?,  "
				+ "            ADDR_POST = ?, addr = ?, addr_detail = ? "
				+ "where user_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user.getUserPwd());
			pstmt.setString(2, user.getUserNm());
			pstmt.setString(3, user.getGender());
			pstmt.setInt(4, user.getAge());
			pstmt.setString(5, user.getPhone());
			pstmt.setString(6, user.getEmail());
			pstmt.setInt(7, user.getPost());
			pstmt.setString(8, user.getAddr());
			pstmt.setString(9, user.getAddrDetail());
			pstmt.setString(10, user.getUserId());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public User selectUser(Connection conn, String userid) {
		User user = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_user where user_id = ?";				
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);			
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				user = new User();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				user.setUserId(userid);
				user.setNickName(rset.getString("nickname"));
				user.setUserPwd(rset.getString("user_pwd"));
				user.setUserNm(rset.getString("user_nm"));
				user.setGender(rset.getString("gender"));
				user.setAge(rset.getInt("age"));
				user.setPhone(rset.getString("phone"));
				user.setEmail(rset.getString("email"));
				user.setPost(rset.getInt("addr_post"));
				user.setAddr(rset.getString("addr"));
				user.setAddrDetail(rset.getString("addr_detail"));
				user.setPoint(rset.getInt("point"));
				user.setUserIntro(rset.getString("user_intro"));
				user.setPreferred(rset.getString("preferred"));
				user.setUserRank(rset.getString("user_rank"));
				user.setAdmin(rset.getString("admin"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return user;
	}
	
	public ArrayList<User> selectUserList(Connection conn) {
		ArrayList<User> list = new ArrayList<User>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * "
				+ "FROM (SELECT ROWNUM RNUM, USER_ID, NICKNAME, USER_NM, GENDER, AGE, PHONE, EMAIL "
				+ "        FROM TB_USER "
				+ "        WHERE ADMIN = 'N' "
				+ "        ORDER BY USER_ID DESC)";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				User user = new User();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				user.setUserId(rset.getString("user_id"));
				user.setNickName(rset.getString("nickname"));
				user.setUserNm(rset.getString("user_nm"));
				user.setGender(rset.getString("gender"));
				user.setAge(rset.getInt("age"));
				user.setPhone(rset.getString("phone"));
				user.setEmail(rset.getString("email"));
				
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public int deleteUser(Connection conn, String userid, String userpwd) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from tb_user where user_id = ? and user_pwd = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);	
			pstmt.setString(2, userpwd);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateUserProfile(Connection conn, User user) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update tb_user set nickname = ?, user_intro = ?, preferred = ? "
				+ "where user_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user.getNickName());
			pstmt.setString(2, user.getUserIntro());
			pstmt.setString(3, user.getPreferred());
			pstmt.setString(4, user.getUserId());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from tb_user";
		
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

	public ArrayList<User> selectSearchUserId(Connection conn, String keyword, int startRow, int endRow) {
		ArrayList<User> list = new ArrayList<User>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * "
				+ "FROM (SELECT ROWNUM RNUM, USER_ID, NICKNAME, USER_NM, GENDER, AGE, PHONE, EMAIL "
				+ "        FROM TB_USER "
				+ "        WHERE ADMIN = 'N' "
				+ "        ORDER BY USER_ID DESC) "
				+ "WHERE USER_ID LIKE ? AND RNUM >= ? AND RNUM <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				User user = new User();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				user.setUserId(rset.getString("user_id"));
				user.setNickName(rset.getString("nickname"));
				user.setUserNm(rset.getString("user_nm"));
				user.setGender(rset.getString("gender"));
				user.setAge(rset.getInt("age"));
				user.setPhone(rset.getString("phone"));
				user.setEmail(rset.getString("email"));
				
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<User> selectSearchUserNick(Connection conn, String keyword, int startRow, int endRow) {
		ArrayList<User> list = new ArrayList<User>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * "
				+ "FROM (SELECT ROWNUM RNUM, USER_ID, NICKNAME, USER_NM, GENDER, AGE, PHONE, EMAIL "
				+ "        FROM TB_USER "
				+ "        WHERE ADMIN = 'N' "
				+ "        ORDER BY USER_ID DESC) "
				+ "WHERE NICKNAME LIKE ? AND RNUM >= ? AND RNUM <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				User user = new User();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				user.setUserId(rset.getString("user_id"));
				user.setNickName(rset.getString("nickname"));
				user.setUserNm(rset.getString("user_nm"));
				user.setGender(rset.getString("gender"));
				user.setAge(rset.getInt("age"));
				user.setPhone(rset.getString("phone"));
				user.setEmail(rset.getString("email"));
				
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<User> selectSearchGender(Connection conn, String keyword, int startRow, int endRow) {
		ArrayList<User> list = new ArrayList<User>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * "
				+ "FROM (SELECT ROWNUM RNUM, USER_ID, NICKNAME, USER_NM, GENDER, AGE, PHONE, EMAIL "
				+ "        FROM TB_USER "
				+ "        WHERE ADMIN = 'N' "
				+ "        ORDER BY USER_ID DESC) "
				+ "WHERE GENDER =  ? AND RNUM >= ? AND RNUM <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, keyword);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				User user = new User();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				user.setUserId(rset.getString("user_id"));
				user.setNickName(rset.getString("nickname"));
				user.setUserNm(rset.getString("user_nm"));
				user.setGender(rset.getString("gender"));
				user.setAge(rset.getInt("age"));
				user.setPhone(rset.getString("phone"));
				user.setEmail(rset.getString("email"));
				
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<User> selectSearchAge(Connection conn, int keyword, int startRow, int endRow) {
		ArrayList<User> list = new ArrayList<User>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * "
				+ "FROM (SELECT ROWNUM RNUM, USER_ID, NICKNAME, USER_NM, GENDER, AGE, PHONE, EMAIL "
				+ "        FROM TB_USER "
				+ "        WHERE ADMIN = 'N' "
				+ "        ORDER BY USER_ID DESC) ";
		
		if(keyword == 60) {
			query += "WHERE AGE >= ? AND RNUM >= ? AND RNUM <= ?";
		} else {
			query += "WHERE AGE BETWEEN ? AND ? AND RNUM >= ? AND RNUM <= ?";
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			if(keyword == 60) {
				pstmt.setInt(1, keyword);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
			} else {
				pstmt.setInt(1, keyword);
				pstmt.setInt(2, keyword + 9);
				pstmt.setInt(3, startRow);
				pstmt.setInt(4, endRow);
			}
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				User user = new User();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				user.setUserId(rset.getString("user_id"));
				user.setNickName(rset.getString("nickname"));
				user.setUserNm(rset.getString("user_nm"));
				user.setGender(rset.getString("gender"));
				user.setAge(rset.getInt("age"));
				user.setPhone(rset.getString("phone"));
				user.setEmail(rset.getString("email"));
				
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int deleteUser(Connection conn, String userid) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from tb_user where user_id = ?";
		
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

	public User selectUserFindId(Connection conn, String username, String phone) {
		User user = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_user where user_nm = ? and phone = ?";				
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, phone);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				user = new User();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				user.setUserId(rset.getString("user_id"));
				user.setUserNm(rset.getString("user_nm"));
				user.setPhone(rset.getString("phone"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return user;
	}

	public int updateUserChangePassword(Connection conn, User user) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update tb_user set user_pwd = ? "
				+ "where user_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user.getUserPwd());
			pstmt.setString(2, user.getUserId());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public User selectUserFindPwd(Connection conn, String userid, String username, String phone) {
		User user = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_user where user_id = ? and user_nm = ? and phone = ?";				
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);
			pstmt.setString(2, username);
			pstmt.setString(3, phone);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				user = new User();
				
				//컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				user.setUserId(rset.getString("user_id"));
				user.setUserNm(rset.getString("user_nm"));
				user.setPhone(rset.getString("phone"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return user;
	}
}

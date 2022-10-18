package project;

import java.sql.Connection;
import java.sql.SQLException;

public class UsersDAO extends DAO{
	Connection conn = null;
	
	//회원가입
	public void insert(Users user) {
		conn = getConnect();
//		String sql = "insert into users value(users_id, users_passwd, user_name"
		try {
			psmt = conn.prepareStatement("insert into users values (?, ?, ?)");
			psmt.setString(1, user.getId());
			psmt.setString(2, user.getPw());
			psmt.setString(3, user.getName());
			
			psmt.executeQuery();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}	}

	// 로그인
		public Users login(String id, String pwd) {
			conn = getConnect();
			Users extra = null;
			try {
				psmt = conn.prepareStatement("select * " + "from users "+ "where id = ? and passwd = ?");
				psmt.setString(1, id);
				psmt.setString(2, pwd);
				rs = psmt.executeQuery();
				
				if (rs.next()) {
					extra = new Users(rs.getString("id")
							,rs.getString("passwd")
							,rs.getString("user_name"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
			return extra;
		}
		
		//탈퇴
		public void delUser(Users bye) {
			String sql = "delete from users where id = ? and passwd = ? ";
			conn = getConnect();
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, bye.getId());
				psmt.setString(2, bye.getPw());

				psmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
		}

		
}

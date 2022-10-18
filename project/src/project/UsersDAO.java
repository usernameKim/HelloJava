package project;

import java.sql.Connection;
import java.sql.SQLException;

public class UsersDAO extends DAO{
	Connection conn = null;
	
	public void insert(Users user) {
		conn = getConnect();
		try {
			psmt = conn.prepareStatement("insert into users value(?, ?, ?)");
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
				psmt.setString(1, pwd);
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
}

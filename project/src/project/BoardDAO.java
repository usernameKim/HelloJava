package project;

import java.sql.SQLException;

public class BoardDAO extends DAO {
	// 로그인
	public boolean login(String id, String pwd) {
		String sql = "select * from users where id = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				if (rs.getString("password").equals(pwd)) {
					return true;
				}
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}
	
	//글등록
	public void input(Board brd) {
		String sql = "insert into board(board_num, board_title"
				+ ", board_content, board_writer)"
				+ "values(?, ?, ?, ?)";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, brd.getNumber());
			psmt.setString(2, brd.getTitle());
			psmt.setString(3, brd.getContent());
			psmt.setString(4, brd.getWriter());
			
			psmt.executeUpdate();
			System.out.println("등록되었습니다!");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
	}
	
	//글수정
	public void updateBrd(Board brd) {
		String sql ="update board" + "set board_num =?, board_content
					
	}
	
}

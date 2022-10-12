package co.edu.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Create Read Update Delete 등록 조회 수정 삭제
public class BoardDAO extends DAO{
 
	
	// 등록
	public void insert(Board brd) {
		String sql = "insert into board (board_num, board_title, board_content, board_writer)\r\n"
				+ "values("+ brd.getNumber()
				+", '"+brd.getTitle()
				+"', '"+brd.getContent()
				+"', '"+brd.getWriter()+"')";
			System.out.println(sql);
			conn = getConnect();
			try {
				stmt = conn.createStatement();
				int r = stmt.executeUpdate(sql);
				System.out.println(r + "건 입력됨");
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
		}
	// 조회
	public List<Board> search(){
		conn = getConnect();
		List<Board> list = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from board order by board_num");
			while(rs.next()) {
				list.add(new Board(rs.getInt("board_num")
					,rs.getString("board_title")
					,rs.getString("board_content")
					,rs.getString("board_writer")));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	// 상세조회
	public Board search(int number){
		String sql = "select * from board where board_num =?";
		conn = getConnect();
		Board brd = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, number);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				brd = new Board(rs.getInt("board_num")
					,rs.getString("board_title")
					,rs.getString("board_content")
					,rs.getString("board_writer")
					,rs.getString("date")
					,rs.getInt("bord_count"));
	
			}
			System.out.println(rs +"건 조회됨.");
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return brd;
		
	}
	
	// 수정
	public void update(Board brd) {
		String sql = "update board"
				+ "set board_num = ?"
				+ "    board_content = ?"
				+ "where board_num = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, brd.getNumber());
			psmt.setString(2, brd.getContent());
			psmt.setInt(3, brd.getNumber());
			
			int r = psmt.executeUpdate();
			System.out.println(r +"건 수정됨.");
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	//삭제
	public boolean delete(int number) {
		String sql = "delete from board order by board_num";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, number);
			int r = psmt.executeUpdate();
			if(r > 0)
				return true;
			System.out.println(r +"건 삭제됨.");
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}
}
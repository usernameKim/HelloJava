package project;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public void inputBrd (Board brd) {
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
		
			int r = psmt.executeUpdate();
			System.out.println(r+"게시글이 등록되었습니다!");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
	}
	
	//댓글 등록
	public void inputRep(Reply reply) {
		String sql = "insert into reply(rep_seq, "+ 
					", rep_content, rep_writer)"
					+ "values(?, ?, ?, ?)";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, reply.getReNumber());
			psmt.setString(2, reply.getReContent());
			psmt.setString(3, reply.getReWriter());
		
			int r = psmt.executeUpdate();
			System.out.println(r+"댓글이 등록되었습니다!");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	//글수정
	public void updateBrd(Board brd) {
		String sql ="update board" + "set board_num = ?, "
				+ "board_content = ?" + "where board_num = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, brd.getNumber());
			psmt.setString(2, brd.getContent());
			
			int r = psmt.executeUpdate();
			System.out.println(r+ "게시글이 수정되었습니다!");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
					
	}
	//댓글수정
	public void updateRep(Reply reply) {
		String sql ="update reply" + "set rep_seq = ?, "
				+ "rep_content= ?" + "where rep_seq = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, reply.getReNumber());
			psmt.setString(2, reply.getReContent());
			
			int r = psmt.executeUpdate();
			System.out.println(r+ "댓글이 수정되었습니다!");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	//글삭제
	public boolean deleteBrd(int number) {
		String sql ="delete from board where board_num = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, number);
			int r = psmt.executeUpdate();
			if (r > 0)
				return true;
			System.out.println(r + "게시물이 삭제되었습니다!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}
	//댓글삭제
	public boolean deleteRep(int number) {
		String sql ="delete from reply where rep_seq = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, number);
			int r = psmt.executeUpdate();
			if (r > 0)
				return true;
			System.out.println(r + "댓글이 삭제되었습니다!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}
	//글 조회
	public List<Board> checkBrd(){
		conn = getConnect();
		List<Board> list = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from board order by board_num" );
			while(rs.next()) {
				list.add(new Board(rs.getInt("board_num"), rs.getString("board_title"), 
									rs.getString("board_content"), rs.getString("board_writer")));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				disconnect();
			}
		return list;
		}
	
	//댓글 조회
	public List<Reply> checkRep(int number){
		conn = getConnect();
		List<Reply> list = new ArrayList<>();
		String sql = "select * from reply where board_num =?";
		try {
			psmt =conn.prepareStatement(sql);
			psmt.setInt(1, number);
			rs = psmt.executeQuery();
			if(rs.next()) {
				list.add(new Reply(rs.getInt("req_seq"), rs.getInt("board_num")
								,rs.getString("rep_content"), rs.getString("rep_writer")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
	
	//글상세조회
	public Board directBrd(int number) {
		String sql = "select * from board where board_num =?";
		String cnt = "upate board set cnt = cnt + 1 where board_num =?"; 
		conn = getConnect();
		Board brd = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, number);
			rs = psmt.executeQuery();
			
			psmt = conn.prepareStatement(cnt);
			psmt.setInt(1, number);
			psmt.executeQuery();
			if(rs.next()) {
				brd = new Board(rs.getInt("board_num"), rs.getString("board_title")
						, rs.getString("board_content"),rs.getString("board_writer"));
			}
			System.out.println(rs +"게시글이 상세조회되었습니다!");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return brd;
	}
}

	

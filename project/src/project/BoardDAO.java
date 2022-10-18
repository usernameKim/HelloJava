package project;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.edu.board.Board;

public class BoardDAO extends DAO {
	
	
	//글등록
	public void inputBrd (Board brd) {
		Scanner scn = new Scanner(System.in);
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
			System.out.println("게시글이 등록되었습니다!");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
	}
	
	
	//글수정
	public void updateBrd(Board brd) {
		Scanner scn = new Scanner(System.in);
		conn = getConnect();
		
		try {
			psmt = conn.prepareStatement("update board "
					+ "set board_title = ?, "
					+ " board_content = ?, "
					+ " creation_date = sysdate "
					+ "where board_num = ?");
			
			psmt.setString(1, brd.getTitle());
			psmt.setString(2, brd.getContent());
			psmt.setInt(3, brd.getNumber());
			
			int r = psmt.executeUpdate();
			System.out.println(r+ "게시글이 수정되었습니다!");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
					
	}
	
	//글삭제
	public void deleteBrd(int number) {
		String sql ="delete from board where board_num = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, number);
			int r = psmt.executeUpdate();
			System.out.println(r+"건 삭제되었습니다!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	//글 조회
	public List<Board> checkBrd(){
		List<Board> list = new ArrayList<>();
		conn = getConnect();
		try {
			psmt = conn.prepareStatement("select * from Board");
			rs = psmt.executeQuery();
			while(rs.next()) {
				list.add(new Board(rs.getInt("board_num")
						, rs.getString("board_title")
						, rs.getString("board_content")
						, rs.getString("board_writer")
						, rs.getInt("cnt")));
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
		conn = getConnect();
		Board brd = null;

		try {
			psmt = conn.prepareStatement("update board set cnt = cnt+1 "
					+ "where board_num =?");
			psmt.setInt(1, number);
			psmt.executeUpdate();
			
			psmt = conn.prepareStatement("select * from board where board_num = "+no);	
			rs = psmt.executeQuery();
			if (rs.next()) {// 값이없으면 null이 리턴
				brd = new Board(rs.getInt("board_num")//
						, rs.getString("board_title")//
						, rs.getString("board_content")//
						, rs.getString("board_writer")
						, rs.getInt("cnt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return brd;
	}
	public Board IdNum(String id, int no) {
		conn = getConnect();
		Board brd = null;
		
		try {
			psmt = conn.prepareStatement("select * from board where board_writer = ? and board_num=?");
			psmt.setString(1, id);
			psmt.setInt(2, no);
			rs = psmt.executeQuery();
			if(rs.next()) {//값이없으면 null이 리턴
				brd = new Board(rs.getInt("board_num")//
						, rs.getString("board_title")//
						, rs.getString("board_content")//
						, rs.getString("board_writer")//
						, rs.getInt("cnt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return brd;
	}
	
	public boolean numCheckBoard(int n) {
		boolean A = false;
		conn = getConnect();
		
		try {
			psmt = conn.prepareStatement("select * from board where board_num = ?");
			psmt.setInt(1, n);
			rs = psmt.executeQuery();
			if(rs.next()) {//값이없으면 null이 리턴	
				A=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return A;
	}
}

	

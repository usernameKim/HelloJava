package project;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardDAO extends DAO {
	
	
	//글등록
	public void inputBrd (Board brd) {
//		Scanner scn = new Scanner(System.in);
		String seq = "select theboard_seq.nextval from dual";
		String sql = "insert into boards(board_num, board_title"
				+ ", board_content, board_writer)"
				+ "values(?, ?, ?, ?)";
		conn = getConnect();
		try {
			// sequence 쿼리
			int seqInt = 0;
			psmt =conn.prepareStatement(seq);
			rs = psmt.executeQuery();
			if(rs.next()) {
				seqInt = rs.getInt(1);
			}
			// insert
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, brd.getNumber());
			psmt.setString(2, brd.getTitle());
			psmt.setString(3, brd.getContent());
			psmt.setString(4, brd.getWriter());
		
			psmt.executeUpdate();
			System.out.println("게시글이 등록되었습니다!");
			
			brd.setNumber(seqInt);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
	}
	
	
	//글수정
	public void updateBrd(Board brd) {
//		Scanner scn = new Scanner(System.in);
		conn = getConnect();
		
		try {
			psmt = conn.prepareStatement("update boards "
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
		String sql ="delete from boards where board_num = ?";
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
	
	// 조회
	public List<Board> checkBrd(){
		List<Board> list = new ArrayList<>();
		conn = getConnect();
		try {
			psmt = conn.prepareStatement("select * from boards ");
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
			psmt = conn.prepareStatement("update boards set cnt = cnt+1 "
					+ "where board_num =?");
			psmt.setInt(1, number);
			psmt.executeUpdate();
			
			psmt = conn.prepareStatement("select * from boards where board_num = ?");	
			psmt.setInt(1, number);
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
	
	//아이디와 글번호가 있는지확인 ->  게시물 조회
	public Board IdNum(String id, int no) {
		conn = getConnect();
		Board brd = null;
		
		try {
			psmt = conn.prepareStatement("select * from boards where board_writer = ? and board_num=?");
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
	
	public int numCheckBoard(int n) {
		conn = getConnect();
		int a = -1;
		try {
			psmt = conn.prepareStatement("select * from boards where board_num = ?");
			psmt.setInt(1, n);
			rs = psmt.executeQuery();
			if(rs.next()) {//값이없으면 null이 리턴	
				a = rs.getInt("board_num");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return a;
	}
	
	public Board idCheck(String id) {
		conn = getConnect();
		Board brd = new Board(0, "","","","",0);
		try {
			psmt = conn.prepareStatement("select * from boards where board_writer = ?");	
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				brd = new Board(rs.getInt("board_num")//
						, rs.getString("board_title")//
						, rs.getString("board_content")//
						, rs.getString("board_writer")//
						, rs.getInt("cnt"));
			}
		} catch(SQLException e) {
			
		} finally {
			disconnect();
		}
		return brd;
	
	}
	
	
	
//	//목록
//	public List<Board> brdList(Board brd){
//		List<Board> brdList = new ArrayList<Board>();
//		getConnect();
//		String sql = "select * from theboard"
//				+ " where board_num = decode(?, 0, board_num, ?) "
//				+ " and	  board_title like '%'||?||'%' "
//				+ " and   board_content like '%'||?||'%' "
//				+ " and   board_writer like '%'||?||'%' "
//				+ " and   to_char(creation_date, 'yyyy-mm-dd') like '%'||?||'%' "
//				+ " and   cnt = decode(?, 0, board_num, ?)";
//	try {
//		psmt = conn.prepareStatement(sql);
//		psmt.setInt(1, brd.getNumber());
//		psmt.setInt(2, brd.getNumber());
//		psmt.setString(3, brd.getTitle());
//		psmt.setString(4, brd.getContent());
//		psmt.setString(5, brd.getWriter());
//		psmt.setString(6, brd.getDate());
//		psmt.setInt(7, brd.getCnt());
//	
//		rs = psmt.executeQuery();
//		while(rs.next()) {
//			int brdNum = rs.getInt("board_num");
//			String title = rs.getString("board_title");
//			String content = rs.getString("board_content");
//			String writer = rs.getString("board_writer");
//			String date = rs.getString("creation_date");
//			int cnt = rs.getInt("cnt");
//			
//			Board brd2 = new Board(brdNum, title, content, writer, date, cnt);
//			brdList.add(brd2);
//		}
//	} catch(SQLException e) {
//		e.printStackTrace();
//	} finally {
//		disconnect();
//	}
//	return brdList;
//}
}

	

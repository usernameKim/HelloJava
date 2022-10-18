package project;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReplyDAO extends DAO {
	Connection conn = null;
	
	// 댓글등록
	public void inputRep(Reply reply) {
		conn = getConnect();
		try {
			psmt = conn.prepareStatement("insert into reply(rep_seq, board_num, rep_content, rep_writer, creation_date)"
					+ "values (reply_seq.nextval, ?, ?, ?, sysdate)");
			psmt.setInt(1, reply.getBoNum());
			psmt.setString(2, reply.getReContent());
			psmt.setString(3, reply.getReWriter());
			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 댓글 조회
	public List<Reply> checkRep(int number) {
		List<Reply> list = new ArrayList<>();
		conn = getConnect();
		try {
			psmt = conn.prepareStatement("select * from reply where board_num =?");
			psmt.setInt(1, number);
			rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(new Reply(rs.getInt("rep_seq")
						, rs.getInt("board_num")
						, rs.getString("rep_content")
						,rs.getString("rep_writer")
						, rs.getString("creation_date")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

//		//댓글수정
//		public void updateRep(Reply reply) {
//			String sql ="update reply" + "set rep_seq = ?, "
//					+ "rep_content= ?" + "where rep_seq = ?";
//			conn = getConnect();
//			try {
//				psmt = conn.prepareStatement(sql);
//				psmt.setInt(1, reply.getReNumber());
//				psmt.setString(2, reply.getReContent());
//				
//				int r = psmt.executeUpdate();
//				System.out.println(r+ "댓글이 수정되었습니다!");
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}finally {
//				disconnect();
//			}
//		}
	public boolean numCheckReply(int n) {
		boolean A = false;
		conn = getConnect();

		try {
			psmt = conn.prepareStatement("select * from reply where rep_seq = ?");
			psmt.setInt(1, n);
			rs = psmt.executeQuery();
			if (rs.next()) {// 값이없으면 null이 리턴
				A = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return A;
	}

	public Reply IdNumReply(String id, int no) {
		conn = getConnect();
		Reply re = null;

		try {
			psmt = conn.prepareStatement("select * from reply where rep_writer = ? and rep_seq=?");
			psmt.setString(1, id);
			psmt.setInt(2, no);
			rs = psmt.executeQuery();
			if (rs.next()) {// 값이없으면 null이 리턴
				re = new Reply(rs.getInt("rep_seq")//
						, rs.getInt("board_num")//
						, rs.getString("rep_content")//
						, rs.getString("rep_writer"), rs.getString("creation_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return re;
	}

	// 댓글삭제
	public void deleteRep(int number) {
		String sql = "delete from reply where rep_seq = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, number);
			int r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}
}

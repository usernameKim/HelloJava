package co.edu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.common.DAO;
import co.edu.vo.MemberVO;

public class MemberDAO extends DAO {
	// 생성, 수정, 삭제, 한건조회, 목록조회
	public void memberInsert(MemberVO vo) {
		getConnect();
		String sql = "insert into members(id, passwd, name, email) values(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	//조회
//	public MemberVO memberSearch(String id) {
//		conn = getConnect();
//		MemberVO vo = null;
//		List<MemberVO> list = new ArrayList<MemberVO>();
//		try {
//			psmt = conn.prepareStatement("select * from members where id =?");
//			rs = psmt.executeQuery();
//			psmt.setString(1, id);
//			if (rs.next()) {// 값이없으면 null이 리턴
//				vo = new MemberVO(rs.getString("id")//
//						, rs.getString("passwd")//
//						, rs.getString("name")//
//						, rs.getString("email"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			disconnect();
//		}
//		return vo;
//	}
	
	public MemberVO memberSearch(String id) {
		MemberVO vo = new MemberVO();
		String sql = "select * from members where id = ?";
		conn = getConnect();
		try {

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();

			if (rs.next()) {
				vo = (new MemberVO(rs.getString("id"), rs.getString("passwd"), rs.getString("name"),
						rs.getString("email")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}

	//수정
	public void memberUpdate(MemberVO vo) {
		getConnect();
		String sql = "update members set id=?, passwd=?, name=?, email=? where id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());
			psmt.setString(5, vo.getId());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	//삭제
	public void memberDelete(String id) {
		getConnect();
		String sql = "delete from members where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	//목록조회
	public List<MemberVO> memberList() {
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		getConnect();
		String sql = "select * from members";
		try {
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("passwd");
				String name = rs.getString("name");
				String email = rs.getString("email");

				MemberVO vo = new MemberVO(id, pwd, name, email);
				memberList.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return memberList;
	}
	// String id, String passwd => MemberVO 
	public MemberVO login(String id, String passwd) {
		getConnect();
		String sql = "select * from members where id=? and passwd=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, passwd);
			
			rs = psmt.executeQuery();
			if(rs.next()) { //참이면 실행
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setPasswd(rs.getString("passwd"));
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
}

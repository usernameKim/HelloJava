package co.edu.dao;

import java.sql.SQLException;

import co.edu.board.MemberVO;
import co.edu.common.DAO;

public class MemberDAO extends DAO {

	// 회원가입
	public MemberVO memberInsert(MemberVO vo) {
		getConnect();
		String sql = "insert into members(id, passwd, name, email, responsibility) values(?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());
			psmt.setString(5, vo.getResponsibility());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력.");
			if (r > 0) {
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// 로그인
	public MemberVO login(String id, String passwd) {
		getConnect();
		String sql = "select * from members where id=? and passwd=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, passwd);

			rs = psmt.executeQuery();
			if (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setResponsibility(rs.getString("responsibility"));
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// 비밀번호 변경
	public MemberVO rePasswd(String id, String passwd) {
		getConnect();
		String sql = "update * from members set passwd=? where id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, passwd);
			psmt.setString(2, id);

			rs = psmt.executeQuery();
			if (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
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

package co.edu.service;

import java.util.List;

import co.edu.dao.MemberDAO;
import co.edu.vo.MemberVO;

// 서비스 로직 : 실제 데이터베이스 등록/수정/삭제/조회

public class MemberServiceImpl implements MemberService{

	MemberDAO dao = new MemberDAO();
	
	@Override
	public void addMember(MemberVO vo) {
//		dao.memberSearch(""); 조회후 추가, MemberDAO에 메소드 만들 필요x, 간단하게 표현
		dao.memberInsert(vo);
	}

	@Override
	public void modifyMember(MemberVO vo) {
		dao.memberUpdate(vo);
	}

	@Override
	public void removeMember(String id) {
		dao.memberDelete(id);
	}

	@Override
	public MemberVO findMember(String id) {
		return dao.memberSearch(id);
	}

	@Override
	public List<MemberVO> memberList() {
		return dao.memberList();
	}

	@Override
	public MemberVO login(String id, String passwd) {
		return dao.login(id, passwd);
	}

}

package co.micol.prj.member.service;

import java.util.List;

import co.micol.prj.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO vo); //한명의 데이터 또는 로그인처리
	int memberInsert(MemberVO vo);
	int memberDelete(MemberVO vo);
	int memberUpdate(MemberVO vo);
	
	MemberVO memberLogin(String id, String password); // 위의 select로 하는게좋음 원랜
	boolean isMemberIdCheck(String id); //존재하면 false(관례적으로)
}

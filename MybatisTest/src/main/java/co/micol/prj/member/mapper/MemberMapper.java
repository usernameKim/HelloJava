package co.micol.prj.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.micol.prj.member.vo.MemberVO;

public interface MemberMapper {
	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO vo); //한명의 데이터 또는 로그인처리
	int memberInsert(MemberVO vo);
	int memberDelete(MemberVO vo);
	int memberUpdate(MemberVO vo);
	
	// 매개변수가 2개 이상일때 넘어올때 어노테이션Param으로 넘어온다.(즉 serivce와 거의 같지만 mapper에서는 이렇게!)
	MemberVO memberLogin(@Param("id") String id, @Param("password") String password); // 위의 select로 하는게좋음 원랜
	// 변수명 : "id", "password" -> xml에서 이 변수로 쓰겠다는 뜻.
	boolean isMemberIdCheck(String id); //존재하면 false(관례적으로)
	
}

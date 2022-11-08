package co.micol.prj.book.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.impl.MemberServiceImpl;
import co.micol.prj.member.vo.MemberVO;

public class MemberJoin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 회원입력
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPasswd(request.getParameter("passwd"));
		vo.setName(request.getParameter("name"));
		vo.setEmail(request.getParameter("email"));
		
		int n = dao.memberInsert(vo);
		String message ="입력이 실패 했습니다.";
		if(n> 0) {
			message="회원가입이 정상적으로 이루어 졌다.";
		}
		request.setAttribute("message", message);
		return "member/memberLogin.tiles";
	}

}

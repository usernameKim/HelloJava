package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.common.Command;

public class Logout implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 로그아웃 처리
		HttpSession session = request.getSession(); //초기화
		String message = (String) session.getAttribute("name"); //cascading
		message = message.concat("님 안녕히 가세요!!!!!!"); //문자열 결합
		//jsp페이지에 넘겨주는 방법!!
		request.setAttribute("message", message); 
		//로그아웃: 세션 없애줌.
		session.invalidate(); // 서버에 보관한 session을 아예없엠
		return "member/memberLogin.tiles";
//		return "main.do"; //처음으로 돌리는 것
	}

}

package co.micol.prj.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	// return value : string, server가 request, response자동으로 만듦
	// request에 클라이언트가 요청한 값들이 모두, response는 응답객체
	public String exec(HttpServletRequest request, HttpServletResponse response);
	
}

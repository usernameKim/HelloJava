package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Command;
import co.edu.common.HttpUtil;

public class MemberSearchFrom implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 화면open.
		String id = req.getParameter("id");
		
		req.setAttribute("sid", id);
		
		HttpUtil.forward(req, resp, "memberView/memberSearch.jsp");
	}

}

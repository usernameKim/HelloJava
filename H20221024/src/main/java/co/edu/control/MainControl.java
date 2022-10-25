package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.common.Command;
import co.edu.common.HttpUtil;

public class MainControl implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		// session정보가 있으면 main페이지로 이동.
		// 없으면 로그인페이지로 이동.
		String id = (String) session.getAttribute("id");
		if (id != null) {
			HttpUtil.forward(req, resp, "memberView/main.jsp");
		
		} else {
			HttpUtil.forward(req, resp, "memberLog/loginForm.jsp");
		}

	}
}

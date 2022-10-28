package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.board.MemberVO;
import co.edu.common.Control;
import co.edu.common.HttpUtil;
import co.edu.service.BoardService;
import co.edu.service.BoardServiceImpl;

public class passwdReConfirm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		String pass = req.getParameter("passwd");
		
		BoardService service = new BoardServiceImpl();
		MemberVO result = service.login(id, pass);
		
		if(result !=null) {
			req.setAttribute("logInfo", result);
			
			HttpSession session = req.getSession();
			session.setAttribute("id", result.getId());
			session.setAttribute("passwd", result.getPasswd());
			
			MailApp mail = new MailApp();
			
			
			HttpUtil.forward(req, resp, "member/memberlogin.tiles");
		} else {
			HttpUtil.forward(req, resp, "member/signinForm.tiles");
		}
	}
}
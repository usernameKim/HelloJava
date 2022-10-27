package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.board.MemberVO;
import co.edu.common.Control;
import co.edu.common.HttpUtil;
import co.edu.service.BoardService;
import co.edu.service.BoardServiceImpl;

public class SignUp implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("passwd");
		String nm = req.getParameter("name");
		String ml = req.getParameter("email");
		String rep = req.getParameter("responsibility");
		
		MemberVO vo = new MemberVO(id, pw, nm, ml, rep);
		System.out.println(vo);
		BoardService service = new BoardServiceImpl();
		service.addMember(vo);
	
		HttpUtil.forward(req, resp, "member/member.tiles");
	}

}

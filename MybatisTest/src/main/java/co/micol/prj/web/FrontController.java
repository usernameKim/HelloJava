package co.micol.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.book.command.BookList;
import co.micol.prj.book.command.MemberJoin;
import co.micol.prj.common.Command;
import co.micol.prj.main.MainCommand;
import co.micol.prj.member.command.AjaxIdCheck;
import co.micol.prj.member.command.Logout;
import co.micol.prj.member.command.MemberJoinForm;
import co.micol.prj.member.command.MemberLogin;
import co.micol.prj.member.command.MemberLoginForm;

/**
 * 모든요청을 받아들이는 컨트롤러
 */
@WebServlet("*.do") // 가상의 주소, 어노테이션
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 명령을 저장할 공간을 생성(내가 만든 패키지로 import해야함)
	private HashMap<String, Command> map = new HashMap<String, Command>(); //value: command
	public FrontController() {
        super();
    }
	//요청한 것을 실행하는 명령을 모아 두는 곳
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand()); // 처음 보여줄 페이지 명령
		map.put("/bookList.do", new BookList()); // 책목록보기
		map.put("/memberLoginForm.do", new MemberLoginForm()); //로그인 폼 호출
		map.put("/memberLogin.do", new MemberLogin()); //멤버로그인처리
		map.put("/logout.do", new Logout()); //로그아웃
		map.put("/memberJoinForm.do", new MemberJoinForm());
		map.put("/ajaxIdCheck.do", new AjaxIdCheck());//ajax를 이용한
		map.put("/memberJoin.do", new MemberJoin());
	}
	
	//요청을 분석하고 실행, 결과를 돌려주는 곳
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //한글깨짐방지
		String uri = request.getRequestURI(); //요청한 uri를 구함
		String contextPath = request.getContextPath(); //루트를 구함, context path
		String page = uri.substring(contextPath.length()); //실제 수행할 요청을 구함
		
		//key값을 넣으면 value값 return
		Command command = map.get(page); // init 메소드에서 수행할 명령을 가져온다. get은 value값만
		
//		Command command = new MainCommand(); 위나 아래나 같은것. 
		
		String viewPage = command.exec(request, response); //명령을 수행하고 결과를 돌려받음.
		
		// 어느 페이지에 보여줄 것인지 view 찾기
		// 끝에 .do가 포함되어 있지 않다면 server에 접근하도록 해줌
		// viewResolver: 사용자가 요청한 것에 대한 응답 view를 렌더링
		// viewResolve 파트(spring은 자동으로 만들어줌)
		if(!viewPage.endsWith(".do") && viewPage != null) {
			//ajax 처리
			if(viewPage.startsWith("ajax:")) {
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5)); //ajax: 이거 자름
				return;
			}
			//타일즈 돌아가는곳
			if(!viewPage.endsWith(".tiles")) {
				viewPage = "/WEB-INF/views/" + viewPage + ".jsp"; //타일즈를 안태움
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
			//  클라이언트로부터 최초에 들어온 요청을 JSP/Servlet 내에서 원하는 자원으로 요청을 넘기는(보내는) 역할
		} else { 
			// dispatcher(값을 함께 가지고 가는것, 내가 보내는 값을 가지고 감, 다른사람에게 전달) 
			// sendRedirect(request에 있는 값을 가지고 가지 x, 명령만 보내는 것(수리해!.. but 폰은 안가져감..))
			response.sendRedirect(viewPage); //*.do로 들어올때 돌아가는 곳
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

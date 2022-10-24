package co.edu;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{ // 모든요청을 FrontController에서.
	//servlet을 모두 관리.
	// url주소와 실행할 서블릿을 map타입으로 관리
	Map<String, Command> map = new HashMap<String, Command>();
	
	@Override
	public void init() throws ServletException { //실행시 처음 한번만 
		map.put("/first.do", new FirstImpl()); // 인터페이스를 구현하는 구현객체
		map.put("/second.do", new SecondImpl());
		map.put("/third.do", new ThirdImpl());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI(); //http://localhost:8081/HelloWeb/first.do url:/HelloWeb/first.do
		String contextPath = req.getContextPath(); // uri에서 프로젝트 정보를 반환.
		String path = uri.substring(contextPath.length());
		
//		System.out.println("url: " + uri);
//		System.out.println("contextPath: " + contextPath);
//		System.out.println("path: " + path);
		
		Command command = map.get(path);
		command.exec(req, resp);
	}
}

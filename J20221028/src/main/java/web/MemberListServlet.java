package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import member.MemberVO;
import service.MemberDAO;

@WebServlet("/MemberListServlet")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		response.setContentType("text/json;charset=utf-8");
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.memberList();
		// key, value 형태
		// [{"id:"user1","name":"홍길동", "email":"email.com", "responsibility":"user"},{},{},{}]
		// 3건 1(0),2(1),3(2)
//		String json ="[";
//		for(int i =0; i<list.size(); i++) {
//			// \: ""를 실제 따옴표로 인식해줌
//			json += "{\"id\":\""+list.get(i).getId()
//					+"\",\"name\":\""+list.get(i).getName()
//					+"\",\"email\":\""+list.get(i).getEmail()
//					+"\",\"responsibility\":\""+list.get(i).getResponsibility() +"\"}";
//			
//			if(i < list.size() -1) {
//				json += ",";
//			}
//		}
//		json += "]"; 
		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(list));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("dopost");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding(("utf-8"));
		response.setContentType("text/json;charset=utf-8");
		
		String job = request.getParameter("job");
		String id = request.getParameter("id");
		
		MemberDAO dao = new MemberDAO();
		// job = > 등록, 삭제 구분.
		if(job.equals("delete")) {
			if(dao.deleteMember(id)) {
				response.getWriter().print("success");
			} else {
				response.getWriter().print("fail");
			}
			
		} else if (job.equals("insert")) {
			String pw = request.getParameter("passwd");
			String em = request.getParameter("email");
			String nm = request.getParameter("name");
			
			MemberVO vo = new MemberVO();
			vo.setId(id);
			vo.setPasswd(pw);
			vo.setEmail(em);
			vo.setName(nm);
			
			dao.insertMember(vo);
			
			Gson gson = new GsonBuilder().create(); // gson인스턴스 호출방법
			// {"id":"user1", "passwd":....??} 자바 객체를 json형태로 바꿔줌
			
			response.getWriter().print(gson.toJson(vo));
		}
		
		
	}

}

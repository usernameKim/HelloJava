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

@WebServlet("/ScheduleServlet")
public class ScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ScheduleServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");
		MemberDAO dao = new MemberDAO();
		Gson gson = new GsonBuilder().create();
		List<MemberVO> result = dao.schList();
		response.getWriter().print(gson.toJson(result));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding(("utf-8"));
		response.setContentType("text/json;charset=utf-8");
		
		MemberDAO dao = new MemberDAO();
		String title = request.getParameter("title");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		
		MemberVO vo = new MemberVO();
		vo.setTitle(title);
		vo.setStart_date(start);
		vo.setEnd_date(end);
		
		dao.schInput(vo);
		
		response.getWriter().print(vo);
	}

}

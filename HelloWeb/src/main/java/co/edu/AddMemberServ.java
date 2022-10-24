package co.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.emp.EmpDAO;
import co.edu.emp.EmployeeVO;

@WebServlet({ "/addMemberServlet", "/addMember" })
public class AddMemberServ extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public AddMemberServ() {
        super();
    }

    // get 방식의 요청 시 실행.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// content 타입을 지정.
		response.setContentType("text/html;charset=UTF-8");
		
		System.out.println("AddMemberSer 페이지입니다.");
		String empId = request.getParameter("employee_id");
		String lName = request.getParameter("last_name");
		String email = request.getParameter("email");
		String hireD = request.getParameter("hire_date");
		String jobId = request.getParameter("job_id");
		
		System.out.println(empId);
		
		
		// 입력.
		EmpDAO dao = new EmpDAO();
		EmployeeVO vo= new EmployeeVO (0, lName, email, hireD, jobId);
		dao.insertEmp(vo);
		
		System.out.println("입력완료.");
		
		PrintWriter out = response.getWriter(); // 출력스트림.
		out.print("<h3>입력결과.</h3>");
		out.print("<h4>사원번호: "+ vo.getEmployeeId() + "</h4>");
		out.print("<h4>성씨: "+ vo.getLastName() + "</h4>");
		out.print("<h4>이메일: "+ vo.getEmail() +"</h4>");
		out.print("<h4>입사일: "+ vo.getHireDate() +"</h4>");
		out.print("<h4>직무: "+ vo.getJobId() +"</h4>" );
		out.print("<a href= member/memberAdd.html> " + "회원등록 페이지 이동" +"</a>");
		
	}
	// post 방식의 요청 시 실행.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
//		doGet(request, response);
		PrintWriter out = response.getWriter(); // 사용자의 브라우저(출력스트림 생성)
		out.print("<h3>Post 방식의 요청</h3>");
	}
	
}


package co.edu.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO extends DAO {
	
	//삭제
	public boolean delete(int empId) {
		String sql = "delete from empl where employee_id =?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empId);
			int r = psmt.executeUpdate();
			if(r > 0)
			return true;
			System.out.println(r +"건 삭제됨.");
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
	}
		return false; //아무것도 처리 안되었다는 뜻.(삭제 한거 없음)
}
	
	//수정
	public void update(Employee emp) {
		String sql = "update empl " // 나중에 parameter를 채우겠다는 의미
				+ "set email = ?, "
				+ "    hire_date = ?, "
				+ "    job_id = ? "
				+ "where employee_id = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql); //객체를 넣을때 이미sql을 넣음.
			psmt.setString(1, emp.getEmail());
			psmt.setString(2, emp.getHireDate());
			psmt.setString(3, emp.getJobId());
			psmt.setInt(4, emp.getEmployeeId());
			
			int r = psmt.executeUpdate();
			System.out.println(r +"건 수정됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	// 입력.
	public void insert(Employee emp) {
		String sql = "insert into empl (employee_id, last_name, email, hire_date, job_id)\r\n"
				+ "values( "+emp.getEmployeeId()
				+", '"+emp.getLastName()
				+"', '"+emp.getEmail()
				+"', '"+emp.getHireDate()
				+"', '"+emp.getJobId()+"')";
		System.out.println(sql);
		conn = getConnect();
		try {
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql);
			System.out.println(r + "건 입력");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	// 조회.
	public List<Employee> search() {
		conn = getConnect(); // 변수값은 dao의 conn 필드의 값
		List<Employee> list = new ArrayList<>(); // 반환하기 위한 값.
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from empl"); //조회
			while(rs.next()) {
				list.add(new Employee(rs.getInt("employee_id") //
						,rs.getString("last_name")// 
						,rs.getString("email")//
						,rs.getString("hire_date")//
						,rs.getString("job_id")//
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	public Employee getEmp(int empId) {
		// 한건만 반환. 컬렉션 필요 없음.
		String sql = "select * from empl where employee_id =?";
		conn = getConnect();
		Employee emp2 = null;
		try {
			psmt = conn.prepareStatement(sql); //? -> preparestatement 사용
			psmt.setInt(1, empId); // 쿼리문이 2개이므로 두번째꺼
			
			rs = psmt.executeQuery(); // ->select 사용시 써주는 쿼리문
		if(rs.next()) { // 커서 위치를 옮겨주는 역할.
			 emp2 = new Employee(rs.getInt("employee_id") //인스턴스를 emp2변수에 담음.
					,rs.getString("last_name")// 
					,rs.getString("email")//
					,rs.getString("hire_date")//
					,rs.getString("job_id")//
					);
		}
			
			System.out.println(rs +"건 조회됨.");
		
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
	}
		
		return emp2;
	}
}
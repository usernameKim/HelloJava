package co.edu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpDAO {
	public static void main(String[] args) {
		update();
	}

	public static void update() {
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			//jdbc 드라이버를 통하여 커넥션을 만드는 역할을 한다.
			stmt = conn.createStatement();
			int r = stmt.executeUpdate("update empl set first_name = 'mash' where employee_id = 500");
			
			System.out.println(r +"건이 수정되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	

	public static void delete() {
		Connection conn = null;
		Statement stmt = null;
//		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

			stmt = conn.createStatement();
			int r = stmt.executeUpdate("delete from empl where employee_id = 700"); // insert, delete, update 쓸때 update
																					// 메소드 씀, 건수 리턴
			System.out.println(r + "건 삭제됨.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 예외 발생, 정상 처리.
			try {
//				rs.close();
				stmt.close();
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void search() {
		// jdbc driver로드
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr"); // url, id, pw

			stmt = conn.createStatement(); // 실행쿼리문을 전송, 결과 받아오도록 하는 객체./ 커넥션 객체
			rs = stmt.executeQuery("select * from empl order by employee_id"); // 결과를 담을 객체, 조회할 메소드(select 경우)
			// Set컬렉션
			while (rs.next()) {
				System.out.println("사원번호: " + rs.getInt("employee_id"));
				System.out.println("이름: " + rs.getString("first_name"));
				System.out.println("급여: " + rs.getInt("salary"));
				System.out.println("=======================================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 예외 발생, 정상 처리. 무조건 실행.
			try {
				rs.close();
				stmt.close();
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("프로그램 종료.");
	}
}

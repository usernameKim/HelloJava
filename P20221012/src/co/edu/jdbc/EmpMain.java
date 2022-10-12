package co.edu.jdbc;

import java.util.List;
import java.util.Scanner;

public class EmpMain {

	public static void main(String[] args) {

		EmployeeDAO dao = new EmployeeDAO();
		Scanner scn = new Scanner(System.in);

		// 메뉴=> 1. 사원등록(insert) 2. 한건조회(getEmp) 3. 수정 4. 삭제 5. 목록조회 9.종료
		while (true) {
			System.out.println("1. 사원등록(insert) 2. 한건조회(getEmp) 3. 수정 4. 삭제 5. 목록조회 9.종료");
			System.out.println("번호를 입력>");
			int menu = scn.nextInt();
			scn.nextLine();
			if (menu == 1) {
				Employee emp = null;

				System.out.println("사원번호 입력");
				int empId = Integer.parseInt(scn.nextLine());
				System.out.println("이름 입력");
				String name = scn.nextLine();
				System.out.println("이메일 입력");
				String email = scn.nextLine();
				System.out.println("입사일자 입력");
				String hDate = scn.nextLine();
				System.out.println("직무 입력");
				String jobId = scn.nextLine();

				emp = new Employee(empId, name, email, hDate, jobId);
				dao.insert(emp);
				System.out.println("사원등록 완료");
				
				
			} else if (menu == 2) {
				System.out.println("사원번호 입력");
				int empId = Integer.parseInt(scn.nextLine());
				System.out.println(dao.getEmp(empId));

			} else if (menu == 3) {
				Employee emp2 = null;
				
				System.out.println("수정할 사원번호 입력");
				int empId = Integer.parseInt(scn.nextLine());
				System.out.println("수정할 이름 입력");
				String name = scn.nextLine();
				System.out.println("수정할 이메일 입력");
				String email = scn.nextLine();
				System.out.println("수정할 입사날짜 입력");
				String hDate = scn.nextLine();
				System.out.println("수정할 직무 입력");
				String jobId = scn.nextLine();
				
				emp2 = new Employee(empId, name, email, hDate, jobId);
				dao.update(emp2);
				System.out.println("수정완료");
				
			} else if (menu == 4) {
				System.out.println("삭제할 사원번호 입력");
				int empId = Integer.parseInt(scn.nextLine());
//				dao.delete(empId);
				
				if(dao.delete(empId)) {
					System.out.println("삭제완료");
					break;
				} else {
					System.out.println("삭제할 데이터 없습니다");
				}
				
			} else if (menu == 5) {
				List<Employee> employees = dao.search();
				for(Employee emp : employees) {
				System.out.println(emp);
				}

			} else if (menu == 9) {
				System.out.println("종료");
				break;
			}else {
				System.out.println("잘못된 번호");
			}		

		} 
		scn.close(); //break 써줘야 오류 안남.
		System.out.println("프로그램 종료.");
	}

}


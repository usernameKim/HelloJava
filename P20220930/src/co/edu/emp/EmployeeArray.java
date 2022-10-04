package co.edu.emp;

import java.util.Scanner;

// 배열을 활용해서 정보저장.
public class EmployeeArray implements EmployeeService {
	// 저장공간 생성.
	Employee[] list; 
	int idx = 0; //필드. int타입이면 초기값이 0
	Scanner scn = new Scanner(System.in);
	@Override
	public void init() {
		System.out.println("사원수 입력>> ");
		int cnt = Integer.parseInt(scn.nextLine());
		list = new Employee[cnt]; // 5개 인스턴스를 저장할 수 있는 공간생성.
	}

	@Override
	public void input() {
		
		if(idx >= list.length) {
			System.out.println("더 이상 입력불가.");
			return; //메소드 종료.
		}
		System.out.println("사번>> ");
		int eId = Integer.parseInt(scn.nextLine());
		System.out.println("이름>> ");
		String name = scn.nextLine();
		System.out.println("부서>> ");
		int detpId = Integer.parseInt(scn.nextLine());
		System.out.println("급여>> ");
		int sal = Integer.parseInt(scn.nextLine());
		System.out.println("이메일>> ");
		String email = scn.nextLine();
		Employee emp = new Employee(eId, name, sal, detpId, email);
		list[idx++] = emp;
	}

	@Override
	public String search(int employeeId) {
		return null;
	}

	@Override
	public void print() {
		for(int i=0; i<idx; i++) {
			System.out.printf("%5d %10s %7d\n",
				list[i].getEmployeeId(),
				list[i].getName(),
				list[i].getSalary());
		}
		
	}

}

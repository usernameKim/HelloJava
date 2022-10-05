package co.edu.emp;

import java.util.ArrayList;
import java.util.Scanner;

// 컬렉션(ArrayList)을 활용해서 데이터 저장. 저장공간 생성 안해도 됨.
public class EmployeeArrayList implements EmployeeService{
	// 저장공간 생성.
	ArrayList<Employee> list;
	int idx = 0;
	Scanner scn = new Scanner(System.in);
	
	@Override
	public void init() {
		list = new ArrayList<Employee>();
		System.out.println("초기화 완료.");
	}

	@Override
	public void input() {
		int eId = -1; //eId는 try밖에 쓰기!(내부에서 쓰면 오류)
		while(true) {
		try {
			System.out.println("사번>> ");
			 eId = Integer.parseInt(scn.nextLine());
			 break;
		}catch(NumberFormatException e) {
			System.out.println("숫자를 입력하세요.");
			}
		}
		
		System.out.println("이름>> ");
		String name = "";
		try {
			name =scn.nextLine();
			
		}catch(Exception e1) {
			System.out.println("문자를 기입.");
		}
		
		int detpId = -1;
		while(true) {
			try {
				System.out.println("부서>> ");
				detpId = Integer.parseInt(scn.nextLine());
				break;
			}catch(Exception e2) {
				System.out.println("숫자를 입력.");
			}
		}
		 
		int sal = -1;
		while(true) {
			try{
				System.out.println("급여>> ");
				sal = Integer.parseInt(scn.nextLine());
				break;
			}catch (Exception e3) {
				System.out.println("숫자로 입력.");
			}
		}
		
		
		System.out.println("이메일>> ");
		String email = "";
		try {
			email = scn.nextLine();
		}catch (Exception e4) {
			System.out.println("문자로 입력.");
		}
		
		Employee emp = new Employee(eId, name, sal, detpId, email);
		list.add(emp);
	}

	@Override
	public String search(int employeeId) {
		String result = null;
//		for(int i=0; i < list.size(); i++) {
//			if(list.get(i).getEmployeeId() == employeeId) {
//				result = list.get(i).getName(); //get 메소드로 반환
//				break;
//			}
//		}
		for(Employee emp: list) {
			if(emp.getEmployeeId() == employeeId) {
				result = emp.getName();
			}
		}
		return null;
	}
//	String result = null;
//	for(int i=0; i < list.size(); i++) {
//	Employee emp = list.get(i)   --> list[i]와 같음.
//		if(emp.getEmployeeId() == employeeId) {
//			result = emp.getName(); //get 메소드로 반환
	@Override
	public void print() {
		System.out.printf("%5s %10s %7s\n",
				"사원번호",
				"이름   ",
				"급여   ");
		System.out.println("===========================");
		for(int i=0; i<list.size(); i++) {
			System.out.printf("%5d %10s %7d\n",
				list.get(i).getEmployeeId(),
				list.get(i).getName(),
				list.get(i).getSalary());
		}
		
	}

	@Override
	public int searchSal(int employeeId) {
		int result = -1;
		for(int i=0; i< list.size(); i++) {
			if(list.get(i).getEmployeeId() == employeeId) {
				result = list.get(i).getSalary();
				break;
			}
		}
//		for(Employee emp : list) {
//			if(emp.getEmployeeId() == employeeId) {
//				result = emp.getSalary();
		return result;
	}

}

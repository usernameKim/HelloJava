package co.edu.collect;

import java.util.ArrayList;
import java.util.Scanner;

class Employ {
	int empId;
	String empName;
	int salary;

	Employ(int empId, String empName, int salary) {
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employ [empId=" + empId + ", empName=" + empName + ", salary=" + salary + "]";
	}

}

public class MorningCode {

	public static void main(String[] args) {
		String tok = "Hello World Good";
		Scanner scn = new Scanner(tok);
		Scanner scanner = new Scanner(System.in);

//		while(scn.hasNext()) //값이 있는지 없는지 확인
//		System.out.println(scn.next());

		String[] toks = tok.split(" "); // 공백을 기준으로 문장을 나눠 배열을 만든다는 뜻
//		for (String str : toks) {
//			System.out.println(str);
//		}
		ArrayList<Employ> list = new ArrayList<>();
		System.out.println("입력>> ex) 100 홍길동 2500");
		while (true) {
			System.out.println("입력>> ");
			String inputVal = scanner.nextLine(); // 값을inputval에 담음.
			String[] inputs = inputVal.split(" ");

			if (inputs[0].equals("quit")) {
				break;
			}
			if(inputs.length !=3) {
				System.out.println("다시 입력...");
				 continue; //위로 올라감
			}
//			new Employ(Integer.parseInt(inputs)[0], inputs[1], Integer.parseInt(inputs)[2]); // Employ e = new(toks[0], toks[1], toks[2]);
			list.add(new Employ(Integer.parseInt(inputs[0]), inputs[1], Integer.parseInt(inputs[2]))); // inAry.add(e)
			// 첫번째 값=> empId, 두번째 값=> empName, 세번째 값=> salary
			// Employ 클래스의 인스턴스 생성.
			// ArrayList 에 저장.
			// 종료를 하고 싶으면 quit 종료.

		} // for(반복문) 출력.
		for (Employ emp : list) {
			System.out.println(emp);
		}
		System.out.println("end of prog");
	}

}
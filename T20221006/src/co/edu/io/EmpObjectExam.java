package co.edu.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class EmpObjectExam {

	public static void main(String[] args) throws Exception {

		// C:/Temp/emp.dat
		FileInputStream fis = new FileInputStream("C:/Temp/emp.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		ArrayList<Emp> empList = (ArrayList<Emp>) ois.readObject(); // 오브젝트->array로 변환
		Scanner scn = new Scanner(System.in);
		fis.close();
		ois.close();

		while (true) {
			System.out.println("1.사원등록 2.목록출력 3. 삭제 4.종료");
			System.out.print("선택>> ");

//			int menu = scn.nextInt();
//			scn.nextLine();
//			String[] empAry = null;
//			
			int menu = scn.nextInt();
			scn.nextLine();
			if (menu == 1) {
				System.out.println("사원id 입력하세요>>");
				int empid = scn.nextInt();
				scn.nextLine();
				System.out.println("이름 입력하세요>>");
				String name = scn.nextLine();
				System.out.println("부서 입력하세요>>");
				String dept = scn.nextLine();

				empList.add(new Emp(empid, name, dept));
				// <Emp> -> Emp 객체를 생성해줘야함

				// 교수님코드
//				System.out.println(">> 입력. 예시) 100 홍길동 개발");
//				String empVal = scn.nextLine();
//				//split 이용
//				empAry = empVal.split(" ");
//				Emp emp = new Emp (Integer.parseInt(empAry[0],empAry[1],empAry[2]);
//				empList.add(emp);
//				System.out.println("입력완료");

			} else if (menu == 2) {
				for (Emp emp : empList) {
					System.out.println(emp.toString());
				}

			} else if (menu == 3) {
				// 사원번호를 기준으로 삭제
				System.out.println("사원번호를 입력 >>");
				int empid = scn.nextInt();
				for (int i = 0; i < empList.size(); i++) {
					if (empList.get(i).id == (empid))
						empList.remove(i);
				}
				System.out.println("사원번호가 삭제되었습니다.");

			} else if (menu == 4) {
				// 컬렉션에 있던 ObjectOutputStream 을 활용해서 C:/Temp/emp.dat 저장하고 종료.
				try (FileOutputStream fos = new FileOutputStream("C:/Temp/emp.dat");
						ObjectOutputStream oos = new ObjectOutputStream(fos);) {
					oos.writeObject(empList);

				}
				System.out.println("completed.");
				break;
			} else {
				System.out.println("잘못된 메뉴를 선택했습니다.");
			}

		}
	}

}

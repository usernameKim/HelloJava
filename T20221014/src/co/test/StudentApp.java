package co.test;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentApp {
	public static void main(String[] args) {

		StudentManage app = StudentManage.getInstance();
		ArrayList<Student> StudentList = new ArrayList();
		Scanner scn = new Scanner(System.in);

		while (true) {
			System.out.println("1.등록 2.삭제 3.목록(총점) 4.순위 9.종료");
			System.out.println("선택> ");

			int menu = scn.nextInt();
			if (menu == 1) { // 등록.
//				Student student = null;
				System.out.println("학생번호>> ");
				int number = scn.nextInt();
				scn.nextLine();
				System.out.println("학생이름>> ");
				String name = scn.nextLine();
				System.out.println("학생나이>> ");
				int age = scn.nextInt();
				scn.nextLine();
				System.out.println("영어점수>> ");
				int english = scn.nextInt();
				scn.nextLine();
				System.out.println("수학점수>> ");
				int math = scn.nextInt();
				scn.nextLine();

				Student student = new Student(number, name, age, english, math);
				System.out.println("<<입력되었습니다!>>");

				app.add(student);

			} else if (menu == 2) { // 삭제.
				System.out.println("삭제할 학생번호>> ");
				int studNo = scn.nextInt();
				scn.nextLine();

				app.del(studNo);
				System.out.println("<<삭제되었습니다>>");

			} else if (menu == 3) { // 목록.
				System.out.println("3. 목록일 경우");
				System.out.println("학번 이름 나이 영어 국어 총점");
				
				app.list();
			} else if (menu == 4) { // 순위.

			} else if (menu == 9) { // 종료.
				System.out.println("<<저장되었습니다>>");
				app.storeToFile();
				break;
			}

		}

		scn.close();
		System.out.println("프로그램 종료.");
	}
}

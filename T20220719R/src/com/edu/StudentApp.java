package com.edu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentApp {

	List<Student> list = new ArrayList<Student>();
	Scanner scn = new Scanner(System.in);

	public void execute() {
		// 추가, 목록, 수정.
		while (true) {
			System.out.println("1.추가 2.목록조회 3.수정 9.종료");
			System.out.print("선택>> ");

			int menu = scn.nextInt();
			if (menu == 1) {
				Student student = null;	
				
				int menu2 = scn.nextInt(); scn.nextLine();
				if(menu2 == 1) {
					//학생 번호, 이름, 점수
				
					System.out.println("학생번호 입력");
					String stId = scn.nextLine();
					System.out.println("학생이름 입력");
					String name = scn.nextLine();
					System.out.println("학생점수 입력");
					int score = scn.nextInt();
					
					student = new Student(stId, name, score);
					System.out.println("학생정보가 입력됨");
				}else if(menu2 == 2) {
					//고등학교 담임, 학년정보 입력
					System.out.println("고등학교 담임정보");
					String hName = scn.nextLine();
					System.out.println("학년정보");
					String hGrade = scn.nextLine();
//					student = new HighStudent(studNo, studName, hName, hGrade);
					System.out.println("고등학교 정보 입력완료됨");
					
				}else {
					//대학교 정보
					System.out.println("담당교수 정보");
					String prof = scn.nextLine();
					System.out.println("전공과목 정보");
					String major = scn.nextLine();
					
				}
			} else if (menu == 2) {
				
			} else if (menu == 3) {

			} else if (menu == 9) {

			} else {
				System.out.println("잘못된 번호를 선택했습니다.");
			}
			System.out.println("프로그램종료.");
			scn.close();
		}
	}

}

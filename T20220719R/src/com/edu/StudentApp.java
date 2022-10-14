package com.edu;

//import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;

public class StudentApp {

//	List<Student> list = new ArrayList<Student>();
	Scanner scn = new Scanner(System.in);
	StudentService service = StudentListlmpl.getInstance();
	public void execute() {
		// 추가, 목록, 수정.
		while (true) {
			System.out.println("1.추가 2.목록조회 3.수정 9.종료");
			System.out.print("선택>> ");
			
			int menu = scn.nextInt(); scn.nextLine();	
			
			if(menu == 1) {
			Student student = null;	
				System.out.println("입력할 정보 선택: 1.학생정보 2.고등학교정보 3.대학교정보");
				int subMenu = scn.nextInt(); scn.nextLine();
				
				System.out.println("학생번호 입력");
				String studNo = scn.nextLine();
				System.out.println("학생이름 입력");
				String studName = scn.nextLine();
				System.out.println("학생점수 입력");
				int score = scn.nextInt(); scn.nextLine();
				
				if(subMenu == 1) {
					//학생 번호, 이름, 점수
					student = new Student(studNo, studName, score);
					System.out.println("학생정보가 입력됨");
					
				}else if(subMenu == 2) {
					//고등학교 담임, 학년정보 입력
					System.out.println("고등학교 담임정보");
					String teacher = scn.nextLine(); 
					System.out.println("학년정보");
					String grade = scn.nextLine();
					student = new HighStudent(studNo, studName, score, teacher, grade);
					
					System.out.println("고등학교 정보 입력완료됨");
					
				}else {
					//대학교 정보
					System.out.println("담당교수 정보");
					String professor  = scn.nextLine() ;
					System.out.println("전공과목 정보");
					String major = scn.nextLine();
					student = new CollegeStudent (studNo, studName, score, professor, major);
				}
				service.addStudent(student);
				//목록조회
			} else if (menu == 2) {
				Student[] list = service.StudentList();
				for(int i =0; i<list.length; i++) {
					if(list[i] != null) {
						System.out.println(list[i].toString());
					}
				}
				//수정
			} else if (menu == 3) {
				System.out.println("변경할 학생번호 입력");
				String stId = scn.nextLine();
				System.out.println("변경할 학생점수 입력");
				int score = scn.nextInt();
				
				service.modify(stId, score);
				
			} else if (menu == 9) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("잘못된 번호를 선택했습니다.");
			}
			
			
		}
		System.out.println("프로그램종료.");
		scn.close();
	}

}
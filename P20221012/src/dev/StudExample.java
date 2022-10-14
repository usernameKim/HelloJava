package dev;

import java.util.ArrayList;

public class StudExample {

	public static void main(String[] args) {
		Student stud = new Student(101, "홍길동", 80);
//		stud = "학생"; 타입이 맞지 않아 오류
//		String name1 = stud.studName; //둘다 문자타입 private하면 바로 못넣어서 오류
		String name1 = stud.getStudName();
		int score1 = stud.getScore();
		
		ArrayList<Student> studList = new ArrayList<Student>(); //Student클래스의 인스턴스만 담음
		studList.add(stud); //101번 학생이 담겨있음
		studList.add(new Student(102, "김현수", 88));
		studList.add(0, new Student(103, "박문수", 78)); //위치도 지정가능 , 홍길동이 1칸 밀려짐
		
		Student hong = new Student(201, "홍수환", 90);
		
		//대체
		for(int i=0; i<studList.size(); i++) {
			if(studList.get(i).getStudName().equals("김현수")) {
				studList.add(i, hong); //현재의 인덱스값에 홍수환을 넣을거임 
				break;
			}
		}
		
		// 출력.
		for(int i=0; i<studList.size(); i++) {
			System.out.println(studList.get(i).getStudName()); //배열은 []. 한건가져온다
		}
		
		// 학번기준으로 정렬.
		ArrayList<Student> sortAry = new ArrayList<Student>();
//		for(int i =0; i<studList.size(); i++) {
//			for(int j =0; j<i; i++) {
//			sortAry.add(j. studList.get(i));	
//			}
		}
		
		
	
		
	}



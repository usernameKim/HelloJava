package co.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManage {

	File file = new File("c:/Temp/studentList.txt");
	ArrayList<Student> studentList = new ArrayList<>();
	ArrayList<Student> rankList = new ArrayList<>();
	String x = null;
	// 싱글톤 인스턴스 생성.
	private static StudentManage instance = new StudentManage();

	private StudentManage() {
		readFromFile();
	}

	public static StudentManage getInstance() {
		return instance;
	}

	// 등록.
	public void add(Student student) { // 값을 한번에 다 넣을때 for문 안쓰기..
		// i=1이면 1<0일때 실행 못함.
		// i=0이면 0<0이면 실행이 안됨.
//		for(int i=1; i<studentList.size(); i++) {
//			if(student.equals(studentList.get(i))) {
		studentList.add(student);
//			}
	}
//	}

	// 삭제.
	public void del(int studNo) {
		boolean check = false; // if-else를 쓰면 일치하지 않는 값만 나오는데.. 불린쓰면 존재하지 않는 경우도 나옴
		for (int i = 0; i < studentList.size(); i++) {
			if (studNo == studentList.get(i).getStudNo())
			studentList.remove(i);
			check = true;
		}
		if (!check) {
			System.out.println("<<해당정보가 없습니다>>");
		}

	}

	// 목록(입력순서).
	public void list() {
		for (int i = 0; i < studentList.size(); i++) {
			System.out.println(studentList.get(i).toString());
		}
	}

	// 순위(총점순서).
	public void ord() {
		for (int i = 0; i < studentList.size(); i++) {
			int last = rankList.size();
			for (int j = 0; j <= last; j++) {
				// 비교를 하다가 마지막 순번이 됐을 경우에는 제일 뒤에 추가하기.
				if (j == last) {
					rankList.add(studentList.get(i));
					break;
				}
				// 마지막 순번이 아니면 현재 비교하는 위치에 추가하기.
				if (studentList.get(i).getSumScore() > rankList.get(j).getSumScore()) {
					if (studentList.get(i).getStudNo() < rankList.get(j).getStudNo()) {
						rankList.add(j, studentList.get(i));
						break;
					}
				}
			}
		}	//end of for
		
		int ord = 1;
		for(Student i : rankList) {
			System.out.println(rankList);
		}
	}

	// 저장된 파일을 읽어오기.
	public void readFromFile() {

		try {
			FileReader fr = new FileReader(file); //
			BufferedReader br = new BufferedReader(fr);//

			String studentInfo = null;
			String[] itemAry = null;

			while (true) {
				studentInfo = br.readLine();
				if (studentInfo == null) { // 파일의 끝부분이면 종료.
					break;
				}
				itemAry = studentInfo.split(" ");
				int no = Integer.parseInt(itemAry[0]);
				String name = itemAry[1];
				int age = Integer.parseInt(itemAry[2]);
				int eng = Integer.parseInt(itemAry[3]);
				int math = Integer.parseInt(itemAry[4]);
				Student student = new Student(no, name, age, eng, math);
				
				studentList.add(student);

			}
			br.close();
			fr.close();

		} catch (Exception e) {
			System.out.println("읽을 파일이 없습니다.");
		}
	} // 입력스트림

	// 입력된 내용을 파일에 저장하기.
	public void storeToFile() {
		try {
			FileWriter fw = new FileWriter(file);

			for (int i=0; i<studentList.size(); i++) {
				x = studentList.get(i).toString();
				fw.write(x + "\n");
			}
			System.out.println("<<저장되었습니다>>");
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // 출력스트림

	
}

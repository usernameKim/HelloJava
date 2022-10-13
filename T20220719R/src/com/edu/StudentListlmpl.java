package com.edu;

import java.util.Scanner;

public class StudentListlmpl implements StudentService {

	Student[] StudentList = new Student[10];

	private static StudentListlmpl instance = new StudentListlmpl();

	StudentListlmpl() {
	}

	public static StudentListlmpl getInstance() {
		return instance;
	}

	Scanner scn = new Scanner(System.in);

	@Override
	public void addStudent(Student student) {
		for (int i = 0; i < StudentList.length; i++) {
			if (StudentList[i] == null) {
				StudentList[i] = student;
				break;
			}
		}

	}

	@Override
	public Student[] StudentList() {
		return StudentList;
	}

	@Override
	public void modify(String studNo, int score) {
		int result = -1;
		for(int i=0; i<StudentList.length; i++) {
			if(StudentList[i] != null && StudentList[i].getStudNo().equals(studNo)) {
				StudentList[i].setScore(score);
				break;
			}
		}
	}
}

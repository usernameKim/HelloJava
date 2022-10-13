package com.edu;

public class CollegeStudent extends Student{
//	대학생정보 : 담당교수, 전공과목 정보 추가.
	private String professor;
	private String major;
	// 생성자.
	public CollegeStudent(String professor, String major) {
		super(studNo, studName, score);
		this.professor = professor;
		this.major = major;
	}
	// toString()

}

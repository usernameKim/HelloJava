package com.edu;

public class CollegeStudent extends Student{
//	대학생정보 : 담당교수, 전공과목 정보 추가.
	private String professor;
	private String major;
	// 생성자.
	public CollegeStudent(String studNo, String studName, int score, String professor, String major) {
		super(studNo, studName, score);
		this.professor = professor;
		this.major = major;
	}
	// toString()
	@Override
	public String toString() {
		return "담당교수 정보는 " + professor +", 전공과목은 " + major + "입니다.";
		
	}
}

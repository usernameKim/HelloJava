package com.edu;

public class HighStudent extends Student{
//	고등학생정보 : 담임교사, 학년 정보 추가.
	private String teacher;
	private String grade;
	// 생성자.
	public HighStudent() {};
	public HighStudent(String studNo, String studName, int score, String teacher, String grade) {
		super(studNo, studName, score);
		this.teacher = teacher;
		this.grade = grade;
	}
	
	// toString()
	@Override
	public String toString() {
		return "담임교사 정보는 " + teacher + ", 학년은 " + grade + "입니다."; 
	}
}

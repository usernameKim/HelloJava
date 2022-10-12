package com.edu;

public class Student {
	// 학생번호, 학생이름, 점수
	private String studNo;
	private String studName;
	private int score;

	public Student() {
	}

	public Student(String studNo, String studName, int score) {
		super();
		this.studNo = studNo;
		this.studName = studName;
		this.score = score;
	}

	public String getStudNo() {
		return studNo;
	}

	public void setStudNo(String studNo) {
		this.studNo = studNo;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [studNo=" + studNo + ", studName=" + studName + ", score=" + score + "]";
	}

}

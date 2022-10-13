package com.edu;

public interface StudentService {
	// 추가
	public void addStudent(Student student);
	
	// 목록
	public Student[] StudentList();
	
	// 수정
	public void modify(String studNo, int score);
	
	
}

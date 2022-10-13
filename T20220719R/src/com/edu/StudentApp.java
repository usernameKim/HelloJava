package com.edu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentApp {

	List<Student> list = new ArrayList<Student>();
	Scanner scn = new Scanner(System.in);

	public void execute() {
		// 추가, 목록, 수정.
		while(true) {
			System.out.println("1.추가 2.목록조회 3.수정 9.종료");
		}
	}
}

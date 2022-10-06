package co.edu.api;

import java.util.ArrayList;

public class ListExe {

	public static void main(String[] args) {
		// 컬렉션.
		//제네릭타입
		int[] intAry = new int[5];
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(new Integer(100));
		list.add(100); //기본데이터(100) 타입 -> wrapper클래스 타입으로 자동 변환.
		
		int a = 5; 
		Integer b = 10; // int => Integer. 자동박싱.
		a=b;
		//b는 integer의 클래스

	}

}

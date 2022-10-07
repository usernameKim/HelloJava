package co.edu.collect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ListExample {

	public static void main(String[] args) {
		ArrayList<String> strs = new ArrayList <String>();
		// 추가.
		strs.add("홍길동");
		strs.add("김민식");
		strs.add("박유식");
		
		strs.remove(0);
		strs.remove("박유식");
		
		strs.add(0, "최기분"); //중복 저장.
		System.out.println("collect 크기: " + strs.size());
		
		for(String str : strs) {
			System.out.println(str);
		}
		for(int i=0; i<strs.size(); i++) {
			System.out.printf("%d번째의 값은 %s\n",i,strs.get(i));
		}
		// 반복자를 생성.
		Iterator <String> itr =strs.iterator(); //컬렉션 안에는 iterator 존재.
		while(itr.hasNext()) { //가지고 올 값이 있는지 확인 있으면 true.
			String result = itr.next(); //값이 있는지 확인(다음 데이터 반환)
			System.out.println(result);
		}
		// 10만건. 저장방식의 차이
		ArrayList<Integer> inAry = new ArrayList<Integer>(); //
		long start = System.nanoTime(); //현재 시점을 나노타임으로 바꿈
		for(int i=0; i < 100000; i++) {
			inAry.add(0, i); //첫번째 자리에 붙임 i만쓰면 마지막 자리에 붙이는 것 더 빠른시간 나옴!
//			inAry.add(i);
		}
		long end = System.nanoTime();//
		System.out.println("ary: "+(end-start)); 
		
		LinkedList<Integer> lnAry = new LinkedList<Integer>();
		 start = System.nanoTime(); //현재 시점을 나노타임으로 바꿈 long 두번 선언x
		for(int i=0; i < 1000000; i++) {
			lnAry.add(0, i);
		}
		 end = System.nanoTime();//
		System.out.println("lna: "+(end-start));  // 
		
	}

}

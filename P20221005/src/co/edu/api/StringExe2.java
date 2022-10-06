package co.edu.api;

import java.io.IOException;

public class StringExe2 {

	public static void main(String[] args) {
//		System.out.println("abcDEF".toLowerCase());
//		while (true) {
//			try {
//				int bytes = System.in.read(); // 시스템에 있는 기본 입력장치를 통해 들어오는 값을 읽는 메소드.
//				if (bytes == 122) // --> z넣으면 빠져나옴
//					break;
//				System.out.println("입력값: " + bytes);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		System.out.println("end of prog");
		changeCapital("HelloWorld");
	}

	public static void changeCapital(String msg) {
		// 대문자->소문자, 소문자-대문자
		// aBcD => AbCd 97(a):65(A), 98(b):66 122(소문자범위) '32'를 빼면 대문자값, 더하면 소문자값이 나옴.
		// 소문자: 97 ~ 122, 대문자: 65 ~ 90
		String[] msgAry = msg.split("");
		for (String str : msgAry) {
			char chr = str.charAt(0);
			int chr2 =0;
			
			if (chr >= 97)
				chr2 = chr - 32;
			else if (chr <= 92)
				chr2 = chr + 32;
			
			System.out.println((char)chr2);
			
		}
//		String str = "a";
//		System.out.println((char) chr2);

	}
}

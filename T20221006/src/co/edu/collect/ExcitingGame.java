package co.edu.collect;

import java.util.Scanner;

public class ExcitingGame {

	public static void main(String[] args) {
		long gameStart = System.currentTimeMillis();
		Scanner scn = new Scanner(System.in);
		String target = "Defines JDK utility classes ";
		String[] targetAry = target.split(" ");

//		if(targetAry[0].equals("Defines")) {
//			targetAry[0] = null; //지운다는 뜻(자바에서)
//		}
		boolean run = false;
		System.out.println(target);
		while (true) {
			System.out.println("입력");
			String input = scn.nextLine();
			for (int i = 0; i < targetAry.length; i++) {
				if (targetAry[i] != null && targetAry[i].equals(input)) {
					targetAry[i] = null;
				}
			}
			run = true;

			for (String str : targetAry) {
				if (str != null) {
					System.out.printf("%s ", str);
					run = false; // null이되면 while문 -> run이 true이므로 if문으로 내려가 run실행되서 종료.
				}
			}

			long gameEnd = System.currentTimeMillis();
			long during = ((gameEnd - gameStart) / 1000); // 30*1000(30초) + 1*60*1000(1분) = 63000/60000 분, 63000%6000
															// 초=>
			if (during <= 10) {
				System.out.println("성공");
				run = true;
			} else {
				System.out.println("실패");
			}
			System.out.println(during + "초");
			if (run) {
				break;
			}
		}
	}
}
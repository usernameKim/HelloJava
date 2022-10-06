package co.edu.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StringExe {

	public static void main(String[] args) {

		String fileName = "src/co/edu/api/Birth.txt";
		File file = new File(fileName); //파일 형태로 변환

		String searchKey = "자 바";
		searchKey = searchKey.replace(" ", "");
		Scanner scn = null;
		try {
			scn = new Scanner(file);
			while (true) {
				String str = scn.nextLine();
				if (str == null)
					break;
//				if (str.indexOf(searchKey) != -1) { // -1은 없을때.
//					System.out.println(str);
//				}
				// 남자입니다. 여자입니다.
				
				str = str.replace(" ", "");
				str = str.replace("-","");
				if(str.charAt(6) == '1'|| str.charAt(6) =='3') {
					System.out.println("남자입니다.");
				}else if(str.charAt(6) == '2' || str.charAt(6) == '4'){
					System.out.println("여자입니다.");
				}
				
//				if(str.replace("-", "").charAt(6) % 2 ==1) {
//					System.out.println("남자");
//					
//				}else if((str.replace("-", "").charAt(6) & 2) ==0) {
//					System.out.println("여자");
//				}else {
//					System.out.println("잘못된 번호입니다.");
//				}
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (NoSuchElementException e) {

		}
		scn.close();
		System.out.println("end of prog");

	}

}

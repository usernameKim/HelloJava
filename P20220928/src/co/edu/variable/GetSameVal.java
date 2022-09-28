package co.edu.variable;

import java.util.Scanner; //scanner기능을 가져와서 쓰겠음
import java.lang.System; //동일 패키지내의 클래스들은 import하지 않아도 됨.

// java.lang이 베이스 패키지.

public class GetSameVal {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in); //scanner라는 클래스
		System.out.println("이름을 입력하세요>>> ");
		String name = scn.nextLine(); // 사용자입력값을 읽어들이고 반환.
		
		String[] names = {"김현지","김유리","남미주","송지은"};
		
		boolean isChecked = false;
		for(int i=0; i < names.length; i++ ) { //0<4<i++와 같음
			// "몇번째 위치에 있습니다." 출력.
			if(names[i].equals(name)) { //문자열비교는 문자열.equals(비교문자열) ==안됨
				System.out.println(( i + 1)+"번째 위치에 있습니다."); //+로 이어줌
				isChecked = true;
				break;
				
			}
		}
		if(!isChecked) {
			System.out.println("찾는 이름이 없습니다.");
		}
		System.out.println("입력값: "+name);
		scn.close();
	}
}

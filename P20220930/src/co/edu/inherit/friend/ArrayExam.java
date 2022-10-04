package co.edu.inherit.friend;

import java.util.ArrayList;

public class ArrayExam {

	public static void main(String[] args) {
		// 크기가 정해지면 변경불가.
		String[] flowers = new String[3];
		flowers[0] ="장미";
		flowers[1] ="해바라기";
		flowers[2] ="무궁화꽃";
//		flowers[3] ="목련";
		
		// flowers2 선언.
		String[] flowers2 = new String[6];
//		flowers2[0] ="장미";
//		flowers2[1] ="해바라기";
//		flowers2[2] ="무궁화꽃";
//		flowers2[3] ="목련";
		
		for(String str : flowers2) {
			if(str != null) {
				System.out.println(str);
			}
		}
		
		// 배열의 크기 고정 => 컬렉션(ArrayList);
		// Object 모든 클래스의 최상위 클래스.
		ArrayList flowers3 = new ArrayList(); // 지정안하면 크기 10개 공간생성. 인덱스 사용안해도됨.
		flowers3.add("장미"); // 첫번째 위치 장미저장. 클래스이기때문에 메소드를 씀
		flowers3.add("해바라기");
		flowers3.add("무궁화꽃");
//		flowers3.add(123); //문자열과 int타입을 같이 넣으면 오류가 날 수 있음.
		for(Object str : flowers3) {
			String result = (String) str; // 문자타입으로 불러오고 싶으니 문자열로 형변환
			System.out.println(result);
		}
		// 컬렉션의 크기 : length대신 size() 메소드 사용! 
		for(int i=0; i<flowers3.size(); i++) {
			String result = (String) flowers3.get(i); //get을 사용해서 인덱스값을 가져옴.
			System.out.println(result);
		}
	}

}

package co.edu.variable;

public class MethodCalendar {

	public static void main(String[] args) {
		makeCal(6); //호출 할거임. 
		
	}
	public static void makeCal(int month) {
		System.out.println("        >>>>" + month + "월" +   "<<<<");
		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat"};
		
		// 요일 출력.
		for(String day : days) {// day는 공간, days의 배열 요소를 반복한다는 뜻.
			System.out.printf("%4s", day); //f메소드 ->4개의 문자열을 활용해서 day를 출력
			//글자는 3개니까 공간이 하나 생김
		} 
		System.out.println(); //줄바꿔줌
		
		// 1일의 위치지정.
		for(int i=0; i<getFirstDay(month); i++) {
			System.out.printf("%4s", " ");
		}
		
		// 날짜 출력
		for(int i=1; i<=getLastDate(month); i++) { 
			System.out.printf("%4d", i); // 왼쪽으로 추가 여백이 생김(d->정수)
			if((i) %7 == (7-getFirstDay(month))) {
				System.out.println();
			}
		}
	}  //end of makeCal()
	  

	public static int getFirstDay(int month) {
		if(month == 9) {
			return 4;
		}else if(month == 8) {
			return 1;
		}else if(month ==7) {
			return 5;
		}else if(month ==6) {
			return 3;
		}
		else {
			return 0;
		}
	}// end of getFirstDay()
	
	public static int getLastDate(int month) {
		//switch..case..구문.
		switch(month) {
		case 9:
			return 30;
		case 8:
			return 31;
		case 7:
			return 31;
		case 6:
			return 30;
		default:
			return 30;
		}
		
	}
}

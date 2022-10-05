package co.edu.emp.list;

import java.util.Calendar;

public class MethodCalendar {
	private static MethodCalendar instance =  new MethodCalendar(); //생성자 호출해서 값 담아줌, 필드선언
	private MethodCalendar() {}
	public static MethodCalendar getInstance() {
		return instance;
	}
//	public static void main(String[] args) {
//		makeCal(6); //호출 할거임. 	
//	}
	
	public void makeCal(int year, int month) { // static은 메소드.makeCal -> 실현
		System.out.println("      >>>>" + year + "년 " + month + "월" +   "<<<<");
		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat"};
		
		// 요일 출력.
		for(String day : days) {// day는 공간, days의 배열 요소를 반복한다는 뜻.
			System.out.printf("%4s", day); //f메소드 ->4개의 문자열을 활용해서 day를 출력
			//글자는 3개니까 공간이 하나 생김
		} 
		System.out.println(); //줄바꿔줌
		
		// 1일의 위치지정.
		for(int i=0; i<getFirstDay(year, month); i++) {
			System.out.printf("%4s", " ");
		}
		
		// 날짜 출력
		for(int i=1; i<=getLastDate(year, month); i++) { 
			System.out.printf("%4d", i); // 왼쪽으로 추가 여백이 생김(d->정수)
			if((i+getFirstDay(year, month)) %7== 0) {
				System.out.println();
			}
		}
	}  //end of makeCal()
	  

	public int getFirstDay(int year, int month) { //공간만든 것
		Calendar cal = Calendar.getInstance();
		cal.set(year, month -1, 1); 
		return cal.get(Calendar.DAY_OF_WEEK) -1; // 1부터 시작, 1빼면 원래기능대로
		
//		if(month == 9) {
//			return 4;
//		}else if(month == 8) {
//			return 1;
//		}else if(month ==7) {
//			return 5;
//		}else if(month ==6) {
//			return 3;
//		}
//		else {
//			return 0;
//		}
	}// end of getFirstDay()
	
	public int getLastDate(int year, int month) {
		//switch..case..구문.
		Calendar cal = Calendar.getInstance();
		cal.set(year, month -1, 1); 
		return cal.getActualMaximum(Calendar.DATE);
		
//		switch(month) {
//		case 9:
//			return 30;
//		case 8:
//			return 31;
//		case 7:
//			return 31;
//		case 6:
//			return 30;
//		default:
//			return 30;
//		}
		
	}
}

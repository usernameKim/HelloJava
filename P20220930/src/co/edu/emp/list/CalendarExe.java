package co.edu.emp.list;

import java.util.Calendar;

public class CalendarExe {

	public static void main(String[] args) {
//		Calendar today = new Calendar(); -> 오류. 새롭게 생성자 호출 불가
		Calendar today = Calendar.getInstance();
		today.set(2020, 1, 1); // 2022년 10월 1일
		System.out.println("요일정보: "+ today.get(Calendar.DAY_OF_WEEK));
		System.out.println("날짜정보: "+ today.get(Calendar.DATE));
		System.out.println("월정보: "+ (today.get(Calendar.MONTH) + 1)); //보기 편하게 1더함
		System.out.println("월말정보: "+ today.getActualMaximum(Calendar.DATE));
	}

}

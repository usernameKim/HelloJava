package co.edu.variable;

public class MethodExample {
	// 가로, 세로 =>  
	public static int getArea(int w, int h) {
		int width = w * h;
		return width;
	}
	
	// 배열요소의 각 값의 합. ary는 배열이 들어오는 곳. 이름은 상관 없음.
	public static int sumAry(int[] ary) {
		int sum =0;
		for(int i=0; i < ary.length; i++) {
			sum = sum + ary[i];
			}
			return sum;
	}
	
	// 두 수의 나눈 결과를 반환하는 메소드.
	public static double divide(double n1, double n2) {
		double result = n1 / n2;
		return result;
	}
	
	// 두 수를 나누는 작업. 매개변수를 int 지정.
	public static double divide(int n1, int n2) {
		// 1bit* 8= 1byte.
		// 유형: byte(1바이트), short(2), int(4), long(8)
		//	  : float(4), double(8)
		if(n2 == 0) {
			return 0; //infinity 안나오게 값 지정
		} 
		double result = (double) n1 / n2; // 3.0 /2.0 => 1.5 하나만 변환해도 ok
		// 캐스팅 : 직접 강제 형변환 , 프로모션?
		//3 /2 => 1.5 .5를 표현하지 못함(int) 그래서 1을 double타입으로 보여줌.
		return result; // 1.0이 나옴. 즉, 동일한 타입의 형태로만 연산 가능함!
		// n2이 long형태면 자동으로 n1도 long형태로 계산 -> 자동 형변환
	}
	
	public static void main(String[] args) {
		int result = getArea(20, 15);
		System.out.println("전체 너비는 " + result);
		
		int[] intAry = {23, 45, 12};
		result = sumAry(intAry);
		System.out.println("전체 배열요소의 합계는 " + result);
		
//		int sum = 0;
//		for(int i =0; i<intAry.length; i++) {
//			sum = sum + intAry[i];
//		}
	
		// 실수. float, double
		double d1 = 23.4567;
		double d2 = 12.34;
		double d3 = d1 + d2; //타입 맞게 써주기.
		
		d3 = divide(d1, d2);
		System.out.println("나눈 결과는 " + d3);
		
		d3 = divide(3,0); //ctrl +click 0으로 나누면 infinity
		System.out.println("나눈 결과는 " + d3);
		
	}
}

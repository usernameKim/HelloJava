package co.edu.variable;

public class MethodExe {
	
	// main 메소드: 첫번째 실행.
	public static void main(String[] args) { //void->반환(return)값이 없다는 뜻 String~ ->매개변수
//		printStar();
//		printStar(3); // 실행부분은 
//		printCircle("※");
//		printCircle("♥", 5); //값이 들어와야함 (int 쓰면 x)
		int result = sum(sum(2, 3), sum(3, 4));
		System.out.println("최종값은 "+ result);
	}
	
	public static void printStar() { // 반환값: 없음. 매개변수: 없음.
		System.out.println("☆");
	}
		
	public static void printStar(int times) {
		for(int i =0; i < times; i++) {
			System.out.println("★");
		}
	}
	
	public static void printCircle(String circle) {
		System.out.println(circle);
	}
	// 출력하는 모양, 개수
	public static void printCircle(String circle, int times) {
		for(int i =0; i < times; i++) {
			System.out.println(circle);
		}
	}
	
	// 반환값을 가지는 메소드. int ->sum호출, return 써주기
	public static int sum(int n1, int n2) {
		int result = n1 * 2 + n2 * 3;
		System.out.println("결과값은 " + result);
		return result; // 반환값의 유형은 int
	}
}


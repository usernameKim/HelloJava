package co.edu.nested;

// 익명 구현 객체.
// 추상메소드가 하나만 존재(구현할넘이 하나면)하는 인터페이스 => Functional 인터페이스.
interface MyInterface {
	void run();
//	void walk();
}

interface MyInterface2 {
	void run(String kind);
	
}

interface MyInterface3 {
	int sum(int num1, int num2);
}
public class AnonymousExample3 {
	public static void main(String[] args) {

		// 람다표현식(복잡한 코드를 간결하게쓰는것)
		MyInterface inft = () -> System.out.println("MyInterface Run.");
		inft.run();
		// 매개값을 받아 밑에 문장 구현(추상메소드 하나니까 메소드 이름 안써줘도됨). 블럭도 노필요

		MyInterface2 intf2 = kind -> System.out.println(kind + " Run.");
		intf2.run("농구종목");
		
		MyInterface3 intf3 = (num1, num2)  -> num1 * 2 + num2;
		int result = intf3.sum(10, 20);
		
		intf3 = (num1, num2) -> num1 * 2 + num2 * 3;
		result = intf3.sum(11,22);
 	}
}

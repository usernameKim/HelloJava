package co.edu.inherit;

public class MainApp {
	public static void main(String[] args) {
		Child child = new Child(); // field1, method1()
		child.method(); // Parent의 메소드.
		child.method1(); // Child의 메소드.
		
		Child2 child2 = new Child2();
//		child2.method(); 상속 안받으면 오류남
		child2.method2(); // Child2의 메소드.
		
		Parent c1 = new Parent(); //타입은 서로 같아야함.
		c1 = new Child(); // 부모클래스의 변수에 자식인스턴스 대입가능.
		c1 = new Child2(); //자동형변환(자식인스턴스 -> 부모인스턴스)
		
//		c1.method2(); 오류. 부모클래스의 멤버(메소드)들만 호출 가능하기 때문. 클래스는 대입가능

		if(c1 instanceof Child2) {
			Child2 c2 = (Child2) c1; // c2의 인스턴스로 변환 가능, 강제형변환(casting)
			c2.method2(); //호출가능하게됨.
		}
	
		Parent c3 = new Parent(); //parent라는 클래스가 담김 
		if(c3 instanceof Child2) { // instance가 맞는지 확인해야함.
			Child2 c4 = (Child2) c3; // casting작업. 참이 아니니 실행은 안됨.
			c4.method2(); 
		}
	}
}// 생성자와 메소드가 모두 호출됨. 공통 부분 -> 부모, 개별 -> 자식


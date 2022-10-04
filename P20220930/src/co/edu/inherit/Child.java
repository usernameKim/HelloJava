package co.edu.inherit;

public class Child extends Parent{
	String field1;
	Child(){
		super("args"); //부모클래스의 생성자 호출. args를 넣으면 매개값있는 생성자 호출됨.
		System.out.println("Child() call.");
	}
	void method1() {
		System.out.println("method1() call.");
	}
	// 부모클래스의 메소드를 재정의. overriding. 매개값, 리소드 이름, 리턴타입이 같아야함.
	@Override // 어노테이션: 부모클래스의 메소드(반환값, 메소드의 이름, 매개값)와 같은지 체크.
	void method() {
		System.out.println("Child method() call."); // 재정의(부모요소를 가져다 쓸 수도 있음)
	}
	@Override //toString메소드를 오버라이딩 -> 기본적으로 object를 상속받기 때문
	public String toString() {
		return "Child [field1=" + field1 + "]";
	}
} 



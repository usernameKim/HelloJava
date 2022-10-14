package co.edu.nested;

class Person{   //안에 있는 것들은 클래스의 멤버들임
	// 필드.
	String name;
	int age;
	// 생성자.
	Person(){}
	// 메소드.
	void showInfo() {
		// 로컬 클래스
		class Local{
			
			void show() {
				System.out.println("show");
			}
		}
		Local local = new Local();
		local.show();
	}
	// 중첩클래스 = Inner 클래스(인스턴스)
	class Car {
		String carName;
		
		void run() {
			System.out.println("run");
		}
	}
	// Inner 클래스(정적)
	static class Calculator {
		void add() {
			System.out.println("add");
		}
	}
	class Run implements Runnable{

		@Override
		public void run() {
			System.out.println("run 구현.");
			
		}
		
	}
	
	// Inner 인터페이스.
	interface Runnable{
		void run();
	}
}

public class NestedExample {
	public static void main(String[] args) {
		Person p = new Person();
		
		// 인스턴스 멤버 클래스.
		Person.Car car = p.new Car(); // 내부클래스 호출. 인스턴스 생성.
		car.run();
		
		// 정적 멤버 클래스.
		Person.Calculator cal = new Person.Calculator();
		cal.add();
		
		p.showInfo(); // 로컬 클래스.
	}
}

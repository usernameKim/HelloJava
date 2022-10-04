package co.edu.inherit.friend;

public class Cat extends Animal{ 
	
	//자식메소드에서 Animal클래스의 추상메소드를 반드시 구현.
	@Override
	public void eat() {
		System.out.println("고양이가 먹이를 먹습니다.");
		
	}

	@Override
	public void speak() {
		System.out.println("야옹야옹.");
	}

}

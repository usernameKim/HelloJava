package co.edu.api;

import java.util.HashSet;
import java.util.Set;

class Student { // object 상속
	String name;
	int age;

	// Set 컬렉션: 동일한 인스턴스는 담아주지않는 컬렉션.
	@Override
		public int hashCode() { //객체가 가진 주소값을 16진수로 리턴.
//			return super.hashCode(); //부모가 가지고 있는 해쉬코드 반환
			return age; //나이를 기준으로 
		}
	@Override //Ctrl space -> tostring
		public String toString() { //toString 메소드 실행
			return "학생의 이름은 " + name + ", 나이는" + age + "입니다.";
		}
	
	@Override // ctrl + space 하기, 자식클래스가 재정의하는 것.
	public boolean equals(Object obj) {
		if (! (obj instanceof Student)) {
			return false;
		}
			Student str = (Student) obj; //강제형변환(casting)

//			return super.equals(obj);
			if (this.name.equals(str.name) && this.age == str.age)
				return true;

			return false;
		}
	}


// 모든 클래스의 최상위 Object.
public class ObjectExe {
	public static void main(String[] args) {
		Object obj = new Object();
		Object obj2 = new Object();

		System.out.println(obj.equals(obj2)); // obj == obj2

		Student s1 = new Student();
		s1.name = "Hong";
		s1.age = 10;
		Student s2 = new Student();
		s2.name = "Hong";
		s2.age = 10; // 나이가 달라도 이름만 비교하니 true가 나옴.
		String s3 = "Hong";

//		System.out.println(s1.equals(s3));
		System.out.println(s1.toString());
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		// Set 컬렉션: 인터페이스 -> 구현클래스 통해서 인스턴스 생성. set은 담기만 함
		Set<Integer> set = new HashSet<Integer>();  //integer타입만 담을 수 있음
		set.add(new Integer(100));
		set.add(new Integer(110));
		set.add(new Integer(100));
		
		System.out.println("컬렉션의 크기: "+set.size()); //100은 동일한 범위므로 ->2가 나옴
			
		// Set 컬렉션에 Student 인스턴스 저장시 논리적으로 동일한 인스턴스 판단
		// hashCode(), equals() => 기준.
		Set<Student> students = new HashSet<Student>(); //student의 인스턴스를 담음
		students.add(s1);
		students.add(s2); //s1과 s2가 동일한 인스턴스 입니다. -> 1
		System.out.println("컬렉션의 크기: "+students.size());
	}
}

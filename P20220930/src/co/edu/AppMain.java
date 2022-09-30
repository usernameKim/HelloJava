package co.edu;

// 하나의 실행 클래스와 여러개의 라이브러리클래스.(Person)
public class AppMain {
	public static void main(String[] args) {
		// Object -> Class -> Instance
		Person kim = new Person(); // 인스턴스 생성 person의 주소값이 kim에 담김
		kim.name = "김민기";
		kim.age = 20;
		kim.sleep();
		kim.eat("사과");
		
		Person lee = new Person();
		lee.name = "이순신";
		lee.age = 25;
		lee.sleep();
		lee.eat("피자");
		
		Student stud1 = new Student();
//		stud1.setStudNo() = "123-123"; 안됩니다.
		stud1.setStudNo("123-123");
//		stud1.studName = "김경미";
		stud1.setStudname("김경미");
//		stud1.age =29;
//		stud1.major = "education";
//		stud1.studNo =13;
//		stud1.study();
//		stud1.sleep();
//		stud1.gaming();
//		
		Student stud2 = new Student();
		stud2.setStudNo("123-123");
//		stud2.studName = "김연경";
//		stud2.StudNo = 10;
		stud2.setStudname("김경미");
		Student stud3 = new Student();
		
		Student[] students;
		students = new Student[] {stud1, stud2, stud3};
		for(Student stud: students) {
			System.out.println("학번: "+stud.getStudNo() + ",학생이름: "+ stud.getStudName());
		}
		
//		System.out.println(stud1.name);
		
		//상속.
		WorkMan wman = new WorkMan();
		wman.name ="직장인";
		wman.age = 30;
	
		StudMan sman = new StudMan();
		sman.school = "고등학교";
		sman.height = 164.3;
		
		
	}
}

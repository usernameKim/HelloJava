package co.edu.api;

class Student { //object 상속
	String name; 
	int age;
	
	@Override //ctrl + space 하기
		public boolean equals(Object obj) {
			
			return super.equals(obj);
		}
}
public class ObjectExe {
	public static void main(String[] args) {
		Object obj = new Object();
		Object obj2 = new Object();
		
		System.out.println(obj.equals(obj2)); // obj == obj2
		
		Student s1 = new Student();
		Student s2 = new Student();
		
		System.out.println(s1.equals(s2));
	}
}

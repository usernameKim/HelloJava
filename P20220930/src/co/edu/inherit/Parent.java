package co.edu.inherit;

public class Parent extends Object //기본적으로 오브젝트를 상속받음. 제일 상위에 존재.
{
	String field;
	Parent(){
		System.out.println("Parent() call");
	} // 기본생성자를 적어줘야 super 사용 가능
	Parent(String args){ //매개변수에 값을 적어주면 기본생성자는 없다는 뜻.
		System.out.println("Parent(String args) call");
	}
	void method() {
		System.out.println("Parent method() call.");
	}
	@Override
	public String toString() {
		return "Parent [field=" + field + "]";
	}
}

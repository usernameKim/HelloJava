package co.edu.inherit.friend;

public class Friend { //오브젝트 상속받음.
	private String name;
	private String phone;
	
	public Friend() {} // 기본생성자 정의.
	public Friend(String name, String phone) {
		super(); //오브젝트 생성자를 호출. 지워도 상관 x
		this.name = name;
		this.phone = phone;
	}
	
	public void setName(String name) { //default 접근 제한자는 다른 패키지에서 사용불가.
		this.name = name;				// protected는 다른 패키지에서 상속관계만 접근 허용.
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return this.name;
	}
	public String getPhone() {
		return this.phone;
	}
	public String showInfo() {
		return "친구의 이름은 " + name + ", 연락처는 " + phone;
	}
}
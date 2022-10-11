package co.edu.friend;

public class UniFriend extends Friend {
	// 친구이름, 연락처 (상속) + 학교정보, 전공정보 (추가)
	private String college;
	private String major;

	// 필요한 생성자를 작성.
	public UniFriend(String name, String phoneNumber, String college, String major) {
		super(name, phoneNumber);
		this.college = college;
		this.major = major;
	}
	// get, set 메소드 작성.

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	// Friend클래스의 getInfo() 를 overriding 하세요.
	@Override
	public String getInfo() {
		return "학교친구의 이름은 " + getName() // private 속성이라 메소드 써줘서 불러야함.
		+ ", 연락처는 " + getPhoneNumber() //
		+ ", 학교명은 " + this.college //
		+ ", 전공은 " + this.major;
		
	}

}

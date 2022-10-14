package co.edu.io;

public class Member {
	private String id;
	private String name;
	private int point;
	
	public Member() {}
	public Member(String id, String name, int point ) {
		this.id =id;
		this.name =name;
		this.point=point;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	@Override
	public String toString() {
		return "회원아이디: " + id + "회원이름" + name + "회원포인트" + point;
	}
}

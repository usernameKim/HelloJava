package dev;

public class Student {
	private int studNo;
	private String studName;
	private int score;
	
	Student(int stuNo, String studName, int score){
		this.studNo = studNo;
		this.studName = studName;
		this.score = score;
	}
	
	public void setStudNo(int studNo) {  //값을 담아주고 싶어서 메소드들을 만듬
		this.studNo = studNo;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public void setScore(int score) {
		this.score =score;
	}
	
	public int getStudNo() { //매개값이 없어도됨
		return studNo;
	}
	public String getStudName() {
		return studName;
	}
	public int getScore() {
		return score;
	}
}

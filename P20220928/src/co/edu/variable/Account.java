package co.edu.variable;

public class Account {
	private String accNo; // 계좌번호. 두단어의 조합: 2번째 첫번째 대문자. employeeId
	private String owner; // 예금주.
	private int balance; // 예금액.
	
	// setter, getter 정의
	
	void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	String getAccNo() {
		return this.accNo;
	}
	
	void setOwner(String owner) {
		this.owner = owner;
	}
	String getOwner() {
		return this.owner;
	}
	void setBalance(int balance) {
		this.balance = balance;
	}
	int getBalance() {
		return this.balance;
	}
}

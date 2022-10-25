package co.edu.vo;

import lombok.Data;

@Data //생성자,get,set메소드 만들어줌
public class EmployeeVO {
	private int employeeId;
	private String firstName;
	private String email;
}

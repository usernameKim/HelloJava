package co.edu.jdbc;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EmpDbToFile {
	public static void main(String[] args) {

		try {
			FileWriter fw = new FileWriter("C:/Temp/empList.txt");
			EmployeeDAO dao = new EmployeeDAO();
			List<Employee> list = dao.search(); // 값을 가져옴
			
			for(Employee emp : list) {
//				emp.getEmployeeId();
				fw.write(emp.getEmployeeId() +" "+ emp.getLastName() + " " +emp.getEmail() +" "+ emp.getHireDate() +" "+ emp.getJobId()+ " \n");
			}
			
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("completed");
		
	}
}

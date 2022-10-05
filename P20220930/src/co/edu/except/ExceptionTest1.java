package co.edu.except;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest1 {
	public static void main(String[] args) {
		// null pointer 참조.
		String str = "Hello World!!";
		// 예외처리. RuntimeException 상속받아서 처리하는 예외클래스.
		try {
		String result = str.substring(0, 10); //자름, 구문상 오류는 없음
		char chr = result.charAt(22);
		System.out.println(chr);
		} catch(NullPointerException e){ //nullpointerexception이 발생하면 밑 구문 출력, runtime클래스 상속받음. 실행을해봐야 알수 있음. 
			System.out.println("참조하는 값이 없습니다.");
		} catch(StringIndexOutOfBoundsException e1) {
			System.out.println("인덱스범위를 벗어난 값입니다.");
		} catch(RuntimeException e2) {	
			System.out.println("실행예외가 발생했습니다."); //다중 catch 
		} catch(Exception e3) {	//제일 상위의 예외. 순서를 지켜 작성.
			System.out.println("알수 없는 예외가 발생했습니다.");
		}
//		catch(NullPointerException | StringIndexOutOfBoundsException e) 도 가능
		
		Scanner scn = new Scanner(System.in); 
	while(true) {
		System.out.println("숫자입력>>>");
		
		try {
			int menu = scn.nextInt(); // InputMismatchException
			System.out.println("입력값은 : " + menu);
			break;
		} catch(InputMismatchException e) {
			System.out.println("숫자를 입력하세요!");
			scn.nextLine(); //abc (Enter)
			}finally {
				System.out.println("반드시 실행할 코드."); //정상실행되도 출력
				// db connection 사용하고 resource 반환.
			}
		
		} try {
			exceptMethod();
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("프로그램 종료.");
	} // end of main()

	public static void exceptMethod() throws ClassNotFoundException {
	// 일반예외 : Exception 상속받아서 처리하는 예외클래스.
//			try {
				Class.forName("java.lang.String");
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
	}
}
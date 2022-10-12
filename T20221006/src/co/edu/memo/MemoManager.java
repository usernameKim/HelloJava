package co.edu.memo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemoManager { // 실제 조회,입력,삭제 기능 입력

	List<Memo> memoStorage = new ArrayList<>(); // 정보(Memo인스턴스)담아놓기위한 컬렉션
	File file = new File("C:/Temp/memobook.dat"); // 읽고 쓰기 위해 만든 객체
	Scanner scn = new Scanner(System.in);

	// 싱글톤
	private static MemoManager instance = new MemoManager();

	private MemoManager() {
		readFromFile();

	}

	public static MemoManager getInstance() {
		return instance;
	}

	// 추가.
	public void inputData() {
		System.out.println("번호> ");
		int no = Integer.parseInt(scn.nextLine());
		System.out.println("날짜> ");
		String date = scn.nextLine();
		System.out.println("내용> ");
		String content = scn.nextLine();

		memoStorage.add(new Memo(no, date, content));

	}

	// 조회(날짜) -> 출력
	public void searchData() {
		System.out.println("날짜> ");
		String sDate = scn.nextLine();
		boolean exists = false;
		for (int i = 0; i < memoStorage.size(); i++) {
			if (sDate.equals(memoStorage.get(i).getDate())) { // get(i) ->하나만 리턴
				System.out.println(memoStorage.get(i).toString()); // 전체출력.
				exists = true;
			}
		}if(!exists) {
			System.out.println("해당날짜의 메모가 없습니다.");
		}
	}
	
	// 번호를 입력하면 한건 삭제.
	public void deleteData() {
		System.out.println("번호 입력>");
		int num = Integer.parseInt(scn.nextLine());
		boolean exists = false;
		for(int i=0; i< memoStorage.size(); i++) {
			if(num == (memoStorage.get(i).getNo()));
				memoStorage.remove(i);
				System.out.println("삭제되었습니다.");
				exists = true;
		}
	}
	// 파일을 읽어서 데이터 memoStorage에 담는 기능.
	public void readFromFile() {
		// try with resource.
		try( FileInputStream fis = new FileInputStream(file); // 데이터를 읽기 위한 스트림 객체 생성
			 ObjectInputStream ois = new ObjectInputStream(fis); //
				){									// 바이트 배열을 다시 객체로 복원
			
			
			memoStorage = (List<Memo>) ois.readObject(); 
			
		}catch(Exception e) {
//			e.printStackTrace();
			return;
		}
	}
	
	// 종료하면 파일저장.
	public void storeToFile() {
		try( FileOutputStream fos = new FileOutputStream(file);  //파일에 저장하기 위해 파일 출력 스트림 객체 생성
			ObjectOutputStream oos = new ObjectOutputStream(fos) //컬렉션타입, 객체를 읽기 위해 써줌, 객체를 파일에 출력하기 위한 스트림 객체 생성
			){									 // 파일저장(객체 -> 바이트) : 직렬화
			oos.writeObject(memoStorage);
		}catch(Exception e) {
			e.printStackTrace(); 
		}
	}
}

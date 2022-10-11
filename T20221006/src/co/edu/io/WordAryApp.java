package co.edu.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordAryApp {
	public static void main(String[] args) throws Exception {
		// 임의 문장을 10개씩 출력하고 타이핑해서 맞으면 사라지고 ...
		Scanner scn = new Scanner(System.in);
		ArrayList<String> words = randomWords(10); // ArrayList<String>형식 10개 출력
		for (String word : words) {
			System.out.println(word); // return -> null예외 나오므로 주석
		}
		String inputVal = scn.nextLine();
		// 하나씩 찾아서 지우기.
//		if (words.get(i).equals(inputVal)) {
//			words.remove(i);
//		}
//		if (words.isEmpty()) {
//			break;
//		}

	}

	public static ArrayList<String> randomWords(int times) throws Exception {
		// ArratList<String> 전체 문장을 담고..
		ArrayList<String> words = new ArrayList<String>(); // 변수 선언
		String path = "src/co/edu/io/wordAry.txt"; // 경로일뿐
		File file = new File(path);// 경로를 생성자로 해서 파일객체 만듦
		Scanner scn = new Scanner(file);

		while (scn.hasNext()) { // 건수가 있으면 계속 출력
			String readStr = scn.nextLine();
			readStr = readStr.replaceAll("\"", "").trim(); // "", 공백제거
//			System.out.println(readStr);
			words.add(readStr.substring(0, readStr.indexOf(","))); // ,가 있는 인덱스값
		}
		// 임의의 개수times 개수만큼을 반환하도록.
		ArrayList<String> randomWords = new ArrayList<String>(); // 컬렉션
		// --> CODE HERE...

		// 중복된 값을 제거하기 위해서 Set컬렉션을 사용하여 저장.
		Set<Integer> idxSet = new HashSet<>();
		while (idxSet.size() < times) {
			idxSet.add((int) (Math.random() * words.size()));
		}
		for (int i = 0; i < idxSet.size(); i++) {
			randomWords.add(words.get(i));
		}

//		for(int i=0; i<times; i++) {
//			int random = (int) (Math.random()* 494); //495반환.
//			randomWords.add(words.get(random));
//		}
//	
		scn.close();
		return randomWords;
	}
}

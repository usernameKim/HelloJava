package co.edu.collect;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapExeample {

	public static void main(String[] args) {
		// key:Integer, val:String
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(100, "홍길동");
		map.put(200, "김기영");
		map.put(300, "박문식");
		map.put(300, "윤문식"); // 같은 key값이 있으면 박문식 사라지고 윤문식 들어감

		map.remove(300); // 삭제.

		System.out.println("컬렉션: " + map.size());

		System.out.println("val: " + map.get(300)); // 300 value를 리턴

		// 반복자 생성.
		Set<Integer> KeySet = map.keySet(); // 키만 새로운 set컬렉션에 저장.
		for (Integer key : KeySet) {
			System.out.println("키: " + key + ", 값: " + map.get(key));
		}
		Set<Entry<Integer, String>> entSet = map.entrySet(); // 키와 값을 담고 있는 타입의 클래스를 set컬렉션에 담음
		for(Entry<Integer, String> ent : entSet) {
			System.out.println("키: "+ ent.getKey() + ", 값: "+ ent.getValue());
			
		}
		
	}

}

package co.edu.inherit.friend;

import java.util.ArrayList;
import java.util.Scanner;

public class FriendExe {
	Scanner scn = new Scanner(System.in);
//	Friend[] friends = new Friend[10];
	ArrayList friends = new ArrayList();
	
	// 친구등록 - 학교/회사/친구...
	public void exe() {
		
		while(true) {
			System.out.println("1.친구등록 2.친구조회 3.종료");
			System.out.println("선택>> ");
			
			int menu = scn.nextInt(); scn.nextLine(); 
			if(menu ==1) {
				System.out.println("1.회사친구 2.학교친구 3.친구");
				int subMenu = scn.nextInt(); scn.nextLine(); 
				if(subMenu==1) {
					addComFriend(); //return 없음.
				}else if(subMenu==2) {
					addUnivFriend();
				}else if(subMenu==3) {
					addFriend();
				}
			}else if(menu ==2) {
				searchFriend();
			}else if(menu ==3) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}else {
				System.out.println("잘못된 메뉴를 선택했습니다.");
			}
		}
		System.out.println("프로그램 종료.");
	} // end of exe()
	
	// 추가메소드 정의.
	public void addComFriend() {
		System.out.println("회사친구 이름을 입력하세요.");
		String name = scn.nextLine();
		System.out.println("회사친구 연락처를 입력하세요.");
		String number = scn.nextLine();
		System.out.println("회사명을 입력하세요.");
		String companyName = scn.nextLine();
		System.out.println("부서명을 입력하세요.");
		String deptName = scn.nextLine();
		
		ComFriend friend = new ComFriend();
		friend.setName(name);
		friend.setPhone(number);
		friend.setCompany(companyName);
		friend.setDept(deptName);
//		
//		for(int i=0; i<friends.length; i++) {
//			if(friends[i] == null) {
//				friends[i] = friend;
				
		friends.add(friend);
		
	
		
		System.out.println("회사친구가 등록되었습니다.");
	}
	
	public void addUnivFriend() {
		System.out.println("대학친구 이름을 입력하세요.");
		String univfName = scn.nextLine();
		System.out.println("대학친구 연락처를 입력하세요.");
		String univNumber = scn.nextLine();
		System.out.println("대학명을 입력하세요.");
		String univName = scn.nextLine();
		System.out.println("전공명을 입력하세요.");
		String majorName = scn.nextLine();
		
		UnivFriend univfriend = new UnivFriend(univfName, univNumber, univName, majorName);
		
		friends.add(univfriend);
		
//		for(int i=0; i<friends.length; i++) {
//			if(friends[i] == null) {
//				friends[i] = univfriend;
//				break;
//			}
//		} 
		System.out.println("대학친구가 등록되었습니다.");
		
	}	
	public void addFriend() {
		System.out.println("친구 이름을 입력하세요.");
		String newfName = scn.nextLine();
		System.out.println("친구 연락처를 입력하세요.");
		String newfNumber = scn.nextLine();
		
		Friend newfriend = new Friend(newfName, newfNumber); //매개변수에 name, phone 써도 됨.
		
		
		friends.add(newfriend); // 비워져있는 위치에 한건 등록.
//			newfriend.setName(newfName);
//			newfriend.setPhone(newfNumber);
//			
//		for(int i=0; i<friends.length; i++) {
//			if(friends[i] == null) {
//				friends[i] = newfriend;
//				break;
//			}
//		}
		System.out.println("친구가 등록되었습니다.");
	}
	public void searchFriend() {
		// 권수미, 권미현, 강민기 => 자바 문자열 포함
		System.out.println("조회할 친구이름을 입력하세요.");
		String sfriend = scn.nextLine(); //"미"
//		for(int i=0; i<friends.length; i++) {
//			if(friends[i] != null && friends[i].getName().contains(sfriend)); 
//			System.out.println(friends[i].showInfo());
//			break; //equal대신 쓰면 이름 하나만 입력해도 서치가능.
		
		for(int i=0; i<friends.size(); i++) {
			// Friend 클래스의 상속. Friend, ComFriend, UnivFriend의 인스턴스가 담겨져 있음.
			Object frnd = friends.get(i); //Object 타입을 가져옴.
			if(frnd instanceof Friend) { // frnd 변수의 타입이 어떤 유형의 클래스인지..
				Friend friend = (Friend) frnd;
				System.out.println(friend.showInfo()); //타입에 맞는 friend의 showInfo를 불러옴.
				
			}else if(frnd instanceof ComFriend) {
				ComFriend friend = (ComFriend) frnd;
				System.out.println(friend.showInfo());
				
			}else if(frnd instanceof UnivFriend) {
				UnivFriend friend = (UnivFriend) frnd;
				System.out.println(friend.showInfo());
			}
			
		}
	}
	
}
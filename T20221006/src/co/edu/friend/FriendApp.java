package co.edu.friend;

import java.util.Scanner;

public class FriendApp {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		FriendService service = FriendListImpl.getInstance(); // FriendListImpl 인스턴스 생성.

		while (true) {
			System.out.println("1.추가 2.리스트 3.수정 4.삭제 9.종료");
			System.out.print("선택>> ");
			
			int menu = scn.nextInt();
			if (menu == 1) { //
				Friend friend = null;
				
				int subMenu = scn.nextInt();
				scn.nextLine();
				System.out.println("이름>>");
				String name = scn.nextLine();
				System.out.println("연락처>>");
				String number = scn.nextLine();
				if (subMenu == 1) {
					// 학교친구정보등록
					
					System.out.println("대학명을 입력하세요.");
					String uniName = scn.nextLine();
					System.out.println("전공명을 입력하세요.");
					String majName = scn.nextLine();

					friend = new UniFriend(name, number, uniName, majName);
					System.out.println("대학친구가 등록되었습니다.");

				} else if (subMenu == 2) {
					// 회사친구등록
					
					System.out.println("회사명을 입력하세요.");
					String colName = scn.nextLine();
					System.out.println("부서명을 입력하세요.");
					String depName = scn.nextLine();

					friend = new CoFriend(name, number, colName, depName);
					System.out.println("회사친구가 등록되었습니다.");

				} else {
					// 친구정보등록
				
					System.out.println("친구가 등록되었습니다.");
					friend = new Friend(name, number);

				}
				service.addFriend(friend);

			} else if (menu == 2) {
				Friend[] list = service.friendList();
				// 친구의 정보를 출력하는데 getInfo()를 사용해서 출력. for사용.
				for (int i = 0; i < list.length; i++) {
					if (list[i] != null) {
						System.out.println(list[i].getInfo());
						
					}
				}
			} else if (menu == 3) {
				System.out.println("변경할 친구이름입력>> ");
				String name = scn.nextLine();
				System.out.println("변경할 연락처 입력>> ");
				String number = scn.nextLine();

				service.modFriend(name, number);

			} else if (menu == 4) {
				System.out.println("삭제할 친구의 연락처를 입력>> ");
				String phoneNo = scn.nextLine();

				service.delFriend(phoneNo); // phoneNo를 매개값으로 사용하도록 관련된 인터페이스와 클래스를 수정. /실행시에는 값만 넣기(String x)

			} else if (menu == 9) {
				System.out.println("프로그램을 종료합니다.");
				break;

			} else {
				System.out.println("잘못된 메뉴입니다.");
			}

		}
		System.out.println("프로그램 종료.");
		scn.close();
	}
}

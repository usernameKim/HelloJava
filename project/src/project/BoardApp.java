package project;

import java.util.Scanner;

public class BoardApp {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		BoardDAO dao = new BoardDAO();
		Board brd = new Board();
		String logid = null;
		Reply reply = new Reply();

		while (true) {
			System.out.println("아이디를 입력하세요.");
			String id = scn.nextLine();
			System.out.println("비밀번호를 입력하세요");
			String pwd = scn.nextLine();

			if (dao.login(id, pwd)) {
				System.out.println("로그인 되었습니다.");
				logid = id;
				break;
			} else
				System.out.println("다시 로그인하세요.");
			continue;
		}
		while (true) {
			System.out.println("<< 00수업 대나무숲	>>");
			System.out.println("1.게시글작성 2.수정 3.삭제 4.조회 5.상세조회 9.종료");
			System.out.println("숫자를 입력하세요>> ");

			int menu = scn.nextInt(); scn.nextLine();
			if (menu == 1) {
				System.out.println("게시글 작성란.");
				int subMenu = scn.nextInt();
				scn.nextLine();
				
					System.out.println("글번호 입력>>");
					int number = Integer.parseInt(scn.nextLine());
					System.out.println("글제목 입력>>");
					String title = scn.nextLine();
					System.out.println("글내용 입력>>");
					String content = scn.nextLine();
					String writer = logid;

					brd = new Board(number, title, content, writer);
					System.out.println("글작성 완료.");
					dao.input(brd);
				 
			} else if (menu == 2) {
				System.out.println("무엇을 수정할까요?>> ");
				int subMenu = Integer.parseInt(scn.nextLine());
				if(subMenu ==1) {
					System.out.println("수정할 글번호 입력>> ");
					int number = Integer.parseInt(scn.nextLine());
					System.out.println("수정할 글내용 입력>> ");
					String content = scn.nextLine();
					brd = new Board(number, content);
					
					dao.update(brd);
				}else if(subMenu ==2) {
				    System.out.println("수정할 댓글번호 입력>> ");
				    int reNumber = Integer.parseInt(scn.nextLine());
					System.out.println("수정할 댓글내용 입력>> ");
					String reContent = scn.nextLine();
					
					reply = new Reply(reNumber, reContent);
					dao.updateRep(reply);
				}

			} else if (menu == 3) {
				dao.delete();
			} else if (menu == 4) {
				
			} else if (menu == 5) {
				//글 상세조회
				System.out.println("상세조회할 글번호 입력>> ");
				int number = Integer.parseInt(scn.nextLine());
				System.out.println(dao.directBrd(number));
				
				//댓글 상세조회
				System.out.println("상세조회할 댓글번호 입력>> ");
				int reNumber = Integer.parseInt(scn.nextLine());
				System.out.println(dao.directRep(reNumber));
				
				//댓글 작성하기
				System.out.println("댓글번호 입력>>");
				int reNumber = Integer.parseInt(scn.nextLine());
				System.out.println("댓글내용 입력>>");
				String reContent = scn.nextLine();
				String reWriter = logid;

				reply = new Reply(reNumber, reContent, reWriter);
				System.out.println("댓글 작성완료.");
				dao.inputRep(reply);
			} else if(menu == 9){
				System.out.println("프로그램 종료.");
				break;

			}

		}
		scn.close();
		System.out.println("end of program");
	}
}

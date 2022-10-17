package project;

import java.util.List;
import java.util.Scanner;

public class BoardApp2 {
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
			System.out.println("1.글작성 2.글조회 3.글삭제 4.글수정 5.탈퇴 9.종료");
			System.out.println("숫자를 입력하세요>> ");

			int menu = scn.nextInt();
			scn.nextLine();
			if (menu == 1) {
				System.out.println("게시글을 작성합니다.");
				System.out.println("글번호를 입력하세요>>");
				int number = Integer.parseInt(scn.nextLine());
				System.out.println("글제목을 입력하세요>>");
				String title = scn.nextLine();
				System.out.println("글내용을 입력하세요>>");
				String content = scn.nextLine();
				String writer = logid;

				brd = new Board(number, title, content, writer);
				System.out.println("게시글이 작성되었습니다.");
				dao.inputBrd(brd);
			
			}else if(menu ==2) {
				System.out.println("게시글을 조회합니다.");
				System.out.println("조회할 글번호를 입력하세요>> ");
				int number = Integer.parseInt(scn.nextLine());
				List<Board> board =dao.checkBrd();
				for(Board brd1: board)
					System.out.println(brd1.getNumber()+ brd1.getTitle()
									 + brd1.getContent()+brd1.getWriter());
				}
				System.out.println("댓글을 작성하시겠습니까?");
				
				System.out.println("댓글을 삭제하시겠습니까?");
			}else if(menu ==3) {
				System.out.println("게시글을 삭제합니다.");
			}else if(menu ==4) {
				
			}else if(menu ==5) {
				
			}else if(menu ==9) {
				
			}
			scn.close();
			System.out.println("end of program");
	}
}

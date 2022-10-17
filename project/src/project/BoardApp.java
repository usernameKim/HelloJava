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
				System.out.println("게시글이 작성되었습니다!");
				dao.inputBrd(brd);
					
//				// 댓글 작성하기
//				System.out.println("댓글 작성란.");
//				System.out.println("댓글번호를 입력하세요>>");
//				int reNumber = Integer.parseInt(scn.nextLine());
//				System.out.println("댓글내용을 입력하세요>>");
//				String reContent = scn.nextLine();
//				String reWriter = logid;
//
//				reply = new Reply(reNumber, reContent, reWriter);
//				System.out.println("댓글이 작성되었습니다!");
//				dao.inputRep(reply);
				
			} else if (menu == 2) {
				System.out.println("게시글을 수정합니다.>> ");
					System.out.println("수정할 글번호를 입력하세요>> ");
					int number = Integer.parseInt(scn.nextLine());
					System.out.println("수정할 글내용을 입력하세요>> ");
					String content = scn.nextLine();
					brd = new Board(number, content);
					dao.updateBrd(brd);

			//댓글 수정
					System.out.println("수정할 댓글번호를 입력하세요>> ");
					int reNumber = Integer.parseInt(scn.nextLine());
					System.out.println("수정할 댓글내용을 입력하세요>> ");
					String reContent = scn.nextLine();
					reply = new Reply(reNumber, reContent);
					dao.updateRep(reply);
				

			} else if (menu == 3) {
				System.out.println("게시글 삭제란");
				int number = Integer.parseInt(scn.nextLine());
				Board brd1 = dao.directBrd(number);
				
				if (subMenu == 1) {
					System.out.println("삭제할 글 번호를 입력하세요");
					int bNum = Integer.parseInt(scn.nextLine());
					if (brd1 != null) {
						if (brd1.getWriter().equals(logid))
							dao.deleteBrd(bNum);
						System.out.println("글이 삭제되었습니다!");
					} else {
						System.out.println("글이 삭제되지 못했습니다.");
					}
					
					if (subMenu == 2) {
						System.out.println("삭제할 댓글 번호를 입력하세요");
						int reNum = Integer.parseInt(scn.nextLine());
						if (brd1 != null) {
							if (brd1.getWriter().equals(logid))
								dao.checkRep(reNum);
							System.out.println("댓글이 삭제되었습니다!");
						} else {
							System.out.println("댓글이 삭제되지 못했습니다.");
						}
					}
				}
			} else if (menu == 4) {
				List<Board> board =dao.checkBrd();
				for(Board brd: board)
					System.out.println(brd.getNumber()
									+ brd.getTitle()
									+brd.getWriter());
				}
				
			} else if (menu == 5) {
				// 글 상세조회
				System.out.println("상세조회할 글번호 입력>> ");
				int number = Integer.parseInt(scn.nextLine());
				System.out.println(dao.directBrd(number));

				// 댓글 상세조회
				System.out.println("상세조회할 댓글번호 입력>> ");
				if(dao.directBrd(number)!= null) {
					System.out.println(dao.directBrd(number));
					
					List<Reply> replies = dao.
				}

				
			} else if (menu == 9) {
				System.out.println("프로그램 종료.");
				break;

			}

			scn.close();
			System.out.println("end of program");
		}
	}



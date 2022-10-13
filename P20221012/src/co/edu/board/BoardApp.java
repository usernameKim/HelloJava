package co.edu.board;

import java.util.List;
import java.util.Scanner;

// main
public class BoardApp {

	public static void main(String[] args) {

		BoardDAO dao = new BoardDAO();
		Scanner scn = new Scanner(System.in);
		boolean checked = false;
		String storage = null;
		
		while(!checked) {
			System.out.println("로그인아이디를 입력");
			String id = scn.nextLine();
			System.out.println("비밀번호 입력");
			String pw = scn.nextLine();

			if (dao.login(id, pw) == true) {
				System.out.println("로그인성공");
				 storage = id;
				break;
			} else {
				System.out.println("실패");
				continue;
			}
			
		}

		// 메뉴=> 1. 글등록 2.글수정 3.글삭제 4.글목록 5.상세조회 9. 종료
		while (true) {
			System.out.println("1. 글등록 2.글수정 3.글삭제 4.글목록 5.상세조회 9.종료");
			System.out.println("번호를 입력>");
			int menu = scn.nextInt();
			scn.nextLine();
			if (menu == 1) {
				Board brd = null;
				System.out.println("글번호 입력");
				int number = Integer.parseInt(scn.nextLine());
				System.out.println("글제목 입력");
				String title = scn.nextLine();
				System.out.println("글내용 입력");
				String content = scn.nextLine();
				System.out.println("작성자 입력");
				String writer = scn.nextLine();
				System.out.println("작성일시 입력");
				String wDate = scn.nextLine();
				int cnt = 0;

				brd = new Board(number, title, content, writer, wDate, cnt);
				dao.insert(brd);
				System.out.println("글정보등록 완료");

			} else if (menu == 2) {
				Board brd2 = null;

				System.out.println("수정할 글번호 입력");
				int number = Integer.parseInt(scn.nextLine());
			
				System.out.println("수정할 내용 입력");
				String content = scn.nextLine();

				brd2 = new Board(number, content);
				dao.update(brd2);
				System.out.println("글정보 수정완료");

			} else if (menu == 3) {
				System.out.println("삭제할 글번호 입력");
				int number = Integer.parseInt(scn.nextLine());	
				String delete = storage;
				
				if(dao.searchDetail(number).equals(delete)) {
					dao.delete(number);
						System.out.println("삭제완료");
						
					
					}else {
						System.out.println("삭제 불가");
					}


	
			} else if (menu == 4) {

				List<Board> board = dao.search();
				for (Board brd : board) {
					System.out.println(brd.getNumber() + brd.getTitle() + brd.getWriter() + brd.getDate());
				}

			} else if (menu == 5) {
				System.out.println("상세조회할 글번호 입력");
				int number = Integer.parseInt(scn.nextLine());
				System.out.println(dao.searchDetail(number));

			} else if (menu == 9) {
				System.out.println("종료");
				break;
			} else {
				System.out.println("잘못된 번호");
			}

		}scn.close();System.out.println("프로그램 종료.");
		}
	}

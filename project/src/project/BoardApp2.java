package project;

import java.util.List;
import java.util.Scanner;

public class BoardApp2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		BoardDAO dao = new BoardDAO();
		UsersDAO uDao = new UsersDAO();
		ReplyDAO rDAO = new ReplyDAO();
		
		Users logined = uDao.login("하이", "하이");
		while (true) {
			System.out.println("1.로그인 2.회원가입");
			try {
				int menu = Integer.parseInt(scn.nextLine());
				if(menu ==1) {
					System.out.println("아이디를 입력하세요>> ");
					String id = scn.nextLine();
					System.out.println("비밀번호를 입력하세요>> ");
					String pw = scn.nextLine();
					logined = uDao.login(id, pw);
					if(logined == null) {
						System.out.println("다시 입력하세요>> ");
					}else {
						System.out.println("로그인 되었습니다.");
						break;
					}
 				}else if(menu == 2) {
 					Users user = new Users();
 					System.out.println("새로운 아이디를 입력하세요>> ");
 					String id = scn.nextLine();
					System.out.println("새로운 비밀번호를 입력하세요>> ");
					String pw = scn.nextLine();
					System.out.println("이름을 입력하세요>> ");
					String name = scn.nextLine();
					user = new Users(id, pw, name);
					uDao.insert(user);
 				}else {
 					System.out.println("잘못된 메뉴입니다.");
 				}
			}catch(NumberFormatException e) {
				System.out.println("다른 숫자를 입력하세요>> ");
			}
		}
		while (true) {
			System.out.println("<< 00수업 대나무숲	>>");
			System.out.println("1.글작성 2.글조회(댓글포함) 3.수정 4.삭제 5.목록조회 9.종료");
			try {
				int menu = Integer.parseInt(scn.nextLine());
			if (menu == 1) {
				System.out.println("게시글을 작성합니다.");
				System.out.println("글번호를 입력하세요>>");
				int number = Integer.parseInt(scn.nextLine());
				System.out.println("글제목을 입력하세요>>");
				String title = scn.nextLine();
				System.out.println("글내용을 입력하세요>>");
				String content = scn.nextLine();

				Board brd = new Board(number, title, content, logined.getId(), 0);
				System.out.println("게시글이 작성되었습니다.");
				dao.inputBrd(brd);
			
			}else if(menu ==2) {
				Board idx = null;
				System.out.println("게시글을 조회합니다.");
				while(true) {
				System.out.println("조회할 글번호를 입력하세요>> ");
				int number = Integer.parseInt(scn.nextLine());
				boolean a = dao.numCheckBoard(number);
				if(a) {
					idx = dao.login(logined.getId(), number);
					if(idx != null) {
						Board forCnt = dao.directBrd(number);
						System.out.println(forCnt.getNo()+"번글     "
								+ "<"+forCnt.getTitle()+"> "
								+ "조회수:" + forCnt.getCnt()+
								" \n글 내용: "+forCnt.getContent()+
								" \n작성일시: "+forCnt.getDate());
						break;
					} else {
						System.out.println("권한이 없습니다");
					}
				}else {
					System.out.println("찾는 글이 없습니다");
				}
			}
			
			
			}
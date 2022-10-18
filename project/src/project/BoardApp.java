package project;

import java.util.List;
import java.util.Scanner;

public class BoardApp {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		BoardDAO dao = new BoardDAO();
		UsersDAO uDao = new UsersDAO();
		ReplyDAO rDao = new ReplyDAO();
		
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
		System.out.println("<<00수업 대나무숲에 오신 것을 환영합니다!>>");
		while (true) {
			System.out.println("1.글작성 2.글조회(댓글포함) 3.수정 4.삭제 5.목록조회 6.탈퇴 9.종료");
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
				System.out.println("게시글을 조회합니다");
				while(true) {
				System.out.println("조회할 글번호를 입력하세요>> ");
				int number = Integer.parseInt(scn.nextLine());
				boolean a = dao.numCheckBoard(number);
				if(a) {
					idx = dao.IdNum(logined.getId(), number);
					if(idx != null) {
						Board forCnt = dao.directBrd(number);
						System.out.println(forCnt.getNumber()+"번글 "+ "<"+forCnt.getTitle()+"> "+ "조회수:" + forCnt.getCnt()+
								" \n글 내용: "+forCnt.getContent()+ " \n작성일시: "+forCnt.getDate());
						break;
					} else {
						System.out.println("권한이 없습니다");
					}
				}else {
					System.out.println("찾는 글이 없습니다");
					break;
				}
			}
				System.out.println("댓글보기>");
				while(true) {
					System.out.println("1.조회 2.작성 3.댓글삭제 4.종료");
					int submenu = Integer.parseInt(scn.nextLine());
					//댓글 조회(1)
					if(submenu==1) {
						System.out.println("댓글을 조회합니다");
						List<Reply> list = rDao.checkRep(idx.getNumber());
						if(list!=null) {
							for (Reply r : list) {
								System.out.println("원본글번호: "+ r.getBoNum()//
										+", 댓글번호: "+r.getRseq() +"\n댓글 내용: "//
										+ r.getReContent() +"\n댓글작성자: "//
										+ r.getReWriter()+" 작성일시: "+ r.getReDate());
							}
						}else {
							System.out.println("작성된 댓글이 없습니다");
						}
					}else if(submenu ==2) {//댓글 작성(2)
						System.out.println("댓글 내용>> ");
					
						String reCont = scn.nextLine();
						Reply newR = new Reply(idx.getNumber(), reCont, idx.getWriter());
						rDao.inputRep(newR);
					}else if(submenu ==3) {
						System.out.println("댓글 삭제");
						System.out.println("댓글번호>> ");
						int num = Integer.parseInt(scn.nextLine());
						boolean a = rDao.numCheckReply(num);
						if(a) {
							Reply x = rDao.IdNumReply(logined.getId(), num);
							if (x==null) {
								System.out.println("권한이 없습니다");
							}else {
								rDao.deleteRep(num);
								System.out.println("댓글 삭제 완료");
							}				
						}else  {
							System.out.println("일치하는 댓글이 없습니다");
						}
					}else if(submenu ==4) {
							System.out.println("댓글 닫기");
							break;
					}else {
						System.out.println("잘못된 메뉴입니다");
					}
				}
			} else if (menu == 3) {
				System.out.println("3.수정");
				System.out.println("수정할 글 번호를 입력하세요>> ");
				int num = Integer.parseInt(scn.nextLine());
				boolean a = dao.numCheckBoard(num);
				if(a) {
					Board x = dao.IdNum(logined.getId(), num);
					if (x==null) {
						System.out.println("권한이 없습니다");
					}else {
						System.out.println("변경할 제목을 입력하세요>> ");
						String title = scn.nextLine();
						System.out.println("변경할 내용을 입력하세요>> ");
						String content = scn.nextLine();
						Board bd = new Board(num, title, content, logined.getName(), x.getCnt());
						dao.updateBrd(bd);
						System.out.println("수정완료");
					}
				}else {
					System.out.println("찾는 글이 없습니다");
				}
			} else if (menu == 4) {
				System.out.println("4.삭제");
				System.out.println("삭제할 글번호를 입력하세요>> ");
				int num = Integer.parseInt(scn.nextLine());
				Board x = dao.IdNum(logined.getId(), num);
				if (x == null) {
					System.out.println("권한이 없습니다");
				}else {
					dao.deleteBrd(num);
				}

			} else if (menu == 5) {
				System.out.println("5.전체목록조회");
				List<Board> boards = dao.checkBrd();
				for(int i=0; i<boards.size(); i++) {
					System.out.println(boards.get(i).getNumber()+") 제목:"//
							+boards.get(i).getTitle()+" 작성자:"+boards.get(i).getWriter()//
							+" 조회수:"+boards.get(i).getCnt());
				}
			} else if(menu ==6) {
				Users bye = new Users();
				System.out.println("6.탈퇴");
				System.out.println("탈퇴할 아이디를 입력하세요");
				String id = scn.nextLine();
				System.out.println("탈퇴할 비밀번호를 입력하세요");
				String passwd = scn.nextLine();
				bye = new Users(id, passwd);
				uDao.delUser(bye);
				
			}		
			 else if (menu == 9) {
				System.out.println("9.종료");
				System.out.println("프로그램을 종료합니다");
				break;
			} else {
				System.out.println("잘못된 메뉴입니다");
			}
		} catch (NumberFormatException e) {
			System.out.println("숫자를 입력하세요");
		} // try catch 끝
	} // while의 끝

}// main의 끝

}

			
package project;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BoardApp {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		BoardDAO dao = new BoardDAO();
		UsersDAO uDao = new UsersDAO();
		ReplyDAO rDao = new ReplyDAO();
		MailApp app = new MailApp();
		Users login = null;
		
		
//		Users logined = uDao.login("하이", "바이");
		while (true) {
			System.out.println("1.로그인 2.회원가입");
			try {
				int menu = Integer.parseInt(scn.nextLine());
				if (menu == 1) {
					System.out.println("아이디를 입력하세요>> ");
					String id = scn.nextLine();
					System.out.println("비밀번호를 입력하세요>> ");
					String pw = scn.nextLine();
					login = uDao.login(id, pw);
					if (login == null) {
						System.out.println("다시 입력하세요>> ");
					} else {
						System.out.println("로그인 되었습니다.");
						break;
					}
				} else if (menu == 2) {
					Random random = new Random();
					int createNum = 0;
					String ranNum ="";
					int letter =6;
					String result = "";
					
					for(int i=0; i<letter; i++) {
						createNum =random.nextInt(9);
						ranNum = Integer.toString(createNum); // int를 toString으로 바꾸는 것.
						result += ranNum;
					}
					Users user = new Users();
					System.out.println("새로운 아이디를 입력하세요>> ");
					String id = scn.nextLine();
					
					if (!dao.idCheck(id).getWriter().equals(id)) {
						System.out.println(id);
						System.out.println("새로운 비밀번호를 입력하세요>> ");
						String pw = scn.nextLine();
						System.out.println("이름을 입력하세요>> ");
						String name = scn.nextLine();
						System.out.println("인증번호를 받을 이메일을 입력하세요");
						String email = scn.nextLine();
						System.out.println("이메일 전송중입니다...");
						String from = "rudal754@maver.com"; 
						String to = email;
						String subject = "대나무숲 가입인증번호 입니다.";
						String content = "대나무숲 관리자입니다. 인증번호는 " + result + " 입니다.";
						app.sendMail(from, to, subject, content);
						System.out.println("인증번호를 발송했습니다.");
						while(true) {
							System.out.println("인증번호를 입력하세요");
							String inputVal = scn.nextLine();
							if(result.equals(inputVal)) {
								System.out.println("가입되었습니다! 아이디는 " + id +" 입니다.");
	
								user = new Users(id, pw, name);
								uDao.insert(user);
								break;
							}		
						}
					}else {
						System.out.println("중복된 값이 있습니다.");
					}
					
				} else {
					System.out.println("잘못된 메뉴입니다.");
				}
			} catch (NumberFormatException e) {
				System.out.println("다른 숫자를 입력하세요>> ");
			}
		}
		System.out.println("<<00대학교 대나무숲에 오신 것을 환영합니다!>>");
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

					Board brd = new Board(number, title, content, login.getId(), 0);
					System.out.println("게시글이 작성되었습니다.");
					dao.inputBrd(brd);

				} else if (menu == 2) {	
					System.out.println("게시글을 조회합니다");
					int number;
					while (true) {
						System.out.println("조회할 글번호를 입력하세요>> ");
						number = Integer.parseInt(scn.nextLine());
						int a = dao.numCheckBoard(number);
						
						if (a != -1) {
							Board brd = dao.directBrd(number);
							System.out.println(brd.getNumber() + "번글 " + "<" + brd.getTitle() + "> " + " 글 내용: "
									+ brd.getContent() + "\n조회수:" + brd.getCnt() + " 작성일시: " + brd.getDate() + " 입니다.");
							break;

						} else {
							System.out.println("찾는 글이 없습니다");
							break;
						}
					} // 글 while
					
					System.out.println("<댓글보기>");
					while (true) {
						System.out.println("1.조회 2.작성 3.댓글삭제 4.댓글수정 5.종료");
						int submenu = Integer.parseInt(scn.nextLine());
						// 댓글 조회(1)
						if (submenu == 1) {
							System.out.println("댓글을 조회합니다");
							List<Reply> list = rDao.checkRep(number);
							if (list != null) {
								for (Reply r : list) {
									System.out.println("원본글번호: " + r.getBoNum() + ", 댓글번호: " + r.getRseq() + "\n댓글내용: "
											+ r.getReContent() + "\n댓글작성자: " + r.getReWriter() + " 작성일시: "
											+ r.getReDate() + " 입니다.");
								}
							} else {
								System.out.println("작성된 댓글이 없습니다");
							}

						} else if (submenu == 2) {// 댓글 작성(2)
							System.out.println("댓글 내용을 입력하세요.>> ");
							String reCont = scn.nextLine();
							Reply newR = new Reply(number, reCont, login.getId());
							rDao.inputRep(newR);

						} else if (submenu == 3) {
							System.out.println("댓글을 삭제합니다.");
							System.out.println("댓글번호를 입력하세요>> ");
							int num = Integer.parseInt(scn.nextLine());
							boolean a = rDao.numCheckReply(num);
							if (a) {
								Reply x = rDao.IdNumReply(login.getId(), num);
								if (x == null) {
									System.out.println("권한이 없습니다");
								} else {
									rDao.deleteRep(num);
									System.out.println("댓글 삭제 완료");
								}
							} else {
								System.out.println("일치하는 댓글이 없습니다");
							}
						} else if (submenu == 4) {
							System.out.println("댓글을 수정합니다.");
							System.out.println("댓글번호를 입력하세요>> ");
							int num = Integer.parseInt(scn.nextLine());
							System.out.println("수정할 댓글내용을 입력하세요");
							String reCon = scn.nextLine();
							Reply rly = new Reply(num, reCon);

							boolean a = rDao.numCheckReply(num);
							if (a) {
								Reply x = rDao.IdNumReply(login.getId(), num);
								if (x == null) {
									System.out.println("권한이 없습니다");
								} else {
									rDao.updateRep(rly);
									System.out.println("댓글 수정 완료");
								}
							} else {
								System.out.println("일치하는 번호가 없습니다.");
							}

						} else if (submenu == 5) {
							System.out.println("댓글 닫기");
							break;
						} else {
							System.out.println("잘못된 메뉴입니다");
						}
					} // 댓글 while
				} else if (menu == 3) {
					System.out.println("3.수정");
					System.out.println("수정할 글 번호를 입력하세요>> ");
					int num = Integer.parseInt(scn.nextLine());
					Board brd = dao.directBrd(num);

					if (brd != null) {
						if (brd.getNumber() == num) {
							if (dao.IdNum(login.getId(), num) != null) {

								System.out.println("변경할 제목을 입력하세요>> ");
								String title = scn.nextLine();
								System.out.println("변경할 내용을 입력하세요>> ");
								String content = scn.nextLine();
								Board bd = new Board(num, title, content, login.getName(), brd.getCnt());
								dao.updateBrd(bd);
								System.out.println("수정완료");
							} else {
								System.out.println("아이디가 일치하지 않습니다.");
							}
						} else {
							System.out.println("찾는 글이 없습니다");
						}
					}

				} else if (menu == 4) {
					System.out.println("4.삭제");
					System.out.println("삭제할 글번호를 입력하세요>> ");
					int num = Integer.parseInt(scn.nextLine());
					Board brd = dao.directBrd(num);

					if (brd != null) {
						if (brd.getNumber() == num) {
							if (dao.IdNum(login.getId(), num) != null) {
								System.out.println("삭제되었습니다");
							}
							dao.deleteBrd(num);
						} else {
							System.out.println("삭제할 수 없습니다.");
						}
					}

				} else if (menu == 5) {
					System.out.println("5.전체목록조회");
					System.out.println("조회할 글번호를 입력하세요");
					List<Board> brd = dao.checkBrd();
					for (int i = 0; i < brd.size(); i++) {
						System.out.println(brd.get(i).getNumber() + ") " + "1.제목 :" + brd.get(i).getTitle() + " 2.작성자 :"
								+ brd.get(i).getWriter() + " 3.조회수 :" + brd.get(i).getCnt());
					}
				} else if (menu == 6) {
					Users bye = new Users();
					System.out.println("6.탈퇴");
					System.out.println("탈퇴할 아이디를 입력하세요");
					String id = scn.nextLine();
					System.out.println("탈퇴할 비밀번호를 입력하세요");
					String passwd = scn.nextLine();
					bye = new Users(id, passwd);
					uDao.delUser(bye);

				} else if (menu == 9) {
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

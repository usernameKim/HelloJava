package co.edu.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Morning20221014 {
	public static void main(String[] args) {
		File file = new File ("C:/Temp/memberList.txt");
		ArrayList<Member> MemberList = new ArrayList<>()  ;
		Scanner scn = new Scanner(System.in);
		String x = null;
		
		
		while (true) {
			String member = scn.nextLine();
			System.out.println("1.회원등록");
			System.out.print("아이디>> ");
			String id = scn.nextLine();
			
			if(id.equals("quit")) {
				System.out.println("입력 끝");
				break;}
			}
		
		System.out.println("2.회원이름");
		String name = scn.nextLine();
		System.out.println("3.회원포인트");
		int point = Integer.parseInt(scn.nextLine());
		
		MemberList.add(new Member(id, name, point));
			
	

	try(FileWriter fw = new FileWriter(file);){
		for (int i = 0; i < list.size(); i++) {
			x = list.get(i).getid() + " " + list.get(i).getname() + " " + list.get(i).getpoint();
			fw.write(x + " ");
		}
		System.out.println("저장성공");
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}scn.close();}
}

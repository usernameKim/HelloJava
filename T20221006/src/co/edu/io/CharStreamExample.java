package co.edu.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharStreamExample {

	public static void main(String[] args) {
		read();
	}

	public static void read() {

		try {
			FileReader reader = new FileReader("C:/Temp/addr.txt");
			BufferedReader br = new BufferedReader(reader);
			while (true) {
				String bytes = br.readLine(); // 문자 기반 -> 2바이트씩 읽음. 
				if (bytes == null) { //byte 는 -1, string은 null
					break;
				}
//				System.out.print((char) bytes + " "); // char로 변환, 안쓰면 byte단위로 나옴
				String [] strAry = bytes.split(",");
//				System.out.println(bytes + "\n");
//				for(String str : strAry) { // hello, world
//					System.out.println(str);
//				}
				System.out.println("학번 " +strAry[0]);
				System.out.println("성명 " +strAry[1]);
				System.out.println("영어 " +strAry[2]);
				System.out.println("수학 " +strAry[3]);
				System.out.println("==================");
			} // H는 104 -> char로 인해 H로 보이는 것임.
			reader.close();
			System.out.println("completed.");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void write() {
		Scanner scn = new Scanner(System.in);

		// 문자기반 스트림 생성. Reader/ Writer
		try {
			FileWriter fw = new FileWriter("C:/Temp/addr.txt");

			while (true) {
				System.out.print(">> ");
				String temp = scn.nextLine();
				if (temp.equals("quit"))
					break;

				fw.write(temp + "\n");
			}

			fw.close();
			scn.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("completed.");

	}
}

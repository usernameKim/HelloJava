package co.edu.io;

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
			FileReader reader = new FileReader("src/co/edu/io/ByteStreamExample.java");

			while (true) {
				int bytes = reader.read(); // 문자 기반 -> 2바이트씩 읽음.
				if (bytes == -1) {
					break;
				}
				System.out.print((char) bytes + " "); // char로 변환, 안쓰면 byte단위로 나옴
			}
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

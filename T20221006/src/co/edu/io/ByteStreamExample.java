package co.edu.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteStreamExample {

	public static void main(String[] args) {
		read2();

	}

	public static void read2() {
		try {
			InputStream is = new FileInputStream("C:/Temp/mydata.dat");
			byte[] buf = new byte[100]; //100개씩 읽는다는 뜻 
			while (true) {
				int result = is.read(buf);
				if (result == -1)
					break;
				for (int i = 0; i < result; i++) {
					System.out.println(buf[i]);
				}
			}

			is.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void write2() {
		// C:/Temp/mydata.dat
		// 10, 20, 30 값을 출력

		try {
			OutputStream os = new FileOutputStream("C:/Temp/mydata.dat"); // byte값이라 파일열면 알수없는 형태로 보임
			for (int i = 0; i < 100; i++) {
				os.write(i); // 2 4 6 8 ...128(byte범위)까지만  
			}
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("end of prog");

	}

	// byte단위로 읽고 쓰기.
	public static void fileCopy() throws IOException {
		FileInputStream fis = new FileInputStream("C:/Temp/origin.jpg");
		FileOutputStream fos = new FileOutputStream("C:/Temp/copy.jpg"); // 읽어들인 파일을 copy.jpg로
		byte[] buf = new byte[100];

		// 시간출력.
		long start = System.currentTimeMillis();
		while (true) {
			int bytes = fis.read(buf); // 한바이트씩 읽기.
			if (bytes == -1)
				break;

			fos.write(buf); // 배열의 크기만큼 buf에 모아놨다가 한번에 저장.

		}
		fos.close();
		fis.close();

		long end = System.currentTimeMillis();

		System.out.println(end - start);

		System.out.println("complete");
	}

	public static void readBuf() throws IOException {
		InputStream is = new FileInputStream("C:/Temp/data2.dat");
		byte[] buf = new byte[2]; // 2바이트 만큼 읽음

		while (true) {
			int bytes = is.read(buf); // 배열에 선언된 크기만큼 읽어들임.
			if (bytes == -1) {
				break;
			}
			for (int i = 0; i < bytes; i++) {
				System.out.print(buf[i] + " ");
			}
			System.out.println();
		}
		System.out.println("complete");
		is.close();
	}

	// writeBuf를 호출한 영역에서 예외처리(IO는 상위 예외처리니까)
	public static void writeBuf() throws IOException {
		byte[] arr = new byte[] { 10, 20, 30 };
		OutputStream os = new FileOutputStream("C:/Temp/data2.dat");
		os.write(arr);
		os.close();

		System.out.println("complete.");
	}

	public static void read() {

		try {
			InputStream is = new FileInputStream("C:/Temp/data1.dat"); // 파일을 읽는 용도.
			while (true) {
				int bytes = is.read(); // byte 읽고 더 이상 읽을 바이트 없으면 -1 반환. 한건씩 읽겠다는뜻
				// 10, 20을 읽음.
				if (bytes == -1) { // -1 -> 더이상 읽을 값이 없다는 뜻.
					break;
				}
				System.out.println(bytes);
			}

			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("complete.");
	}

	public static void write() {
		// 출력스트림(바이트)
		try {
			OutputStream os = new FileOutputStream("C:/Temp/data1.dat");
			// write(1byte씩 쓰겠다는 뜻) (byte b)
			byte a = 10;
			byte b = 20;

			os.write(a);
			os.write(b);

			// resource 반환.
			os.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("complete.");
	}

}

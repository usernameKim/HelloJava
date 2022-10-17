package co.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.*;

public class MyFrame extends JFrame {

	public MyFrame() {

		setTitle("윈도우 UI");
		setSize(300, 250); // 윈도우 사이즈.

		setLayout(new FlowLayout()); // 배치관리자.

		JButton btn = new JButton("확인"); // 버튼
		JButton btn2 = new JButton("취소");
		btn.addActionListener(e -> System.out.println("확인버튼 클릭.")); // 람다식으로 표현
		// 이벤트등록(이벤트가 발생하면 인터페이스(동작)을 구현)
		// 이벤트 구현
		
		btn2.addActionListener((e) -> {
			System.out.println("취소버튼 클릭.");
			System.exit(0); // 0넣으면 종료

		});

		add(btn); // 컨트롤 등록.
		add(btn2);

		setVisible(true); // 화면출력.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 화면종료.
	}

	public static void main(String[] args) {
		new MyFrame(); // 생성자호출

	}
}

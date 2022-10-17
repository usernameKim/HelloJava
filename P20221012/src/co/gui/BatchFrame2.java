package co.gui;

import java.awt.BorderLayout;

import javax.swing.*;

public class BatchFrame2 extends JFrame{
	
	public BatchFrame2() {
		setTitle("BorderLayout 관리자"); // 특별위치에 배치가능
		setSize(300, 250);
		
		setLayout(new BorderLayout(10,10)); // 여백지정가능
		
		JButton top = new JButton("top");
		JButton left = new JButton("left");
		JButton center = new JButton("center");
		JButton right = new JButton("right");
		JButton bottom = new JButton("bottom");
		
		add("North", top);
		add("West", left);
		add("Center", center);
		add("East", right);
		add("South", bottom);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // null ->화면의 중앙.  
	}
	
	public static void main(String[] args) {
		new BatchFrame2();
	}
}

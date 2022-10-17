package co.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class ComponentExam extends JFrame{

	public ComponentExam() {
		setTitle("라벨 예제");
		setSize(new Dimension(300, 250));

		JPanel panel = new JPanel(); // component들을 판넬에 부착하고 다시 윈도우에 부착/ 기본레이아웃 borderlayout이 기본지정
		JLabel label1 = new JLabel("Color Label"); 
		label1.setFont(new Font("Arial", Font.ITALIC, 20));
		label1.setForeground(Color.yellow);
		label1.setText("Yellow Font");
	
		JLabel label2 = new JLabel("Font Label"); 
		label2.setFont(new Font("Arial", Font.BOLD, 15)); //font 객체를 매개값으로
		label2.setForeground(Color.green);
		
		JLabel label3 = new JLabel();
		ImageIcon icon = new ImageIcon("c:/Temp/spring.jpg");
		// 이미지 크기 지정?
		label3.setIcon(icon);
//		label3.setSize(200, 180); SIZE말고 Dimension쓰셈
		label3.setPreferredSize(new Dimension(180,150)); 
		
		
		panel.add(label1);
		panel.add(label2); //부착
		panel.add(label3);
		
		add(panel);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	public static void main(String[] args) {
		new ComponentExam();
	}
}

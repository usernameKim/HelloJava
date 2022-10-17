package co.gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

// 간단한 계산기.
public class ComponentExam3 extends JFrame {

	String[] keys = { "1", "2", "3", "+", "4", "5", "6", 
					"-", "7", "8", "9", "*", "0", "=", "C", "/" };
	JButton[] keyBtn = new JButton[16];
	String displayText = "";
	String left, right;

	public ComponentExam3() {
		setTitle("계산기 UI");
		setBounds(100, 100, 300, 220); // 위치와 크기지정하는 메소드. (100위치, 픽셀? 높이, 너비)

		// 배치관리자
		setLayout(new FlowLayout());
		
		// display 정보를 출력하기 위한 panel.
		JPanel displayPanel = new JPanel();
		JTextField display = new JTextField("0", 20);
		display.setHorizontalAlignment(JTextField.RIGHT);
		displayPanel.add(display);

		// 버튼을 생성하기 위한 panel.
		JPanel keyPanel = new JPanel();
		keyPanel.setLayout(new GridLayout(4, 4, 5, 5)); // 로우 컬럼 4개씩
		for (int i = 0; i < keyBtn.length; i++) {
			keyBtn[i] = new JButton(keys[i]);
			// 버튼 이벤트.
			keyBtn[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
//					System.out.println(((JButton)e.getSource()).getText()); //object -> jbutton타입으로 캐스팅
					//누르면 콘솔에 출력됨.
					String keyOper = ((JButton) e.getSource()).getText(); //string타입으로 
					// 계산처리.
					if(keyOper.equals("=")) {
						left = displayText.substring(0, displayText.indexOf("+")); //345+12
						right = displayText.substring(displayText.indexOf("+")+ 1);
						displayText = String.valueOf(Integer.parseInt(left) + Integer.parseInt(right));
						display.setText(displayText);
						return;
					}
					
					displayText += keyOper;
					display.setText(displayText);	
//					if(keyOper.equals("C")) {
//						display.setText("");
//					
//					}
				} 
			});
			
			keyPanel.add(keyBtn[i]);
		}
		
		add(displayPanel);
		add(keyPanel);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ComponentExam3();
	}
}

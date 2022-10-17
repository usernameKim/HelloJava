package co.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ComponentExam2 extends JFrame {
	
	public ComponentExam2() {
		setTitle("입력필드 UI");
		setSize(350, 150);
		Dimension lblDim = new Dimension(60, 16); //라벨에서 쓰는크기(높이 너비지정)

		setLayout(new BorderLayout());
		
	 //배치관리자를 뭘로?
		
		JPanel center = new JPanel();
		JPanel bottom = new JPanel();
	
		JLabel idLb1 = new JLabel("id");
		idLb1.setPreferredSize(lblDim);
		JLabel pwLb1 = new JLabel("password");
		pwLb1.setPreferredSize(lblDim);
		JTextField idTxt = new JTextField(23); //글씨쓰는 공간 어느정도의 크기인지..??
		JPasswordField pwTxt = new JPasswordField(23); //비밀번호 필드는 비번 안보여줌!
		
		center.add(idLb1);
		center.add(idTxt);
		center.add(pwLb1);
		center.add(pwTxt);
		
		JButton btn = new JButton("확인");
		center.add(btn);
		
		add("Center", center); // 이 panel을 윈도우에 부착할거임
		add("South", bottom); 
		

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new ComponentExam2();
	}
}

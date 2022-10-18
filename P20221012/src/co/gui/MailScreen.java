package co.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// 메일 발송 화면.
public class MailScreen extends JFrame {

	Dimension lbl1 = new Dimension(65, 15);
	Dimension lbl2 = new Dimension(45, 15);
	
	JPanel center, bottom; // 컴포넌트를 모아두기 위한 컨테이너.
	JLabel fromLbl, toLbl, subjectLbl, contentLbl; // 레이블.
	JTextField fromTxt, toTxt, subjectTxt; // 텍스트필드.
	JTextArea contentTxt;
	JButton send, cancel;
	
	MailApp app = new MailApp();
	
	
	public MailScreen() {
		setTitle("메일 보내기 UI");
		setSize(340, 300);
		setLayout(new BorderLayout());
		
		// panel..
		center = new JPanel();
		bottom = new JPanel();
		
		// label..
		toLbl = new JLabel("받는 사람");
		fromLbl = new JLabel("보내는 사람");
		subjectLbl = new JLabel("제목");
		contentLbl = new JLabel("내용");
		toLbl.setPreferredSize(lbl1); //setsize 말고 이거 써주기
		fromLbl.setPreferredSize(lbl1); 
		subjectLbl.setPreferredSize(lbl1);
		contentLbl.setPreferredSize(lbl2);
		
		// textfield
		toTxt = new JTextField(22);
		fromTxt = new JTextField(22);
		subjectTxt = new JTextField(22);
		contentTxt = new JTextArea(10, 25);
		
		// button.
		send = new JButton("보내기");
		send.addActionListener(new MyActionListener()); // ActionListener ->인터페이스 : 구현객체를 만들어야됨(메소드구현)
		
		cancel = new JButton("취소");
		cancel.addActionListener(new MyActionListener());
		
		// container setting.
		center.add(fromLbl);
		center.add(fromTxt);
		center.add(toLbl);
		center.add(toTxt);
		center.add(subjectLbl);
		center.add(subjectTxt);
		center.add(contentLbl);
		center.add(contentTxt);
		
		// 컨테이너에 컴포넌트 배치.
		bottom.add(send);
		bottom.add(cancel);
		
		// 윈도우에 컨테이너 배치.
		add("Center", center);
		add("South", bottom);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); //화면 중앙에 띄움.
	}
	// 기능을 실행하는 구현객체.
	class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource(); // 어떤 event가 발생했는지 알려줌.
			if(src == send) {
				System.out.println("보내기 버튼 actionPerformed.");
				String from = fromTxt.getText();
				String to = toTxt.getText();
				String subject = subjectTxt.getText();
				String content = contentTxt.getText();
				
				if(app.sendMail(from, to, subject, content).equals("Success")) {
					// 콘솔에 "성공"; -> 값을 지워주도록.
					System.out.println("성공");
//					fromTxt.setText("");
//					toTxt.setText("");
//					subjectTxt.setText("");
//					contentTxt.setText("");
					JOptionPane.showMessageDialog(null, "발송성공!!", "전송결과", JOptionPane.DEFAULT_OPTION);
				}else {
					// 콘솔에 "실패";
					JOptionPane.showMessageDialog(null, "발송실패!!", "에러", JOptionPane.WARNING_MESSAGE);
				}
			}else if(src == cancel){
				System.out.println("취소 버튼 actionPerformed");
			}
		}
		
	}
	// 화면시작.
	public static void main(String[] args) {
		new MailScreen();
	}
}

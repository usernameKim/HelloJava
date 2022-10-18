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

public class SmsScreen extends JFrame {

	Dimension lbl1 = new Dimension(65, 15);
	Dimension lbl2 = new Dimension(45, 15);

	JPanel center, bottom;
	JLabel fromLbl, toLbl, subjectLbl, contentLbl;
	JTextField fromTxt, toTxt, subjectTxt;
	JTextArea contentTxt;
	JButton send, cancel;

	SmsApp app = new SmsApp();

	public SmsScreen() {
		setTitle("문자 보내기 UI");
		setSize(340, 300);
		setLayout(new BorderLayout());

		// panel..
		center = new JPanel();
		bottom = new JPanel();

		// label
		toLbl = new JLabel("수신 번호");
		fromLbl = new JLabel("발신 번호");
		subjectLbl = new JLabel("문자 제목");
		contentLbl = new JLabel("문자 내용");
		toLbl.setPreferredSize(lbl1);
		fromLbl.setPreferredSize(lbl1);
		subjectLbl.setPreferredSize(lbl1);
		contentLbl.setPreferredSize(lbl2);

		// textfield
		toTxt = new JTextField(22);
		fromTxt = new JTextField(22);
		subjectTxt = new JTextField(22);
		contentTxt = new JTextArea(10, 25);

		// button
		send = new JButton("전송");
		send.addActionListener(new MyActionListener());

		cancel = new JButton("취소");
		cancel.addActionListener(new MyActionListener());

		// container setting
		center.add(fromLbl);
		center.add(fromTxt);
		center.add(toLbl);
		center.add(toTxt);
		center.add(subjectLbl);
		center.add(subjectTxt);
		center.add(contentLbl);
		center.add(contentTxt);

		bottom.add(send);
		bottom.add(cancel);

		add("Center", center);
		add("South", bottom);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource();
			if (src == send) {
				System.out.println("전송 버튼 actionPerformed.");
				String from = fromTxt.getText();
				String to = toTxt.getText();
//				String subject = subjectTxt.getText();
				String content = contentTxt.getText();

				if (app.sendSms(to, from, content).equals("Success")) {
					System.out.println("성공");
					JOptionPane.showMessageDialog(null, "발송성공!!", "전송결과", JOptionPane.DEFAULT_OPTION);
				} else {
					// 콘솔에 "실패";
					JOptionPane.showMessageDialog(null, "발송실패!!", "에러", JOptionPane.WARNING_MESSAGE);
				}
			} else if (src == cancel) {
				System.out.println("취소 버튼 actionPerformed");
			}
		}

	}

	// 화면시작
	public static void main(String[] args) {
		new SmsScreen();
	}
}

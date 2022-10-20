package project;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class BrdScreen extends JFrame implements ActionListener, MouseListener {

	// 입력항목.
	private String[] labels = { "글번호", "글제목", "글내용", "작성자", "작성일시", "조회수" };
	private JTextField[] fields = new JTextField[6];

	// 컨테이너.
	private JPanel topPanel;
	private JScrollPane centerPanel;
	private JPanel rightJPanel;

	private JTable table;

	// 버튼.
	private JButton addBtn, delBtn, findBtn, dFindBtn;

	BoardDAO dao = new BoardDAO();
	List<Board> list;

	public BrdScreen() {
		setTitle("00대학교 대나무숲");
		setLayout(new BorderLayout(10, 10));

		// topPanel
		topPanel = new JPanel(new GridLayout(6, 2));
		for (int i = 0; i < labels.length; i++) {
			topPanel.add(new JLabel(labels[i]));
			fields[i] = new JTextField(30);
			topPanel.add(fields[i]);
		}
		// centerPanel
		String[] headers = { "글번호", "글제목", "글내용", "작성자", "작성일시", "조회수" };
		DefaultTableModel model = new DefaultTableModel(headers, 0);

		table = new JTable(model);
		table.addMouseListener(this);
		centerPanel = new JScrollPane(table);

		// 오른쪽 버튼
		rightJPanel = new JPanel(new GridLayout(4, 1));
		addBtn = new JButton("게시글 추가");
		delBtn = new JButton("게시글 삭제");
		findBtn = new JButton("게시글 조회");
		dFindBtn = new JButton("게시글 상세조회");

		addBtn.addActionListener(this);
		delBtn.addActionListener(this);
		findBtn.addActionListener(this);
		dFindBtn.addActionListener(this);

		rightJPanel.add(addBtn);
		rightJPanel.add(delBtn);
		rightJPanel.add(findBtn);
		rightJPanel.add(dFindBtn);

		add("North", topPanel);
		add("Center", centerPanel);
		add("East", rightJPanel);

		setSize(620, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	} // end of brdScreen()

	// 조회
	public void searchData() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		int allCnt = model.getRowCount();
		for (int i = 0; i < allCnt; i++) {
			model.removeRow(0);
		}
		String[] record = new String[6];
		list = dao.checkBrd();

		for (int i = 0; i < list.size(); i++) {
			record[0] = String.valueOf(list.get(i).getNumber());
			record[1] = list.get(i).getTitle();
			record[2] = list.get(i).getContent();
			record[3] = list.get(i).getWriter();
			record[4] = list.get(i).getDate();
			record[5] = String.valueOf(list.get(i).getCnt());
			model.addRow(record);
		}
	}
	//상세조회
//	public void detailSearchData() {
//		DefaultTableModel model = (DefaultTableModel) table.getModel();
//		
//		int allCnt = model.getRowCount();
//		for (int i = 0; i < allCnt; i++) {
//			model.removeRow(0);
//		}
//		String[] record = new String[6];	
//	}
	
	// 삭제
	public void removeData() {
		int selectedRow = table.getSelectedRow();
		if (selectedRow < 0) {
			return;
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int brdNum = Integer.parseInt((String) model.getValueAt(selectedRow, 0));

		dao.deleteBrd(brdNum);

		model.removeRow(selectedRow);
	}

	// 등록
	public void addData() {
		String[] records = new String[6];
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (int i = 0; i < fields.length; i++) {
			records[i] = fields[i].getText();
		}
		Board brd = new Board(0, records[1], records[2], records[3], 0);
		dao.inputBrd(brd);
		records[0] = String.valueOf(brd.getNumber());

		model.addRow(records);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == addBtn) {
			addData();
		} else if (src == delBtn) {
			removeData();
		} else if (src == findBtn) {
			searchData();
		} else if (src == dFindBtn) {
//			detailSearchData();
		}

	}// end of actionPerformed(ActionEvent e)

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	public static void main(String[] args) {
		new BrdScreen();
	}
}// end of class.

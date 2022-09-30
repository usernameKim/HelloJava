package co.edu.board;

public class Board {
	private int boardNo;
	private String title;
	private String content;
	
	public Board() {} // 매개변수가 없는 기본생성자

	public Board(int boardNo, String title, String content) {
		super();
		this.boardNo = boardNo; //Source -constructor using field 단축기 사용.
		this.title = title;
		this.content = content;
	}

	// 단축기로 getter and setter 생성
	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override //generate to string
	public String toString() {
		return "Board [boardNo=" + boardNo + ", title=" + title + ", content=" + content + "]";
	}
	
	
}

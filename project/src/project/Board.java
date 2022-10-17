package project;

public class Board {
	private int number;
	private String title;
	private String content;
	private String writer;

	public Board() {};
	public Board(int number, String title, String content, String writer) {
		this.number = number;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	public Board(int number, String content) {
		this.number = number;
		this.content = content;
	}
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "글번호 " + number + " 글제목 " + title 
			+ " 글내용 " + content + " 작성자 " + writer;
	}
	public String showInfo() {
		return "글번호 " + number + "글제목 " + title
				+ "작성자 " + writer;
	}

}

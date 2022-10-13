package co.edu.board;

public class Board {
	private int number;
	private String title;
	private String content;
	private String writer;
	private String date;
	private int count;
	
	public Board(int number, String title, String content, String writer, String date, int count) {
		this.number = number;
		this.title = title;
		this.content = content;
		this.writer =writer;
		this.date = date;
		this.count =count;
	}

	
	public Board(int number, String title, String content, String writer) {
		this.number = number;
		this.title = title;
		this.content = content;
		this.writer =writer;
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


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	@Override
	public String toString() {
		return "글번호 " + number + " 글제목 " + title 
				+ " 글내용 " + content + " 작성자 " + writer
				+ " 작성일시 " + date + " 읽은횟수 " + count;
	}
	public String showInfo() {
		return "글번호 " + number + "글제목 " + title
				+ "작성자 " + title + "작성일시 " + date;
	}
	}


package project;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Board {
	private int number;
	private String title;
	private String content;
	private String writer;
	private String date;
	private int cnt;

	public Board() {};
	
	public Board(int number, String title, String content, String writer, String date, int cnt) {
		SimpleDateFormat formatdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.number = number;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = formatdate.format(new Date());
		this.cnt = cnt;
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
	public int getCnt() {
		return cnt;
	}
	public void setCnt() {
		this.cnt = cnt;
	}

}

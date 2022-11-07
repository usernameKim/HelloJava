package co.micol.prj.book.vo;

import lombok.Getter;
import lombok.Setter;

// 멤버변수, getter, setter로 구성
// table 이름과 vo를 일치
@Getter
@Setter
public class BookVO {
	private String bookCode; //camel로 적어주기
	private String bookTitle;
	private String bookAuthor;
	private String bookPress;
	private int bookPrice;
}

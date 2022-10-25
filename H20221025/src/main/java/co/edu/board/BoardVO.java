package co.edu.board;

import lombok.Data;

@Data
public class BoardVO {
	private int boardNO;
	private String title;
	private String content;
	private String writeDate; // 2020-11-23
	private int clickCnt;
	private String image;
}

package co.edu.board;

public class Reply {
	private int rseq;
	private int brdnum;
	private String rcontent;
	private String rwriter;
	private String date;
	
	public Reply(){
		
	}
	public Reply(int rseq, int brdnum, String rcontent, String rwriter, String date) {
		this.rseq = rseq;
		this.brdnum =brdnum;
		this.rcontent = rcontent;
		this.rwriter = rwriter;
		this.date = date;
	}

	public int getRseq() {
		return rseq;
	}

	public void setRseq(int rseq) {
		this.rseq = rseq;
	}

	public int getBrdnum() {
		return brdnum;
	}

	public void setBrdnum(int brdnum) {
		this.brdnum = brdnum;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public String getRwriter() {
		return rwriter;
	}

	public void setRwriter(String rwriter) {
		this.rwriter = rwriter;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "댓글번호 " + rseq + "원본글번호 " + brdnum 
				+ "댓글내용 " + rcontent + "댓글작성자아이디" 
				+ rwriter + "댓글작성일시 " + date;
	}
}

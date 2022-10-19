package project;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reply {
		private int rseq;
		private int boNum;
		private String reContent;
		private String reWriter;
		private String reDate;

		public Reply(int boNum, String reContent, String reWriter) {
			SimpleDateFormat formatdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			this.rseq = 1;
			this.boNum = boNum;
			this.reContent = reContent;
			this.reWriter = reWriter;
			this.reDate = formatdate.format(new Date());
		}
		
		public Reply(int rseq, int boNum, String reContent, String reWriter, String date) {
			this.rseq = rseq;
			this.boNum = boNum;
			this.reContent = reContent;
			this.reWriter = reWriter;
			this.reDate = date;
		}
	
		public Reply(int rseq, String reContent) {
			this.rseq = rseq;
			this.reContent = reContent;
		}

		public int getRseq() {
			return rseq;
		}
		public void setRseq(int rseq) {
			this.rseq = rseq;
		}
		public int getBoNum() {
			return boNum;
		}
		public void setBoNum(int boNum) {
			this.boNum = boNum;
		}
		public String getReContent() {
			return reContent;
		}
		public void setReContent(String reContent) {
			this.reContent = reContent;
		}
		public String getReWriter() {
			return reWriter;
		}
		public void setReWriter(String reWriter) {
			this.reWriter = reWriter;
		}
		public String getReDate() {
			return reDate;
		}
		public void setReDate(String reDate) {
			this.reDate = reDate;
		}

//		@Override
//		public String toString() {
//			return "Reply [rseq=" + rseq + ", boNum=" + boNum + ", reContent=" + reContent + ", reWriter=" + reWriter
//					+ ", reDate=" + reDate + "]";
//		}
		
		
		
}
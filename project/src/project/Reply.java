package project;

	public class Reply {
		private int rseq;
		private int reNumber;
		private String reContent;
		private String reWriter;

		public Reply() {};
		public Reply(int rseq, int reNumber, String reContent, String reWriter) {
			this.rseq = rseq;
			this.reNumber = reNumber;
			this.reContent = reContent;
			this.reWriter = reWriter;
		}

		public Reply(int reNumber, String reContent) {
			this.reNumber = reNumber;
			this.reContent = reContent;
		}
		
		public Reply(int reNumber, String reContent, String reWriter) {
			this.reNumber = reNumber;
			this.reContent = reContent;
			this.reWriter = reWriter;
		}
		public int getRseq() {
			return rseq;
		}
		public void setRseq(int rseq) {
			this.rseq = rseq;
		}
		public int getReNumber() {
			return reNumber;
		}

		public void setReNumber(int reNumber) {
			this.reNumber = reNumber;
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
		@Override
		public String toString() {
			return "댓글번호 " + rseq + "원본글번호 " + reNumber
					+"댓글내용 " + reContent + "댓글작성자" + reWriter;
		}
		
	}




package project;

	public class Reply {
		private int reNumber;
		private String reContent;
		private String reWriter;

		public Reply() {};
		public Reply(int reNumber, String reContent, String reWriter) {
			this.reNumber = reNumber;
			this.reContent = reContent;
			this.reWriter = reWriter;
		}

		public Reply(int reNumber, String reContent) {
			this.reNumber = reNumber;
			this.reContent = reContent;
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
		
		
	}




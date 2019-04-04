package dto;

public class FreeDTO {
	private int idx;
	private int reff;
	private int seq;
	private String author;
	private String content;
	private boolean reply;
	
	
	
	public FreeDTO() {
		super();
	}
	
	
	

	public FreeDTO(int reff, String author, String content) {
		super();
		this.reff = reff;
		this.author=author;
		this.content=content;
	}




	public FreeDTO(int reff, int seq, String author, String content) {
		super();
		this.reff = reff;
		this.seq = seq;
		this.author = author;
		this.content = content;
	}



	public FreeDTO(int idx, int reff, int seq, String author, String content) {
		super();
		this.idx = idx;
		this.reff = reff;
		this.seq = seq;
		this.author = author;
		this.content = content;
	}
	
	
	
	



	public FreeDTO(int idx, int reff, int seq, String author, String content, boolean reply) {
		super();
		this.idx = idx;
		this.reff = reff;
		this.seq = seq;
		this.author = author;
		this.content = content;
		this.reply = reply;
	}




	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getReff() {
		return reff;
	}
	public void setReff(int reff) {
		this.reff = reff;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public boolean isReply() {
		return reply;
	}
	public void setReply(boolean reply) {
		this.reply = reply;
	}
	



	@Override
	public String toString() {
		return "FreeDTO [idx=" + idx + ", reff=" + reff + ", seq=" + seq + ", author=" + author + ", content=" + content
				+ "]";
	}
}	

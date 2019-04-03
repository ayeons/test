package dto;

public class FreeDTO {
	private int idx;
	private int ref;
	private int seq;
	private String author;
	private String content;
	private boolean reply;
	
	
	
	public FreeDTO() {
		super();
	}
	
	
	

	public FreeDTO(int ref, int seq) {
		super();
		this.ref = ref;
		this.seq = seq;
	}




	public FreeDTO(int ref, int seq, String author, String content) {
		super();
		this.ref = ref;
		this.seq = seq;
		this.author = author;
		this.content = content;
	}



	public FreeDTO(int idx, int ref, int seq, String author, String content) {
		super();
		this.idx = idx;
		this.ref = ref;
		this.seq = seq;
		this.author = author;
		this.content = content;
	}
	
	
	
	



	public FreeDTO(int idx, int ref, int seq, String author, String content, boolean reply) {
		super();
		this.idx = idx;
		this.ref = ref;
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
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
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
		return "FreeDTO [idx=" + idx + ", ref=" + ref + ", seq=" + seq + ", author=" + author + ", content=" + content
				+ "]";
	}
}	

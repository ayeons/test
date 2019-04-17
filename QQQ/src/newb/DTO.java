package newb;

public class DTO {
	private int idx;
	private int refg;
	private int seq;
	private int lev;
	private String author;
	private String content;
	private String title;
	private int views;
	
	public DTO() {
		super();
	}


	public DTO(int idx, int refg, int seq, int lev, String author, String content) {
		super();
		this.idx = idx;
		this.refg = refg;
		this.seq = seq;
		this.lev = lev;
		this.author = author;
		this.content = content;
	}

	
	public DTO(int idx, int refg, int seq, int lev, String author, String content, String title, int views) {
		super();
		this.idx = idx;
		this.refg = refg;
		this.seq = seq;
		this.lev = lev;
		this.author = author;
		this.content = content;
		this.title = title;
		this.views = views;
	}


	public int getIdx() {
		return idx;
	}


	public void setIdx(int idx) {
		this.idx = idx;
	}


	public int getRefg() {
		return refg;
	}


	public void setRefg(int refg) {
		this.refg = refg;
	}


	public int getSeq() {
		return seq;
	}


	public void setSeq(int seq) {
		this.seq = seq;
	}


	public int getLev() {
		return lev;
	}


	public void setLev(int lev) {
		this.lev = lev;
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


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getViews() {
		return views;
	}


	public void setViews(int views) {
		this.views = views;
	}


	@Override
	public String toString() {
		return "DTO [idx=" + idx + ", refg=" + refg + ", seq=" + seq + ", lev=" + lev + ", author=" + author
				+ ", content=" + content + "]";
	}
	
	
}

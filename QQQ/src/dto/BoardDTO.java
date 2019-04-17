package dto;

public class BoardDTO {
	private int id;
	private String writer;
	private String title;
	private String content;
	private String mail;
	
	
	public BoardDTO() {
		super();
	}
	
	
	public BoardDTO(int id, String writer, String title) {
		super();
		this.id = id;
		this.writer = writer;
		this.title = title;
	}


	public BoardDTO(int id, String writer, String title, String content, String mail) {
		super();
		this.id = id;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.mail = mail;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
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

	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	@Override
	public String toString() {
		return "BoardDTO [id=" + id + ", writer=" + writer + ", title=" + title + ", content=" + content + ", mail="
				+ mail + "]";
	}


	
}

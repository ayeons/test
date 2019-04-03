package dto;

public class BoardDTO {
	private int id;
	private String author;
	private String title;
	private String content;
	
	
	public BoardDTO() {
		super();
	}
	
	
	public BoardDTO(int id, String author, String title) {
		super();
		this.id = id;
		this.author = author;
		this.title = title;
	}


	public BoardDTO(int id, String author, String title, String content) {
		super();
		this.id = id;
		this.author = author;
		this.title = title;
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
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


	@Override
	public String toString() {
		return "BoardDTO [id=" + id + ", author=" + author + ", title=" + title + ", content=" + content + "]";
	}
	
	
}

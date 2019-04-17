package test;

import java.util.Date;

public class DTO {
	private int id;
	private Date date;
	private String content;
	
	public DTO() {
		super();
	}

	public DTO(int id, Date date, String content) {
		super();
		this.id = id;
		this.date = date;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "DTO [id=" + id + ", date=" + date + ", content=" + content + "]";
	}
	
	
}

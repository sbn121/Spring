package com.hanul.middle;

import java.sql.Date;

public class NoticeVO {
	
	private int id, reancnt;
	private String title, content, writer, filenmae, filepath;
	private Date writedate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getReancnt() {
		return reancnt;
	}
	public void setReancnt(int reancnt) {
		this.reancnt = reancnt;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getFilenmae() {
		return filenmae;
	}
	public void setFilenmae(String filenmae) {
		this.filenmae = filenmae;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public Date getWritedate() {
		return writedate;
	}
	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}
	
	

}

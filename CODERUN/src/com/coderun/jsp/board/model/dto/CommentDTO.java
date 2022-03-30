package com.coderun.jsp.board.model.dto;

import java.sql.Date;


public class CommentDTO {
	
	private int no;
	private String writer;
	private String content;
	private Date date;
	private Date update;
	private String delete;
	private int bdNo;
	
	public CommentDTO() {}

	public CommentDTO(int no, String writer, String content, Date date, Date update, String delete, int bdNo) {
		super();
		this.no = no;
		this.writer = writer;
		this.content = content;
		this.date = date;
		this.update = update;
		this.delete = delete;
		this.bdNo = bdNo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getUpdate() {
		return update;
	}

	public void setUpdate(Date update) {
		this.update = update;
	}

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public int getBdNo() {
		return bdNo;
	}

	public void setBdNo(int bdNo) {
		this.bdNo = bdNo;
	}

	@Override
	public String toString() {
		return "CommentDTO [no=" + no + ", writer=" + writer + ", content=" + content + ", date=" + date + ", update="
				+ update + ", delete=" + delete + ", bdNo=" + bdNo + "]";
	}


	

	

}

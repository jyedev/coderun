package com.coderun.jsp.board.model.dto;

import java.sql.Date;
import java.util.List;

import com.coderun.jsp.member.model.dto.MemberDTO;
import com.coderun.jsp.mentor.model.dto.CurriculumDTO;

public class BoardDTO {
	
	private int no;
	private String title;
	private String writerId; 
	private MemberDTO writer;
	private String content;
	private Date date;
	private Date update;
	private String delete;
	private List<CommentDTO> commentList;
	
	public BoardDTO() {}

	public BoardDTO(int no, String title, String writerId, MemberDTO writer, String content, Date date, Date update,
			String delete, List<CommentDTO> commentList) {
		super();
		this.no = no;
		this.title = title;
		this.writerId = writerId;
		this.writer = writer;
		this.content = content;
		this.date = date;
		this.update = update;
		this.delete = delete;
		this.commentList = commentList;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public MemberDTO getWriter() {
		return writer;
	}

	public void setWriter(MemberDTO writer) {
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

	public List<CommentDTO> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<CommentDTO> commentList) {
		this.commentList = commentList;
	}

	@Override
	public String toString() {
		return "BoardDTO [no=" + no + ", title=" + title + ", writerId=" + writerId + ", writer=" + writer
				+ ", content=" + content + ", date=" + date + ", update=" + update + ", delete=" + delete
				+ ", commentList=" + commentList + "]";
	}

}
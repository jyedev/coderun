package com.coderun.jsp.board.model.dto;

import java.sql.Date;

import com.coderun.jsp.member.model.dto.MemberDTO;

public class CommentDTO {
	private int no;
	private String writerId;
	private MemberDTO writer;
	private String content;
	private Date date;
	private Date update;
	private String delete;
	private int bdNo;
	private BoardDTO board;
	
	public CommentDTO() {}

	public CommentDTO(int no, String writerId, MemberDTO writer, String content, Date date, Date update, String delete,
			int bdNo, BoardDTO board) {
		super();
		this.no = no;
		this.writerId = writerId;
		this.writer = writer;
		this.content = content;
		this.date = date;
		this.update = update;
		this.delete = delete;
		this.bdNo = bdNo;
		this.board = board;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	public int getBdNo() {
		return bdNo;
	}

	public void setBdNo(int bdNo) {
		this.bdNo = bdNo;
	}

	public BoardDTO getBoard() {
		return board;
	}

	public void setBoard(BoardDTO board) {
		this.board = board;
	}

	@Override
	public String toString() {
		return "CommentDTO [no=" + no + ", writerId=" + writerId + ", writer=" + writer + ", content=" + content
				+ ", date=" + date + ", update=" + update + ", delete=" + delete + ", bdNo=" + bdNo + ", board=" + board
				+ "]";
	}
}

package com.coderun.jsp.board.model.dto;

import java.sql.Date;

import com.coderun.jsp.member.model.dto.MemberDTO;

public class ReportDTO {
	private int no;
	private String memberId;
	private MemberDTO member;
	private int bdNo;
	private BoardDTO board;
	private int cmtNo;
	private CommentDTO comment;
	private int typeNo;
	private String result;

	
	public ReportDTO() {}


	public ReportDTO(int no, String memberId, MemberDTO member, int bdNo, BoardDTO board, int cmtNo, CommentDTO comment,
			int typeNo, String result) {
		super();
		this.no = no;
		this.memberId = memberId;
		this.member = member;
		this.bdNo = bdNo;
		this.board = board;
		this.cmtNo = cmtNo;
		this.comment = comment;
		this.typeNo = typeNo;
		this.result = result;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public MemberDTO getMember() {
		return member;
	}


	public void setMember(MemberDTO member) {
		this.member = member;
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


	public int getCmtNo() {
		return cmtNo;
	}


	public void setCmtNo(int cmtNo) {
		this.cmtNo = cmtNo;
	}


	public CommentDTO getComment() {
		return comment;
	}


	public void setComment(CommentDTO comment) {
		this.comment = comment;
	}


	public int getTypeNo() {
		return typeNo;
	}


	public void setTypeNo(int typeNo) {
		this.typeNo = typeNo;
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	@Override
	public String toString() {
		return "ReportDTO [no=" + no + ", memberId=" + memberId + ", member=" + member + ", bdNo=" + bdNo + ", board="
				+ board + ", cmtNo=" + cmtNo + ", comment=" + comment + ", typeNo=" + typeNo + ", result=" + result
				+ "]";
	}
	
}

	
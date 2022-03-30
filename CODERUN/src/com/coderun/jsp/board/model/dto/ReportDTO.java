package com.coderun.jsp.board.model.dto;

import java.util.List;

public class ReportDTO {
	
	private int no;
	private String memberId;
	private int bdNo;
	private int cmtNo;
	private int typeNo;
	private String result;
	private ReportReasonDTO reportReason;
	private BoardDTO board;
	private CommentDTO comment;
	
	public ReportDTO() {}

	public ReportDTO(int no, String memberId, int bdNo, int cmtNo, int typeNo, String result,
			ReportReasonDTO reportReason, BoardDTO board, CommentDTO comment) {
		super();
		this.no = no;
		this.memberId = memberId;
		this.bdNo = bdNo;
		this.cmtNo = cmtNo;
		this.typeNo = typeNo;
		this.result = result;
		this.reportReason = reportReason;
		this.board = board;
		this.comment = comment;
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

	public int getBdNo() {
		return bdNo;
	}

	public void setBdNo(int bdNo) {
		this.bdNo = bdNo;
	}

	public int getCmtNo() {
		return cmtNo;
	}

	public void setCmtNo(int cmtNo) {
		this.cmtNo = cmtNo;
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

	public ReportReasonDTO getReportReason() {
		return reportReason;
	}

	public void setReportReason(ReportReasonDTO reportReason) {
		this.reportReason = reportReason;
	}

	public BoardDTO getBoard() {
		return board;
	}

	public void setBoard(BoardDTO board) {
		this.board = board;
	}

	public CommentDTO getComment() {
		return comment;
	}

	public void setComment(CommentDTO comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "ReportDTO [no=" + no + ", memberId=" + memberId + ", bdNo=" + bdNo + ", cmtNo=" + cmtNo + ", typeNo="
				+ typeNo + ", result=" + result + ", reportReason=" + reportReason + ", board=" + board + ", comment="
				+ comment + "]";
	}

	
	
}

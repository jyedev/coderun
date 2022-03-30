package com.coderun.jsp.board.model.dto;

public class ReportReasonDTO {

	private int typeNo;
	private String reason;
	
	public ReportReasonDTO() {}

	public ReportReasonDTO(int typeNo, String reason) {
		super();
		this.typeNo = typeNo;
		this.reason = reason;
	}

	public int getTypeNo() {
		return typeNo;
	}

	public void setTypeNo(int typeNo) {
		this.typeNo = typeNo;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "ReportReasonDTO [typeNo=" + typeNo + ", reason=" + reason + "]";
	}
	
	
	
}

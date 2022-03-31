package com.coderun.jsp.board.model.dto;

import java.sql.Date;

import com.coderun.jsp.member.model.dto.MemberDTO;

public class ReportReasonDTO {
	private int typeNo;
	private ReportDTO report;
	private String reason;

	
	public ReportReasonDTO() {}


	public ReportReasonDTO(int typeNo, ReportDTO report, String reason) {
		super();
		this.typeNo = typeNo;
		this.report = report;
		this.reason = reason;
	}


	public int getTypeNo() {
		return typeNo;
	}


	public void setTypeNo(int typeNo) {
		this.typeNo = typeNo;
	}


	public ReportDTO getReport() {
		return report;
	}


	public void setReport(ReportDTO report) {
		this.report = report;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	@Override
	public String toString() {
		return "ReportReasonDTO [typeNo=" + typeNo + ", report=" + report + ", reason=" + reason + "]";
	}
	
	


	
}

	
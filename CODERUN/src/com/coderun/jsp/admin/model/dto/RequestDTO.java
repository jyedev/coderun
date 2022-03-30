package com.coderun.jsp.admin.model.dto;

import java.sql.Date;

import com.coderun.jsp.member.model.dto.MemberDTO;

public class RequestDTO {

	private int reqNo;
	private String approveStatus;
	private Date reqDate;
	private String memberId;
	private MemberDTO member;
	
	public RequestDTO() {}

	public RequestDTO(int reqNo, String approveStatus, Date reqDate, String memberId, MemberDTO member) {
		super();
		this.reqNo = reqNo;
		this.approveStatus = approveStatus;
		this.reqDate = reqDate;
		this.memberId = memberId;
		this.member = member;
	}

	public int getReqNo() {
		return reqNo;
	}

	public void setReqNo(int reqNo) {
		this.reqNo = reqNo;
	}

	public String getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}

	public Date getReqDate() {
		return reqDate;
	}

	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
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

	@Override
	public String toString() {
		return "RequestDTO [reqNo=" + reqNo + ", approveStatus=" + approveStatus + ", reqDate=" + reqDate
				+ ", memberId=" + memberId + ", member=" + member + "]";
	}

	
}

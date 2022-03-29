package com.coderun.jsp.admin.model.dto;

import com.coderun.jsp.mentor.model.dto.MentorDTO;

public class CalculationDTO {
	
	private int no;
	private String status;
	private String period;
	private int percent;
	private int amount;
	private String memberId;
	private MentorDTO member;
	
	public CalculationDTO() {}

	public CalculationDTO(int no, String status, String period, int percent, int amount, String memberId,
			MentorDTO member) {
		super();
		this.no = no;
		this.status = status;
		this.period = period;
		this.percent = percent;
		this.amount = amount;
		this.memberId = memberId;
		this.member = member;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public MentorDTO getMember() {
		return member;
	}

	public void setMember(MentorDTO member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "CalculationDTO [no=" + no + ", status=" + status + ", period=" + period + ", percent=" + percent
				+ ", amount=" + amount + ", memberId=" + memberId + ", member=" + member + "]";
	}
}

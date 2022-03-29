package com.coderun.jsp.member.model.dto;

import java.sql.Date;

public class PaymentDTO {
	private int no;
	private Date date;
	private Date end;
	private String memberId;
	private MemberDTO member;
	private int price;
	
	public PaymentDTO() {}

	public PaymentDTO(int no, Date date, Date end, String memberId, MemberDTO member, int price) {
		super();
		this.no = no;
		this.date = date;
		this.end = end;
		this.memberId = memberId;
		this.member = member;
		this.price = price;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "PaymentDTO [no=" + no + ", date=" + date + ", end=" + end + ", memberId=" + memberId + ", member="
				+ member + ", price=" + price + "]";
	}
}

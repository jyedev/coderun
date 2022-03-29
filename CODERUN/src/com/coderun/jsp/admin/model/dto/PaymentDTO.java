package com.coderun.jsp.admin.model.dto;

import java.sql.Date;

public class PaymentDTO {
	
	private int no;
	private java.sql.Date date;
	private java.sql.Date end;
	private String memberId;
	private int price;
	
	public PaymentDTO() {}

	public PaymentDTO(int no, Date date, Date end, String memberId, int price) {
		super();
		this.no = no;
		this.date = date;
		this.end = end;
		this.memberId = memberId;
		this.price = price;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public java.sql.Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	public java.sql.Date getEnd() {
		return end;
	}

	public void setEnd(java.sql.Date end) {
		this.end = end;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "PaymentDTO [no=" + no + ", date=" + date + ", end=" + end + ", memberId=" + memberId + ", price="
				+ price + "]";
	}
	
	
	
}

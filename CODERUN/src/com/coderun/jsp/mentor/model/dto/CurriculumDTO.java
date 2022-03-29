package com.coderun.jsp.mentor.model.dto;

import java.util.List;

import com.coderun.jsp.member.model.dto.MemberDTO;
import com.coderun.jsp.mentor.model.dto.MentorDTO;

public class CurriculumDTO {

	private int no;
	private String name;      
	private String videoLink; 
	private int count;
	private String memberId;


	
	public CurriculumDTO() {}


	public CurriculumDTO(int no, String name, String videoLink, int count, String memberId) {
		super();
		this.no = no;
		this.name = name;
		this.videoLink = videoLink;
		this.count = count;
		this.memberId = memberId;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getVideoLink() {
		return videoLink;
	}


	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	@Override
	public String toString() {
		return "CurriculumDTO [no=" + no + ", name=" + name + ", videoLink=" + videoLink + ", count=" + count
				+ ", memberId=" + memberId + "]";
	}

	


	


	
	
	
}

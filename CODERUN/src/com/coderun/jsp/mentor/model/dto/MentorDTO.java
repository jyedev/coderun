package com.coderun.jsp.mentor.model.dto;

import java.util.List;

import com.coderun.jsp.admin.model.dto.RequestDTO;
import com.coderun.jsp.member.model.dto.ImageDTO;
import com.coderun.jsp.member.model.dto.MemberDTO;

public class MentorDTO {

	private String memberId;
	private MemberDTO member;
	private String nickname;
	private String introduce;
	private String language;
	private String strength;
	private List<CurriculumDTO> curriculumName;
	private ImageDTO image;
	private RequestDTO request;
	
	
	public MentorDTO() {}


	public MentorDTO(String memberId, MemberDTO member, String nickname, String introduce, String language,
			String strength, List<CurriculumDTO> curriculumName, ImageDTO image, RequestDTO request) {
		super();
		this.memberId = memberId;
		this.member = member;
		this.nickname = nickname;
		this.introduce = introduce;
		this.language = language;
		this.strength = strength;
		this.curriculumName = curriculumName;
		this.image = image;
		this.request = request;
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


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getIntroduce() {
		return introduce;
	}


	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public String getStrength() {
		return strength;
	}


	public void setStrength(String strength) {
		this.strength = strength;
	}


	public List<CurriculumDTO> getCurriculumName() {
		return curriculumName;
	}


	public void setCurriculumName(List<CurriculumDTO> curriculumName) {
		this.curriculumName = curriculumName;
	}


	public ImageDTO getImage() {
		return image;
	}


	public void setImage(ImageDTO image) {
		this.image = image;
	}


	public RequestDTO getRequest() {
		return request;
	}


	public void setRequest(RequestDTO request) {
		this.request = request;
	}


	@Override
	public String toString() {
		return "MentorDTO [memberId=" + memberId + ", member=" + member + ", nickname=" + nickname + ", introduce="
				+ introduce + ", language=" + language + ", strength=" + strength + ", curriculumName=" + curriculumName
				+ ", image=" + image + ", request=" + request + "]";
	}

	
		
}

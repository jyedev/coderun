package com.coderun.jsp.mentor.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coderun.jsp.member.model.dto.MemberDTO;
import com.coderun.jsp.mentor.model.dto.CurriculumDTO;
import com.coderun.jsp.mentor.model.dto.MentorDTO;
import com.coderun.jsp.mentor.model.service.MentorService;


@WebServlet("/mentor/information")
public class MentorInfoPageServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/mentor/mentorInformation.jsp").forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 아이디(세션에서 가져옴), 닉네임, 자기소개 받기 */
		String memberId = ((MemberDTO) request.getSession().getAttribute("loginMember")).getId();
		String nickname = request.getParameter("nickname");
		String introduce = request.getParameter("introduce");
		
		
		MentorDTO mentorInfo = new MentorDTO();
		mentorInfo.setMemberId(memberId);
		mentorInfo.setNickname(nickname);
		mentorInfo.setIntroduce(introduce);
		
		/* 커리큘럼 부분 */
		List<CurriculumDTO> requestCurriculum = new ArrayList<>();
	
		
		String[] curriArray = request.getParameterValues("curriculum");
		String[] videoArray = request.getParameterValues("video");
		
		
		
		/* 커리큘럼명 list에 담기 */

		if (curriArray != null) {
			for (int i = 0; i < curriArray.length; i++) {
				CurriculumDTO curriculum = new CurriculumDTO();
				curriculum.setMemberId(memberId);
				curriculum.setName(curriArray[i]);
				curriculum.setVideoLink(videoArray[i]);

				requestCurriculum.add(curriculum);

			}
		}
		
		mentorInfo.setCurriculumName(requestCurriculum);
	
		
		/* 멘토테이블 닉네임, 자기소개 update */
		int mentorResult = new MentorService().updateMentor(mentorInfo);
		
		
	
		
		
		String page = "";
		
		if(mentorResult > 0) {
			page = "/WEB-INF/views/main/main.jsp";
		} else {
			/* 실패시에는 어디로 보내지...*/
		}
		
		request.getRequestDispatcher(page).forward(request, response);
		
	} 

}

package com.coderun.jsp.mentor.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coderun.jsp.member.model.dto.MemberDTO;
import com.coderun.jsp.mentor.model.dto.MentorDTO;
import com.coderun.jsp.mentor.model.service.MentorService;


@WebServlet("/mentor/detail")
public class MentorSelectDetailServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String memberId = request.getParameter("memberId");
		
		
		System.out.println("memberId : " + memberId);
		
		MentorService mentorService = new MentorService();
		MentorDTO mentorDetail = mentorService.selectMentorDetail(memberId);

		
		System.out.println("멘토 상세 : " + mentorDetail);
		
		
		String path = "";
		if(mentorDetail != null) {
			path = "/WEB-INF/views/mentor/mentorDetailList.jsp";
			request.setAttribute("mentor", mentorDetail);
		} else {
			/* 멘토 상세 조회 오류시에 보낼 페이지 */
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}

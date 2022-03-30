package com.coderun.jsp.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coderun.jsp.admin.model.service.AdminService;
import com.coderun.jsp.member.model.dto.MemberDTO;
import com.coderun.jsp.mentor.model.dto.MentorDTO;

@WebServlet("/admin/mentordetail")
public class AdminMentorDetailServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = (String) (request.getParameter("memberId"));
		
		MentorDTO mentorDetail = new AdminService().selectOneMentor(memberId);
		System.out.println(mentorDetail);
		
		String path = "";
		if(mentorDetail != null) {
			path = "/WEB-INF/views/admin/mentorDetail.jsp";
			request.setAttribute("mentorDetail", mentorDetail);
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}

package com.coderun.jsp.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coderun.jsp.admin.model.service.AdminService;
import com.coderun.jsp.member.model.service.MemberService;


@WebServlet("/admin/reject")
public class MentorRejectServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberId = request.getParameter("memberId");
		int reqNo = Integer.parseInt(request.getParameter("reqNo"));
		
		int result1 = new AdminService().rejectMentor(reqNo);
		int result2 = new MemberService().rejectMentor(memberId);
		
		if(result1 > 0 && result2 > 0) {
			request.setAttribute("rejectMentorResult", "success");
			response.sendRedirect(request.getContextPath() + "/admin/mentordetail?memberId=" + memberId);
		} else {
			request.setAttribute("rejectMentorResult", "failed");
			response.sendRedirect(request.getContextPath() + "/admin/mentordetail?memberId=" + memberId);
		}
		
	}

}

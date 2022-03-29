package com.coderun.jsp.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coderun.jsp.admin.model.service.AdminService;
import com.coderun.jsp.member.model.dto.MemberDTO;

@WebServlet("/admin/memberdetail")
public class AdminMemberDetailServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String)(request.getParameter("id"));
		
		MemberDTO memberDetail = new AdminService().selectOneMember(id);
		System.out.println(memberDetail);
		
		String path = "";
		if(memberDetail != null) {
			path ="/WEB-INF/views/admin/memberDetail.jsp";
			request.setAttribute("memberDetail", memberDetail);
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	
}

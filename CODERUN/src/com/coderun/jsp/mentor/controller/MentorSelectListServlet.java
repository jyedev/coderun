package com.coderun.jsp.mentor.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coderun.jsp.mentor.model.dto.MentorDTO;
import com.coderun.jsp.mentor.model.service.MentorService;


@WebServlet("/mentor/list")
public class MentorSelectListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<MentorDTO> mentorList = new MentorService().selectAllMentorList();
		
		System.out.println("멘토 목록 : " + mentorList);
		
		String path= "";
		if(mentorList != null) {
			path ="/WEB-INF/views/mentor/mentorList.jsp";
			request.setAttribute("mentorList", mentorList);
		} else {
			/* 조회 실패시에 보낼 페이지 */
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

/*	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	} */

}

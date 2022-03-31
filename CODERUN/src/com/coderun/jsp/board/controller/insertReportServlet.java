package com.coderun.jsp.board.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coderun.jsp.member.model.dto.MemberDTO;
import com.coderun.jsp.board.model.dto.BoardDTO;
import com.coderun.jsp.board.model.dto.ReportDTO;
import com.coderun.jsp.board.model.service.BoardService;

@WebServlet("/report/insert")
public class insertReportServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberId  = ((MemberDTO) request.getSession().getAttribute("loginMember")).getId();
		int bdNo = Integer.parseInt(request.getParameter("bdNo"));
		int cmtNo = Integer.parseInt(request.getParameter("cmtNo"));
		int typeNo = Integer.parseInt(request.getParameter("typeNo"));
		
		ReportDTO newReport = new ReportDTO();
		newReport.setMemberId(memberId);
		newReport.setBdNo(bdNo);
		newReport.setCmtNo(cmtNo);
		newReport.setTypeNo(typeNo);
		
		BoardService boardService = new BoardService();
		int result = boardService.insertReport(newReport);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "insertReport");
			
		} else {
			path = "/WEB-INF/views/board/insertBoard.jsp";
			request.setAttribute("message", "신고글 작성에 실패하셨습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}
}

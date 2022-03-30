package com.coderun.jsp.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coderun.jsp.admin.model.service.AdminService;
import com.coderun.jsp.board.model.dto.ReportDTO;

@WebServlet("/admin/reportdetail")
public class AdminReportDetailServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		
		ReportDTO reportDetail = new AdminService().selectOneReport(no);
		
		System.out.println("신고 상세 : " + reportDetail);
		
		String path = "";
		if(reportDetail != null) {
			path = "/WEB-INF/views/admin/reportDetail.jsp";
			request.setAttribute("reportDetail", reportDetail);
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}

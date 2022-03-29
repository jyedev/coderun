package com.coderun.jsp.admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coderun.jsp.admin.model.service.AdminService;

@WebServlet("/admin/mentor/list")
public class AdminMentorServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
			
		}
		
		if(pageNo <= 0) {
			pageNo =1;
		}
		
		String searchCondition = "id";
		String searchValue = request.getParameter("searchValue");
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);
		
		AdminService adminService = new AdminService();
		
		Map<String, Object> returnMap = adminService.selectMentorList(pageNo, searchMap);
		
		System.out.println("mentorList : " + returnMap.get("mentorList"));
		System.out.println("selectCriteria : " + returnMap.get("selectCriteria"));
		
		String path ="";
		if(returnMap.get("mentorList") != null && returnMap.get("selectCriteria") != null) {
			path = "/WEB-INF/views/admin/mentor.jsp";
			request.setAttribute("mentorList", returnMap.get("mentorList"));
			request.setAttribute("selectCriteria", returnMap.get("selectCriteria"));
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "조회된 결과가 없습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);

	}
	

}

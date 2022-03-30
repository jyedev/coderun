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

@WebServlet("/admin/report/list")
public class AdminReportServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;

		if (currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);

		}
		// 0보다 작은 숫자값을 입력해도 1페이지를 보여준다.
		if (pageNo <= 0) {
			pageNo = 1;
		}

		String searchCondition = "memberId";
		String searchValue = request.getParameter("searchValue");

		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);

		AdminService adminService = new AdminService();

		Map<String, Object> returnMap = adminService.selectReportList(pageNo, searchMap);

		System.out.println("reportList : " + returnMap.get("reportList"));
		System.out.println("selectCriteria : " + returnMap.get("selectCriteria"));

		String path = "";
		if (returnMap.get("reportList") != null && returnMap.get("selectCriteria") != null) {
			path = "/WEB-INF/views/admin/report.jsp";
			request.setAttribute("reportList", returnMap.get("reportList"));
			request.setAttribute("selectCriteria", returnMap.get("selectCriteria"));
		} else {
			// 함수식으로 실패한 경우일 시 그 path로 보내고, message를 alert창으로 보여주기
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "조회된 결과가 없습니다.");

		}

		request.getRequestDispatcher(path).forward(request, response);
	}

}

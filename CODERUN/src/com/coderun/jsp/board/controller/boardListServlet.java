package com.coderun.jsp.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.coderun.jsp.board.model.dto.BoardDTO;
import com.coderun.jsp.board.model.service.BoardService;
import com.coderun.jsp.member.model.dto.MemberDTO;
import com.coderun.jsp.member.model.service.MemberService;
import com.coderun.jsp.common.paging.Pagenation;
import com.coderun.jsp.common.paging.SelectCriteria;

@WebServlet("/board/list")
public class boardListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/views/board/boardList.jsp";

		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);
		
		BoardService boardService = new BoardService();
		
		Map<String, Object> returnMap = boardService.selectBoardList(pageNo, searchMap);
		
		System.out.println("boardList : " + returnMap.get("boardList"));
		System.out.println("selectCriteria : " + returnMap.get("selectCriteria"));
		
		if(returnMap.get("boardList") != null && returnMap.get("selectCriteria") != null) {
			path = "/WEB-INF/views/board/boardList.jsp";
			request.setAttribute("boardList", returnMap.get("boardList"));
			request.setAttribute("selectCriteria", returnMap.get("selectCriteria"));
		} else {
			path = "/WEB-INF/views/board/boardList.jsp";
			request.setAttribute("message", "게시물 목록 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		

	}
}

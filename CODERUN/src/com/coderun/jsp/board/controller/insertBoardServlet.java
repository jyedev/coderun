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
import com.coderun.jsp.board.model.service.BoardService;

@WebServlet("/board/insert")
public class insertBoardServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/views/board/insertBoard.jsp";

		request.getRequestDispatcher(path).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writerId = ((MemberDTO)request.getSession().getAttribute("loginMember")).getId();
		
		BoardDTO newBoard = new BoardDTO();
		newBoard.setTitle(title);
		newBoard.setContent(content);
		newBoard.setWriterId(writerId);
		
		BoardService boardService = new BoardService();
		int result = boardService.insertBoard(newBoard);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "insertBoard");
			
		} else {
			path = "/WEB-INF/views/board/insertBoard.jsp";
			request.setAttribute("message", "게시판 작성에 실패하셨습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}
}

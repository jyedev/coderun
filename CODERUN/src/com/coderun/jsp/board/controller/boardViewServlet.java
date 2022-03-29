package com.coderun.jsp.board.controller;

import java.io.IOException;
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

@WebServlet("/board/view")
public class boardViewServlet extends HttpServlet {
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		BoardService boardService = new BoardService();
		BoardDTO boardView = boardService.selectBoardView(no);
		
		System.out.println("boardView : " + boardView);
		
		String path = "";
		if(boardView != null) {
			path = "/WEB-INF/views/board/boardView.jsp";
			request.setAttribute("board", boardView);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "게시글 상세 보기 조회에 실패하였습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}

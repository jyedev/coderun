package com.coderun.jsp.board.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coderun.jsp.board.model.dto.BoardDTO;
import com.coderun.jsp.board.model.service.BoardService;

@WebServlet("/board/update")
public class updateBoardServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		BoardService boardService = new BoardService();
		BoardDTO updateBoard = boardService.selectBoardView(no);
		
		String path = "";
		if(updateBoard != null) {
			path = "/WEB-INF/views/board/updateBoard.jsp";
			request.setAttribute("board", updateBoard);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "게시글 수정용 조회하기 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDTO updateBoard = new BoardDTO();
		updateBoard.setNo(no);
		updateBoard.setTitle(title);
		updateBoard.setContent(content);
		
		BoardService boardService = new BoardService();
		int result = boardService.updateBoard(updateBoard);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "updateBoard");
			request.setAttribute("no", no);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "게시글 수정에 실패하셨습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
	}
	
}

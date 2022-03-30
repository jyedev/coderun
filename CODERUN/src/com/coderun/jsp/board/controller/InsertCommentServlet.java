package com.coderun.jsp.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coderun.jsp.board.model.dto.CommentDTO;
import com.coderun.jsp.board.model.service.BoardService;
import com.coderun.jsp.member.model.dto.MemberDTO;

@WebServlet("/board/insertComment")
public class InsertCommentServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String content = request.getParameter("content");
		String writerId = ((MemberDTO)request.getSession().getAttribute("loginMember")).getId();
		int bdNo = Integer.parseInt(request.getParameter("bdNo"));
		
		CommentDTO newComment = new CommentDTO();
		newComment.setContent(content);
		newComment.setWriterId(writerId);
		newComment.setBdNo(bdNo);
		
		BoardService boardService = new BoardService();
		int result = boardService.insertComment(newComment);
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/board/view?no=" + bdNo);
		} else {
			request.setAttribute("insertCommentResult", "fail");
			request.getRequestDispatcher("/WEB-INF/views/board/list").forward(request, response);
		}
	}

}

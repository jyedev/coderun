package com.coderun.jsp.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coderun.jsp.board.model.dto.CommentDTO;
import com.coderun.jsp.board.model.service.BoardService;

@WebServlet("/board/updateComment")
public class UpdateCommentServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		int bdNo = Integer.parseInt(request.getParameter("bdNo"));
		String content = request.getParameter("content");
		
		CommentDTO updateComment = new CommentDTO();
		
		updateComment.setNo(no);
		updateComment.setContent(content);
		
		int result = new BoardService().updateComment(updateComment);
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/board/view?no=" + bdNo);
		} else {
			request.setAttribute("deleteCommentResult", "fail");
			request.getRequestDispatcher("/WEB-INF/views/board/list").forward(request, response);
		}
	}

}

package com.coderun.jsp.mentor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coderun.jsp.member.model.dto.MemberDTO;
import com.coderun.jsp.member.model.dto.PaymentDTO;
import com.coderun.jsp.member.model.service.PaymentService;

@WebServlet("/mentor/paySuccess")
public class PaySuccessServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 결제 테이블에 추가
		String memberId = ((MemberDTO)request.getSession().getAttribute("loginMember")).getId();
		
		PaymentDTO payment = new PaymentDTO();
		payment.setMemberId(memberId);
		
		int result = new PaymentService().registPayment(payment);
		int result2 = new PaymentService().updateFreepass(memberId);
		
		if(result > 0 && result2 > 0) {
			request.setAttribute("payResult", "success");
		} else {
			request.setAttribute("payResult", "fail");
		}
		
		// 멘토 소개쪽으로 변경!!!!!!
		request.getRequestDispatcher("/WEB-INF/views/mentor/payLecture.jsp").forward(request, response);
	}

}

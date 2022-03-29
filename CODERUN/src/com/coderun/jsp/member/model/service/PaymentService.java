package com.coderun.jsp.member.model.service;

import static com.coderun.jsp.common.mybatis.Template.getSqlSession;

import org.apache.ibatis.session.SqlSession;

import com.coderun.jsp.member.model.dao.PaymentDAO;
import com.coderun.jsp.member.model.dto.PaymentDTO;

public class PaymentService {
	
	private final PaymentDAO paymentDAO;
	
	public PaymentService() {
		paymentDAO = new PaymentDAO();
	}

	public int registPayment(PaymentDTO payment) {
		SqlSession session = getSqlSession();
		
		int result = paymentDAO.insertPayment(session, payment);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}
	
}

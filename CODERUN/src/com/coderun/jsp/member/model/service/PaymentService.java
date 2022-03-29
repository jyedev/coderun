package com.coderun.jsp.member.model.service;

import static com.coderun.jsp.common.mybatis.Template.getSqlSession;

import org.apache.ibatis.session.SqlSession;

import com.coderun.jsp.member.model.dao.MemberDAO;
import com.coderun.jsp.member.model.dao.PaymentDAO;
import com.coderun.jsp.member.model.dto.PaymentDTO;

public class PaymentService {
	
	private final PaymentDAO paymentDAO;
	private final MemberDAO memberDAO;
	
	public PaymentService() {
		paymentDAO = new PaymentDAO();
		memberDAO = new MemberDAO();
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

	public int updateFreepass(String memberId) {
		SqlSession session = getSqlSession();
		
		int result = memberDAO.updateFreepass(session, memberId);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}
	
}

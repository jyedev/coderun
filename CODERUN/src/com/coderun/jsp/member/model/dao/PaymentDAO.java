package com.coderun.jsp.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.coderun.jsp.member.model.dto.PaymentDTO;

public class PaymentDAO {

	public int insertPayment(SqlSession session, PaymentDTO payment) {
		return session.insert("PaymentDAO.insertPayment", payment);
	}

}

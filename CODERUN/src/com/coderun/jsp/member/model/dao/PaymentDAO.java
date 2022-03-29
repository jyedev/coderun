package com.coderun.jsp.member.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.coderun.jsp.common.paging.SelectCriteria;
import com.coderun.jsp.member.model.dto.PaymentDTO;

public class PaymentDAO {

	public int insertPayment(SqlSession session, PaymentDTO payment) {
		return session.insert("PaymentDAO.insertPayment", payment);
	}
	
	public int selectTotalCount(SqlSession session, Map<String, String> searchMap) {
		
		return session.selectOne("PaymentDAO.selectTotalCount", searchMap);
	}

	public List<PaymentDTO> selectPaymentList(SqlSession session, SelectCriteria selectCriteria) {
		
		return session.selectList("PaymentDAO.selectPaymentList", selectCriteria);
	}

}

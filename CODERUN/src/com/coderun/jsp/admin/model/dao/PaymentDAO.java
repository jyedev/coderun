package com.coderun.jsp.admin.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.coderun.jsp.admin.model.dto.PaymentDTO;
import com.coderun.jsp.common.paging.SelectCriteria;

public class PaymentDAO {

	public int selectTotalCount(SqlSession session, Map<String, String> searchMap) {
		
		return session.selectOne("PaymentDAO.selectTotalCount", searchMap);
	}

	public List<PaymentDTO> selectPaymentList(SqlSession session, SelectCriteria selectCriteria) {
		
		return session.selectList("PaymentDAO.selectPaymentList", selectCriteria);
	}

}

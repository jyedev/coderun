package com.coderun.jsp.admin.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.coderun.jsp.admin.model.dto.CalculationDTO;
import com.coderun.jsp.common.paging.SelectCriteria;

public class CalculationDAO {
	
	public int selectTotalCount(SqlSession session, Map<String, String> searchMap) {
		return session.selectOne("CalculationDAO.selectTotalCount", searchMap);
	}
	
	public List<CalculationDTO> selectCalculationList(SqlSession session, SelectCriteria selectCriteria) {
		return session.selectList("CalculationDAO.selectCalculationList", selectCriteria);
	}

}

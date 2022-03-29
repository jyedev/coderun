package com.coderun.jsp.admin.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.coderun.jsp.admin.model.dto.RequestDTO;
import com.coderun.jsp.common.paging.SelectCriteria;

public class RequestDAO {

	public static int insertRequest(SqlSession session, RequestDTO requestCall) {
		return session.insert("RequestDAO.insertRequest", requestCall);
	}

	public int selectTotalCount(SqlSession session, Map<String, String> searchMap) {

		return session.selectOne("RequestDAO.selectTotalCount", searchMap);
	}


	public List<RequestDTO> selectMentorList(SqlSession session, SelectCriteria selectCriteria) {
	
		return session.selectList("RequestDAO.selectMentorList", selectCriteria);
	}
	
	
}

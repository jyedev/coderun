package com.coderun.jsp.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.coderun.jsp.board.model.dto.ReportDTO;
import com.coderun.jsp.common.paging.SelectCriteria;

public class ReportDAO {

	public int selectTotalCount(SqlSession session, Map<String, String> searchMap) {
		
		return session.selectOne("ReportDAO.selectTotalCount", searchMap);
	}

	public List<ReportDTO> selectReportList(SqlSession session, SelectCriteria selectCriteria) {
		
		return session.selectList("ReportDAO.selectReportList", selectCriteria);
	}

	public ReportDTO selectOneReport(SqlSession session, int no) {
		
		return session.selectOne("ReportDAO.selectOneReport", no);
	}



}

package com.coderun.jsp.admin.model.service;

import static com.coderun.jsp.common.mybatis.Template.getSqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.coderun.jsp.admin.model.dao.CalculationDAO;
import com.coderun.jsp.admin.model.dao.RequestDAO;
import com.coderun.jsp.admin.model.dto.CalculationDTO;
import com.coderun.jsp.admin.model.dto.RequestDTO;
import com.coderun.jsp.board.model.dao.ReportDAO;
import com.coderun.jsp.board.model.dto.ReportDTO;
import com.coderun.jsp.common.paging.Pagenation;
import com.coderun.jsp.common.paging.SelectCriteria;
import com.coderun.jsp.member.model.dao.MemberDAO;
import com.coderun.jsp.member.model.dao.PaymentDAO;
import com.coderun.jsp.member.model.dto.MemberDTO;
import com.coderun.jsp.member.model.dto.PaymentDTO;
import com.coderun.jsp.mentor.model.dao.MentorDAO;
import com.coderun.jsp.mentor.model.dto.MentorDTO;

public class AdminService {
	
	private final MemberDAO memberDAO;
	private final PaymentDAO paymentDAO;
	private final CalculationDAO calculationDAO;
	private final RequestDAO requestDAO;
	private final MentorDAO mentorDAO;
	private final ReportDAO reportDAO;
	public AdminService() {
		
		memberDAO = new MemberDAO();
		paymentDAO = new PaymentDAO();
		calculationDAO = new CalculationDAO();
		requestDAO = new RequestDAO();
		mentorDAO = new MentorDAO();
		reportDAO = new ReportDAO();
	}
	
	// 검색한 회원 목록 조회용 메소드
	public Map<String, Object> selectMemberList(int pageNo, Map<String, String> searchMap) {
		
		SqlSession session = getSqlSession();
		
		int totalCount = memberDAO.selectTotalCount(session, searchMap);
		System.out.println("totalMemberCount : " + totalCount);
		
		int limit = 10;
		
		int buttonAmount = 5;
		
		SelectCriteria selectCriteria = null;
		
		if(searchMap.get("searchCondition") != null && !"".equals(searchMap.get("searchCondition"))) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchMap.get("searchCondition"), searchMap.get("searchValue"));
		} else  {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		
		System.out.println(selectCriteria);
		
		List<MemberDTO> memList = memberDAO.selectMemberList(session, selectCriteria);
		
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("memList", memList);
		returnMap.put("selectCriteria", selectCriteria);
		
		session.close();
		
		return returnMap;
	}


	public MemberDTO selectOneMember(String id) {

		SqlSession session = getSqlSession();
		
		MemberDTO memberDetail = null;
		
		memberDetail = memberDAO.selectOneMember(session, id);

		if(memberDetail != null) {
			session.commit();
		} else {
			session.rollback();
		}
		
		
		session.close();
		
		return memberDetail;
	}
	// 해당 아이디를 가진 멘토의 상세정보
	public MentorDTO selectOneMentor(String memberId) {
		
		SqlSession session = getSqlSession();
		
		MentorDTO mentorDetail = null;
		
		mentorDetail = mentorDAO.selectOneMentor(session, memberId);
		
		if(mentorDetail != null) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return mentorDetail;
	}
	
	
	public Map<String, Object> selectPaymentList(int pageNo, Map<String, String> searchMap) {
		
		SqlSession session = getSqlSession();
		
		int totalCount = paymentDAO.selectTotalCount(session, searchMap);
		System.out.println("totalPaymentCount : " + totalCount);
		
		int limit = 10;
		
		int buttonAmount = 5;
		
		SelectCriteria selectCriteria = null;
		
		if(searchMap.get("searchCondition") != null && !"".equals(searchMap.get("searchCondition"))) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchMap.get("searchCondition"), searchMap.get("searchValue"));
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		
		System.out.println(selectCriteria);
		
		List<PaymentDTO> paymentList = paymentDAO.selectPaymentList(session, selectCriteria);
		
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("paymentList", paymentList);
		returnMap.put("selectCriteria", selectCriteria);
		
		session.close();
		
		return returnMap;
	}

	public Map<String, Object> selectCalculationList(int pageNo, Map<String, String> searchMap) {
		SqlSession session = getSqlSession();
		
		int totalCount = calculationDAO.selectTotalCount(session, searchMap);
		System.out.println("totalCalculationCount : " + totalCount);
		
		int limit = 10;
		
		int buttonAmount = 5;
		
		SelectCriteria selectCriteria = null;
		
		if(searchMap.get("searchCondition") != null && !"".equals(searchMap.get("searchCondition"))) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchMap.get("searchCondition"), searchMap.get("searchValue"));
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		
		System.out.println(selectCriteria);
		
		List<CalculationDTO> calculationList = calculationDAO.selectCalculationList(session, selectCriteria);
		
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("calculationList", calculationList);
		returnMap.put("selectCriteria", selectCriteria);
		
		session.close();
		
		return returnMap;
	}

	public Map<String, Object> selectMentorList(int pageNo, Map<String, String> searchMap) {
        
        SqlSession session = getSqlSession();
        
        int totalCount = requestDAO.selectTotalCount(session, searchMap);
        System.out.println("totalMentorCount : " + totalCount);
        
        int limit = 10;
        
        int buttonAmount = 5;
        
        SelectCriteria selectCriteria = null;
        
        if(searchMap.get("searchCondition") != null && !"".equals(searchMap.get("searchCondition"))) {
           selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchMap.get("searchCondition"), searchMap.get("searchValue"));
        } else {
           selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
        }
           
        System.out.println(selectCriteria);
     
        List<RequestDTO> mentorList = requestDAO.selectMentorList(session, selectCriteria);
        
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("mentorList", mentorList);
        returnMap.put("selectCriteria", selectCriteria);
        
        session.close();
        
        return returnMap;
     }

	public int acceptMentor(int reqNo) {

		SqlSession session = getSqlSession();
		
		int result = RequestDAO.acceptMentor(session, reqNo);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		return result;
	}

	public int rejectMentor(int reqNo) {

		SqlSession session = getSqlSession();
		
		int result = RequestDAO.rejectMentor(session, reqNo);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		return result;
	}

	public Map<String, Object> selectReportList(int pageNo, Map<String, String> searchMap) {
		
		SqlSession session = getSqlSession();
		
		int totalCount = reportDAO.selectTotalCount(session, searchMap);
		System.out.println("totalMemberCount : " + totalCount);
		
		int limit = 10;
		
		int buttonAmount = 5;
		
		SelectCriteria selectCriteria = null;
		
		if(searchMap.get("searchCondition") != null && !"".equals(searchMap.get("searchCondition"))) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchMap.get("searchCondition"), searchMap.get("searchValue"));
		} else  {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		
		System.out.println(selectCriteria);
		
		List<ReportDTO> reportList = reportDAO.selectReportList(session, selectCriteria);
		
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("reportList", reportList);
		returnMap.put("selectCriteria", selectCriteria);
		
		session.close();
		
		return returnMap;
		
	}

	public ReportDTO selectOneReport(int no) {
		SqlSession session = getSqlSession();
		
		ReportDTO reportDetail = null;
		
		reportDetail = reportDAO.selectOneReport(session, no);

		if(reportDetail != null) {

			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		
		return reportDetail;
	}

	

	


		
		
	

}

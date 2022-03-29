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
import com.coderun.jsp.common.paging.Pagenation;
import com.coderun.jsp.common.paging.SelectCriteria;
import com.coderun.jsp.member.model.dao.MemberDAO;
import com.coderun.jsp.member.model.dao.PaymentDAO;
import com.coderun.jsp.member.model.dto.MemberDTO;
import com.coderun.jsp.member.model.dto.PaymentDTO;

public class AdminService {
	
	private final MemberDAO memberDAO;
	private final PaymentDAO paymentDAO;
	private final CalculationDAO calculationDAO;
	private final RequestDAO requestDAO;
	public AdminService() {
		
		memberDAO = new MemberDAO();
		paymentDAO = new PaymentDAO();
		calculationDAO = new CalculationDAO();
		requestDAO = new RequestDAO();
	}
	
//	public List<MemberDTO> selectAllEmp() {
//		
//		SqlSession session = getSqlSession();
//				
//		List<MemberDTO> memList = memberDAO.selectAllMember(session);
//
//		session.close();
//		
//		return memList;
//	}
	
	
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

}

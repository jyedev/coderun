package com.coderun.jsp.mentor.model.service;

import static com.coderun.jsp.common.mybatis.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.coderun.jsp.mentor.model.dao.MentorDAO;
import com.coderun.jsp.mentor.model.dto.CurriculumDTO;
import com.coderun.jsp.mentor.model.dto.MentorDTO;

public class MentorService {
	
	private final MentorDAO mentorDAO;
	
	public MentorService() {
		mentorDAO = new MentorDAO();
	}
	
	/* 강사 신청용 메소드 */
	public int registMentor(MentorDTO requestMentor) {
		
		SqlSession session = getSqlSession();
		
		int result = mentorDAO.insertMentor(session, requestMentor);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}

	/* 멘토 목록 전체 조회용 메소드 */
	public List<MentorDTO> selectAllMentorList() {
		
		SqlSession session = getSqlSession();
		
		List<MentorDTO> mentorList = mentorDAO.selectAllMentorList(session);
	
		session.close();
		
		return mentorList;
		
	}

	/* 멘토 상세페이지 메소드 */
/*	public MentorDTO selectMentorDetail(String memberId) {
		
		SqlSession session = getSqlSession();
		MentorDTO mentorDetail = null;
		
		
		int result = mentorDAO.incrementMentorCount(session, memberId);

		if(result > 0) {
			//쿼리문에서 JOIN해서 커리큘럼 테이블, 멘토 테이블 다 가지고 와서 담기
			mentorDetail = mentorDAO.selectMentorDetail(session, memberId);
			
			if(mentorDetail != null) {
				session.commit();
			} else {
				session.rollback();
			}
		} else {
			session.rollback();
		}

		session.close();
		
		return mentorDetail;
} */

	/* 멘토 상세페이지 조회 메소드 */
	public MentorDTO selectMentorDetail(String memberId) {
		
		SqlSession session = getSqlSession();
		
		MentorDTO mentorDetail = mentorDAO.selectMentorDetail(session, memberId);
		
		session.close();
		
		return mentorDetail;
	}

	
	/* 멘토 정보 수정용 메소드 */
	public int updateMentor(MentorDTO mentorInfo) {
		
		SqlSession session = getSqlSession();
		
		int result = 0;
		
		int result1 = mentorDAO.updateMentor(session, mentorInfo);
		
		int result2 = 0;
		
		for(CurriculumDTO curriculum : mentorInfo.getCurriculumName()) {
			result2 += mentorDAO.insertCurriculum(session, curriculum);
		}
		
		if(result1 > 0 && result2 == mentorInfo.getCurriculumName().size()) {
			session.commit();
			result = 1;
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}







		
	}
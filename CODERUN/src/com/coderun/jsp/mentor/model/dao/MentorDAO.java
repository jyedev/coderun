package com.coderun.jsp.mentor.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.coderun.jsp.mentor.model.dto.CurriculumDTO;
import com.coderun.jsp.mentor.model.dto.MentorDTO;

public class MentorDAO {

	/* 멘토 신청용 메소드 */
	public int insertMentor(SqlSession session, MentorDTO requestMentor) {
		
		return session.insert("MentorDAO.insertMentor", requestMentor);
	}


	
	/* 멘토 목록 조회용 메소드 */
	public List<MentorDTO> selectAllMentorList(SqlSession session) {

		return session.selectList("MentorDAO.selectAllMentorList");

		//List<MentorDTO> mentorList = new ArrayList();
		//mentorList = session.selectList("MentorDAO.selectAllMentorList");
		//return mentorList;
	
		
	}
	
	/* 멘토 상세페이지 메소드 */
	public MentorDTO selectMentorDetail(SqlSession session, String memberId) {
		return session.selectOne("MentorDAO.selectMentorDetail", memberId);
	}


	/* 멘토 정보 수정용 메소드 */
	public int updateMentor(SqlSession session, MentorDTO mentorInfo) {
		
		return session.update("MentorDAO.updateMentor", mentorInfo); 
	}


	public int insertCurriculum(SqlSession session, CurriculumDTO curriculum) {
		return session.insert("MentorDAO.insertCurriculum", curriculum);
	}



	public List<CurriculumDTO> selectCurriDetail(SqlSession session, String memberId) {
		// TODO Auto-generated method stub
		return null;
	}









	



	
}

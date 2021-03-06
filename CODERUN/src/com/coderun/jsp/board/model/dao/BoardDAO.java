package com.coderun.jsp.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.coderun.jsp.board.model.dto.BoardDTO;
import com.coderun.jsp.board.model.dto.CommentDTO;
import com.coderun.jsp.common.paging.SelectCriteria;

public class BoardDAO {
	
	public int selectTotalCount(SqlSession session, Map<String, String> searchMap) {
		
		return session.selectOne("BoardDAO.selectTotalCount", searchMap);
				
	}
	
	/* 게시판 목록 전체 조회용 메소드 */
	public List<BoardDTO> selectBoardList(SqlSession session, SelectCriteria selectCriteria) {
		
		return session.selectList("BoardDAO.selectBoardList", selectCriteria);
	}

	/* 게시판 작성용 메소드*/
	public int insertBoard(SqlSession session, BoardDTO newBoard) {
		
		return session.insert("BoardDAO.insertBoard", newBoard);
	}
	
	/* 게시판 상세보기 조회용 메소드 */
	public BoardDTO selectBoardView(SqlSession session, int no) {
		
		return session.selectOne("BoardDAO.selectBoardView", no);
	}
	
	/* 게시판 수정용 메소드 */
	public int updateBoard(SqlSession session, BoardDTO updateBoard) {
		
		return session.update("BoardDAO.updateBoard", updateBoard);
		
	}

	/* 게시판 삭제용 메소드 */
	public int deleteBoard(SqlSession session, int no) {
		
		return session.update("BoardDAO.deleteBoard", no);
		
	}

	public int insertComment(SqlSession session, CommentDTO newComment) {
		return session.insert("BoardDAO.insertComment", newComment);
	}

	public int deleteComment(SqlSession session, int no) {
		return session.update("BoardDAO.deleteComment", no);
	}
	
	public int updateComment(SqlSession session, CommentDTO updateComment) {
		return session.update("BoardDAO.updateComment", updateComment);
	}
}
	


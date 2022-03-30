package com.coderun.jsp.board.model.service;

import static com.coderun.jsp.common.mybatis.Template.getSqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.coderun.jsp.member.model.dto.MemberDTO;
import com.coderun.jsp.board.model.dao.BoardDAO;
import com.coderun.jsp.board.model.dto.BoardDTO;
import com.coderun.jsp.board.model.dto.CommentDTO;
import com.coderun.jsp.common.paging.Pagenation;
import com.coderun.jsp.common.paging.SelectCriteria;

public class BoardService {
	
	private final BoardDAO boardDAO;
	
	public BoardService() {
		boardDAO = new BoardDAO();
	}
	
	/* 게시물 전체 조회용 메소드 */
	public Map<String, Object> selectBoardList(int pageNo, Map<String, String> searchMap) {
		SqlSession session = getSqlSession();
		
		int totalCount = boardDAO.selectTotalCount(session, searchMap);
		System.out.println("totalBoardCount : " + totalCount);
		
		/* 한 페이지에 보여 줄 게시물 수 */
		int limit = 5;		
		/* 한 번에 보여질 페이징 버튼의 갯수 */
		int buttonAmount = 5;
		
		/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
		SelectCriteria selectCriteria = null;
		
		if(searchMap.get("searchCondition") != null && !"".equals(searchMap.get("searchCondition"))) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchMap.get("searchCondition"), searchMap.get("searchValue"));
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		
		System.out.println(selectCriteria);
		
		List<BoardDTO> boardList = boardDAO.selectBoardList(session, selectCriteria);
		
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("boardList", boardList);
		returnMap.put("selectCriteria", selectCriteria);
		
		session.close();
		
		return returnMap;
	}
	
	/* 신규 게시물 등록용 메소드 */
	public int insertBoard(BoardDTO newBoard) {
		SqlSession session = getSqlSession();
		
		int result = boardDAO.insertBoard(session, newBoard);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}
	
	/* 게시물 상세보기용 메소드 */
	public BoardDTO selectBoardView(int no) {
		SqlSession session = getSqlSession();
		BoardDTO boardView = null;
		
		boardView = boardDAO.selectBoardView(session, no);
				
		if(boardView != null) {
			session.commit();
		} else {
			session.rollback();
		}
				
		session.close();
		
		return boardView;
	}
	
	/* 게시글 수정용 메소드 */
	public int updateBoard(BoardDTO updateBoard) {
		SqlSession session = getSqlSession();
		
		int result = boardDAO.updateBoard(session, updateBoard);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
		
	}
	
	/* 게시글 삭제용 메소드 */
	public int deleteBoard(int no) {
		SqlSession session = getSqlSession();
		
		int result = boardDAO.deleteBoard(session, no);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}

	public int insertComment(CommentDTO newComment) {
		SqlSession session = getSqlSession();
		
		int result = boardDAO.insertComment(session, newComment);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}

	public int deleteComment(int no) {
		SqlSession session = getSqlSession();
		
		int result = boardDAO.deleteComment(session, no);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}
	
	public int updateComment(CommentDTO updateComment) {
		SqlSession session = getSqlSession();
		
		int result = boardDAO.updateComment(session, updateComment);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}

}


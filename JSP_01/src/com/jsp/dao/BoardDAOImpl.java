package com.jsp.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.vo.BoardVO;

public class BoardDAOImpl implements BoardDAO {
	private static BoardDAOImpl dao;
	private BoardDAOImpl() {}
	public static BoardDAOImpl getInstance() {
		if(dao ==null)dao= new BoardDAOImpl();
		return dao;
	}
	@Override
	public List<BoardVO> selectBoardList(SqlSession session) throws Exception {
		List<BoardVO> boardList = null;
		
		boardList = session.selectList("board.selectBoardList");
		
				
			
		
		return boardList;
	}

	@Override
	public List<BoardVO> selectBoardList(SqlSession session, Criteria cri) throws Exception {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		List<BoardVO> boardList = 
				session.selectList("board.selectBoardList", null, rowBounds);
		return boardList;
	}
	@Override
	public BoardVO selectBoardone(SqlSession session, int bno) throws Exception {
		BoardVO boardvo = null;
		
		boardvo = session.selectOne("board.selectBoardone", bno);
				
		return boardvo;
	}
	@Override
	public int selectBoardCount(SqlSession session) throws Exception {
		int count  = 0;
		
		count = session.selectOne("board.selectBoardCount");
	
		return count;
	}

}

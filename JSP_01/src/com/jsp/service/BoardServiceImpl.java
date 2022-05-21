package com.jsp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.command.PageMaker;
import com.jsp.dao.BoardDAO;
import com.jsp.dao.BoardDAOImpl;
import com.jsp.dataSource.OracleMybatisSqlSessionFactory;
import com.jsp.vo.BoardVO;

public class BoardServiceImpl implements BoardService {
	private static BoardServiceImpl service;
	private BoardServiceImpl() {}
	public static BoardServiceImpl getInstance() {
		if(service ==null)service= new BoardServiceImpl();
		return service;
	}
	private OracleMybatisSqlSessionFactory sqlSessionFactory 
	= new OracleMybatisSqlSessionFactory();
	
	BoardDAO dao = BoardDAOImpl.getInstance();
	
	@Override
	public List<BoardVO> selectBoardList() throws Exception {
		SqlSession session = sqlSessionFactory.openSession(false);
		List<BoardVO> boardList = null;
		
		try {
			boardList = dao.selectBoardList(session);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			session.close();
		}
		
		
		return boardList;
	}

	@Override
	public List<BoardVO> selectBoardList(Criteria cri) throws Exception {
		SqlSession session = sqlSessionFactory.openSession(false);
		List<BoardVO> boardList = null;
		
		try {
			boardList = dao.selectBoardList(session, cri);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			session.close();
		}
		
		
		return boardList;
	}
	@Override
	public BoardVO selectBoardone(int bno) throws Exception {
		SqlSession session = sqlSessionFactory.openSession(false);
		BoardVO boardvo = null;
		
		try {
			boardvo = dao.selectBoardone(session, bno);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			session.close();
		}
		
		
		return boardvo;
	}
	@Override
	public Map<String, Object> getBoardListForPage(Criteria cri) throws Exception {
		SqlSession session = sqlSessionFactory.openSession(false);
		Map<String,Object> dataMap = null;
		
		try {
			List<BoardVO> boardList = dao.selectBoardList(session, cri);
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(dao.selectBoardCount(session));
			
			dataMap = new HashMap<String,Object>();
			dataMap.put("boardList",boardList);
			dataMap.put("pageMaker", pageMaker);
			
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			session.close();
		}
		
		
		return dataMap;
	}

}

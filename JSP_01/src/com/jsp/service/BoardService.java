package com.jsp.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.vo.BoardVO;

public interface BoardService {
	
	List<BoardVO> selectBoardList() throws Exception;
	List<BoardVO> selectBoardList(Criteria cri) throws Exception;
	BoardVO selectBoardone(int bno)throws Exception;
	Map<String,Object> getBoardListForPage(Criteria cri) throws Exception;
	
}

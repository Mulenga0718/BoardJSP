package com.jsp.dataSource;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.jsp.vo.BoardVO;

public class BoardDataSource {
private Map<String, BoardVO> boardList = new HashMap<String, BoardVO>();
	
	private static BoardDataSource instance = new BoardDataSource();
	private BoardDataSource() {
		for(int i=0;i<10;i++) {
			String temp = "mimi"+i;
			String num = i+1+"";
			String id = "id"+i;
			String content = "내용"+i;
			Date date = new Date(); 
		} 
	}
	public static BoardDataSource getInstance (){
		return instance;
	}
	public Map<String, BoardVO> getBoardList() {
		return boardList;
	}
	public void setBoardList(Map<String, BoardVO> boardList) {
		this.boardList = boardList;
	}
	public static void setInstance(BoardDataSource instance) {
		BoardDataSource.instance = instance;
	}
}

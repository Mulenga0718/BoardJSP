package com.jsp.servlet;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jsp.dataSource.BoardDataSource;
import com.jsp.vo.BoardVO;



public class Board {
	private Map<String, BoardVO> boardlist = new HashMap<String,BoardVO>();
	private static Board instance = new Board();

	private Board(){
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String formatedNow = date.format(formatter);

		for(int i=0; i<10; i++) {
			int num = i+1;
			String title = "mimi"+(i+1);
			String content = "mimi"+(i+1);
			String writer = "mimi"+(i+1);
			
		}
		
	}
	public static Board getInstance (){
		return instance;
	}
	public Map<String, BoardVO> getBoardlist() {
		return boardlist;
	}
	public void setBoardList(Map<String, BoardVO> boardList) {
		this.boardlist = boardList;
	}
	public static void setInstance(Board instance) {
		Board.instance = instance;
	}
}
	
	

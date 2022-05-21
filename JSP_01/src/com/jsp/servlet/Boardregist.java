package com.jsp.servlet;


import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.vo.BoardVO;


/**
 * Servlet implementation class Boardregist
 */
@WebServlet("/board/regist1")
public class Boardregist extends HttpServlet {
	 private Board board = Board.getInstance();  
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/WEB-INF/views/board/boardregist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String writer = "dkrnq";
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String formatedNow = date.format(formatter);
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int max = 0;
		Map<String, BoardVO> map = board.getBoardlist();
		List<Integer> list = new ArrayList<Integer>();
		for(String key : map.keySet()) {
			
		}
		for(int i : list) {
			if(max<i) {
				max = i;
			}
		}
		
		
		response.sendRedirect("list");
	}

}

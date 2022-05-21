package com.jsp.servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.vo.BoardVO;


/**
 * Servlet implementation class BoardList
 */
@WebServlet("/board/list1")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Board board = Board.getInstance();   	
  
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Map<String, BoardVO> map =  board.getBoardlist();
			List<BoardVO> list = new ArrayList<BoardVO>(map.values());
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/views/board/boardlist.jsp").forward(request, response);
			
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

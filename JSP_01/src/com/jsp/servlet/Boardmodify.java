package com.jsp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.vo.BoardVO;

/**
 * Servlet implementation class Boardmodify
 */
@WebServlet("/board/modify")
public class Boardmodify extends HttpServlet {
	 private Board board = Board.getInstance();   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
       	BoardVO vo = board.getBoardlist().get(num);
		
       	request.setAttribute("vo", vo);
       	request.getRequestDispatcher("/WEB-INF/views/board/boardmodify.jsp").forward(request, response);
       	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String num = request.getParameter("num");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		board.getBoardlist().get(num).setContent(content);
		board.getBoardlist().get(num).setTitle(title);
		
		response.sendRedirect("list");
		
	
	}

}

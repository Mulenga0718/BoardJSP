package com.jsp.servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.vo.BoardVO;


/**
 * Servlet implementation class Boarddetail
 */
@WebServlet("/board/detail1")
public class Boarddetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private Board board = Board.getInstance();   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		BoardVO vo = board.getBoardlist().get(num);
		request.setAttribute("detail", vo);
		request.getRequestDispatcher("/WEB-INF/views/board/boarddetail.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

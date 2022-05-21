package com.jsp.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.service.BoardService;
import com.jsp.service.BoardServiceImpl;
import com.jsp.vo.BoardVO;


/**
 * Servlet implementation class Boarddetail
 */
@WebServlet("/board/detail")
public class Boarddetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service = BoardServiceImpl.getInstance();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bno = request.getParameter("bno");
		try {
			BoardVO boardvo = service.selectBoardone(Integer.parseInt(bno));
			request.setAttribute("boardvo", boardvo);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
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

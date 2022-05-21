package com.jsp.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.command.Criteria;
import com.jsp.command.PageMaker;
import com.jsp.service.BoardService;
import com.jsp.service.BoardServiceImpl;
import com.jsp.vo.BoardVO;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service = BoardServiceImpl.getInstance();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/views/board/boardlist.jsp";
		String pageParam = request.getParameter("page");
		String perPageNumParam = request.getParameter("perPageNum");
		
		Criteria cri = new Criteria();
		
		boolean criFlag = true;
		criFlag = criFlag && pageParam != null
						  && !pageParam.isEmpty()
						  && perPageNumParam != null
						  && !perPageNumParam.isEmpty();
		if(criFlag) {
			try {
			cri.setPage(Integer.parseInt(pageParam));
			cri.setPerPageNum(Integer.parseInt(perPageNumParam));
			}catch(Exception e) {
				response.sendError(response.SC_BAD_REQUEST);
				return;
			}
		}
		
		try {
			Map<String,Object> dataMap = service.getBoardListForPage(cri);
			List<BoardVO>boardList = (List<BoardVO>)dataMap.get("boardList");
			PageMaker pageMaker = (PageMaker)dataMap.get("pageMaker");
			request.setAttribute("boardList", boardList);
			request.setAttribute("pageMaker", pageMaker);
			
		} catch (Exception e) {
			url ="/WEB-INF/views/error/500.jsp";
			// TODO: handle exception
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

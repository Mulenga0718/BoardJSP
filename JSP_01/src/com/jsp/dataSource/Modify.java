package com.jsp.dataSource;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.vo.Member;

/**
 * Servlet implementation class Modify
 */
@WebServlet("/modify")
public class Modify extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  DataSource datasource = DataSource.getInstance();
  
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Member member = datasource.getMemberList().get(id);
		
		
		request.setAttribute("member", member);
		request.getRequestDispatcher("/WEB-INF/views/member/modify.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String oldid = request.getParameter("oldid");
		Member member = new Member();
		member.setId(id);
		member.setPwd(pwd);
		
		datasource.getMemberList().remove(oldid);
		datasource.getMemberList().put(id, member);
		
		
		response.sendRedirect("MemberList");
		//response.sendRedirect(request.getContextPath()+"/detail?id="+id);
	}

}

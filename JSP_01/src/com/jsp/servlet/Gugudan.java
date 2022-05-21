package com.jsp.servlet;


import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Gugudan
 */
@WebServlet("/gugudan.do")
public class Gugudan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Scanner sc = new Scanner(System.in);
		int dan = sc.nextInt();
		String str ="";
		for(int i = 1; i<=9; i++){
			str += dan +" * "+i+" = "+dan*i+"\n";
		}
		
		request.setAttribute("str", str);
		request.getRequestDispatcher("/gugudan.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

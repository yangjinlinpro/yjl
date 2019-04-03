package com.web.test.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Register extends HttpServlet {
	public Register() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");  
		String name = (String)request.getParameter("aname");
		String pass = (String)request.getParameter("apass");
		System.out.println(name+" "+pass);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/pages/success.jsp");
		request.setAttribute("name1", name);
		request.setAttribute("pass1", pass);
		dispatcher.forward(request, response);
	}

	public void init() throws ServletException {

	}

}

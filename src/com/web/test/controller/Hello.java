package com.web.test.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Hello extends HttpServlet{
	public Hello() {
		super();
	}
	public void destroy() {
		super.destroy(); 
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/pages/register.jsp");
		dispatcher.forward(request, response);
		
	}
	
	public void init() throws ServletException {
		
	}
}


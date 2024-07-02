package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyFirstServlet
 */
@WebServlet("/hello")
public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) {
		System.out.println("in init"+Thread.currentThread());
	}
	
	public void destroy() {
		System.out.println("in destroy"+Thread.currentThread());
		
	}
	
	public void doGet(HttpServletRequest rq,HttpServletResponse rs) throws ServletException,IOException
	{
		rs.setContentType("text/html");
		try(PrintWriter pr=rs.getWriter())
		{
			String rsp="<h4>Welcome 2 servlet ! "+LocalDateTime.now()+"</h4><a href='hello2'>click me</a>";
			pr.print(rsp);
			
		}
	}
	

}

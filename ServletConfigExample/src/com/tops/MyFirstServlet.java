package com.tops;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	//Collections-->Enumeration Cursor-->
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		ServletConfig config=getServletConfig();
		Enumeration<String> e=config.getInitParameterNames();
		String s="";
		while(e.hasMoreElements())
		{
			s=e.nextElement();
			out.println(s+"-- data is--- "+config.getInitParameter(s));
		}
		
		
		/*
		 * String s=config.getInitParameter("email"); String
		 * a=config.getInitParameter("user"); out.print("Your email is --> "+s);
		 * out.println("Your Name is -->"+a);
		 */
		
	}

}

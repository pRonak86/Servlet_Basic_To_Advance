package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		HttpSession httpSession=request.getSession();
		
		String s=(String) httpSession.getAttribute("xyz");
		
		
		out.println("Hello ---"+s+"<br>");
		out.println("Id of Session --"+httpSession.getId()+"<br>");
		out.println("Session Creation Time--->"+httpSession.getCreationTime()+"<br>");
		out.println("Session Last Access Time--->"+httpSession.getLastAccessedTime()+"<br>");
	}

}

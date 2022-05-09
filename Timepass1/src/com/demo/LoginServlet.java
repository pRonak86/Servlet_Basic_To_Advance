package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String psw=request.getParameter("psw");
		if(psw.equals("admin"))
		{
			int timeout=20;
			HttpSession httpSession=request.getSession(true);
			httpSession.setMaxInactiveInterval(timeout);
			out.println("<h1><a href='Welcome'>Welcome</a></h1>");
			out.print("session id--"+httpSession.getId()+"<br>");
			out.print("session Creation time --"+httpSession.getCreationTime()+"<br>");
			out.print("session last access time --"+httpSession.getLastAccessedTime());
			response.setHeader("Refresh",timeout+"; URL=timeout.jsp");
		}
		else
		{
			out.println("Data is invalid");
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
	}
	
}

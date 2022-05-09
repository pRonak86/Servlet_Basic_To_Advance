package com.tops;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ValidationServlet")
public class ValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String password=request.getParameter("psw");
		if(password.equals("Admin"))
		{
			//out.print("<h1>Password Matched</h1>");
			RequestDispatcher rd=request.getRequestDispatcher("WelcomeServlet");
			rd.forward(request, response);
		}
		else
		{
			out.print("<h1>Password Not Matched</h1>");
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			rd.include(request, response);
		}
	}

}

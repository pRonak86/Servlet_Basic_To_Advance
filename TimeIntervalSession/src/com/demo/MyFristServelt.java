package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/MyFristServelt")
public class MyFristServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String psw=request.getParameter("psw");
		if(psw.equals("Admin"))
		{
			int timeout=20;
			HttpSession session=request.getSession();
			session.setMaxInactiveInterval(timeout);
			out.println("<h1> THis is the page which your want</h1>");
			response.setHeader("Refresh", timeout+";URL=index.html");
		}
		else
		{
			out.println("<h1>Password Not Match</h1>");
		}
	}

}

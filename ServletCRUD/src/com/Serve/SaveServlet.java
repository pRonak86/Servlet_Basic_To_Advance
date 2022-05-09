package com.Serve;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.Student;
import com.DAO.StudentDAO;


@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//fetch from html page 
		String name=request.getParameter("sname");
		int contact=Integer.parseInt(request.getParameter("scontact"));
		String email=request.getParameter("semail");
		String city=request.getParameter("scity");
		
		//we have to store that data in our bean file by setter method 
		Student s=new Student();
		s.setName(name);
		s.setContact(contact);
		s.setEmail(email);
		s.setCity(city);
		
		// we just called method which we already define in StudentDAO for insertion ( Save ) 
		
		int i=0;
		i=StudentDAO.save(s);
		if(i>0)
		{
			response.sendRedirect("ViewServlet");
		}
		else
		{
			out.print("Data not Inserted");
		}
		
		
	}

}

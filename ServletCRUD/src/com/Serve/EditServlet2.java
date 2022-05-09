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
import com.Bean.Student;

/**
 * Servlet implementation class EditServlet2
 */
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("sname");
		int contact=Integer.parseInt(request.getParameter("scontact"));
		String email=request.getParameter("semail");
		String city=request.getParameter("scity");
		Student s=new Student();
		s.setId(id);
		s.setName(name);
		s.setContact(contact);
		s.setEmail(email);
		s.setCity(city);
		
		int i=StudentDAO.updateStudent(s);
		if(i>0)
		{
			response.sendRedirect("ViewServlet");
		}
		else
		{
			out.print("Your Record not Update");
		}
		
		
		
		
		
		
		
		
		
	}

}

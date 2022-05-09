package com.Serve;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.Student;
import com.DAO.StudentDAO;


@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1> Student Data </h1>");
		
		List<Student> list=StudentDAO.getAllStudents();
		out.println("<table border='1'>");
		
		out.print("<tr><th>Id</th><th>Name</th><th>Contact</th><th>Email</th><th>City</th><th>Edit</th><th>Delete</th></tr>");
		// 1) you can use Cursor 
		// 2 ) for each Mehod 
		for (Student student : list) {
			
			out.println("<tr><td>"+student.getId()+"</td><td>"+student.getName()+"</td><td>"+student.getContact()+"</td><td>"+student.getEmail()+"</td><td>"+student.getCity()
			+"</td><td><a href='EditServlet?id="+student.getId()+"'>Edit</a></td><td><a href='DeleteServlet?id="+student.getId()+"'>Delete</a></td></tr>");
				
		}
			
		out.println("</table>");
		out.print("<a href='index.html'>Add new Record</a>");
		//response.sendRedirect("index.html");
		
		
	}

}

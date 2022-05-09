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

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		Student s = StudentDAO.getStudentById(id);
		out.print("<h1> Update Student Details</h1>");
		out.print("<form action='EditServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td>ID</td><td><input type='text' name='id' value=" + s.getId() + "></td></tr>");
		out.print("<tr><td>Name</td><td><input type='text' name='sname' value=" + s.getName() + "></td></tr>");
		out.print("<tr><td>Contact</td><td><input type='text' name='scontact' value=" + s.getContact() + "></td></tr>");
		out.print("<tr><td>Email</td><td><input type='text' name='semail' value=" + s.getEmail() + "></td></tr>");
		out.print("<tr><td>City</td>");
		out.print("<td><select name='scity'>");
		out.print("<option>Baroda</option>");
		out.print("<option>Bharuch</option>");
		out.print("<option>Surat</option>"); 
		out.print("<option>Rajkot</option>");
		out.print("</select></td>");
		out.print("<tr><td><input type='submit' value='Update'></td></tr>");
		out.print("</table>");

		out.print("</form>");
	}

}

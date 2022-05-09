package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Bean.Student;

//this file is use to perform your database opertaion (Insert,Update,Delete,Select All,Select with id)
public class StudentDAO {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 2) Create Connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring", "root", "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static int updateStudent(Student s)
	{
		int status=0;
		try
		{
			Connection con=StudentDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("update student set name=?,contact=?,email=?,city=? where id=?");
			ps.setString(1, s.getName());
			ps.setInt(2, s.getContact());
			ps.setString(3, s.getEmail());
			ps.setString(4, s.getCity());
			ps.setInt(5, s.getId());
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	
	
	
	
	
	
	
	
	
// Student having a number of variable as per the column name 
// if i have id --> id,name,contact,email,city(Select * from student where id=2)
	// this all are the varibale in student bean class 
	// Student calss -_> setter method --> id,name,contact,email,city--> value assign 

	
	public static Student getStudentById(int id)
	{
		Student s=new Student();
		try
		{
			Connection con=StudentDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from student where id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setContact(rs.getInt(3));
				s.setEmail(rs.getString(4));
				s.setCity(rs.getString(5));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return s;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static int deleteStudent(int id)
	{
		int status=0;
		try
		{
			Connection con=StudentDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from student where id=?");
			ps.setInt(1, id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	
	
	
	
	
	
	// beacuase we know what data we have in our table we have to fetch all data so
	// for that we have to store that
	// data inside collection -- List as Generic -- <Student-- Bean >
	public static List<Student> getAllStudents() {
		List<Student> l = new ArrayList<Student>();
		// again database connectivity- -- Fetch all data

		Connection con = StudentDAO.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from student");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				//we will send data to our Student bean
				Student s=new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setContact(rs.getInt(3));
				s.setEmail(rs.getString(4));
				s.setCity(rs.getString(5));
				l.add(s);
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}

	// this method is use for insert your record which comes from index.html page
	// -->
	public static int save(Student s) {
		int status = 0;
		Connection con = StudentDAO.getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("insert into student (name,contact,email,city) values (?,?,?,?)");

			ps.setString(1, s.getName());
			ps.setInt(2, s.getContact());
			ps.setString(3, s.getEmail());
			ps.setString(4, s.getCity());

			status = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;

	}

}

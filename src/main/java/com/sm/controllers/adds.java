package com.sm.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class adds extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public adds() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	    	Class.forName("com.mysql.jdbc.Driver");
	    	Connection c=DriverManager.getConnection(
	    			"jdbc:mysql://localhost:3306/studentm","root","root");
	    	String rn=request.getParameter("r");
	    	String nm=request.getParameter("n");
	    	double cgpa=Double.parseDouble(request.getParameter("c"));
	    	int sem=Integer.parseInt(request.getParameter("s"));
	    	String em=request.getParameter("e");
	    	String sql="insert into students values(?,?,?,?,?)";
	    	PreparedStatement p=c.prepareStatement(sql);
	    	p.setString(1, rn);
	    	p.setString(2, nm);
	    	p.setDouble(3, cgpa);
	    	p.setInt(4,sem);
	    	p.setString(5,em);
	    	p.executeUpdate();
	    	response.getWriter().println("record inserted");
	    	
	       }catch(Exception e) {response.getWriter().println(e.getMessage());}
	}

}

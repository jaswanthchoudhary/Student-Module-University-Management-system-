package com.sm.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class upds
 */
@WebServlet("/upds")
public class upds extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public upds() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
	    	Class.forName("com.mysql.jdbc.Driver");
	    	Connection c=DriverManager.getConnection(
	    			"jdbc:mysql://localhost:3306/studentm","root","root");
	    	String rn=request.getParameter("r");
	    	String nm=request.getParameter("n");
	    	double cgpa=Double.parseDouble(request.getParameter("c"));
	    	int sem=Integer.parseInt(request.getParameter("s"));
	    	String em=request.getParameter("e");
	    	String sql="update students set name=?,cgpa=?,semester=?,email=? where regno=?";
	    	PreparedStatement p=c.prepareStatement(sql);
	    	p.setString(5, rn);
	    	p.setString(1, nm);
	    	p.setDouble(2, cgpa);
	    	p.setInt(3,sem);
	    	p.setString(4,em);
	    	p.executeUpdate();
	    	response.getWriter().println("<h2> record Updated");
	    	
	       }catch(Exception e) {response.getWriter().println(e.getMessage());}
	}

}

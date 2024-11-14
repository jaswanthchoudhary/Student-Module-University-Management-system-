package com.sm.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class fetane
 */
@WebServlet("/fetane")
public class fetane extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fetane() {
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
	    	String r=request.getParameter("sid");
	    	String r1=request.getParameter("cid");
	    	String sq="select * from enrollment where studentid=?,courseid=?";
	    	PreparedStatement ps=c.prepareStatement(sq);
	    	ps.setString(1, r);
	    	ps.setString(2, r1);
	    	
	    	ResultSet rs=ps.executeQuery();
	    	PrintWriter pw=response.getWriter();
	    	while(rs.next()) {
	    		pw.print(rs.getString(1));
	    		pw.print(rs.getString(2));
	    		pw.print(rs.getString(3)+"<br>");
	    	}
	    
	       }catch(Exception e) {}
	}

}

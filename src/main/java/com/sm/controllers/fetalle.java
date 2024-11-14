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
 * Servlet implementation class fetalle
 */
@WebServlet("/fetalle")
public class fetalle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fetalle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		    	String sq="select * from enrollment";
		    	PreparedStatement ps=c.prepareStatement(sq);
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

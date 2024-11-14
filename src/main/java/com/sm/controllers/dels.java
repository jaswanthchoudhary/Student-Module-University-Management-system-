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
 * Servlet implementation class dels
 */
@WebServlet("/dels")
public class dels extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public dels() {
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
		    	String cid=request.getParameter("r");
		    	String sq="delete from students where regno=?";
		    	PreparedStatement ps=c.prepareStatement(sq);
		    	ps.setString(1, cid);
		    	ps.executeUpdate();
		    	response.getWriter().println("<h2> record deleted");
		    
		       }catch(Exception e) {}
			}
	}



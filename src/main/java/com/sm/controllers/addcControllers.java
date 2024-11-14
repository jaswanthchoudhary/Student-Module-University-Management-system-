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
 * Servlet implementation class addc
 */
@WebServlet("/addc")
public class addcControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addcControllers() {
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
		    	String cid=request.getParameter("cid");
		    	String cn=request.getParameter("cn");
		    	int cr=Integer.parseInt(request.getParameter("cc"));
		    	String sq="Insert into courses values(?,?,?)";
		    	PreparedStatement ps=c.prepareStatement(sq);
		    	ps.setString(1, cid);
		    	ps.setString(2, cn);
		    	ps.setInt(3, cr);
		    	ps.executeUpdate();
		    	response.getWriter().println("<h2> record inserted");
		    
		       }catch(Exception e) {}
			}
	}



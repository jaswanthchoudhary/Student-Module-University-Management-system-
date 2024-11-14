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
 * Servlet implementation class dele
 */
@WebServlet("/dele")
public class dele extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dele() {
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
		    	String sid=request.getParameter("sid");
		    	String cid=request.getParameter("cid");
		    	String sq="delete from enrollment where studentid=? and courseid=?";
		    	PreparedStatement ps=c.prepareStatement(sq);
		    	ps.setString(1, sid);
		    	ps.setString(1, cid);
		    	ps.executeUpdate();
		    	response.getWriter().println("<h2> record deleted");
		    
		       }catch(Exception e) {}
			}

}

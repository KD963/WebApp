package com.bridgelabz;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResetServlet
 */
@WebServlet("/ResetServlet")
public class ResetServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	System.out.println("I am in doget of reset servlet");

	// get data
	String pwd = request.getParameter("Password");
	String pwd1 = request.getParameter("Password1");
	
	String eid = request.getParameter("emailid");
	System.out.println("pwd >> " + pwd);
	System.out.println("pwd1 >> " + pwd1);
	System.out.println("eid >> " + eid);
	
	
	// connection 
	
	try {
	    Class.forName("com.mysql.jdbc.Driver");
	    System.out.println("After class");
	    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Webapp", "root", "root");
	    System.out.println("After connection");

	    PreparedStatement statement = connection.prepareStatement("update SignUpDetails set Password =? , RetypePassword =? where emailId =?");
	    statement.setString(1, pwd);
	    statement.setString(2, pwd1);
	    statement.setString(3, eid);
	    int result = statement.executeUpdate();
	    if (result != 0) {
		System.out.println("Inside if");
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	    } else {
		System.out.println("Inside else");

		RequestDispatcher dispatcher = request.getRequestDispatcher("ResetP.jsp");
		dispatcher.forward(request, response);
	    }

	} catch (Exception e) {
	    
	    e.printStackTrace();
	}

	
	
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	
	doGet(request, response);
    }

}

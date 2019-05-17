package com.bridgelabz;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
	super();
	System.out.println("I am in Login servlet");
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// get data
	System.out.println("I am in get data");
	String uname = request.getParameter("UserName");
	String pwd = request.getParameter("Password");
	System.out.println("Username >> " + uname);
	System.out.println("Pwd >> " + pwd);
	try {
	    Class.forName("com.mysql.jdbc.Driver");
	    System.out.println("After class");
	    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Webapp", "root", "root");
	    System.out.println("After connection");

	    PreparedStatement statement = connection.prepareStatement("select * from SignUpDetails where emailId=? and Password=?");
	    statement.setString(1, uname);
	    statement.setString(2, pwd);
	    ResultSet result = statement.executeQuery();
	    if (result.next()) {
		System.out.println("Inside if");
		RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
		dispatcher.forward(request, response);
	    } else {
		System.out.println("Inside else");

		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	    }

	} catch (Exception e) {
	    
	    e.printStackTrace();
	}

	/*
	 * // process data
	 * 
	 * if (uname.equals("kalyani@gmail.com") && pwd.equals("kalyani")) {
	 * 
	 * }
	 */
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

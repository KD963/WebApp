package com.bridgelabz;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class SignInServlet
 */
@WebServlet("/SignInServlet")
public class SignInServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInServlet() {
	super();
	System.out.println("I am in sign in servlet");
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	System.out.println("I am in doget");
	// get data
	
	String fname = request.getParameter("firstname");
	String lname = request.getParameter("lastname");
	String eid = request.getParameter("emailId");
	String phno = request.getParameter("phoneNo");
	String addr = request.getParameter("address");
	String pwd = request.getParameter("password");
	String repwd = request.getParameter("repassword");

	System.out.println("fname >> " + fname);
	System.out.println("lName >> " + lname);
	System.out.println("eid >> " + eid);
	System.out.println("phno >> " + phno);
	System.out.println("addr >> " + addr);
	System.out.println("pwd >> " + pwd);
	System.out.println("repwd >> " + repwd);

	// process data
	
	System.out.println("I am in process data");
	request.setAttribute("Fname", fname);
	request.setAttribute("Lname", lname);
	request.setAttribute("Eid", eid);
	request.setAttribute("PhNo", phno);
	request.setAttribute("Addr", addr);
	request.setAttribute("Pwd", pwd);
	request.setAttribute("Repwd", repwd);

	// navigate data

	
	
	try {
	    Class.forName("com.mysql.jdbc.Driver");
	    System.out.println("After class");
	    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Webapp","root","root");
	    System.out.println("After connection");
	    
	    Statement statement = connection.createStatement();
	      String sql = "insert into SignUpDetails (firstName,lastName,emailId,phoneNo,Address,Password,RetypePassword) values ('" + fname + "','" + lname + "' , '" + eid + "' , '" + phno + "' ,'" + addr + "' , '" + pwd + "' , '" + repwd + "' ) ";
	      System.out.println(sql);
	    
	    int rowcount = statement.executeUpdate(sql);
	    if(rowcount == 1) {
		System.out.println(rowcount +"Inserted");
		
		  request.setAttribute("msg", "Data has been saved");
		  RequestDispatcher dispatcher = request.getRequestDispatcher("inbox.jsp");
		  dispatcher.forward(request, response);
		 
	    } else {
		request.setAttribute("msg", "Something");
		RequestDispatcher dispatcher = request.getRequestDispatcher("inbox.jsp");
		dispatcher.forward(request, response);
	    }

	} catch (Exception e) {
	    
	    e.printStackTrace();
	}
	
	/*
	 * RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
	 * rd.forward(request, response);
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

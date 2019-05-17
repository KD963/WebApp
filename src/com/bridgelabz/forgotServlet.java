package com.bridgelabz;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class forgotServlet
 */
@WebServlet("/forgotServlet")
public class forgotServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public forgotServlet() {
	super();
	System.out.println("I am in forgot servlet");
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	
	System.out.println("I am in doget");
	// get data

	String email = request.getParameter("emailid");
	

	System.out.println("email >> " + email);
	

	// process data

	// navigate data

	System.out.println(" forgot Password ");
	RequestDispatcher dispatcher = request.getRequestDispatcher("ResetP.jsp");
	dispatcher.forward(request, response);
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

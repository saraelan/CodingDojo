package com.codingdojo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String language=request.getParameter("language");
		String hometown=request.getParameter("hometown");
//		String unknown=request.getParameter("unknown");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	    out.write("<h1>Welcome" +firstName+lastName+ "</h1>");
	    out.write("<h1> Your favorite language is " +language+ "</h1>");
	    if (request.getParameter(hometown)==null)
	    {
	    	 out.write("<h1> Your hometown is : unknown </h1>");
	    }
	    else {
	    	out.write("<h1> Your hometown is  " +hometown+ "</h1>");
	    	 }
	    
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

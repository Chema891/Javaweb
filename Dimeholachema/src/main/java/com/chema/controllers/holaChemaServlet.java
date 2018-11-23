package com.chema.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class holaChemaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public holaChemaServlet() {
        super();
 
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txtrec = request.getParameter("txt");
		request.setAttribute("txt" , txtrec);
		request.getRequestDispatcher("/hola.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

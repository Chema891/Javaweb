package com.chema.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chema.database.BBDD;

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idUsuario = request.getParameter("id");
		System.out.println("ID recibido: " + idUsuario);
		
		int idU=Integer.parseInt(idUsuario);

		HttpSession session =  request.getSession();
		
		BBDD bbdd = BBDD.getInstance();
		
		if (session.getAttribute("usuario")!=null){
			request.setAttribute("elUsuario", bbdd.getUsuarioById(idU));
			request.getRequestDispatcher("usuario.jsp").forward(request,response);
			
		}else {
			response.sendRedirect("login");
		
	}
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

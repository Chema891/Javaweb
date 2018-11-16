package com.chema.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chema.database.BBDD;

@WebServlet("/listausuarios")
public class ListadoUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session =  request.getSession();
		
		//Si exitse el dato de usuario en sesion, lo dejo pasar
		//Si no lo redirijo a login
		//BBDD bbdd = new BBDD();
		if (session.getAttribute("usuario")!=null){
			BBDD bbdd= BBDD.getInstance();
			request.setAttribute("losUsuarios", bbdd.usuarios);
			request.getRequestDispatcher("ListaUsuarios.jsp").forward(request,response);
			
		}else {
			response.sendRedirect("login");
		}
		
//		BBDD bbdd = new BBDD();
//
//		request.setAttribute("losUsuarios", bbdd.usuarios);
//		request.getRequestDispatcher("/ListaUsuarios.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

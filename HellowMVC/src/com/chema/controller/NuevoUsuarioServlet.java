package com.chema.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chema.database.BBDD;
import com.chema.servlets.Habitacion;
import com.chema.servlets.Usuario;

@WebServlet("/nuevousuario")
public class NuevoUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NuevoUsuarioServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList<Habitacion> habitaciones = BBDD.getInstance().habitaciones; 
		
		request.setAttribute("lasHabitaciones", habitaciones);
		request.getRequestDispatcher("/nuevousuario.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String namerecib = request.getParameter("name");
		String emailrecib = request.getParameter("email");
		String passrecib = request.getParameter("password");
		String passconfir = request.getParameter("confirmarpassword");
		String habitacionrec = request.getParameter("habitacion");
		
		int habitacionrecID = 0;
		
		try {
			habitacionrecID=Integer.parseInt(habitacionrec);
		} catch (Exception e) {
			System.out.println("Exception!!!!: "+ e.getMessage());
			
		}
	
		System.out.println("habitacion:" + habitacionrec);
		
		Usuario nuevoUser = new Usuario(0, namerecib, emailrecib, passrecib, BBDD.getInstance().getHabitacionById(habitacionrecID));

		if (nuevoUser.esValido(passconfir)) {

			// if (emailrecib!=null && !emailrecib.equals("") && emailrecib.indexOf("@")>0 )
			// primer ej {
			// continuar e introducir el usuario en BBDD

			BBDD bd = BBDD.getInstance();
			bd.inserUsuario(nuevoUser);
			
			//redirijo a listausuario
			response.sendRedirect("listausuarios");

		} else {
			request.setAttribute("mensajeerror", "Datos incorrectos");
			request.setAttribute("nuevousuario", nuevoUser);
			this.doGet(request, response);
		}

		System.out.println("ESTOY en el post!!!!!!!!!!");
		System.out.println("Nombre: " + namerecib);
		System.out.println("Email: " + emailrecib);
		System.out.println("PAss: " + passrecib);
		System.out.println("PAss: " + passconfir);

	}

}

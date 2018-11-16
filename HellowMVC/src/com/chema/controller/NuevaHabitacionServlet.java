package com.chema.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chema.database.BBDD;
import com.chema.servlets.Habitacion;
import com.chema.servlets.Usuario;


@WebServlet("/nuevahabitacion")
public class NuevaHabitacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public NuevaHabitacionServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("/nuevahabitacion.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String callerecib = request.getParameter("calle");
		String nuemrorecib = request.getParameter("numero");
		String ciudadrecib = request.getParameter("ciudad");
		
		System.out.println("habitacion:");
		System.out.println("Calle: " + callerecib);
		System.out.println("Número: " + nuemrorecib);
		System.out.println("Ciudad: " + ciudadrecib);
		
		int nuemrorecibID = 0;
		
		try {
			nuemrorecibID=Integer.parseInt(nuemrorecib);
		} catch (Exception e) {
			System.out.println("Exception!!!!: "+ e.getMessage());
			
		}
		
		
		Habitacion nuevoHab = new Habitacion(0, callerecib, nuemrorecibID, ciudadrecib);

		if (nuevoHab.esValidoh()) {


			BBDD bd = BBDD.getInstance();
			bd.inserHab(nuevoHab);
			
			response.sendRedirect("nuevousuario");

		} else {
			request.setAttribute("mensajeerror", "Datos incorrectos");
			request.setAttribute("nuevahabitacion", nuevoHab);
			this.doGet(request, response);
		}
	}

}

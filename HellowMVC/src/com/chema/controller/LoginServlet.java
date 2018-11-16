package com.chema.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chema.database.BBDD;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String emailrecib=request.getParameter("email");
		String passrecib=request.getParameter("password");
		
		System.out.println("ESTOY en el post!!!!!!!!!!");
		System.out.println("Email: " + emailrecib);
		System.out.println("PAss: " + passrecib);
		
		BBDD bd = BBDD.getInstance();
		//decidir si existe usuario con ese email y password......entrar en lisrausuarios
		//Si no.... volver a mostrat formulario
		
		boolean existeUser = bd.dameUsuarioPorEmailyPass(emailrecib,passrecib);
		
		HttpSession session = request.getSession();
		
		if(existeUser) {
			//llevarlo a lista usuario
			//request.getDispatcherType("/ListaUsuarios").foward(request, response);
			session.setAttribute("usuario", emailrecib);
			response.sendRedirect("listausuarios");
			
		}else {
			//devolver a login
			request.setAttribute("errormensaje", "Usuario y contraseña no Existe!!");
			this.doGet(request, response);
			
	}
	}
}

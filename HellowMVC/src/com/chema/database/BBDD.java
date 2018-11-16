package com.chema.database;

import java.util.ArrayList;

import com.chema.servlets.Habitacion;
import com.chema.servlets.Usuario;

public class BBDD {

	private static BBDD instance=null;
	
	public ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	public ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
	
	public static final BBDD getInstance() {
		if (instance==null) instance=new BBDD();
		return instance;
	}

	private BBDD() {
		this.fillHabitacion();
		this.fillUsuarios();

		this.relacionarUserHab();
	}

	private boolean fillUsuarios() {
		usuarios.add(new Usuario(3, "Pepe", "p@p.es", "ppp", null));
		usuarios.add(new Usuario(23, "Luisa", "l@l.es", "lll", null));
		usuarios.add(new Usuario(69, "Manolo", "m@m.es", "mmm", null));

		return true;
	}

	private boolean fillHabitacion() {
		habitaciones.add(new Habitacion(1, "C/Marques de Vadillo", 23, "Madrid"));
		habitaciones.add(new Habitacion(2, "C/Diego de Leon", 22, "Madrid"));
		habitaciones.add(new Habitacion(3, "C/Alcala", 21, "Madrid"));

		return true;
	}

	private boolean relacionarUserHab() {
		usuarios.get(0).setHabitacion(habitaciones.get(2));
		usuarios.get(1).setHabitacion(habitaciones.get(1));
		usuarios.get(2).setHabitacion(habitaciones.get(0));

		return true;
	}

	/*
	 * Metodo que en funcion de la ID me devuelve un objeto usuario concreto Sí no
	 * exite devuelve null
	 */

	public Usuario getUsuarioById(int id) {
		Usuario usuarioADevolver = null;

		/*
		 * Iteramos por cada usuario y compramos su id con el que nos indican
		 */

		for (Usuario unUsuario : usuarios) {
			if (unUsuario.getId() == id) {
				usuarioADevolver = unUsuario;
				break; // si lo encontramos, nos salimos
			}
		}

		return usuarioADevolver;
	}

	public Habitacion getHabitacionById(int id) {
		Habitacion habitacionADevolver=null;
		
		
		
		for (Habitacion unHabitacion : habitaciones) {
			if(unHabitacion.getHid()==id) {
				habitacionADevolver = unHabitacion;
				break; 
			}
		}
		
		return habitacionADevolver;
	}

	public boolean dameUsuarioPorEmailyPass(String emailrecib, String passrecib) {
		
		boolean existeUsuario = false;
		
		for (Usuario unUsuario : usuarios) {
			if (unUsuario.getEmail().equals(emailrecib) && unUsuario.getPass().equals(passrecib)) {
				existeUsuario = true;
				break; // si lo encontramos, nos salimos
			}
		}

		return existeUsuario;
	
		
		
		
	}

	public int inserUsuario(Usuario newUser) {
			int nuevoId=0;
			
			nuevoId=this.usuarios.size()+1; //simulamos que la bd asigna un id consecutivo
			newUser.setId(nuevoId);
			
			this.usuarios.add(newUser);
			
			return nuevoId;
	}

	
		
		
	}
	
	


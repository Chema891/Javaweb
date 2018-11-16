package com.chema.servlets;

public class Usuario {
	private int id;
	private String name;
	private String email;
	private String pass;
	private Habitacion habitacion;
	

	

	public Usuario(int id, String name, String email, String pass, Habitacion habitacion) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.habitacion = habitacion;
	}
	
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	
	//valida los campos del usuario
	
	public boolean esValido(String passconfir) {
		boolean esValid=true;
		
		if(this.email==null || this.email.equals("") || this.email.indexOf("@")<=0 ) esValid=false;
		
		if(this.name==null || this.name.equals("") || this.name.matches("(.*)?[0-9](.*)?") ) esValid=false;
		
		if(this.pass==null || this.pass.equals("") ) esValid=false;
		
		if(!this.pass.equals(passconfir)) esValid=false;
		
		return esValid;
	}

	

		
	
}

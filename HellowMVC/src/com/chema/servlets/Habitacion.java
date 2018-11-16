package com.chema.servlets;

public class Habitacion {
	private int hid;
	private String streat;
	private int number;
	private String city;
	
	
	public Habitacion(int hid, String streat, int number ,String city) {
		super();
		this.hid = hid;
		this.streat = streat;
		this.number = number;
		this.city = city;
	}



	public int getHid() {
		return hid;
	}


	public void setHid(int hid) {
		this.hid = hid;
	}


	public String getStreat() {
		return streat;
	}


	public void setStreat(String streat) {
		this.streat = streat;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}
	
	public boolean esValidoh() {
		boolean esValidh=true;
		
		if(this.streat==null || this.streat.equals("") || this.streat.matches("(.*)?[0-9](.*)?") ) esValidh=false;
		
		if(this.number<=0 ) esValidh=false;
		
		if(this.city==null || this.city.equals("") || this.city.matches("(.*)?[0-9](.*)?") ) esValidh=false;
		
				
		return esValidh;
	}
	
}

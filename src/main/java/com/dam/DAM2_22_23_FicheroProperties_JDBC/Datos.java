package com.dam.DAM2_22_23_FicheroProperties_JDBC;

public class Datos {
	
	private String rutaDriver;
	private String rutaBBDD;
	private String usuario;
	private String password;
	
	public Datos(String rutaDriver, String rutaBBDD, String usuario, String password) {
		this.rutaDriver = rutaDriver;
		this.rutaBBDD = rutaBBDD;
		this.usuario = usuario;
		this.password = password;
	}

	public String getRutaDriver() {
		return rutaDriver;
	}

	public String getRutaBBDD() {
		return rutaBBDD;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getPassword() {
		return password;
	}
	
}

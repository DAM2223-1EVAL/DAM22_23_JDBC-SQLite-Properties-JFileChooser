package com.dam.DAM2_22_23_FicheroProperties_JDBC;

public class Equipo {
	
	private int codigo;
	private String nombre;
	private String ciudad;
	private int anho;
	
	public Equipo(int codigo, String nombre, String ciudad, int anho) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.anho = anho;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getAnho() {
		return anho;
	}

	public void setAnho(int anho) {
		this.anho = anho;
	}
	
}

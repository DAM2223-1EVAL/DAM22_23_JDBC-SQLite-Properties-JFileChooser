package com.dam.DAM2_22_23_FicheroProperties_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Conexion {

	private String rutaDriver;
	private String rutaConexion;
	private String usuario;
	private String password;

	public Conexion(String rutaDriver, String rutaConexion, String usuario, String password) {
		this.rutaDriver = rutaDriver;
		this.rutaConexion = rutaConexion;
		this.usuario = usuario;
		this.password = password;
	}

	public void getConexion(ArrayList<Equipo> listaEquipos, String gestor) throws ClassNotFoundException, SQLException {
		//Cargar el Driver MySQL
		Class.forName(rutaDriver);

		Connection conexion = null;
		
		if (!gestor.equals("SQLite"))
			conexion = DriverManager.getConnection(rutaConexion, usuario, password);
		else
			conexion = DriverManager.getConnection(rutaConexion);

		//Crear las acciones sobre la BD

		for (int i = 0; i< listaEquipos.size(); i++) {
			Equipo equipo = listaEquipos.get(i);
			
			PreparedStatement pSt = conexion.prepareStatement("INSERT INTO equipo VALUES (?, ?, ?, ?)");
			
			pSt.setInt(1, equipo.getCodigo());
			pSt.setString(2, equipo.getNombre());
			pSt.setString(3, equipo.getCiudad());
			pSt.setInt(4, equipo.getAnho());


			if (pSt.executeUpdate() == 1) 
				System.out.println("Equipo insertado correctamente");
			else 
				System.out.println("Error al insertar el equipo");
		}
	}

}

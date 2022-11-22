package com.dam.DAM2_22_23_FicheroProperties_JDBC;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Principal {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException, ParserConfigurationException, SAXException {

		int finalizar = -1;
		Scanner scan = new Scanner(System.in);
		Conexion con = null;
		Datos datosConexion = null;
		String gestor = null;
		
		//Leemos la ruta con JFileChooser
		JFileChooser escogerFichero = new JFileChooser();
		escogerFichero.showOpenDialog(null);
		String rutaFicheroProp = escogerFichero.getSelectedFile().getAbsolutePath();

		
		while(finalizar!=0) {
			
			System.out.println("    MENÚ     ");
			System.out.println("1. MySQL");
			System.out.println("2. PostgreSQL");
			System.out.println("3. SQLite");
			System.out.println("0. Salir");
			finalizar = scan.nextInt();
			
			ArrayList<Equipo> listaEquipos = new ArrayList<Equipo>();
			listaEquipos = LeerFichero.leerXML();
			
			switch (finalizar) {
			case 1: 
				 	gestor = "MySQL";
					break;
					
			case 2: gestor = "Postgres";
					break;
					
			case 3: gestor = "SQLite";
					break;
					
			case 0: System.out.println("Programa finalizado");
			        break;

			default: System.out.println("Opción no válida");
				
			}
			
			datosConexion = LeerFichero.leerFicheroProp(rutaFicheroProp, gestor);
			con = new Conexion(datosConexion.getRutaDriver(), datosConexion.getRutaBBDD(), 
    				datosConexion.getUsuario(), datosConexion.getPassword());
			con.getConexion(listaEquipos, gestor);
						
		}


	}
}

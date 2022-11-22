package com.dam.DAM2_22_23_FicheroProperties_JDBC;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import javax.swing.JFileChooser;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LeerFichero {

	private static String rutaDriver = null;
	private static String rutaBBDD = null;
	private static String usuario = null;
	private static String password = null;

	public static Datos leerFicheroProp(String rutaFicheroProp, String gestor) throws IOException, ParserConfigurationException, SAXException{
		
//			Path origen = Paths.get("D:\\PRUEBAS\\gestores.properties");
			Path origen = Paths.get(rutaFicheroProp);
			BufferedReader br = Files.newBufferedReader(origen);

			Stream<String> lineas = br.lines();

			lineas.forEach(l -> { 
				String[] lineaProperties = l.split("=");
				if (lineaProperties[0].equals("driver" + gestor))
					rutaDriver = lineaProperties[1];
				else if (lineaProperties[0].equals("ruta" + gestor))
					rutaBBDD = lineaProperties[1];
				else if (lineaProperties[0].equals("usuario" + gestor))
					usuario = lineaProperties[1];
				else if (lineaProperties[0].equals("password" + gestor))
					password = lineaProperties[1];
			});
			
			/* 
			 * Empleando la clase Properties:
			 * 
			 * Properties valores = new Properties();
			 * valores.load(new FileReader("D:\\PRUEBAS\\gestores.properties"));
			 * 
			 * rutaDriver = valores.getProperty("driver" + gestor);
			 * rutaBBDD = valores.getProperty("ruta" + gestor);
			 * usuario = valores.getProperty("usuario" + gestor);
			 * password = valores.getProperty("password" + gestor);
			 * 
			 */

			return new Datos(rutaDriver, rutaBBDD, usuario, password);

	}
	
	public static ArrayList<Equipo> leerXML() throws ParserConfigurationException, SAXException, IOException{
		
		  ArrayList<Equipo> listaEquipos = new ArrayList<Equipo>();
		  
		  FileInputStream fis = new FileInputStream("D:\\PRUEBAS\\leboro.xml");
			
		  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		  DocumentBuilder db = dbf.newDocumentBuilder();
		  Document doc = db.parse(fis);
			
		  NodeList codigos = doc.getElementsByTagName("codequipo");
		  NodeList nombres = doc.getElementsByTagName("nombreEq");
		  NodeList ciudades = doc.getElementsByTagName("Ciudad");
		  NodeList anhos = doc.getElementsByTagName("anho");
			
		  
		  for(int i = 0; i < codigos.getLength(); i++) {
			  listaEquipos.add(new Equipo(Integer.parseInt(codigos.item(i).getTextContent()),
					  									   nombres.item(i).getTextContent(),
					  									   ciudades.item(i).getTextContent(),
					  									   Integer.parseInt(anhos.item(i).getTextContent())));
		  }
		
		  return listaEquipos;
	}

}

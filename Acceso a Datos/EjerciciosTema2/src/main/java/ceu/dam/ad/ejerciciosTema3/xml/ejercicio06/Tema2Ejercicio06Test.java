package ceu.dam.ad.ejerciciosTema3.xml.ejercicio06;


import java.util.ArrayList;
import java.util.List;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio06.modelo.Ejercicio06ServiceImp;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio06.modelo.Largometraje;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLExportException;

public class Tema2Ejercicio06Test {
public static void main(String[] args) {
	Ejercicio06ServiceImp service = new Ejercicio06ServiceImp();
	Largometraje largo = new Largometraje();
	List<Largometraje> lista = new ArrayList<Largometraje>();
	lista= largo.createRandomList(10);
	try {

		
			service.exportarXML(lista, "C:/Users/fcabrera4084/Desktop/Cosas Asignaturas/AccesoDatos/peliculas.xml");
		
	
	} catch (XMLExportException e) {
		
		e.printStackTrace();
	}

}
}


package ceu.dam.ad.ejerciciosTema3.xml.ejercicio04;

import java.util.ArrayList;
import java.util.List;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.modelo.Libro;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio06.modelo.Largometraje;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLExportException;

public class Tema2Ejercicio04Test {
	public static void main(String[] args) {
		
		Ejercicio04ServiceImp service = new Ejercicio04ServiceImp();
		try {
			service.exportXML(Libro.createRandomList(10), "C:/Users/fcabrera4084/Desktop/Cosas Asignaturas/AccesoDatos/librooos.xml");
		} catch (XMLExportException e) {
			
			e.printStackTrace();
		}
		System.out.println("Mira el xml anda...");
	}
}

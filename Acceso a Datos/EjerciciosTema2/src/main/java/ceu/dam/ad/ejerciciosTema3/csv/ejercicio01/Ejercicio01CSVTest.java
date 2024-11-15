package ceu.dam.ad.ejerciciosTema3.csv.ejercicio01;

import ceu.dam.ad.ejerciciosTema3.csv.exceptions.CsvException;

public class Ejercicio01CSVTest {
	

	public static void main(String[] args) {
		Ejercicio01Service service = new Ejercicio01ServiceImpl();
		try {
			service.exportarPeliculasCsv("c:/temporal/peliculas.csv");
			System.out.println("Películas exportadas. Comprobar fichero generado.");
		} catch (CsvException e) {
			e.printStackTrace();
		}
	}

}

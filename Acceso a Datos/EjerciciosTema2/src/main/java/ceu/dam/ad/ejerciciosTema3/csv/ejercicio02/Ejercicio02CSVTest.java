package ceu.dam.ad.ejerciciosTema3.csv.ejercicio02;

import ceu.dam.ad.ejerciciosTema3.csv.exceptions.CsvException;

public class Ejercicio02CSVTest {
	public static void main(String[] args) {
		Ejercicio02Service service = new Ejercicio02ServiceImpl();
		try {
			service.importarUsuarioCSV("c:/temporal/users_data.csv");
		} catch (CsvException e) {
			e.printStackTrace();
		}
	}

}

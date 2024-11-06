package csv.test;

import java.util.List;

import csv.modelo.Gato;
import csv.services.CsvGatosException;
import csv.services.CsvService;

public class TestCSV {

	public static void main(String[] args) {
		CsvService service = new CsvService();
		List<Gato> gatos;
		try {
			gatos = service.leerCsv("c:/temporal/csv/prueba2.csv");
			gatos.stream().forEach(g -> System.out.println(g));
			
			service.escribirCsv(gatos, "c:/temporal/csv/salida.csv");
			System.out.println("TODO OK!!");

		} catch (CsvGatosException e) {
			e.printStackTrace();
		}
		
	}

}

package csv.services;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import csv.modelo.Gato;

public class CsvService {

	public List<Gato> leerCsv(String pathFile) throws CsvGatosException{
		try {
			List<Gato> lista = new ArrayList<Gato>();
			File fichero = new File(pathFile);
			Scanner sc = new Scanner(fichero);
			while(sc.hasNext()) {
				String linea = sc.nextLine();
				String[] trozos = linea.split(";");
				Gato g = new Gato();
				g.setId(Integer.parseInt(trozos[0]));
				g.setNombre(trozos[1]);
				g.setRaza(trozos[2]);
				lista.add(g);
			}
			sc.close();
			return lista;
		}
		catch(Exception e) {
			throw new CsvGatosException("Error leyendo fichero", e);
		}
	}
	
	public void escribirCsv(List<Gato> gatos, String pathFile) throws CsvGatosException {
		try {
			File fichero = new File(pathFile);
			FileWriter writer = new FileWriter(fichero);
			for (Gato gato : gatos) {
				writer.write(gato.getId() + "|");
				writer.write(gato.getNombre() + "|");
				writer.write(gato.getRaza() + "\n");
			}
			writer.close();
		}
		catch(Exception e) {
			throw new CsvGatosException("Error leyendo fichero", e);
		}
	}
	
	
	
	
	
	
}

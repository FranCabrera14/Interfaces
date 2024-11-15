package clase.clase01;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
				 return lista;
				
			}
		} catch (Exception e) {
			throw new CsvGatosException();
		}
		return null;
	}
	public void escribirCsv(List<Gato> gatos, String pathFile) {
		try {
			File fichero = new File(pathFile);
			FileWriter writer = new FileWriter(fichero);
			for (Gato gato : gatos) {
				writer.write(gato.getId() + "|");
				writer.write(gato.getNombre() + "|");
				writer.write(gato.getRaza()+ ".");
			}	
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

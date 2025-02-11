package ceu.dam.ad.ejerciciosTema3.csv.ejercicio01;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ceu.dam.ad.ejerciciosTema3.csv.exceptions.CsvException;
import ejercicioPeliculasServices.modelo.Pelicula;
import ejercicioPeliculasServices.services.PeliculasException;
import ejercicioPeliculasServices.services.PeliculasService;



public class Ejercicio01ServiceImpl  implements Ejercicio01Service{
	private static final Logger log = LoggerFactory.getLogger(Ejercicio01ServiceImpl.class);

	@Override
	public void exportarPeliculasCsv(String nombreFichero) throws CsvException {
		try {
			log.info("Exportando lista de películas a fichero: " + nombreFichero);
			// 1. Llamar al servicio de peliculas para obtener la lista
			PeliculasService service = new PeliculasService();
			List<Pelicula> peliculas = service.consultarPeliculas();
		
			// 2. Crear el fichero y fileWriter
			File file = new File(nombreFichero);
			FileWriter writer = new FileWriter(file);
			
			// 3. Recorremos la lista y vamos escribiendo en cada l�nea un película
			for (Pelicula pelicula : peliculas) {
				log.debug("Escribiendo línea para película: " + pelicula);
				writer.write(pelicula.getId() + "\t" + pelicula.getNombre() + "\t" + pelicula.getLongitud() + "\n");
			}
			
			log.info("Fichero generado con " + peliculas.size() + " líneas");
			
			// 4. Cerramos el fileWriter
			writer.close();
		
		} catch (PeliculasException | IOException e) {
			log.error("Error consultando o exportando películas", e);
			throw new CsvException("Error al generar CSV", e );
		}
	}

}

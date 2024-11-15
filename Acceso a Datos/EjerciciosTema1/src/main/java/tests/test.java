package tests;

import java.util.ArrayList;
import java.util.List;

import modelo.Pelicula;
import services.PeliculaService;

public class test {
	public static void main(String[] args) {
		PeliculaService service = new PeliculaService();
		try {
			
			List<Pelicula> listaPelis = service.consultarPeliculas();
			listaPelis.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}

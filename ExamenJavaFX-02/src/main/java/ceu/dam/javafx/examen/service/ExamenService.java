package ceu.dam.javafx.examen.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ceu.dam.javafx.examen.model.CatalogoPrecios;
import ceu.dam.javafx.examen.model.Coche;
import javafx.scene.paint.Color;

public class ExamenService{

	/** Método que nos permite identificar un catálogo. Debemos llamarlo desde el login
	 * Devuelve un catálogo con todos sus datos completos.
	 * 
	 * Si el catálogo no existe, lanza NotFoundException con el mensaje indicativo.
	 * 
	 * @param Integer idComercial, String marca, LocalDate fecha
	 * @return
	 * @throws NotFoundException
	 */
	public CatalogoPrecios identificarCatalogo(Integer idComercial, String marca, LocalDate fecha) throws NotFoundException {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		if (idComercial == null || marca == null || fecha == null) {
			throw new NotFoundException("No existe el catálogo consultado");
		}
		if (idComercial.equals(1) && !marca.isEmpty()) {
			return new CatalogoPrecios(965, idComercial, marca, fecha);
		}
		if (idComercial < 5) {
			throw new NotFoundException("El catálogo está inactivo");
		}
		if (idComercial < 10) {
			throw new NotFoundException("No hay catálogo para esta marca");
		}
		throw new NotFoundException("No existe el catálogo consultado");
	}
	
	
	/** Método que devuelve lista de marcas disponibles en el sistema.
	 * 
	 * @return
	 */
	public List<String> consultarMarcas(){
		return new ArrayList<>(bbdd.keySet()); 
	}
	
	
	/** Método que devuelve todos los coches del catálogo que están registrados en el sistema
	 * para el catálogo indicado por parámetros
	 * Si no hay ninguno, se devuelve una lista vacía
	 * @param Integer idCatalogo
	 * @return
	 */
	public List<Coche> consultarPrecios(Integer idCatalogo) {
		List<Coche> lista = new ArrayList<>();
		if (965 != idCatalogo ) {
			return lista;
		}
        return todos;
	}	
	
	/** Método que devuelve todos los coches del catálogo que están registrados en el sistema
	 * para el catálogo y el color de coche indicados por parámetros
	 * Si no hay ninguno, se devuelve una lista vacía
	 * @param Color color, Integer idCatalogo
	 * @return
	 */
	public List<Coche> consultarPrecios(Color color, Integer idCatalogo) {
		List<Coche> lista = new ArrayList<>();
		if (965 != idCatalogo || color==null) {
			return lista;
		}
        return todos.stream().filter(c -> c.getColor().equals(color)).collect(Collectors.toList());
    }
	
	
	
	
	
	
	
	
	// Ignorar este código...
	private static Map<String, List<Coche>> bbdd = new HashMap<String, List<Coche>>();
	private static List<Coche> seat = new ArrayList<Coche>();
	private static List<Coche> renault = new ArrayList<Coche>();
	private static List<Coche> bmw = new ArrayList<Coche>();
	private static List<Coche> toyota = new ArrayList<Coche>();
	private static List<Coche> todos = new ArrayList<Coche>();
	static {
		toyota.add(new Coche("Toyota", "Auris", "2010", "1521FFD", 8532, Color.BLACK));
		toyota.add(new Coche("Toyota", "Auris", "2013", "4862DDD", 7896, Color.BLACK));
		toyota.add(new Coche("Toyota", "Rav4", "2016", "4862BRT", 15000, Color.BLACK));
		toyota.add(new Coche("Toyota", "Corolla", "2020", "8761DQT", 16100, Color.WHITE));
		toyota.add(new Coche("Toyota", "Yaris", "2012", "9661JKK", 4350, Color.GRAY));
		toyota.add(new Coche("Toyota", "Rav4", "2019", "4134NBV", 17211, Color.GRAY));
		seat.add(new Coche("Seat", "Córdoba", "2005", "2521RFD", 8000, Color.BLACK));
		seat.add(new Coche("Seat", "Ibiza", "2010", "4522RTD", 6000, Color.BLACK));
		seat.add(new Coche("Seat", "León", "2011", "0114BRT", 15500, Color.BLACK));
		seat.add(new Coche("Seat", "Córdoba", "2019", "8761DQT", 17100, Color.BLACK));
		seat.add(new Coche("Seat", "León", "2020", "9661JKK", 4200, Color.BLACK));
		seat.add(new Coche("Seat", "Ibiza", "2019", "4134BBV", 17211, Color.WHITE));
		seat.add(new Coche("Seat", "Córdoba", "2011", "1521FFD", 8532, Color.WHITE));
		seat.add(new Coche("Seat", "Ibiza", "2013", "4862DDD", 7896, Color.WHITE));
		seat.add(new Coche("Seat", "León", "2016", "4862BRT", 15000, Color.WHITE));
		seat.add(new Coche("Seat", "Toledo", "2005", "2521RFD", 8000, Color.WHITE));
		seat.add(new Coche("Seat", "Ibiza", "2010", "4522RTD", 6000, Color.WHITE));
		seat.add(new Coche("Seat", "Toledo", "2011", "0114BRT", 15500, Color.WHITE));
		seat.add(new Coche("Seat", "Córdoba", "2019", "8761DQT", 17100, Color.WHITE));
		seat.add(new Coche("Seat", "Toledo", "2020", "9661JKK", 4200, Color.WHITE));
		seat.add(new Coche("Seat", "Ibiza", "2019", "4134BBV", 17211, Color.GRAY));
		seat.add(new Coche("Seat", "Córdoba", "2011", "1521FFD", 8532, Color.GRAY));
		seat.add(new Coche("Seat", "León", "2016", "4862BRT", 15000, Color.GRAY));
		seat.add(new Coche("Seat", "Ibiza", "2013", "4862DDD", 7896, Color.GRAY));
		renault.add(new Coche("Renault", "Laguna", "2017", "5562CRT", 3245, Color.BLACK));
		renault.add(new Coche("Renault", "Clío", "2020", "8551CQC", 11500, Color.BLACK));
		renault.add(new Coche("Renault", "Megane", "2008", "1555FPD", 12000, Color.WHITE));
		renault.add(new Coche("Renault", "Megane", "2003", "4662RWD", 10012, Color.WHITE));
		renault.add(new Coche("Renault", "Megane", "2010", "9001VVF", 6588, Color.WHITE));
		renault.add(new Coche("Renault", "Clío", "2009", "0034BWW", 1500, Color.GRAY));
		bbdd.put("TOYOTA", toyota);
		bbdd.put("SEAT", seat);
		bbdd.put("RENAULT", renault);
		bbdd.put("BMW", bmw);
		todos.addAll(toyota);
		todos.addAll(seat);
		todos.addAll(renault);
		
	}
	
	

	
}

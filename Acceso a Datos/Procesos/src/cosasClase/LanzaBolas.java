package cosasClase;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LanzaBolas implements Runnable {
	public String nombre;
	

	public LanzaBolas(String nombre) {
		super();
		this.nombre = nombre;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void run() {
			LocalTime hora = LocalTime.now();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("hh:mm:ss.SSS");
			System.out.println("Lanzando la bola desde " + nombre + " a las " + hora.format(format) );
	}

}

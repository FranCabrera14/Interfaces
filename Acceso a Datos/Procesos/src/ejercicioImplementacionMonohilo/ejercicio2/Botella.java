package ejercicioImplementacionMonohilo.ejercicio2;

import lombok.Data;

@Data
public class Botella {
	private String nombre;
	private char caracter;
	private Integer cantidad;
	private static long milis = 100;

	public Botella(String nombre, char caracter, Integer cantidad) {
		super();
		this.nombre = nombre;
		this.caracter = caracter;
		this.cantidad = cantidad;
	}

	public void vaciar() {
		while (cantidad > 0) {
			System.out.print(caracter);
			cantidad--;
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}
}

package cosasClase;

import java.util.Iterator;

import lombok.Data;

public @Data class CuentaAtras implements Runnable{
	private Integer valorInicial;
	private String nombre;
	private static long ejecuciones = 0; // variable compartida
	private long ejecucionesInstancia = 0; //contador individual
	private final static Integer milis = 1;
	
	// constructor de la clase
	private CuentaAtras (Integer valorInicial, String nombre) {
		this.valorInicial = valorInicial;
		this.nombre = nombre;
	}
	
	// Solución con synchronyzed: Bloque sincronizado para proteger los contadores compartidos
	private synchronized void incrementarEjecuciones() {
		ejecuciones++; //modificación de variable estática
		ejecucionesInstancia++;
	}
	
	private void arrancar() {
		for (int i = valorInicial; i >= 0; i--) {
			System.out.println(nombre + ": " + i);
			incrementarEjecuciones();
		try {
			Thread.sleep(milis); //Pausa entre iteraciones
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}
	
	public static void main(String[] args) {
		CuentaAtras c1 = new CuentaAtras(4, "Cuenta1");
		Integer veces = 100_000;
		for (int i = 0; i < veces; i++) {
			new Thread(c1).start();
			
		}
		//Esperamos un tiempo para que los hilos terminen
	
	try {
		Thread.sleep(milis * veces / 10);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
	System.out.println("Ejecuciones: " + ejecuciones);
	System.out.println("Ejecuciones instancia: " + c1.ejecucionesInstancia);
	}
	
	
	
	
	public void run() {
		arrancar();
	}

}

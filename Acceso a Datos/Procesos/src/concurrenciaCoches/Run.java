package concurrenciaCoches;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run {
	public static void main(String[] args) {
		Carrera carrera = new Carrera(1000);
		ExecutorService ex = Executors.newFixedThreadPool(1000);
		for (int i = 1; i < 1001; i++) {
			Coche c = new Coche("Coche" + i, 100, carrera);
			ex.execute(c);
		}
		
	
	
	
		
		ex.shutdown();
		while (!ex.isTerminated()) {
			
		}
		carrera.imprimirPodio();
	}
}

package ejercicioCafeteria;

import java.util.Random;

public class Profesor implements Runnable {
	private Cafeteria cafeteria;
	private static Random r = new Random();
	
	
	public Profesor(Cafeteria cafeteria) {
		super();
		this.cafeteria = cafeteria;
	}

	public void consumir() {
		
		while(true) {
			Integer esperarFuera = r.nextInt(3) +1; 
			Integer esperarSalir = r.nextInt(4) + 2;
			try {
				Thread.sleep(1_000 * esperarFuera);
				if (cafeteria.haySitio()) {
					cafeteria.entradaSalida();
					Thread.sleep(1_000 * esperarSalir);
					cafeteria.entradaSalida();
				} else {
					System.out.println("El profesor no ha entrado porque la cafeteria está petá");
				}
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
	}
	@Override
	public void run() {
		consumir();
	}

}

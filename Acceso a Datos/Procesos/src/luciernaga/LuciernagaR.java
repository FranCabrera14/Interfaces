package luciernaga;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LuciernagaR implements Runnable {
	private String nombre;
	private boolean encendido;
	private Integer energia;
	private static int milis;

	public LuciernagaR(String nombre, Integer energia) {
		super();
		this.nombre = nombre;
		this.energia = energia;
		encendido = false;
	}

	public void enciende() {
		if (energia > 0 && !encendido) {
			encendido = true;
			while (energia > 0) {
				try {
					Thread.sleep(milis);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				energia--;
				System.out.print(energia + " ");
			}
		}

		encendido = false;

	}
	
	public void run() {
		milis = 3000;
		enciende();
	}
	public static void main(String[] args) {
		LuciernagaR l1 = new LuciernagaR("Cristian", 33);
		LuciernagaR l2 = new LuciernagaR("Jose", 9);
		LuciernagaR l3 = new LuciernagaR("Hijita", 2);
//		new Thread(l1).start();
//		new Thread(l2).start();
//		new Thread(l3).start();
		ExecutorService ejecutor = Executors.newFixedThreadPool(1);
		for (int i = 0; i < 3; i++) {
			new Thread (l1).start();
			new Thread (l2).start();
			new Thread (l3).start();

		}


		ejecutor.shutdown();
	}

}

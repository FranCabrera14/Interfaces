package cosasClase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run {
	public static void main(String[] args) {

		LanzaBolas lanza1 = new LanzaBolas("Lanzabolas1");
		LanzaBolas lanza2 = new LanzaBolas("Lanzabolas2");
		LanzaBolas lanza3 = new LanzaBolas("Lanzabolas3");

		ExecutorService ejecutor = Executors.newFixedThreadPool(9);
		for (int i = 0; i < 3; i++) {
			new Thread (lanza1).start();
			new Thread (lanza2).start();
			new Thread (lanza3).start();

//			ejecutor.execute(lanza1);
//			ejecutor.execute(lanza2);
//			ejecutor.execute(lanza3);
		}

//		lanza1.run();
//		lanza2.run();
//		lanza3.run();
		ejecutor.shutdown();

	}

}

package ejercicio5Multihilo;

import java.util.Timer;

public class Ejercicio5Test {

	public static void main(String[] args) {
		DefinicionEmisor de1 = new DefinicionEmisor('*', 20);
		
		Timer t1 = new Timer ();
		EmisorTimerTask ett1 = new EmisorTimerTask(de1);
		
		System.out.println("Iniciando eutanasia ... ");
		t1.scheduleAtFixedRate(ett1, 0, 500);
		
	}
}

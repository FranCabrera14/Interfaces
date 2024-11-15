package multihiloColorcitos;

public class Test {

	public static void main(String[] args) {
		LanzadorEmisiones l1 = new LanzadorEmisiones("L-1", new Emisor("E-1", 5));
		
		System.out.println("LANZADOR ANTES DE START");
		System.out.println(l1);
		
		l1.start();
		
		System.out.println("DESPUES DE START");
		System.out.println(l1);
		
		l1.setPriority(10);
		
		try {
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("DURANTE EJECUCIÓN");
		System.out.println(l1);
		
		l1.interrupt();
		
		System.out.println("TRAS INTERRUPCIÓN");
		System.out.println(l1);
		
		try {
			l1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("TRAS EJECUCIÓN");
		System.out.println(l1);
	}
}

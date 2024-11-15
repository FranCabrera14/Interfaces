package ejercicioCafeteria;

public class Cafeteria {
	
	private static final Integer AFORO_MAXIMO = 50;
	private static Integer entradas = 0;
	private static Integer salidas = 0;
	private Integer aforoActual;
	
	public Cafeteria() {
		aforoActual = 0;
	}

	
	public boolean haySitio() {
		return aforoActual < AFORO_MAXIMO;
	}
	public synchronized void entradaSalida() {
		
		aforoActual++;
		entradas++;
		System.out.println("Entra persona. Aforo actual = " + aforoActual);
		
		aforoActual--;
		salidas++;
		System.out.println("Sale persona. Aforo actual = " + aforoActual);
		// Comprobación recurrencia
		if(entradas - salidas -aforoActual != 0) {
			System.out.println("Descuadre de gente");
			System.exit(0);
		}
	}

}

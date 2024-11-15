package luciernaga;

import lombok.Data;

@Data
public class LuciernagaT extends Thread {
	private String nombre;
	private boolean encendido;
	private Integer energia;
	private static int milis;

	public LuciernagaT(String nombre, Integer energia) {
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
		milis = 150;
		enciende();
	}
	public static void main(String[] args) {
		LuciernagaT l1 = new LuciernagaT("Cristian", 33);
		LuciernagaT l2 = new LuciernagaT("Jose", 9);
		LuciernagaT l3 = new LuciernagaT("Hijita", 2);
		l1.start();
		l2.start();
		l3.start();
	}
}

package luciernaga;

import lombok.Data;

@Data
public class Luciernaga {
	private String nombre;
	private boolean encendido;
	private Integer energia;
	private static int milis;

	public Luciernaga(String nombre, Integer energia) {
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
	public static void main(String[] args) {
		Luciernaga l1 = new Luciernaga("Cristian", 33);
		Luciernaga l2 = new Luciernaga("Jose", 9);
		Luciernaga l3 = new Luciernaga("Hijita", 2);
		l1.enciende();
		l2.enciende();
		l3.enciende();
	}

}

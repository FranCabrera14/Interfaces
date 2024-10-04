package ejemplo.App;

import ejemplo.modelo.Politico;

public class App {
	public static void main(String[] args) {
		Politico p = new Politico();
		p.setNombre("Perro xanxe");
		p.setAfiliacion("der psoe");
		System.out.println(p);
	}
}

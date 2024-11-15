package ejercicioImplementacionMonohilo.ejercicio2;

import ejercicioImplementacionMonohilo.Botella;
import lombok.Data;

@Data
public class LanzadorVaciadoBotella extends Thread {
	private Botella botella;

	public LanzadorVaciadoBotella(String nombreHilo,Botella botella) {
		super();
		this.botella = botella;
		
	}
	
	public void run() {
		botella.vaciar();
	}
	
	public static void main(String[] args) {
		Botella b1 = new Botella("Fontvella",'j',10);
		new LanzadorVaciadoBotella("b1", b1).start();
		//b1.start();
		Botella b2 = new Botella("Cocacola",'a',10);
		new LanzadorVaciadoBotella("b2", b2).start();
		//b2.start();
	}
	
	

}

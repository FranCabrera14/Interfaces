package ejercicioImplementacionMonohilo;

import lombok.Data;

@Data
public class Botella   implements Runnable{
//	extends Thread
	private String nombre;
	private char caracter;
	private Integer cantidad;
	private static long milis;
	public Botella(String nombre, char caracter, Integer cantidad) {
		super();
		this.nombre = nombre;
		this.caracter = caracter;
		this.cantidad = cantidad;
	}
	
	
	public void vaciar() {
		while (cantidad > 0) {
			System.out.print(caracter);
			cantidad--;
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public void run() {
		milis = 150;
		vaciar();
	}
	
	public static void main(String[] args) {
		Botella b1 = new Botella("Fontvella",'j',10);
		new Thread(b1).start();
		//b1.start();
		Botella b2 = new Botella("Cocacola",'a',8);
		new Thread(b2).start();
		//b2.start();
		
	}


	
	

}

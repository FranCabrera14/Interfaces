package luciernaga;


import java.util.ArrayList;

import lombok.Data;

@Data
public class Deletrator implements Runnable {
private String palabra;
private Integer index;
private static long milis;
public Deletrator(String palabra) {
	super();
	this.palabra = palabra;
	
}

private void deletreo() {
	index = 0;
	ArrayList<String> arrayCaracteres = new ArrayList<String>();
	
	for (int i = 0; i < palabra.length(); i++) {
		String letra = palabra.substring(i, i+1);
		arrayCaracteres.add(letra);
		
	}
	
	 while (index < palabra.length()) {
		 System.out.print("Deletreando " + palabra + ":" + " [");
		 for (int i = 0; i < palabra.length(); i++) {
			if (i == index) {
				System.out.print(arrayCaracteres.get(i));
			}
			System.out.print("-");
		}
		 System.out.println("]");
		 index++;
		 
		 try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		 
	 }
}
@Override
public void run() {
	deletreo();
}

public static void main(String[] args) {
	Deletrator d1 = new Deletrator("hola");
	new Thread (d1).start();
}
}

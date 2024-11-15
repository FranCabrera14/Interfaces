package multihiloColorcitos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Colorcitos implements Runnable{
	private String nombre;
	private char caracter;
	private Integer tiempo;
 

	@Override
	public void run() {
		
	}


	public Colorcitos(char c, int i) {
		this.caracter = c;
		this.tiempo = i;
	}
	
	
	public void emite() {
    	final String ANSI_RESET = "\u001B[0m";    // Resetea el color
    	final String ANSI_GREEN = "\u001B[32m";   // Color verde
        final String ANSI_RED = "\u001B[31m";     // Color rojo
      
      	long milisAlFinal = System.currentTimeMillis() + tiempo * 1000;
      	long milisNextEmite = System.currentTimeMillis() + 300; 
      	while(System.currentTimeMillis() < milisAlFinal) {
      		if(System.currentTimeMillis() > milisNextEmite) {
      			System.out.print(ANSI_GREEN + caracter + ANSI_RESET);
      			milisNextEmite = System.currentTimeMillis() + 300;
      		}
      		System.out.print(ANSI_RED + caracter + ANSI_RESET);
      	}
		
	}
	public static void main(String[] args) {
		Colorcitos emitir = new Colorcitos('*',7);
		emitir.emite();
	}

}

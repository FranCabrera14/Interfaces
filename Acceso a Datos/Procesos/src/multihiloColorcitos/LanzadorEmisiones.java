package multihiloColorcitos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LanzadorEmisiones extends Thread {
	private String nombre;
	private Emisor emisor;
	@Override
	public String toString() {
		return "LanzadorEmisiones\n Nombre " + nombre + "\n Emisor " + emisor.getNombre() + "\n Hilo:\n"
				+ "\t name: " + getName() 
				+ "\n \t id " + threadId() 
				+ "\n \t alive? " + isAlive()
				+ "\n \t state? " + getState()
				+ "\n \t priotidad " + getPriority()
				+ "\n \t interrumpido? " + isInterrupted() 
				+ "\n \t threadGroup " + getThreadGroup();
	}
	public void run () {
		emisor.emite();
	}
	

	

}

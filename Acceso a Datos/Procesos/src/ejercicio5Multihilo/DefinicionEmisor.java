package ejercicio5Multihilo;

import lombok.Data;

@Data
public class DefinicionEmisor {

	private String nombre;
	private char caracter;
	private Integer pulsos;
	
	public DefinicionEmisor(String nombre, char caracter, Integer pulsos) {
		super();
		this.nombre = nombre;
		this.caracter = caracter;
		this.pulsos = pulsos;
	}
	public DefinicionEmisor( char caracter, Integer pulsos) {
		this.caracter = caracter;
		this.pulsos = pulsos;
	}
	
	public void emiteUnitariamente() {
		System.out.print(caracter);
	}
	
	
	
}

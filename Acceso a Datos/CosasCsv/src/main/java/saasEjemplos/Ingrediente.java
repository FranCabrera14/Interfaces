package saasEjemplos;

import lombok.Data;

@Data
public class Ingrediente {
	private Integer cantidad;
	private String tipo;
	private String ingrediente;
	
	public Ingrediente() {
	}
}

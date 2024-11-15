package saasEjemplos;

import java.util.List;

import lombok.Data;
@Data
public class Cristian {
	private Integer id;
	private String nombre;
	private String tamaño;
	private String textura;
	private List<Ingrediente> ingredientes;
	public Cristian() {
		super();
	}

}

package clase.xml;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cristians {
	private Integer id;
	private String nombre;
	private String tamaño;
	private String textura;
	private String ingredientes;
	public Cristians() {
		super();
	}

}

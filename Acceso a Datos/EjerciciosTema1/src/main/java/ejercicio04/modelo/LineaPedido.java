package ejercicio04.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;
@Data
public class LineaPedido {
	private Integer idPedido;
	private Integer numeroLinea;
	private String articulo;
	private BigDecimal precio;
	public LineaPedido( String articulo, BigDecimal precio) {
		super();
		
		this.articulo = articulo;
		this.precio = precio;
	}
	
	public LineaPedido() {
		
	}

	@Override
	public String toString() {
		return "\n Artículo a entregar [" + articulo + "] Precio [" + precio + " €]";
	}
	
	

}

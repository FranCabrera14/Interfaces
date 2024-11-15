package ejercicio04.modelo;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pedido {

	private Integer idPedido;
	private LocalDate fechaPedido;
	private LocalDate fechaEntrega;
	private String cliente;
	private List<LineaPedido> listaPedido;

	public Pedido() {
	}

	public Pedido(LocalDate fechaPedido, LocalDate fechaEntrega, String cliente, List<LineaPedido> listaPedido) {
		super();
		this.fechaPedido = fechaPedido;
		this.fechaEntrega = fechaEntrega;
		this.cliente = cliente;
		this.listaPedido = listaPedido;
	}

	@Override
	public String toString() {
		return "Pedido nº [" + idPedido + "] Fecha de compra [" + fechaPedido + "] Fecha de Entrega [" + fechaEntrega
				+ "] Cliente [" + cliente + "]" + listaPedido;
	}
	

}

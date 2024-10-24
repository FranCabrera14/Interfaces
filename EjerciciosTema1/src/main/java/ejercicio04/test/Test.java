package ejercicio04.test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ejercicio04.modelo.LineaPedido;
import ejercicio04.modelo.Pedido;
import ejercicio04.services.PedidoNotFoundException;
import ejercicio04.services.PedidoService;
import ejercicio04.services.PedidoServiceException;

public class Test {
	 
	public static void main(String[] args) {
		PedidoService pse = new PedidoService();
		LineaPedido lp = new LineaPedido("Pajilleitor", new BigDecimal(111));
		LineaPedido lp2 = new LineaPedido("Sexo", new BigDecimal(33));
		List<LineaPedido> listaLp = new ArrayList<LineaPedido>();
		LineaPedido lp3= new LineaPedido("Loli", new BigDecimal(333));
		LineaPedido lp4 = new LineaPedido("Traje Furro", new BigDecimal(69.33));
		List<LineaPedido> listaLp2 = new ArrayList<LineaPedido>();
		listaLp.add(lp);
		listaLp.add(lp2);
		listaLp2.add(lp3);
		listaLp2.add(lp4);
		Pedido p = new Pedido( LocalDate.of(2024, 10, 15), LocalDate.of(2029, 1, 6), "", listaLp);
		Pedido p2 = new Pedido(LocalDate.of(2024, 3, 6), LocalDate.of(2024, 9, 16), "Julian", listaLp2);
		try {
			pse.hacerPedido(p);
			pse.hacerPedido(p2);
		} catch (PedidoServiceException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(pse.buscarPedido(3));
		} catch (PedidoServiceException | PedidoNotFoundException e) {
			e.printStackTrace();
		}
	}
}

package ceu.dam.ad.mongo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ceu.dam.ad.mongo.model.Pedido;
import ceu.dam.ad.mongo.model.PedidoDetalle;
import ceu.dam.ad.mongo.repositories.PedidoRepository;
@Service
public class PedidoServiceImpl implements PedidoService{
	
	@Autowired
	private PedidoRepository repoPedido;
	@Override
	public String registrarPedido(Pedido pedido) throws DatosIncorrectosException {
		Optional<Pedido> pedidOpt = repoPedido.findByNumero(pedido.getNumero());
		if(pedidOpt.isPresent()) {
			throw new DatosIncorrectosException("Ya hay un pedido registrado con ese número");
		}
		repoPedido.save(pedido);
		return pedido.getId();
		
	}

	@Override
	public Pedido consultarPedido(String id) throws DatosIncorrectosException {
		Optional<Pedido> pedidoOpt = repoPedido.findById(id);
		if(!pedidoOpt.isPresent()) {
			throw new DatosIncorrectosException("No existe un pedido registrado con ese id");
		}
		return pedidoOpt.get();
	}

	@Override
	public List<Pedido> buscarPedidos(LocalDate desde, LocalDate hasta) {

		
		return repoPedido.findByFechaBetween(desde, hasta);
	}

	@Override
	public List<Pedido> consultarPedidosCliente(String dni) {
		return repoPedido.buscarPedidosDniCliente(dni);
	}

	@Override
	public Pedido añadirDetalle(String id, PedidoDetalle detalle) throws DatosIncorrectosException {
		Optional<Pedido> pedidoOpt = repoPedido.findById(id);
		if(!pedidoOpt.isPresent()) {
			throw new DatosIncorrectosException("No existe un pedido registrado con ese id");
			
		}
		Pedido pedido = pedidoOpt.get();
		pedido.getDetalles().add(detalle);
		return pedido;
	}

}

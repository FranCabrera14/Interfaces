package ceu.dam.ad.mongo.api;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ceu.dam.ad.mongo.model.Pedido;
import ceu.dam.ad.mongo.model.PedidoDetalle;
import ceu.dam.ad.mongo.services.DatosIncorrectosException;
import ceu.dam.ad.mongo.services.PedidoServiceImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pedido")
public class PedidoApiService {
	
	@Autowired
	private PedidoServiceImpl service;
	@PostMapping
	public String registrarPedido (@Valid @RequestBody Pedido pedido) throws DatosIncorrectosException{
		return service.registrarPedido(pedido);
	}
	@GetMapping("/{id}")
	public Pedido consultarPedido(@Valid @PathVariable String id) throws DatosIncorrectosException {
		return service.consultarPedido(id);
	}
	@GetMapping("/fecha")
	public List<Pedido> buscarPedidoFecha(@Valid @RequestParam LocalDate antes, @Valid @RequestParam LocalDate despues) {
		return service.buscarPedidos(despues, despues);
	}
	
	@GetMapping("/dni/{dni}")
	public List<Pedido> buscarPedidoDni(@Valid @PathVariable String dni) throws DatosIncorrectosException {
		return service.consultarPedidosCliente(dni);
		
	}
	
	@PutMapping("/id/{id}")
	public Pedido addDetalle(@Valid @PathVariable String id ,@Valid @RequestBody PedidoDetalle detalle) throws DatosIncorrectosException {
		return service.añadirDetalle(id, detalle);
	}
	
}

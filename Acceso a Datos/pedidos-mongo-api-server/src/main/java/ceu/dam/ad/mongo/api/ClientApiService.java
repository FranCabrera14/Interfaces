package ceu.dam.ad.mongo.api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ceu.dam.ad.mongo.model.Cliente;
import ceu.dam.ad.mongo.services.ClienteServiceImpl;
import ceu.dam.ad.mongo.services.DatosIncorrectosException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clients")
public class ClientApiService {

	@Autowired
	private ClienteServiceImpl service;
	@PostMapping()
	public Cliente createClient (@Valid @RequestBody CreateClientRequest request) throws DatosIncorrectosException {
		Cliente client = new Cliente();
		ModelMapper mapper = new ModelMapper();
		mapper.map(request, client);
		return service.crearCliente(client);
	}
	@PutMapping
	public Cliente actualizeClient (@Valid @RequestBody CreateClientRequest request) throws DatosIncorrectosException {
		Cliente client = new Cliente();
		ModelMapper mapper = new ModelMapper();
		mapper.map(request, client);
		return service.actualizarCliente(client);
	}
	
	@GetMapping("/dni{dni}")
	public Cliente checkClientDni(@Valid @PathVariable String dni) throws DatosIncorrectosException {
		return service.consultarClienteByDni(dni);
	}
	@GetMapping("/{id}")
	public Cliente checkClientId(@Valid @PathVariable String id) throws DatosIncorrectosException {
		return service.consultarClienteById(id);
	}
	
	
}

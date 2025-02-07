package ceu.dam.ad.mongo.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import ceu.dam.ad.mongo.model.Cliente;
import ceu.dam.ad.mongo.repositories.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
	private static final Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);

	@Autowired
	ClienteRepository repoCliente;

	@Override
	public Cliente crearCliente(Cliente cliente) throws DatosIncorrectosException {
		log.debug("Creando nuevo cliente: " + cliente);
		Optional<Cliente> existsClient = repoCliente.findOneByDni(cliente.getDni());
		if (existsClient.isPresent()) {
			log.debug("Ya existe un cliente con ese dni");
			throw new DatosIncorrectosException("Cliente ya con dni registrado");
		}
		log.debug("Cliente creado con éxito");
		return repoCliente.save(cliente);
	

	}

	@Override
	public Cliente actualizarCliente(Cliente cliente) throws DatosIncorrectosException {
		log.debug("Actualizando el cliente: " + cliente);
		if (cliente.getId() == null) {
			Optional<Cliente> existsClient = repoCliente.findOneByDni(cliente.getDni());
			log.debug("No se ha encontrado id en el cliente");
			if (!existsClient.isPresent()) {
				log.debug("No existe un cliente con ese ID o DNI");
				throw new DatosIncorrectosException("No existe un cliente con ese DNI");
			}
			Cliente actualizedClient = existsClient.get();
			cliente.setId(actualizedClient.getId());
			log.debug("Cliente y su ID actualizados con éxito");
		}
		log.debug("Cliente actualizado con éxito");
		return repoCliente.save(cliente);
	}

	@Override
	public Cliente consultarClienteById(String id) throws DatosIncorrectosException {
		try {
			log.debug("Consultando cliente con id: " + id);
			Optional<Cliente> existsClient = repoCliente.findById(id);
			if (!existsClient.isPresent()) {
				log.debug("No existe un cliente con ese id");
				throw new DatosIncorrectosException("Cliente ya con id registrado");
			} else {
				return existsClient.get();
			}
		} catch (DataAccessException e) {
			log.error("Error consultando cliente ", e);
			return null;

		}
	}

	@Override
	public Cliente consultarClienteByDni(String dni) throws DatosIncorrectosException {
		try {
			log.debug("Consultando cliente con dni: " + dni);
			Optional<Cliente> existsClient = repoCliente.findOneByDni(dni);
			if (!existsClient.isPresent()) {
				log.debug("No existe un cliente con ese dni");
				throw new DatosIncorrectosException("No existe un cliente con ese dni");
			} else {
				return existsClient.get();
			}
		} catch (DataAccessException e) {
			log.error("Error consultando cliente ", e);
			return null;

		}
	}

}

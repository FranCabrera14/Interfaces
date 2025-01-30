package ceu.dam.ad.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ceu.dam.ad.spring.model.Actor;
import ceu.dam.ad.spring.repositories.ActorRepository;

@Service
public class ActorService {
	//instanciar el dao (dao = new actorDao)
	@Autowired
	private ActorRepository repository;
	
	public Actor consultarActor(Long id) throws ActorNotFoundException {
		Optional<Actor> opcional = repository.findById(id);
		//si hay actor me devuelve actor y si no me devuelve una excepcion
		return opcional.orElseThrow(() -> new ActorNotFoundException("No existe actor con ese id"));
		
//	if(!opcional.isPresent()) {
//		throw new ActorNotFoundException("No existe actor con ese id");
//		}
	}
	//consulta los actores que contienen en su nombre el filtro
	public List<Actor> consultarActores (String filtro) {
		//to esto lo creas en la interfaz que te hace los filtrados
		return repository.findByFirstNameContainingOrLastNameContaining(filtro, filtro);
	}
//	@Transactional //esto es pa que o meta todos o ninguno si hay un error, en plan conn.rollbak
	public void crearActores(List<Actor> actores) throws ActorServiceException {
		try {
		//actores.forEach(a -> repository.save(a));
			repository.saveAll(actores); //esto hace lo mismo que el transactional y lo mete todo
			
		}
		catch(DataAccessException e) {
			throw new ActorServiceException("Error insetando actor", e);
		}
	}
	
	public void actualizarActor(Actor actor) {
		repository.save(actor);
	}
	
	public void borrarActor(Long id) {
		repository.deleteById(id);
	}
}

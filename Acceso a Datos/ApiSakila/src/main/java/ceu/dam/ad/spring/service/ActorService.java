package ceu.dam.ad.spring.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ceu.dam.ad.spring.model.Actor;
import ceu.dam.ad.spring.repository.ActorRepository;

@Service
public class ActorService {
		@Autowired
		ActorRepository repoActor;
		
		public Actor consultarActor(Long id) throws ActorNotFoundException {
			Optional<Actor> actorOptional = repoActor.findById(id);
			if(!actorOptional.isPresent()) {
				throw new ActorNotFoundException("No existe actor con ese id");
			}
			return actorOptional.get();
		}
		
		public List<Actor> consultarFiltro(String filtro) throws ActorNotFoundException {
			List<Actor> listaActores = repoActor.findByFirstNameContainingOrLastNameContaining(filtro, filtro);
			if(listaActores.isEmpty()) {
				throw new ActorNotFoundException("No existe actores con ese filtro");
			}
			return listaActores;
		}
		
		public List<Actor> consultarPorFecha(LocalDate inicio, LocalDate fin) throws ActorNotFoundException {
			List<Actor> listaActores = repoActor.findByLastUpdateBetween(inicio, fin);
			if(listaActores.isEmpty()) {
				throw new ActorNotFoundException("No existe actores con ese filtro");
			}
			return listaActores;
		}
		@Transactional
		public Actor crearActor(Actor actor) throws ActorNotFoundException{
			try {
				actor.setLastUpdate(LocalDate.now());
				return repoActor.save(actor);
			}catch (DataAccessException e) {
				
				throw new ActorNotFoundException("Error al crear el actor", e);
			}
		
			
		}
		@Transactional
		public Actor actualizarActor(Actor actor) throws ActorNotFoundException {
			try {
				consultarActor(actor.getActorId());
				actor.setLastUpdate(LocalDate.now());
				return repoActor.save(actor);
			} catch (DataAccessException e) {
				throw new ActorNotFoundException("Error al crear el Actor ", e);
			}
		}
		@Transactional
		public void borrarActor(Long id) throws ActorNotFoundException {
			try {
				consultarActor(id);
				repoActor.deleteById(id);
			} catch (DataAccessException e) {
			
				throw new ActorNotFoundException("Error al eliminar el coche ", e);
			}
		
		
		}

}

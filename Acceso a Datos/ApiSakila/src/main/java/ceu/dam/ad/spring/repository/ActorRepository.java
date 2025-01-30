package ceu.dam.ad.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ceu.dam.ad.spring.model.Actor;
import java.time.LocalDate;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long>{
	
	public List<Actor> findByFirstNameContainingOrLastNameContaining(String name, String surname);
	
	public List<Actor> findByLastUpdateBetween(LocalDate inicio, LocalDate fin);
}

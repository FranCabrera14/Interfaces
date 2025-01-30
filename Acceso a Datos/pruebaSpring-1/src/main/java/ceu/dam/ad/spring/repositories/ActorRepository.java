package ceu.dam.ad.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ceu.dam.ad.spring.model.Actor;
import java.util.List;

//hay que pasarle el actor y el id del actor
@Repository
public interface ActorRepository extends JpaRepository<Actor, Long>{
	
	public List<Actor> findByFirstNameContainingOrLastNameContaining(String firstName,String lastNameString);
}

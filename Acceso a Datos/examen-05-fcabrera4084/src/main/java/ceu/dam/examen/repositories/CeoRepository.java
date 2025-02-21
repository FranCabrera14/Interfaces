package ceu.dam.examen.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ceu.dam.examen.model.Ceo;

@Repository
public interface CeoRepository extends JpaRepository<Ceo, Long> {
	
	public Optional<Ceo> findByEmail(String email);
}

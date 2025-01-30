package ceu.dam.ad.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ceu.dam.ad.spring.model.Coche;
import java.util.List;

@Repository
public interface CocheRepository extends JpaRepository<Coche, Long>{
	
	public List<Coche> findByMarcaContaining(String marca);

}

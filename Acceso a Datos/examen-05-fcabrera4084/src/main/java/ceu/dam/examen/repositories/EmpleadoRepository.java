package ceu.dam.examen.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ceu.dam.examen.model.Empleado;



@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{
	
	public Optional<Empleado> findByDni(String dni);
	
	 public List<Empleado> findByFechaContratoBetween(LocalDate desde, LocalDate hasta);
}

package ceu.dam.examen.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ceu.dam.examen.model.Empresa;


@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, String>{
	public Optional<Empresa> findByCodigo(String codigo);
}

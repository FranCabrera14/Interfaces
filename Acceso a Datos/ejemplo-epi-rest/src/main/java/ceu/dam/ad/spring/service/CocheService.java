package ceu.dam.ad.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ceu.dam.ad.spring.model.Coche;
import ceu.dam.ad.spring.repository.CocheRepository;

@Service
public class CocheService {
	
	@Autowired
	CocheRepository cocheRepo;

	public Coche consultarCoche(Long id) throws CocheNotFoundException {
		Optional<Coche> cocheOptional = cocheRepo.findById(id);
		
		if(!cocheOptional.isPresent()) {
			throw new CocheNotFoundException("No existe el coche con ese id");
		}
		return cocheOptional.get();
	}
	
	public List<Coche> buscarCoches(String filtroMarca) throws CocheNotFoundException {
		try {
			List<Coche> listaSerie = cocheRepo.findByMarcaContaining(filtroMarca);
			if (listaSerie.isEmpty()) {
				throw new CocheNotFoundException("No existe coches con esa marca" + filtroMarca);
			} else {
				return listaSerie;
			}
		} catch (DataAccessException e) {
			
			throw new CocheNotFoundException("Error al buscar la serie ", e);
		}
	}
	@Transactional
	public Coche crearCoche(Coche coche) throws CocheNotFoundException {
		try {
			return cocheRepo.save(coche);
		} catch (DataAccessException e) {
			throw new CocheNotFoundException("Error al crear el coche ", e);
		}
	}
	@Transactional
	public Coche actualizarCoche(Coche coche) throws CocheNotFoundException {
		try {
			consultarCoche(coche.getId());
			return cocheRepo.save(coche);
		} catch (DataAccessException e) {
			throw new CocheNotFoundException("Error al crear el coche ", e);
		}
	}
	@Transactional
	public void borrarCoche(Long id) throws CocheNotFoundException {
		try {
			consultarCoche(id);
			cocheRepo.deleteById(id);
		} catch (DataAccessException e) {
		
			throw new CocheNotFoundException("Error al eliminar el coche ", e);
		}

	}
}

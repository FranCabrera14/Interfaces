package ceu.dam.ad.spring.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ceu.dam.ad.spring.model.Coche;
import ceu.dam.ad.spring.service.CocheNotFoundException;
import ceu.dam.ad.spring.service.CocheService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
public class CocheApiService {
	@Autowired
	private CocheService service;
	
	@GetMapping("/coches/{id}")
	@Operation(summary = "Consulta de coches", description = "Consultar un coche a partir de su ID")
	public Coche consultar(@PathVariable Long id) throws CocheNotFoundException {
		return service.consultarCoche(id);
	}
	@GetMapping("/coches")
	@Operation(summary = "Consulta de marcas", description = "Consultar un coche a partir de su marca")
	public List<Coche> consultarMarca(@RequestParam(defaultValue = " ",required = false) String marca) throws CocheNotFoundException {
		return service.buscarCoches(marca);
	}
	
	@PostMapping("/coches")
	@Operation(summary = "Creacion  de coches", description = "Crear un coche y su lista de conductores")
	public Coche crear(@Valid @RequestBody Coche coche) throws CocheNotFoundException {
		return service.crearCoche(coche);
	}
	
	@PutMapping("/coches")
	@Operation(summary = "Actualizar  coches", description = "Actualizar un coche y su lista de conductores")
	public Coche actualizar(@Valid @RequestBody Coche coche) throws CocheNotFoundException {
		return service.actualizarCoche(coche);
	}
	
	@DeleteMapping("/coches/{id}")
	@Operation(summary = "Borrado de coches", description = "Borra un coche y su lista de conductoresD\"")
	public void borrar(@PathVariable Long id) throws CocheNotFoundException {
		service.borrarCoche(id);
	}
}

package ceu.dam.ad.spring.api;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ceu.dam.ad.spring.model.Actor;
import ceu.dam.ad.spring.service.ActorNotFoundException;
import ceu.dam.ad.spring.service.ActorService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/actores")
public class ActorApiService {
	@Autowired
	private ActorService service;
	
	@GetMapping("/{id}")
	@Operation(summary = "Consulta de un actor", description = "Consultar un coche a partir de su ID")
	public Actor consultar(@PathVariable Long id) throws ActorNotFoundException {
		return service.consultarActor(id);
	}
	@GetMapping("/filtro")
	@Operation(summary = "Consulta de actores por filtros", description = "Consultar unos actores a partir del filtro nombre o apellido")
	public List<Actor> consultarActoresFiltro(@RequestParam(defaultValue = " ",required = false) String filtro) throws ActorNotFoundException {
		return service.consultarFiltro(filtro);
	}
	
	@GetMapping("/fechas")
	@Operation(summary = "Consulta de actores por fechas", description = "Consultar unos actores entre dos fechas definidas")
	public List<Actor> consultarActoresFecha(
		@RequestParam() 
		@DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate inicio, 
		@RequestParam()
		@DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fin) throws ActorNotFoundException {
		return service.consultarPorFecha(inicio, fin);
	}
	
	@PostMapping()
	@Operation(summary = "Creacion  de actores", description = "Crear un actor")
	public Actor crear(@Valid @RequestBody Actor actor) throws ActorNotFoundException {
		return service.crearActor(actor);
	}
	
	@PutMapping()
	@Operation(summary = "Actualizar  actores", description = "Actualizar un actor")
	public Actor actualizar(@Valid @RequestBody Actor actor) throws ActorNotFoundException {
		return service.actualizarActor(actor);
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Borrado de actores", description = "Borra un actor")
	public void borrar(@PathVariable Long id) throws ActorNotFoundException {
		service.borrarActor(id);
	}

}

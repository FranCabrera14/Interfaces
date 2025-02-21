package ceu.dam.examen.api;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ceu.dam.examen.model.Empleado;
import ceu.dam.examen.model.Empresa;
import ceu.dam.examen.services.ContratacionesService;
import ceu.dam.examen.services.DuplicadosException;
import ceu.dam.examen.services.NoEncontradoException;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ContratacionesApiService  {
		@Autowired
		ContratacionesService service;
	
	@Operation(summary="Consulta de empleados" , description = "Permite obtener un Empleado por su dni")
	@GetMapping("/empleado/{dni}")	
	public Empleado consultarEmpleado(@Valid @PathVariable String dni) throws NoEncontradoException {
		return service.consultarEmpleado(dni);
	}
	
	@GetMapping("/empresa/{codigo}")
	public Empresa consultarEmpresa(@Valid @PathVariable String codigo) throws NoEncontradoException {
		return service.consultarEmpresa(codigo);
	}
	
	@PostMapping("/empresa")
	public void crearEmpresa(@Valid @RequestBody Empresa empresa) throws DuplicadosException {
		service.crearEmpresa(empresa);
	}
	
	@PostMapping("/empleado")
	public Empleado contratarEmpleado(@RequestBody EmpleadoRequest request) throws NoEncontradoException, DuplicadosException {
		return service.contratarEmpleado(request.getDni(), request.getNombreCompleto(), request.getCodEmpresa());
	}
	@Operation(summary="Consulta de empleados contratados" , description = "Permite obtener una lista de empleados buscando por codigo de empresa y entre dos fechas")
	@GetMapping("/empleado")
	public List<Empleado> consultarEmpleadosContratados(@Valid @RequestParam String codEmpresa,
			@Valid @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy")  LocalDate fechaDesde, 
			@Valid @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fechaHasta) throws NoEncontradoException{
		return service.consultarEmpleadosContratados(codEmpresa, fechaDesde, fechaHasta);
	}
	
}

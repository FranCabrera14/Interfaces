package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ceu.dam.examen.model.Ceo;
import ceu.dam.examen.model.Empleado;
import ceu.dam.examen.model.Empresa;
import ceu.dam.examen.model.Oficina;
import ceu.dam.examen.services.ContratacionesService;
import ceu.dam.examen.services.DuplicadosException;
import ceu.dam.examen.services.NoEncontradoException;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Examen05Fcabrera4084ApplicationTests {
	
	
	@Autowired
	private ContratacionesService service;
	
	private Empresa empresa;
	private Ceo ceo;
	private Oficina oficina;
	private Empleado empleado;
		@BeforeEach
		void initTodo() {
		
			ceo.setEmail("asdadasdsadsaddad@gmail.com");
			ceo.setNombre("Nos vemos en semana verde");
			empresa.setCeo(ceo);
			empresa.setCodigo("SAD");
			empresa.setNombreComercial("Errores Fran S.L");
			empresa.setOficinas(new ArrayList<Oficina>());
			empresa.getOficinas().get(0).setCiudad("Murcia");
			empresa.getOficinas().get(0).setCodigo("help123");
			empleado.setDni("123456789D");
			empleado.setEmpresa(empresa);
			empleado.setFechaContrato(LocalDate.now());
			empleado.setNombreCompleto("Soledad de las nieves martinez verde");
		}
		
	@Test
	@Order(1)
	void crearEmpresa() throws DuplicadosException {
		 service.crearEmpresa(empresa);
		 assertNotNull(empresa);
		 assertNotNull(empresa.getCeo());
		 assertEquals(1, empresa.getOficinas().size());
	}
	
	@Test
	@Order(2)
	void crearEmpresaMal() {
		empresa.setCodigo("BOR");
		assertThrows(DuplicadosException.class, () ->  service.crearEmpresa(empresa));
	}
	@Test
	@Order(3)
	void contratarEmpleado() throws NoEncontradoException, DuplicadosException {
		Empleado emp = service.contratarEmpleado(empleado.getDni(), empleado.getNombreCompleto(), empleado.getEmpresa().getCodigo());
		assertNotNull(emp);
		assertNotNull(emp.getEmpresa());
	}
	@Test
	@Order(4)
	void contratarEmpleadoMalDni() {
		empleado.setDni("11111111A");
		assertThrows(DuplicadosException.class, () -> service.contratarEmpleado(empleado.getDni(), empleado.getNombreCompleto(), empleado.getEmpresa().getCodigo()));
	}
	@Test
	@Order(5)
	void contratarEmpleadoMalEmpresa() {
		empresa.setCodigo("inv");
		assertThrows(NoEncontradoException.class, ()-> service.contratarEmpleado(empleado.getDni(), empleado.getNombreCompleto(), empleado.getEmpresa().getCodigo()));
	}
	
	@Test
	@Order(6)
	void consultarEmpleado() throws NoEncontradoException {
		Empleado emp = service.consultarEmpleado(empleado.getDni());
		assertNotNull(emp);
		assertNotNull(emp.getEmpresa());
		assertNotNull(emp.getFechaContrato());
		assertEquals("123456789D", emp.getDni());
	}
	@Test
	@Order(7)
	void consultarEmpleadoMal() throws NoEncontradoException{
		empleado.setDni("falso");
		assertThrows(NoEncontradoException.class,() -> service.consultarEmpleado(empleado.getDni()));
	}
	
	@Test
	@Order(8)
	void consultarEmpresa() throws NoEncontradoException {
		Empresa empr = service.consultarEmpresa(empresa.getCodigo());
		assertNotNull(empr);
		assertNotNull(empr.getCeo());
		assertNotNull(empr.getOficinas());
		List<Oficina> lista = empr.getOficinas();
		assertEquals(1, lista.size());
	}
	@Test
	@Order(9)
	void consultarEmpresaMal() throws NoEncontradoException {
		empresa.setCodigo("no");
		assertThrows(NoEncontradoException.class, () -> service.consultarEmpresa(empresa.getCodigo()));
	}
	
	@Test
	@Order(10)
	void consultarEmpContratados() throws NoEncontradoException {
		List<Empleado> result = service.consultarEmpleadosContratados(empresa.getCodigo(), LocalDate.of(2024, 02, 20), LocalDate.of(2054, 02, 18));
		assertNotNull(result);
	}
	@Test
	@Order(11)
	void consultarEmpContratadosMal() throws NoEncontradoException {
		empresa.setCodigo("mal");
		service.consultarEmpleadosContratados(empresa.getCodigo(), LocalDate.of(2024, 02, 20), LocalDate.of(2054, 02, 18));
	}

}

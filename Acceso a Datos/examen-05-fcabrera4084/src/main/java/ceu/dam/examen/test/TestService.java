package ceu.dam.examen.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ceu.dam.examen.model.Ceo;
import ceu.dam.examen.model.Empleado;
import ceu.dam.examen.model.Empresa;
import ceu.dam.examen.model.Oficina;
import ceu.dam.examen.services.ContratacionesService;
@Component
public class TestService {
	@Autowired
	private ContratacionesService service;
	
	private Scanner sc;

	public void test() {
		sc = new Scanner(System.in);
		Empresa ciclo = createEmpresa();
		
		System.out.println("\nANTES DE COMENZAR CON LAS PRUEBAS ASEGURA QUE TIENES LA BBDD LIMPIA. BORRA LAS TABLAS CON ESTO: \n");
		
		System.out.println("DELETE FROM empleado;\r\n"
				+ "DELETE FROM oficina;\r\n"
				+ "DELETE FROM empresa;\r\n"
				+ "DELETE FROM ceo;");
		
		
		System.out.println("\n");
		if (!pregunta()) {
			return;
		}
		
		try {
			System.out.println(">>> PRUEBA 1: PROBAMOS A CREAR UNA EMPRESA....");
			pausa();
			service.crearEmpresa(ciclo);
			System.out.println(">>> PRUEBA 1 OK. Revisa la BBDD que se haya guardado todo (salvo empleados)");
		} catch (Exception e) {
			System.out.println("Tienes algún error");
			pausa();
			e.printStackTrace();
		}
		if (!pregunta()) {
			return;
		}
		try {
			System.out.println(">>> PRUEBA 2: PROBAMOS A CONTRATAR TRES EMPLEADOS EN LA EMPRESA ANTERIOR....");
			pausa();
			service.contratarEmpleado("11111111A", "EMPLEADO 1 DE PRUEBA", "CEU");
			service.contratarEmpleado("22222222B", "EMPLEADO 2 DE PRUEBA", "CEU");
			service.contratarEmpleado("33333333C", "EMPLEADO 3 DE PRUEBA", "CEU");
			System.out.println(">>> PRUEBA 2 OK. Revisa en BBDD que se hayan registrado 3 empleados");
		} 
		catch (Exception e) {
			System.out.println("Tienes algún error");
			pausa();
			e.printStackTrace();
		}
		if (!pregunta()) {
			return;
		}
		try {
			System.out.println(">>> PRUEBA 3: PROBAMOS A CONSULTAR UN EMPLEADO...");
			pausa();
			Empleado alumno = service.consultarEmpleado("22222222B");
			System.out.println(alumno);
			System.out.println(">>> PRUEBA 3 OK. Verifica que se imprimen todos sus datos");
		} 
		catch (Exception e) {
			System.out.println("Tienes algún error");
			pausa();
			e.printStackTrace();
		}
		if (!pregunta()) {
			return;
		}
		try {
			System.out.println(">>> PRUEBA 4: PROBAMOS A CONSULTAR UNA EMPRESA...");
			pausa();
			ciclo = service.consultarEmpresa("DAM");
			System.out.println(ciclo);
			System.out.println(">>> PRUEBA 4 OK. Verifica que se imprimen todos sus datos");
		} 
		catch (Exception e) {
			System.out.println("Tienes algún error");
			pausa();
			e.printStackTrace();
		}
		if (!pregunta()) {
			return;
		}
		try {
			System.out.println(">>> PRUEBA 5: PROBAMOS A CONSULTAR EMPLEADOS CONTRATADOS...");
			pausa();
			List<Empleado> lista = service.consultarEmpleadosContratados("CEU", LocalDate.now().minusDays(10), LocalDate.now().plusDays(10));
			lista.forEach(System.out::println);
			System.out.println(">>> PRUEBA 5 OK. Verifica que se imprimen todos los empleados (3)");
		} 
		catch (Exception e) {
			System.out.println("Tienes algún error");
			pausa();
			e.printStackTrace();
		}
		if (!pregunta()) {
			return;
		}

		System.out.println("FIN DE LAS PRUEBAS");
				
		
		
		sc.close();
		
		
		
	}


	private Empresa createEmpresa() {
		Ceo ceo = new Ceo();
		ceo.setNombre("Blas Calipo");
		ceo.setEmail("blas@ceu.es");
		Oficina of1 = new Oficina();
		of1.setCodigo("BOR");
		of1.setCiudad("Bormujos");
		Oficina of2 = new Oficina();
		of2.setCodigo("SEV");
		of2.setCiudad("Sevilla");
		List<Oficina> oficinas = new ArrayList<>();
		oficinas.add(of1);
		oficinas.add(of2);
		Empresa empresa = new Empresa();
		empresa.setCodigo("CEU");
		empresa.setNombreComercial("CEU Andalucía");
		empresa.setCeo(ceo);
		empresa.setOficinas(oficinas);
		return empresa;
	}
	
	
	private void pausa() {
		System.out.println("Pulsa tecla ENTER para continuar...\n");
		sc.nextLine();
	}
	
	private Boolean pregunta() {
		System.out.println("¿Quieres continuar con las pruebas? (S/N)\n");
		return sc.nextLine().equalsIgnoreCase("S");
	}
	
}

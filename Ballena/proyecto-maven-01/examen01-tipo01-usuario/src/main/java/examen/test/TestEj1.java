package examen.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import examen.dao.PaisesDao;
import examen.modelo.Equipo;
import examen.modelo.Pais;
import examen.services.EquipoNotFoundException;
import examen.services.FutbolDbException;
import examen.services.parte1.FutbolDbService;
import examen.services.parte1.FutbolDbServiceImpl;

public class TestEj1 {

	
	 //TODO: DESCOMENTA ESTA CLASE CUANDO QUIERAS PROBAR LA PRIMERA PARTE DEL EXAMEN
	
	private static final Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		FutbolDbService service = new FutbolDbServiceImpl();
		try {
			test1(service);
			if (!pregunta()) {
				return;
			}
			test2(service);
			if (!pregunta()) {
				return;
			}
			test3(service);
			if (!pregunta()) {
				return;
			}
			System.out.println("\n\nNo hay más pruebas... :(");
			
		} catch (Exception e) {
			System.out.println("Tienes algún error. Mira ahora la traza de la excepción cuando pulse ENTER");
			pausa();
			e.printStackTrace();
		}
	}

	private static void test3(FutbolDbService service) throws FutbolDbException {
		try {
			System.out.println(">>> Prueba 3: Consultar equipo que NO existe");
			service.consultarEquipo(9999L);
			System.out.println("Tienes algún error porque no lanzas excepción si no existe");
			pausa();
		}
		catch(EquipoNotFoundException ok) {
			System.out.println(ok.getMessage());
			System.out.println("Excepción controlada OK");
		}
	}

	private static void test2(FutbolDbService service) throws FutbolDbException, EquipoNotFoundException {
		System.out.println(">>> Prueba 2: Consultar equipo que existe");
		Equipo equipo = service.consultarEquipo(1L);
		System.out.println("No hay errores: Comprueba que los datos que se imprimen a continuación son los de BBDD para el equipo 1 (3 jugadores y país Ecuador)");
		System.out.println(equipo);
	}

	private static void test1(FutbolDbService service) throws FutbolDbException {
		System.out.println(">>> Prueba 1: Insertar lista de equipos 5 equipos, 2 de ellos con errores");
		List<Equipo> equipos = new ArrayList<>();
		for (int i = 0; i <= 4; i++) {
			equipos.add(new Equipo());
			equipos.get(i).setNombre("PRUEBA " +(i+1));
			equipos.get(i).setSocios(new Random().nextInt(10000, 90000));
			equipos.get(i).setPais(new Pais());
			equipos.get(i).getPais().setCodigo((String)new PaisesDao().getAllMapPaises().keySet().toArray()[new Random().nextInt(6)]);
		}
		equipos.get(1).getPais().setCodigo("NOEXISTE");
		equipos.get(3).setNombre("MUYLARGOMUYLARGOMUYLARGOMUYLARGOMUYLARGOMUYLARGOMUYLARGOMUYLARGOMUYLARGOMUYLARGOMUYLARGOMUYLARGOMUYLARGOMUYLARGO");
		List<Equipo> equiposInsertados = service.insertarListaEquipos(equipos);
		if (equiposInsertados == null) {
			System.out.println("Tienes algún error porque la lista que devuelve el servicio es null. Revisa el código.");
		}
		else if (equiposInsertados.size() != 3) {
			System.out.println("Tienes algún error porque la lista que devuelve el servicio no tiene 3 equipos. Tiene " + equiposInsertados.size() + ". Revisa el código.");
		}
		else {
			System.out.println("No hay errores: Comprueba que los datos que se imprimen a continuación son los de BBDD para los 3 equipos insertados");
			System.out.println("Sólo deben aparecer 3 equipos. Tienen que tener su ID ok. La descripción del país estará a NULL");
			equiposInsertados.forEach(System.out::println);
		}
	}
	
	private static void pausa() {
		System.out.println("Pulsa tecla ENTER para continuar...\n");
		sc.nextLine();
	}
	
	private static Boolean pregunta() {
		System.out.println("¿Quieres continuar con las pruebas? (S/N)\n");
		return sc.nextLine().equalsIgnoreCase("S");
	}
	
	
	
}

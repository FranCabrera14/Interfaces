package examen.test;

import java.util.List;
import java.util.Scanner;

import examen.modelo.Equipo;
import examen.services.EquipoNotFoundException;
import examen.services.FutbolDbException;
import examen.services.FutbolXmlException;
import examen.services.parte2.FutbolXmlService;
import examen.services.parte2.FutbolXmlServiceImpl;

public class TestEj2 {

	// TODO: USA ESTA CLASE PARA PROBAR LA SEGUNDA PARTE DEL EXAMEN
	// TODO: REVISA ANTES LAS CONSTANTES CON LAS RUTAS DE LOS FICHEROS QUE TIENES AQUÍ ABAJO 
	private static final String RUTA_FICHERO_PARA_LEER = "c:/temporal/examenes/liga.xml";
	private static final String RUTA_FICHERO_PARA_ESCRIBIR = "c:/temporal/examenes/equipo.xml";
	
	private static final Scanner sc = new Scanner(System.in);
	private static FutbolXmlService service;
	
	public static void main(String[] args) {
		service = new FutbolXmlServiceImpl();
		try {
			test1();
			if (!pregunta()) {
				return;
			}
			test2();
			if (!pregunta()) {
				return;
			}
			test3();
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

	private static void test3() throws FutbolDbException, FutbolXmlException {
		try {
			System.out.println(">>> Prueba 3: Intentar escribir XML para equipo que NO existe");
			service.exportarEquipo(RUTA_FICHERO_PARA_ESCRIBIR, 99999L);
			System.out.println("Tienes algún error porque no lanzas excepción si no existe");
			pausa();
		}
		catch(EquipoNotFoundException ok) {
			System.out.println(ok.getMessage());
			System.out.println("Excepción controlada OK");
		}
	}

	private static void test2() throws FutbolDbException, EquipoNotFoundException, FutbolXmlException {
		System.out.println(">>> Prueba 2: Escribir XML para el equipo 1 de BBDD. El fichero se escribirá aquí " + RUTA_FICHERO_PARA_ESCRIBIR );
		service.exportarEquipo(RUTA_FICHERO_PARA_ESCRIBIR, 1L);
		System.out.println("No hay errores: Comprueba que los datos del fichero generado son los de BBDD para el equipo 1 (3 jugadores y país Ecuador)");
	}

	private static void test1() throws FutbolDbException, FutbolXmlException {
		System.out.println(">>> Prueba 1: Importar XML. Son 3 equipos y uno es erróneo. Se deben insertar 2");
		List<Equipo> equiposInsertados = service.importarEquipos(RUTA_FICHERO_PARA_LEER);
		System.out.println("No hay errores: Comprueba que los datos que se imprimen a continuación son los de BBDD para los 2 equipos insertados");
		System.out.println("Sólo deben aparecer 2 equipos (el CeuFC y el KingsQueens). Tienen que tener su ID ok y todos sus datos OK, salvo el ID de los futbolistas que estará a null");
		equiposInsertados.forEach(System.out::println);
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

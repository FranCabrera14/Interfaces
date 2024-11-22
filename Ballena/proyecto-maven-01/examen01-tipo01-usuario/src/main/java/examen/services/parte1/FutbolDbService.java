package examen.services.parte1;

import java.util.List;

import examen.modelo.Equipo;
import examen.services.EquipoNotFoundException;
import examen.services.FutbolDbException;

public interface FutbolDbService {

	/** Este método tiene que consultar en BBDD el equipo con el ID que le llega por parámetro.
	 * Tiene que devolver un equipo completo con todos sus datos. Es decir, con todos sus atributos
	 * incluyendo su país (código y descripción) y su lista de futbolistas completa.
	 * Utiliza los DAO que has implementado para ello. Y también el DAO de Paises proporcionado.
	 * 
	 * Si el equipo no existe, tendrás que lanzar EquipoNotFoundException con un mensaje y el origen de la excepción.
	 * Si hay algún error al hacer la consulta, tendrás que lanzar FutbolDbException con un mensaje y el origen de la excepción.	 
	 * */
	public Equipo consultarEquipo(Long id) throws FutbolDbException, EquipoNotFoundException;

	
	
	
	/** Este método recibe una lista de equipos. Tendrá que insertar en BBDD todos los equipos de la lista. 
	 * Sólo inserta los datos de la tabla EQUIPOS (no inserta nada en la tabla de países ni futbolistas).
	 * Si hay algún error al insertar un equipo, no se detiene, continúa con el resto de equipos. 
	 * 
	 * El método debe devolver una lista con los equipos que se han insertado  en BBDD (los que no han dado error) 
	 * con su ID correctamente configurado en cada uno de ellos (el ID generado por la BBDD).
	 * 
	 * Si hay algún error al abrir la conexión a BBDD, tendrás que lanzar FutbolDbException con un mensaje y el origen de la excepción.	 
	 */
	public List<Equipo> insertarListaEquipos(List<Equipo> equipo) throws FutbolDbException;
	
	
}

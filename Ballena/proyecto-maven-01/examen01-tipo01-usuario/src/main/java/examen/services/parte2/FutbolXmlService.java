package examen.services.parte2;

import java.util.List;

import examen.modelo.Equipo;
import examen.services.EquipoNotFoundException;
import examen.services.FutbolDbException;
import examen.services.FutbolXmlException;

public interface FutbolXmlService {

	/**  
	 * Este método recibe la ruta completa con el nombre de un fichero XML. El método debe leer el fichero completo para obtener
	 * una lista de Equipos. Cuando la tenga, tendrá que insertar dicha lista en BBDD utilizando el método del servicio
	 * FutbolDbService que ya has implementado anteriormente. 
	 * 
	 * El método devolverá una lista de los equipos insertados con su ID relleno (el ID generado por la BBDD). 
	 * 
	 * Para leer el XML podrás utilizar SAX o DOM. Lo que prefieras.
	 * 
	 * Si hay algún error al leer el XML, tendrás que lanzar FutbolXmlException con un mensaje y el origen de la excepción.
	 * Si hay algún error al abrir la conexión para insertar, tendrás que lanzar FutbolDbException con un mensaje y el origen de la excepción.	 
	 */
	public List<Equipo> importarEquipos(String pathFile) throws FutbolXmlException, FutbolDbException;

	
	
	
	/** Este método recibe la ruta y nombre completo de un fichero que inicialmente no existe. Este método tiene que 
	 * crear dicho fichero. 
	 * El fichero se creará con todos los datos del equipo que tenga en BBDD el id que recibimos por parámetro. Es decir,
	 * debes consultar el equipo con el ID indicado utilizando el servicio FutbolDbService implementado anteriormente. 
	 * Cuando lo tengas, escribe un XML en la ruta indicada con los datos de ese equipo. Mira el FORMATO del equipo xml
	 * proporcionado en Moodle. 
	 * 
	 * Para escribir el XML tienes que utilizar JACKSON.
	 * 
	 * Si el equipo no existe, tendrás que lanzar EquipoNotFoundException con un mensaje y el origen de la excepción.
	 * Si hay algún error al hacer la consulta, tendrás que lanzar FutbolDbException con un mensaje y el origen de la excepción.	 
	 * Si hay algún error al crear el XML, tendrás que lanzar FutbolXmlException con un mensaje y el origen de la excepción.	 
	 */
	public void exportarEquipo(String pathFile, Long idEquipo) throws FutbolXmlException, FutbolDbException, EquipoNotFoundException;

	
	
	
	
	
}
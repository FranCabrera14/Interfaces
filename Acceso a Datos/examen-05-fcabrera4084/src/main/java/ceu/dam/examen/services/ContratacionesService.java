package ceu.dam.examen.services;

import java.time.LocalDate;
import java.util.List;

import ceu.dam.examen.model.Empleado;
import ceu.dam.examen.model.Empresa;

public interface ContratacionesService {

	/** Este método debe consultar los datos del empleado a partir de su DNI en BBDD y devolverlo. 
	 * Vendrá con todos sus datos, incluyendo la empresa en la que está contratado con 
	 * todas sus oficinas y su CEO 
	 * NOTA: un CEO sólo puede dirigir una empresa.
	 * 
	 * Si no existe el empleado, se lanzará NoExisteExcepcion.
	 * 
	 * Este método tendrá que estar también publicado en un API en la URL /empleado con GET. 
	 * El DNI se enviará por URL a continuación de /empleado/. Ejemplo: /empleado/22222222B
	 * Si se lanza NoEncontradoException tendrá que devolver un 404 NOT FOUND con mensaje explicativo en el body
	 * 
	 * @param dni
	 * @return
	 * @throws NoEncontradoException
	 */
	public Empleado consultarEmpleado(String dni) throws NoEncontradoException;
	
	
	/** Este método debe consultar los datos de la empresa a partir de su código en BBDD y devolverla 
	 * Vendrá con todos sus datos, incluyendo sus oficinas y su CEO
	 * NOTA: un CEO sólo puede dirigir una empresa.
	 * 
	 * Si no existe la empresa, se lanzará NoEncontradoException.
	 * 
	 * Este método tendrá que estar también publicado en un API en la URL /empresa con GET. 
	 * El código se enviará por URL a continuación de /empresa/. Ejemplo /empresa/CEU
	 * Si se lanza NoEncontradoException tendrá que devolver un 404 NOT FOUND con mensaje explicativo en el body
	 * 
	 * @param codigo
	 * @return
	 * @throws NoEncontradoException
	 */
	public Empresa consultarEmpresa(String codigo) throws NoEncontradoException;
	
	
	
	
	/** Este método debe crear una empresa en BBDD. Se creará la empresa y todas sus entidades asociadas. 
	 * NOTA: un CEO sólo puede dirigir una empresa.
	 * Si ya existe empresa con el mismo código, se lanzará DuplicadosException.
	 * Si ya existe un CEO con el mismo email, se lanzará DuplicadosException.
	 * La empresa y sus entidades asociadas tienen que ser válidas de acuerdo a los comentarios indicados en el modelo.
	 * Si ocurre algún error, no se guardará nada en BBDD. Es decir, o se guarda la empresa completa, o no se guarda nada
	 * 
	 * Este método tendrá que estar también publicado en un API en la URL /empresa con POST. 
	 * La empresa se enviará en el body de la petición. 
	 * Se debe validar que la empresa recibida en la petición cumpla todas las restricciones de validación.
	 * Si no es válida, tendrá que devolver 400 BAD REQUEST con un mensaje indicando qué atributo no es válido y por qué.
	 * 
	 * Si se lanza DuplicadosException tendrá que devolver un 400 BAD REQUEST con mensaje explicativo en el body
	 * 
	 * @param empresa
	 * @return
	 * @throws DuplicadosException
	 */
	public void crearEmpresa(Empresa empresa) throws DuplicadosException;
	
	
	
	
	/** Este método debe crear un empleado en BBDD con contratado para le empresa del código recibido. Como fecha de contratación
	 * se pondrá la fecha actual.
	 * Si ya existe un empleado contratado con ese DNI en la BBDD (aunque sea para otra empresa), se lanzará DuplicadosException.
	 * Si NO existe una empresa con el código indicado, se lanzará NoEncontradoException.
	 * 
	 * Este método tendrá que estar también publicado en un API en la URL /contratar con POST. 
	 * Todos los datos se enviarán como parámetros de la petición. Ejemplo: /contratar?dni=12345678Y&nombre=Garcia&codEmpresa=CEU
	 * 
	 * Si se lanza DuplicadosException tendrá que devolver un 400 BAD REQUEST con mensaje explicativo en el body
	 * Si se lanza NoEncontradoException tendrá que devolver un 404 NOT FOUND con mensaje explicativo en el body
	 * 
	 * @param dni, nombre, codEmpresa
	 * @return
	 * @throws DuplicadosException, NoEncontradoException
	 */
	public Empleado contratarEmpleado(String dni, String nombre, String codEmpresa) throws NoEncontradoException, DuplicadosException;
	
	
	
	
	/** Este método consultará todos los empleados contratados en la empresa con el código indicado y cuya
	 * fecha de contratación este entre las dos fechas enviadas. 
	 * Si NO existe una empresa con el código indicado, se lanzará NoEncontradoException.
	 * 
	 * Este método tendrá que estar también publicado en un API en la URL /contratos con GET. 
	 * El código de empresa se enviará en la URL a continuación de /contratos/. El resto de datos (las fechas) se 
	 * enviarán como parámetros de la petición con formato dd-MM-yyyy. Ejemplo: /contratos/CEU?fechaDesde=01-02-2025&fechaHasta=01-03-2025
	 * 
	 * Si se lanza NoEncontradoException tendrá que devolver un 404 NOT FOUND con mensaje explicativo en el body
	 * 
	 * @param codEmpresa, fechaDesde, fechaHasta
	 * @return
	 * @throws  NoEncontradoException
	 */
	public List<Empleado> consultarEmpleadosContratados(String codEmpresa, LocalDate fechaDesde, LocalDate fechaHasta) throws NoEncontradoException;
	
}

package services;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.mariadb.jdbc.Connection;

import dao.PeliculaDao;
import modelo.Pelicula;

public class PeliculaService extends Service {
	private PeliculaDao dao;

	public PeliculaService() {
		dao = new PeliculaDao();
	}

	public List<Pelicula> borrarPeliculas() throws PeliculaServiceException {
		try (Connection conn = abrirConexion();) {
			List<Pelicula> listaPeli = dao.consultarPeliculas(conn);
			for (Iterator<Pelicula> iterator = listaPeli.iterator(); iterator.hasNext();) {
				Pelicula peli = (Pelicula) iterator.next();
				if (peli.getLongitud() > 100) {
					iterator.remove();
				}
			}
			return listaPeli;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PeliculaServiceException("Error, consulta bien las cosas", e);

		}

	}
	public List<Pelicula> consultarPeliculas() throws PeliculaServiceException {
		return consultarPeliculas(100);
	}
 
	public List<Pelicula> consultarPeliculas(Integer longitud) throws PeliculaServiceException {
		try (Connection conn = abrirConexion()){
			return dao.consultarPeliculas(conn)
					.stream()
					.filter(p -> p.getLongitud() < longitud)
					.toList();
		}
		catch (SQLException e) {
			System.err.println("Error al consultar peliculas");
			throw new PeliculaServiceException("Error al consultar peliculas en BBDD", e);
 
		}
 
	}
 
	


}

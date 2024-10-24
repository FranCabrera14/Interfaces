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
			List<Pelicula> listaPeli = dao.listaCompleta(conn);
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

}

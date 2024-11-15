package clase01;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mariadb.jdbc.Connection;

import dao.ActorDao;

public class Services extends DAO {
	private ActorDao dao;

	public Services() {
		dao = new ActorDao();
	}

	public List<Actores> consultarActores(String cadena) throws ActorServiceException {
		try (Connection conn = abrirConexion();) {
			return dao.buscar(conn, "%" + cadena + "%");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ActorServiceException("asdasdsada",e);

		}

	}
}

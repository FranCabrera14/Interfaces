package services;

import java.sql.SQLException;
import java.util.Map;
import java.util.stream.Collectors;

import org.mariadb.jdbc.Connection;

import dao.ClienteDao;
import modelo.Cliente;

public class ClienteService extends Service {
	private ClienteDao dao;

	public ClienteService() {
		dao = new ClienteDao();
	}

	public Map<String, Cliente> mapa() throws ClienteServiceException {
		try (Connection conn = abrirConexion();) {
			return dao.listaCompleta(conn).stream().collect(Collectors.toMap(e -> e.getEmail(), e -> e));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ClienteServiceException("Nena tu tas equivocao", e);
		}

	}
}

package ejercicio3.services;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.mariadb.jdbc.Connection;

import dao.ClienteDao;
import ejercicio3.dao.PagoDao;
import ejercicio3.modelo.Pago;
import services.ClienteServiceException;

public class PagoService extends Service {
	private ClienteDao cdao;
	private PagoDao pdao;

	public PagoService() {
		cdao = new ClienteDao();
		pdao = new PagoDao();
	}

	public Map<String, List<Pago>> mapaTodosPagos() throws ClienteServiceException, PagoServiceException {
		Map<String, List<Pago>> mapa = new HashMap<String, List<Pago>>();
		try (Connection conn = abrirConexion();) {

			return cdao.listaCompleta(conn).stream()
					.collect(Collectors.toMap(c -> c.getEmail(), c -> pdao.listaCompleta(conn, c.getId())));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PagoServiceException("Nena tu tas equivocao", e);
		}

	}
}

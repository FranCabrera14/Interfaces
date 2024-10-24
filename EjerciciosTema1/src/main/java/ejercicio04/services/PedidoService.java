package ejercicio04.services;


import java.sql.SQLException;

import org.mariadb.jdbc.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ejercicio04.dao.LineaPedidoDao;
import ejercicio04.dao.PedidoDao;
import ejercicio04.modelo.LineaPedido;
import ejercicio04.modelo.Pedido;

public class PedidoService extends Services {
	private static final Logger log = LoggerFactory.getLogger(PedidoService.class);
	private PedidoDao pedidoDao;
	private LineaPedidoDao lineaPedidoDao;
	private Integer contadorLineas;

	public PedidoService() {

		pedidoDao = new PedidoDao();
		lineaPedidoDao = new LineaPedidoDao();
		contadorLineas = 1;
	}

	public Pedido buscarPedido(Integer idPedido) throws PedidoServiceException, PedidoNotFoundException {

		try (Connection conn = abrirConexion()) {

			Pedido p1 = pedidoDao.consultarPedido(conn, idPedido);
			if (p1 != null) {
				p1.setListaPedido(lineaPedidoDao.consultarLineaPedido(conn, idPedido));
			} else {
				throw new PedidoNotFoundException("No existe un pedido con ese ID");
			}

			return p1;

		} catch (SQLException e) {
			log.error("Error registrando pedido" , e);
			e.printStackTrace();
			throw new PedidoServiceException("Hubo un problema", e);
		}

	}

	public void hacerPedido(Pedido pedido) throws PedidoServiceException {
		log.debug("Creando nuevo pedido...");
		try (Connection conn = abrirConexion()) {
			try {
				log.debug("Insertando datos generales del pedido...");
				conn.setAutoCommit(false);
				Integer Key = pedidoDao.insertarPedido(conn, pedido);
				log.debug("Insertando lineas del pedido...");
				for (LineaPedido lineaP : pedido.getListaPedido()) {
					lineaP.setIdPedido(Key);
					lineaP.setNumeroLinea(contadorLineas);
					lineaPedidoDao.insertarLineaPedidoDao(conn, lineaP);
					contadorLineas++;
				}

				conn.commit();
				log.info("Pedido realizado con id " + pedido.getIdPedido());
			} catch (SQLException e) {
				conn.rollback();
				throw e;
			}
		} catch (SQLException e) {

			throw new PedidoServiceException();
		}
	}

}

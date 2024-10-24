package ejercicio04.dao;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mariadb.jdbc.Connection;

import ejercicio04.modelo.LineaPedido;
import ejercicio04.modelo.Pedido;

public class LineaPedidoDao {

	public void insertarLineaPedidoDao(Connection conn, LineaPedido lineaPedido) throws SQLException {
		String sql = "INSERT INTO pedidos_lineas values (?,?,?,?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			stmt.setInt(1, lineaPedido.getIdPedido());
			stmt.setInt(2, lineaPedido.getNumeroLinea());
			stmt.setString(3, lineaPedido.getArticulo());
			stmt.setBigDecimal(4, lineaPedido.getPrecio());
			stmt.executeUpdate();

			ResultSet keys = stmt.getGeneratedKeys();
			keys.next();
		}

	}

	public List<LineaPedido> consultarLineaPedido(Connection conn, Integer idPedido) throws SQLException {
		String sql2 = "select * from pedidos_lineas where id_pedido = ?";

		try (PreparedStatement stmt = conn.prepareStatement(sql2)) {
			stmt.setInt(1, idPedido);
			ResultSet rs = stmt.executeQuery();
			List<LineaPedido> lp1 = new ArrayList<LineaPedido>();
			while (rs.next()) {
				LineaPedido lineaBsucada = new LineaPedido();

				lineaBsucada.setIdPedido(rs.getInt("id_pedido"));
				lineaBsucada.setNumeroLinea(rs.getInt("numero_linea"));
				lineaBsucada.setArticulo(rs.getString("articulo"));
				lineaBsucada.setPrecio(rs.getBigDecimal("precio"));
				lp1.add(lineaBsucada);

			}

			return lp1;
		}

	}

}

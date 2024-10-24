package ejercicio04.dao;

import java.sql.Statement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mariadb.jdbc.Connection;

import ejercicio04.modelo.Pedido;

public class PedidoDao {
	
	public Integer insertarPedido (Connection conn, Pedido pedido) throws SQLException {
		
		String sql = "INSERT INTO pedidos (fecha_pedido, fecha_entrega, cliente)  values (?,?,?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
			
			stmt.setDate(1, Date.valueOf(pedido.getFechaPedido()));
			stmt.setDate(2, Date.valueOf(pedido.getFechaEntrega()));
			stmt.setString(3, pedido.getCliente());
			stmt.executeUpdate();
			
			ResultSet keys = stmt.getGeneratedKeys();
			keys.next();
			return keys.getInt(1);
			
		}
		
	}
	
	public Pedido consultarPedido (Connection conn, Integer idPedido) throws SQLException {
		String sql2 = "select * from pedidos where id_pedido = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql2)) {
			stmt.setInt(1, idPedido);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Pedido pedidoBuscado = new Pedido();
				
				pedidoBuscado.setIdPedido(rs.getInt("id_pedido"));
				pedidoBuscado.setFechaPedido(rs.getDate("fecha_pedido").toLocalDate());
				pedidoBuscado.setFechaEntrega(rs.getDate("fecha_entrega").toLocalDate());
				pedidoBuscado.setCliente(rs.getString("cliente"));
				return pedidoBuscado;
			}
			return null;
		
		}
		
	}

}

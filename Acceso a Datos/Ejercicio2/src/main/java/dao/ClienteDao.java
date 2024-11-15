package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;

public class ClienteDao {

	public List<Cliente> listaCompleta(Connection conn) throws SQLException {
		List<Cliente> lista = new ArrayList<Cliente>();
		String sql = "select * from customer";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Cliente cliente1 = new Cliente();
				cliente1.setId(rs.getInt("customer_id"));
				cliente1.setFirstName(rs.getString("first_name"));
				cliente1.setLastName(rs.getString("last_name"));
				cliente1.setEmail(rs.getString("email"));
				cliente1.setActivo(rs.getBoolean("active"));

				lista.add(cliente1);
			}
			return lista;
		}

	}

}

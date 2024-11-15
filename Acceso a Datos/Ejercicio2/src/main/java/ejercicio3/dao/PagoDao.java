package ejercicio3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ejercicio3.modelo.Pago;

public class PagoDao {
	public List<Pago> listaCompleta(Connection conn, Integer id){
		List<Pago> listaPagos = new ArrayList<Pago>();
		String sql = "select * from payment where customer_id = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Pago pago = new Pago();
				pago.setImporte(rs.getBigDecimal("amount"));
				pago.setFecha(rs.getDate("payment_date").toLocalDate());

				listaPagos.add(pago);
			}
			return listaPagos;
		} catch(SQLException e) {
			System.out.println("Pito mal");
			return null;
		}

	}
	

}

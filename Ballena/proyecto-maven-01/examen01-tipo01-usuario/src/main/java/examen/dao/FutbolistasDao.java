package examen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import examen.modelo.Futbolista;

public class FutbolistasDao {

	// TODO: IMPLEMENTA ESTE DAO. NO TIENES QUE AÑADIR MÁS MÉTODOS.

	public List<Futbolista> selectByEquipo(Connection conn, Long idEquipo) throws SQLException {
		String sql = "select * from futbolistas where id_equipo = ?";
		List<Futbolista> listaFutbolista = new ArrayList<Futbolista>();
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setLong(1, idEquipo);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Futbolista futbolista = new Futbolista();
				futbolista.setId(rs.getLong("id_futbolista"));
				futbolista.setDorsal(rs.getInt("dorsal"));
				futbolista.setNombre(rs.getString("nombre"));
				futbolista.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
				futbolista.setPosicion(rs.getString("posicion"));

				listaFutbolista.add(futbolista);
			}
			return listaFutbolista;
		}

	}

}

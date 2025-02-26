package examen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mariadb.jdbc.Statement;

import examen.modelo.Equipo;
import examen.modelo.Pais;

public class EquiposDao {

	// TODO: IMPLEMENTA ESTE DAO. NO TIENES QUE AÑADIR MÁS MÉTODOS.

	public Equipo selectById(Connection conn, Long idEquipo) throws SQLException {
		String sql = "select * from equipos where id_equipo = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setLong(1, idEquipo);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Equipo equipoBuscado = new Equipo();
				Pais pais = new Pais();
				equipoBuscado.setId(rs.getLong("id_equipo"));
				equipoBuscado.setNombre(rs.getString("nombre"));
				pais.setCodigo(rs.getString("cod_pais"));
				equipoBuscado.setPais(pais);
				equipoBuscado.setSocios(rs.getInt("socios"));
				return equipoBuscado;
			}
		}
		return null;
	}

	public Long insert(Connection conn, Equipo equipo) throws SQLException {
		String sql = "INSERT INTO equipos (nombre, cod_pais, socios) values (?,?,?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			try {

				stmt.setString(1, equipo.getNombre());
				Pais pais = new Pais();
				pais = equipo.getPais();
				stmt.setString(2, pais.getCodigo());
				stmt.setInt(3, equipo.getSocios());
				stmt.executeUpdate();
				ResultSet keys = stmt.getGeneratedKeys();
				keys.next();
				return keys.getLong(1);
			} catch (Exception e) {
				throw new SQLException("Algo no funciona bien", e);

			}

		}
	}

}

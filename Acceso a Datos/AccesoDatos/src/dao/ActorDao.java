package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mariadb.jdbc.Connection;

import clase01.Actores;

public class ActorDao {
	
	public List<Actores> buscar (Connection conn, String filtro) throws SQLException {
		List<Actores> lista = new ArrayList<Actores>();
		String sql = "Select actor_id,first_name,last_name from actor where first_name like ? or last_name like ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, "%" + filtro + "%");
			stmt.setString(2, "%" + filtro + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Actores actors1 = new Actores();
				actors1.setActorId(rs.getInt("actor_id"));
				actors1.setFirstName(rs.getString("first_name"));
				actors1.setLastName(rs.getString("last_name"));

				lista.add(actors1);
			}
			return lista;
		} 
		

		}
		
		
	}


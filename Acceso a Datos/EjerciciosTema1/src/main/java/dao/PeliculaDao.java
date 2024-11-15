package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ejercicio04.modelo.Pedido;
import modelo.Pelicula;

public class PeliculaDao  {
	public List<Pelicula> consultarPeliculas (Connection conn) throws SQLException{
		List<Pelicula> lista = new ArrayList<Pelicula>();
		String sql = "select * from film";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Pelicula peli1 = new Pelicula();
				peli1.setId(rs.getInt("film_id"));
				peli1.setTitulo(rs.getString("title"));
				peli1.setLongitud(rs.getInt("length"));

				lista.add(peli1);
			}
			return lista;
		} 
		
	}


	


}

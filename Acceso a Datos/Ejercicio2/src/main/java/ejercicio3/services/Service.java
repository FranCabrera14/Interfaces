package ejercicio3.services;

import java.sql.DriverManager;

import org.mariadb.jdbc.Connection;

public class Service {
	public Connection abrirConexion() {
		String urlConexion = "jdbc:mariadb://127.0.0.1:3306/sakila";
		String driver = "org.mariadb.jdbc.Driver";
		String usuario = "sakila";
		String password = "fuego";

		try {
			Class.forName(driver);
			return (Connection) DriverManager.getConnection(urlConexion, usuario, password);

		} catch (Exception e) {
			System.err.println("No he podido abrir la conexión. " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException("No puedo conectarme a la BBDD");
		}

	}

	public void testConexion() {
		Connection conn = abrirConexion();
		System.out.println("Esta es mi conexion: " + conn);
		if (conn != null) {
			System.out.println("Todo ok");
		} else {
			System.out.println("Esto no rula...");
		}
	}

}

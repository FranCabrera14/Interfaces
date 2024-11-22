package examen.services;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class DbService {
	
	public void testConnection() {
		Connection conn = openConnection();
		System.out.println("Esta es mi conexión: " + conn);
		if (conn != null) {
			System.out.println("Todo OK!!");
		}
		else {
			System.out.println("Esto no rula...");
		}
	}
	
	
	protected Connection openConnection() {
		String urlConexion =  "jdbc:mariadb://localhost:3306/exam01-ad";
		String driver = "org.mariadb.jdbc.Driver";
		String usuario = "exam01-ad";
		String password = "exam01-ad";

		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(urlConexion, usuario, password);
			return conn;
		}
		catch(Exception e) {
			System.err.println("No he podido abrir la conexión. " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException("No puedo conectarme a la BBDD");
		}
		
	}
}

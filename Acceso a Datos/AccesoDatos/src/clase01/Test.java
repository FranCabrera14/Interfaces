package clase01;

import java.security.Provider.Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.ActorDao;

public class Test {
	public static void main(String[] args) throws SQLException, ActorServiceException {
		Scanner sc = new Scanner(System.in);
		Services servicioActor = new Services();
		Actores actores1 = new Actores();
		System.out.println("Indica un nombre o apellido para filtrar en la base de datos.");
		String filtro = sc.nextLine();
		System.out.println(servicioActor.consultarActores(filtro));
		
		sc.close();
	}
}

package saasEjemplos;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		CristianSaxService service = new CristianSaxService();
		
		try {
			List<Cristian> lista = service.leerXMLCristian("C:/Users/fcabrera4084/Desktop/Cosas Asignaturas/AccesoDatos/croquetasDeLaAbuela.xml");
			
			for (Cristian cristian : lista) {
				System.out.println(cristian);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

package clase.xml;

import java.util.ArrayList;
import java.util.List;

public class Test {
	
	public static void main(String[] args) {
		List<Cristians> lista = new ArrayList<Cristians>();
		
		for (int i = 0; i < 6; i++) {
			lista.add(new Cristians(i, "Cristian gafa", "Tam" +  i, " Textura blanda " + i, " Ingredientes " + i));
		}
		
		CristianXMLService service = new CristianXMLService();
		service.escribirCristians(lista, "C:/Users/fcabrera4084/Desktop/Cosas Asignaturas/AccesoDatos/cristian.xml");
		System.out.println("Mira el xml anda...");
		
		lista = service.leerXmlCristians("C:/Users/fcabrera4084/Desktop/Cosas Asignaturas/AccesoDatos/cristian.xml");
		System.out.println(lista);
	}

}

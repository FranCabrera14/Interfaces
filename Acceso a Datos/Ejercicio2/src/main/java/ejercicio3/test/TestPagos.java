package ejercicio3.test;

import ejercicio3.services.PagoService;
import ejercicio3.services.PagoServiceException;
import services.ClienteServiceException;

public class TestPagos {
	public static void main(String[] args) {
		PagoService ps = new PagoService();
//		try {
//			System.out.println(ps.mapaTodosPagos().get("MARILYN.ROSS@sakilacustomer.org"));
//		} catch (ClienteServiceException e) {
//			
//			e.printStackTrace();
//		} catch (PagoServiceException e) {
//			
//			e.printStackTrace();
//		}
		try {
			ps.mapaTodosPagos().get("MARILYN.ROSS@sakilacustomer.org").forEach(System.out::println);
		} catch (ClienteServiceException e) {

			e.printStackTrace();
		} catch (PagoServiceException e) {

			e.printStackTrace();
		}
	}
}

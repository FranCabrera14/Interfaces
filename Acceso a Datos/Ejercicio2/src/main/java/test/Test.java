package test;

import services.ClienteService;

public class Test {
	public static void main(String[] args) {
		ClienteService cs = new ClienteService();

		try {
			System.out.println(cs.mapa().get("MARILYN.ROSS@sakilacustomer.org"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package ejercicioBanco;

public class BancoSimulacion {
	public static void main(String[] args) {

		CuentaBancaria cuenta1 = new CuentaBancaria(1500);
		Cliente fran = new Cliente(cuenta1, "Fran");
		Cliente pepe = new Cliente(cuenta1, "Pepe");

		while (cuenta1.getSaldo() > 0) {
			new Thread(fran).start();
			new Thread(pepe).start();
			try {
				Thread.sleep(10L);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

}

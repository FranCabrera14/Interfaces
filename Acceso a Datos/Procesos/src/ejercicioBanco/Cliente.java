package ejercicioBanco;

import java.util.Random;

import lombok.Data;

public @Data class Cliente implements Runnable {
	public CuentaBancaria cuenta;
	public String nombreCliente;

	public void run() {
		Random r = new Random();
		Integer cantidad = r.nextInt(1, 200);
		if (!cuenta.retirarDinero(cantidad, nombreCliente)) {
			System.out.println("No hay suficiente dinero en la cuenta, te queda un total de: " + cuenta.getSaldo());
			return;
		}
		System.out.println("Has sacado " + cantidad + "€" + " de la cuenta de " + nombreCliente);
		System.out.println("Te quedan " + cuenta.getSaldo() + "€ en la cuenta.");
	}

	public Cliente(CuentaBancaria cuenta, String nombre) {
		this.cuenta = cuenta;
		this.nombreCliente = nombre;
	}

}

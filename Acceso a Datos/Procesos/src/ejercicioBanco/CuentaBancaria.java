package ejercicioBanco;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

public @Data class CuentaBancaria {
	private Integer saldo;
	private List <String> registroTransacciones = new ArrayList<String>();
	
	public synchronized Boolean retirarDinero(Integer cantidad, String nombreCliente) {
		
		if (saldo >= cantidad ) {
			saldo = saldo - cantidad;
			registrarTransaccion(nombreCliente);
			return true;
		}
		return false;
	} 
	
	public void registrarTransaccion (String transaccion) {
		registroTransacciones.add(transaccion); 
	}

	public String toString() {
		return "Tu cuenta Bancaria:/n  Tu saldo: "   + saldo;
	}
	
	public void imprimirHistorialTransacciones() {
		for (String trans : registroTransacciones) {
			System.out.println(trans);
		}
	}

	public CuentaBancaria(int saldoInicial) {
		this.saldo = saldoInicial;
	}
	

}

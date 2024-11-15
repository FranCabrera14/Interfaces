package ejercicio3.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.Data;

@Data
public class Pago {
	private BigDecimal importe;
	private LocalDate fecha;
	@Override
	public String toString() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		return "Pago realizado: con el importe[" + importe + "] y la fecha [" + fecha.format(formato) + "]";
	}

}

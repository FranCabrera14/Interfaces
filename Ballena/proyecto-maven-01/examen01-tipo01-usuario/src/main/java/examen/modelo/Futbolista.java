package examen.modelo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;

@Data
public class Futbolista {

	// NO PUEDES AÑADIR MÁS ATRIBUTOS.
	@JsonIgnore
	private Long id;
	@JacksonXmlProperty(isAttribute = true)
	private Integer dorsal;
	private String nombre;
	@JsonIgnore
	private LocalDate fechaNacimiento;
	private String posicion;

	@Override
	public String toString() {
		return id + "-" + nombre + " // Dorsal y posición: " + dorsal + " " + posicion + " (" + fechaNacimiento + ")";
	}

}

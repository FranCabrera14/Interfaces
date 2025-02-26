package examen.modelo;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import lombok.Data;

@Data
public class Equipo {

	// NO PUEDES AÑADIR MÁS ATRIBUTOS.

	private Long id;
	@JsonProperty("denominacion")
	private String nombre;

	private Pais pais;
	private Integer socios;
	@JacksonXmlElementWrapper(localName = "plantilla")
	@JsonProperty("futbolista")
	private List<Futbolista> plantilla;

	@Override
	public String toString() {
		String toString = "Equipo: " + id + " / " + nombre + " (" + socios + " socios)\n\tOrigen: " + pais
				+ "\n\tPlantilla: \n\t\t";
		if (plantilla == null || plantilla.isEmpty()) {
			return toString + "- NO HAY FUTBOLISTAS -";
		}
		return toString + plantilla.stream().map(Futbolista::toString).collect(Collectors.joining("\n\t\t"));
	}
}

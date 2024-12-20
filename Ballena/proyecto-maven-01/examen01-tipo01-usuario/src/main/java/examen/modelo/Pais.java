package examen.modelo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import lombok.Data;

@Data
public class Pais {

	// NO PUEDES AÑADIR MÁS ATRIBUTOS.
	@JacksonXmlProperty(isAttribute = true)
	private String codigo;
	@JacksonXmlText
	private String descripcion;

	@Override
	public String toString() {
		return codigo + " - " + descripcion;
	}

}

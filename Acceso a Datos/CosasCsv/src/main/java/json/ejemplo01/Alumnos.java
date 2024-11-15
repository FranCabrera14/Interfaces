 package json.ejemplo01;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;
@Data
@JacksonXmlRootElement(localName = "alumnos")
public class Alumnos {
	@JacksonXmlElementWrapper(useWrapping = false)
	@JsonProperty("alumno")
	private List<Alumno> alumnos;
	

}

package json.ejemplo01;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class AlumnoXmlService {
	public void escribirXmlAlumnos(List<Alumno> lista, String pathFile) {
		try {
			File file = new File(pathFile);
			
			JsonMapper mapper = new JsonMapper();
			
			Alumnos alumnos = new Alumnos();
			alumnos.setAlumnos(lista);
			mapper.writeValue(file, alumnos);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Alumno> leerXmlAlumnos( String pathFile) {
		try {
			File file = new File(pathFile);
			
			XmlMapper mapper = new XmlMapper();
			
			Alumnos alumnos = mapper.readValue(file, Alumnos.class);
			
			
		
			 return alumnos.getAlumnos();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

}

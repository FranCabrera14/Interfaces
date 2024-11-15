package saasEjemplos;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class CristianSaxService {
	
	public List<Cristian> leerXMLCristian(String pathFile) throws RuntimeException{
		try  {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		
		CristianSaxHandler handler = new CristianSaxHandler();
		File file = new File(pathFile);
		
		parser.parse(file, handler);
		return handler.getCristians();
		
		} catch(Exception e) {
			throw new RuntimeException("Error al leer el fichero XML ", e);
		}
	}

}

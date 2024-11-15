package clase.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class CristianXMLService {
	
	public void escribirCristians(List<Cristians> lista, String pathFile) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document xml = builder.newDocument();
			
			Element cristiansTag = xml.createElement("cristians");
			xml.appendChild(cristiansTag);
			
		
			for (Cristians cristians : lista) {
				Element cristianTag = xml.createElement("cristian");
				cristiansTag.appendChild(cristianTag);
				cristianTag.setAttribute("id", cristians.getId().toString());
				Element nombreTag = xml.createElement("nombre");
				nombreTag.setTextContent(cristians.getNombre());
				cristianTag.appendChild(nombreTag);
				Element tamañoTag = xml.createElement("tamaño");
				tamañoTag.setTextContent(cristians.getTamaño());
				cristianTag.appendChild(tamañoTag);
				Element texturaTag = xml.createElement("textura");
				texturaTag.setTextContent(cristians.getTextura());
				cristianTag.appendChild(texturaTag);
				Element ingredienteTag = xml.createElement("ingredientes");
				ingredienteTag.setTextContent(cristians.getIngredientes());
				cristianTag.appendChild(ingredienteTag);
			}
			
			TransformerFactory transformerFact = TransformerFactory.newInstance();
			Transformer transformer = transformerFact.newTransformer();
			DOMSource source = new DOMSource(xml);
			File fichero = new File(pathFile);
			StreamResult result = new StreamResult(fichero);
			
			transformer.transform(source, result);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public List<Cristians> leerXmlCristians (String pathFile) {
		List<Cristians> cristians = new ArrayList<Cristians>();
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			File fichero = new File(pathFile);
			Document xml = builder.parse(fichero);
			
			Element cristiansTag = xml.getDocumentElement();
			
			NodeList cristianList = cristiansTag.getElementsByTagName("cristian");
			
			for (int i = 0; i < cristianList.getLength(); i++) {
				Element cristianTag = (Element) cristianList.item(i);
				Cristians cristian = new Cristians();
				
				Integer id = Integer.parseInt(cristianTag.getAttribute("id"));
				cristian.setId(id);
				cristians.add(cristian);
				
				Element nombreTag = (Element) cristianTag.getElementsByTagName("nombre").item(0);
				cristian.setNombre(nombreTag.getTextContent());
				
				Element tamañoTag = (Element) cristianTag.getElementsByTagName("tamaño").item(0);
				cristian.setNombre(tamañoTag.getTextContent());
				
				Element texturaTag = (Element) cristianTag.getElementsByTagName("textura").item(0);
				cristian.setNombre(texturaTag.getTextContent());
				
				Element ingredienteTag = (Element) cristianTag.getElementsByTagName("ingredientes").item(0);
				cristian.setNombre(ingredienteTag.getTextContent());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cristians;
	}

}

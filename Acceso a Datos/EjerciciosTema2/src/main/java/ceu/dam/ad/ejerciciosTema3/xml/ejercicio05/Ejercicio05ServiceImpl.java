package ceu.dam.ad.ejerciciosTema3.xml.ejercicio05;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.Ejercicio04Service;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.modelo.Edicion;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.modelo.Libro;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLExportException;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLImportException;



public class Ejercicio05ServiceImpl implements Ejercicio05Service {
	public static final Logger log = LoggerFactory.getLogger(Ejercicio04Service.class);
	public List<Libro> importXML(String pathFile) throws XMLImportException {
		List<Libro> libros = new ArrayList<>();
		log.debug("Leyendo el fichero XML en " + pathFile);
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document xml = builder.parse(new File(pathFile));
			Element librosTag = xml.getDocumentElement();
			NodeList librosNodeList = librosTag.getElementsByTagName("libro");
			for (int i = 0; i < librosNodeList.getLength(); i++) {
				Element libroTag = (Element) librosNodeList.item(i);
				Libro libro = new Libro();
				libros.add(libro);
				libro.setIsbn(Integer.parseInt(libroTag.getAttribute("isbn")));
				
				Element tituloTag = (Element) libroTag.getElementsByTagName("titulo").item(0);
				libro.setTitulo(tituloTag.getTextContent());
				
				Element autoresTag = (Element) libroTag.getElementsByTagName("autores").item(0);
				List<String> autores = new ArrayList<>();
				NodeList autoresNodeList = autoresTag.getElementsByTagName("autor");
				libro.setAutores(autores);
				for (int j = 0; j < autoresNodeList.getLength(); j++) {
					Element autorTag = (Element) autoresNodeList.item(j);
					autores.add(autorTag.getTextContent());
				};
				Element edicionesTag = (Element) libroTag.getElementsByTagName("ediciones").item(0);
				List<Edicion> ediciones = new ArrayList<>();
				NodeList edicionesNodeList = edicionesTag.getElementsByTagName("edicion");
				libro.setEdiciones(ediciones);
				for (int j = 0; j < edicionesNodeList.getLength(); j++) {
					Element edicionTag = (Element) edicionesNodeList.item(j);
					Edicion edicion = new Edicion();
					ediciones.add(edicion);
					
					
					Element añoTag = (Element) edicionTag.getElementsByTagName("año").item(0);
					edicion.setAño(Integer.parseInt(añoTag.getTextContent()));
					Element editorialTag = (Element) edicionTag.getElementsByTagName("editorial").item(0);
					
					edicion.setEditorial(editorialTag.getTextContent());
				
				}
				
				
			}
		} catch (Exception e) {
			throw new XMLImportException("Error immportando XML");
		}
		return libros;
	}

}

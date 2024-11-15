package ceu.dam.ad.ejerciciosTema3.xml.ejercicio04;


import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.modelo.Edicion;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.modelo.Libro;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLExportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ejercicio04ServiceImp implements Ejercicio04Service {
	public static final Logger log = LoggerFactory.getLogger(Ejercicio04Service.class);

	@Override
	public void exportXML(List<Libro> libros, String pathFile) throws XMLExportException {
		
		try {
			log.info("Exportando Xml al archivo  " + pathFile );
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document xml = builder.newDocument();
			
			Element librosTag = xml.createElement("libros");
			xml.appendChild(librosTag);
			
			for (Libro libro : libros) {
				log.debug("Incluyendo nuevo libro en el XML " + libro);
				Element libroTag = xml.createElement("libro");
				librosTag.appendChild(libroTag);
				libroTag.setAttribute("isbn", libro.getIsbn().toString());
				
				Element tituloTag = xml.createElement("titulo");
				libroTag.appendChild(tituloTag);
				tituloTag.setTextContent(libro.getTitulo());
				
				Element autoresTag = xml.createElement("autores");
				libroTag.appendChild(autoresTag);
				for (String autor : libro.getAutores()) {
					Element autorTag = xml.createElement("autor");
					autoresTag.appendChild(autorTag);
					autorTag.setTextContent(autor);
				}
				
				
				Element edicionesTag = xml.createElement("ediciones");
				libroTag.appendChild(edicionesTag);
				for (Edicion edicion : libro.getEdiciones()) {
					Element edicionTag = xml.createElement("edicion");
					edicionesTag.appendChild(edicionTag);
					
					Element añoTag = xml.createElement("año");
					edicionTag.appendChild(añoTag);
					añoTag.setTextContent(edicion.getAño().toString());
					
					Element editorialTag = xml.createElement("editorial");
					edicionTag.appendChild(añoTag);
					añoTag.setTextContent(edicion.getEditorial());
				}
				
	
				
			}
			TransformerFactory transformerFact = TransformerFactory.newInstance();
			Transformer transformer = transformerFact.newTransformer();
			DOMSource source = new DOMSource(xml);
			File fichero = new File(pathFile);
			StreamResult result = new StreamResult(fichero);
			
			transformer.transform(source, result);
			log.debug("Fichero XML generado correctamente");
		} catch (Exception e) {
			log.error("Error exportando XML..." , e);
			throw new XMLExportException("Error exportando XML..." , e);
		}
	}

}

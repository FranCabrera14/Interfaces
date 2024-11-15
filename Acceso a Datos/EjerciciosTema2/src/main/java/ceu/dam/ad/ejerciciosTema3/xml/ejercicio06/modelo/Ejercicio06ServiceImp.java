package ceu.dam.ad.ejerciciosTema3.xml.ejercicio06.modelo;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.Ejercicio04Service;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio06.Ejercicio06Service;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLExportException;

public class Ejercicio06ServiceImp implements Ejercicio06Service {
	public static final Logger log = LoggerFactory.getLogger(Ejercicio04Service.class);

	@Override
	public void exportarXML(List<Largometraje> peliculas, String fichero) throws XMLExportException {

		try {
			log.info("Exportando Xml al archivo  " + fichero);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document xml = builder.newDocument();
			Element peliculasTag = xml.createElement("peliculas");
			xml.appendChild(peliculasTag);

			for (Largometraje largometraje : peliculas) {
				log.debug("Incluyendo nuevo libro en el XML " + largometraje);
				Element peliculaTag = xml.createElement("pelicula");
				peliculasTag.appendChild(peliculaTag);

				Element tituloTag = xml.createElement("titulo");
				peliculaTag.appendChild(tituloTag);
				tituloTag.setAttribute("titulo", largometraje.getTitulo());

				Element duracionTag = xml.createElement("duracion");
				peliculaTag.appendChild(duracionTag);
				duracionTag.setAttribute("duracion", largometraje.getDuracion().toString());

				Element añoTag = xml.createElement("año");
				peliculaTag.appendChild(añoTag);
				añoTag.setAttribute("año", largometraje.getAño().toString());

				Element artistasTag = xml.createElement("artistas");
				peliculaTag.appendChild(artistasTag);

				exportarArtista(xml, largometraje.getDireccion(), Persona.DIRECCION, artistasTag);

				exportarArtista(xml, largometraje.getProduccion(), Persona.PRODUCCION, artistasTag);

				for (Persona artista : largometraje.getActores()) {
					exportarArtista(xml, artista, Persona.INTERPRETACION, artistasTag);
				}

			}
			TransformerFactory transformerFact = TransformerFactory.newInstance();
			Transformer transformer = transformerFact.newTransformer();
			DOMSource source = new DOMSource(xml);
			File ficherito = new File(fichero);
			StreamResult result = new StreamResult(fichero);
			
			transformer.transform(source, result);
			log.debug("Fichero XML generado correctamente");

		} catch (Exception e) {
			log.error("Error exportando XML...", e);
			throw new XMLExportException("Error exportando XML...", e);
		}

	}

	private void exportarArtista(Document xml, Persona p, String tipo, Element artistasTag) {
		Element artistaTag = xml.createElement("artista");
		artistasTag.appendChild(artistaTag);
		artistaTag.setAttribute("tipo", tipo);

		Element nombreTag = xml.createElement("nombre");
		artistaTag.appendChild(nombreTag);
		nombreTag.setAttribute("nombre", p.getNombre());

		Element nacionalidadTag = xml.createElement("nacionalidad");
		artistaTag.appendChild(nacionalidadTag);
		nacionalidadTag.setAttribute("nacionalidad", p.getNacionalidad());

	}

}

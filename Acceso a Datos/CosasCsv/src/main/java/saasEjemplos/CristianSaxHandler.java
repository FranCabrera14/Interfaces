package saasEjemplos;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import lombok.Data;
@Data
public class CristianSaxHandler extends DefaultHandler{
	
	//lo tipico es el start documnet element , end element y cada vez que 
	//haya texto con el metodo characters
	
	
	//debo saber cuando tengo el tag abierto o cerrado
	private Boolean openTag;
	
	private String texto;
	
	//lista donde guardo los cristian que me creo
	private List<Cristian> cristians;
	
	private Cristian cristian;
	
	private Ingrediente ingrediente;
	@Override
	public void startDocument() throws SAXException {
		cristians = new ArrayList<>();
	}
	
	
	//esto salta cuando empieza un tag
	//cuando abre ponemos el texto a texto vacio pa que no contatene
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		openTag = true;
		texto = "";
		//pregunto cual es el tag abierto
		if (qName.equals("croqueta")) {
			cristian = new Cristian();
			Integer id = Integer.parseInt(attributes.getValue("id"));
			cristian.setId(id);
			cristians.add(cristian);
		}
		else if (qName.equals("ingredientes")) {
			cristian.setIngredientes(new ArrayList<>());
		}
		else if (qName.equals("ingrediente")) {
			ingrediente = new Ingrediente();
			cristian.getIngredientes().add(ingrediente);
		}
	}
	//esto salta cuando se cierra un tag
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		openTag = false;
		if (qName.equals("nombre")) {
			cristians.getLast().setNombre(texto);
		}
		else if (qName.equals("tamaño")) {
			cristians.getLast().setTamaño(texto);
		}
		else if (qName.equals("textura")) {
			cristians.getLast().setTextura(texto);
		}
		else if (qName.equals("tipo")) {
			ingrediente.setTipo(texto);
		}else if (qName.equals("cantidad")) {
			ingrediente.setCantidad(Integer.parseInt(texto));
		}
	
		
	}
	//si el texto esta en un tag que lea lo escrito sino no.
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (openTag) {
			texto += new String(ch,start,length);
		}
		
	}
}

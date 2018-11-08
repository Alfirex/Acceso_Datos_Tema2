
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parser {
	
	private Document dom = null;
	private ArrayList<Libro> libro = null;

	public Parser() {
		libro = new ArrayList<Libro>();
	}

	public void parseFicheroXml(String fichero) {
		// creamos una factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
			// creamos un documentbuilder
			DocumentBuilder db = dbf.newDocumentBuilder();

			// parseamos el XML y obtenemos una representación DOM
			dom = db.parse(fichero);
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (SAXException se) {
			se.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

	public void parseDocument() {
		// obtenemos el elemento raíz
		Element docEle = dom.getDocumentElement();

		// obtenemos el nodelist de elementos
		NodeList nl = docEle.getElementsByTagName("libro");
			
		if (nl != null && nl.getLength() > 0) {
			for (int i = 0; i < nl.getLength(); i++) {
				
				// obtenemos un elemento de la lista (Libro)
				Element el = (Element) nl.item(i);
				

				// obtenemos un objeto libro
				Libro p = getLibro(el);

				// lo añadimos al array
				libro.add(p);
			}
		}
	}
	
	
	
	private Libro getLibro(Element libroEle){
		
		//para cada elemento Libro, obtenemos su nombre , su editor, su titulo, sus paginas y su atributo de titulo
		String nombre = getTextValue(libroEle,"nombre");
		String editor = getTextValue(libroEle,"editor");
		String titulo = getTextValue(libroEle,"titulo");
		int paginas = getIntValue(libroEle,"paginas");
		String anyo = getAtributeValue(libroEle,"titulo");		
		
		//Creamos un nuevo Libro con los elementos leídos del nodo
		Libro e = new Libro(nombre,editor,titulo,paginas,anyo);

		return e;		
		
	}
	
	// Obtendremos el valor dentro de la respectiva etiqueta
	private String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}		
		return textVal;
	}
	// Obtendremos el atributo del valor dentro de la respectiva etiqueta
	private String getAtributeValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			textVal = el.getAttribute("anyo");
		}		
		return textVal;
	}
	// Obtendremos el valor dentro de la respectiva etiqueta en formato Integer
	private int getIntValue(Element ele, String tagName) {				
		return Integer.parseInt(getTextValue(ele,tagName));
	}
	
	public void print(){

		Iterator it = libro.iterator();
		while(it.hasNext()) {
			Libro p=(Libro) it.next();
			p.print();
		}
	}

}

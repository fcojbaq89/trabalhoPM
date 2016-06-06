package org.jespxml.pruebas;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.jespxml.JespXML;
import org.jespxml.excepciones.AtributoNotFoundException;
import org.jespxml.excepciones.TagHijoNotFoundException;
import org.jespxml.modelo.Tag;
import org.xml.sax.SAXException;

public class Lectura {

	public static void main(String[] args) {
		try {
			//Cargo el archivo
			JespXML archivo = new JespXML("prueba.xml");
			//leo el archivo y me retorna el tag raiz, que en este caso
			// es biblioteca
			Tag biblioteca = archivo.leerXML();
			//Obtengo los tags que necesito, por el nombre
			Tag libro = biblioteca.getTagHijoByName("libro");
			Tag titulo = libro.getTagHijoByName("titulo");
			Tag autor = libro.getTagHijoByName("autor");

			//puedo obtener los valores de los atributos de un tag específico
			String paginas = libro.getValorDeAtributo("paginas");

			//imprimo la información requerida
			System.out.println("Páginas: "+paginas);
			System.out.println("Título: "+titulo.getContenido());
			System.out.println("Autor: "+autor.getContenido());
		} catch (AtributoNotFoundException ex) {
			//exception lanzada cuando no se encuentra el atributo
			Logger.getLogger(Lectura.class.getName()).log(Level.SEVERE, null, ex);
		} catch (TagHijoNotFoundException ex) {
			//exception lanzada cuando no se encuentra el tag hijo
			Logger.getLogger(Lectura.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ParserConfigurationException ex) {
			Logger.getLogger(Lectura.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SAXException ex) {
			Logger.getLogger(Lectura.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(Lectura.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
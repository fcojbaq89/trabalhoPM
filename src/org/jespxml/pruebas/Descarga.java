package org.jespxml.pruebas;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.jespxml.JespXML;
import org.jespxml.excepciones.AtributoNotFoundException;
import org.jespxml.excepciones.TagHijoNotFoundException;
import org.jespxml.modelo.Tag;
import org.xml.sax.SAXException;

import br.unirio.bsi.pm.capes.model.Programa;

public class Descarga {

	public static void main(String[] args) {
		try {
			URL myURL = new URL("https://s3.amazonaws.com/posgraduacao/");
			URL page1URL = new URL(myURL, "programas.xml");
			//Cargo el archivo
			JespXML archivo = new JespXML(page1URL);
			//leo el archivo y me retorna el tag raiz, que en este caso
			// es biblioteca
			Tag programas = archivo.leerXML();
			//Obtengo los tags que necesito, por el nombre
			Tag programa = programas.getTagHijoByName("programa");

			//puedo obtener los valores de los atributos de un tag específico
			String nome = programa.getValorDeAtributo("nome");
			
			Programa pro = new Programa(nome);

			//imprimo la información requerida
			System.out.println("Programas: " + programas.getContenido());
			System.out.println("Programa: " + programa);
			System.out.println("ProgramaCon: " + programa.getValorDeAtributo("nome"));
			System.out.println(pro);

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

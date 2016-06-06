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

import br.unirio.bsi.pm.capes.model.Professor;

public class Segundo {

	public static void main(String[] args) {
		
		try {
			URL myURL = new URL("https://s3.amazonaws.com/posgraduacao/");
			URL page1URL = new URL(myURL, "programas.xml");
			
			//https://s3.amazonaws.com/posgraduacao/[nomedo-programa]/contents.xml.		
			JespXML archivo = new JespXML(page1URL);
			Tag programas = archivo.leerXML();
			Tag programa = programas.getTagHijoByName("programa");
			String nome = programa.getValorDeAtributo("nome");
			
			URL page2URL = new URL(myURL, nome + "/contents.xml");
			
			System.out.println("URL: " + page2URL);
			
			JespXML dos = new JespXML(page2URL);
			Tag dosTag = dos.leerXML();
			Tag linha = dosTag.getTagHijoByName("linha");
			//String nomelinha = linha.getValorDeAtributo("nome");
			
			Tag professor = linha.getTagHijoByName("professor");
			
			String codigo = professor.getValorDeAtributo("codigo");
			String nomeP = professor.getValorDeAtributo("nome");
			Professor pro = new Professor(codigo, nomeP);
			
			//https://s3.amazonaws.com/posgraduacao/[nome-do-programa]/[codigo-do-professor].zip.
			
			
			System.out.println("Profesor: " + pro);
			URL page3URL = new URL(myURL, nome + "/" + codigo + ".zip");
			System.out.println("URL2: " + page3URL);
			//System.out.println("Atributo: " + nome2);
			
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

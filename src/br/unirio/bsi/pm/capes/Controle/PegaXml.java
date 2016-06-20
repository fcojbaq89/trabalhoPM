package br.unirio.bsi.pm.capes.Controle;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author Victor
 */
public class PegaXml {

	public static Element getXmlRoot(String arquivo) throws ParserConfigurationException, SAXException, IOException
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = dbf.newDocumentBuilder();
		Document doc = docBuilder.parse(new File(arquivo));
		Element root = doc.getDocumentElement();
		return root;
	}

	@SuppressWarnings("unused")
	public static List<Element> getElementosXml(String arquivo, String tag) throws ParserConfigurationException, SAXException, IOException
	{
		List<Element> lista;
		lista = new ArrayList<Element>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = dbf.newDocumentBuilder();
		Document doc = docBuilder.parse(new File(arquivo));
		Element root = doc.getDocumentElement();
		NodeList listaNodes = doc.getElementsByTagName(tag);

		for(int i=0; i < listaNodes.getLength(); i++)
		{
			lista.add((Element) listaNodes.item(i));
		}

		return lista;
	}

}

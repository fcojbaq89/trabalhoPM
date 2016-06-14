package br.unirio.bsi.pm.capes.Controle;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Victor
 */
public class PegaXml {
    
    public static Element getXmlElement(String arquivo)
    {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = dbf.newDocumentBuilder();
        Document doc = docBuilder.parse(new File("arquivo.xml")); //ToDO passar nome do arquivo
        Element root = doc.getDocumentElement();
        return root;
    
    }
    
}

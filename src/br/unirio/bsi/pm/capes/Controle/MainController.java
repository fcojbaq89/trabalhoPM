package br.unirio.bsi.pm.capes.Controle;

import br.unirio.bsi.pm.capes.model.Programa;
import br.unirio.bsi.pm.gpxcleaner.xml.XmlUtils;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
/**
 *
 * @author Victor
 */
public class MainController {
    
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException
    {
        System.out.println("O programa irá iniciar o download dos arquivos necessários. Aguarde um instante.");
        
        //BAIXANDO PRIMEIRO ARQUIVO
        Downloader.downloadArquivo(Downloader.PRIMEIRA_URL);
        
        //BAIXANDO SEGUNDO ARQUIVO
        Element programas = PegaXml.getXmlRoot(System.getProperty("user.dir") + "/xml/programas.xml"); //toDo: caminho do arquivo baixado
        Element programa = XmlUtils.getSingleElement(programas, "programa");
        
        String nomePrograma = XmlUtils.getStringAttribute(programa, "nome");
        Downloader.downloadArquivo(Downloader.retornaSegundaUrl(nomePrograma));
        
        //BAIXANDO TERCEIROs ARQUIVOs
        List<Element> professores = PegaXml.getElementosXml("xml/contents.xml", "professor");
        
        for (Element professor : professores) {
            String codigoProfessor = XmlUtils.getStringAttribute(professor, "codigo");
            Downloader.downloadArquivo(Downloader.retornaTerceiraUrl(nomePrograma, codigoProfessor));
        }
        
        
        //ToDo salvar as informações no arquivo .txt
        
    }
}

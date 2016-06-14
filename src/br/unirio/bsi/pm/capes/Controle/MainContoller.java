package br.unirio.bsi.pm.capes.Controle;

import br.unirio.bsi.pm.capes.Controle.Downloader;
import br.unirio.bsi.pm.capes.model.Programa;
import br.unirio.bsi.pm.gpxcleaner.xml.XmlUtils;
import org.w3c.dom.Element;
/**
 *
 * @author Victor
 */
public class MainContoller {
    
    public static void main(String[] args)
    {
        System.out.println("TODO"); //todo inserir alguma mensagem de feedback
        Downloader.downloadArquivo(Downloader.PRIMEIRAURL);
        Downloader.downloadArquivo(Downloader.retornaSegundaUrl());
        Downloader.downloadArquivo(Downloader.retornaTerceiraUrl());
        
        Element programa = PegaXml.getXmlElement("todo");
        Programa p = new Programa();
        p.setNome(XmlUtils.getStringAttribute(programa, "nome")); //setando nome do programa no objeto
        
        //todo salvar as informações no arquivo .txt
        
    }
}

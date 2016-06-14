package br.unirio.bsi.pm.capes.Controle;

import br.unirio.bsi.pm.capes.Controle.Downloader;
import br.unirio.bsi.pm.capes.model.Linha;
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
        
        //BAIXANDO PRIMEIRO ARQUIVO
        Downloader.downloadArquivo(Downloader.PRIMEIRAURL);
        
        //BAIXANDO SEGUNDO ARQUIVO
        Element programas = PegaXml.getXmlRoot("toDo"); //toDo: caminho do arquivo baixado
        Programa p = new Programa();
        p.setNome(XmlUtils.getStringAttribute(programas, "nome")); //setando nome do programa no objeto
        
        Downloader.downloadArquivo(Downloader.retornaSegundaUrl(p.getNome()));
        
        //BAIXANDO TERCEIRO ARQUIVO
        Element contents = PegaXml.getXmlRoot("toDo");
        
        for()
        
        Downloader.downloadArquivo(Downloader.retornaTerceiraUrl(p.getNome(), ));
        
        //todo salvar as informações no arquivo .txt
        
    }
}

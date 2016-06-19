package br.unirio.bsi.pm.capes.Controle;

import br.unirio.bsi.pm.capes.model.Linha;
import br.unirio.bsi.pm.capes.model.Professor;
import br.unirio.bsi.pm.capes.model.Programa;
import br.unirio.bsi.pm.gpxcleaner.xml.XmlUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
/**
 *
 * @author Victor
 */
public class MainController {
    
    static final String CAMINHO_DO_USUARIO = System.getProperty("user.dir"); //definindo o caminho root do projeto
    
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException
    {   
        System.out.println("O programa irá iniciar o download dos arquivos necessários. Aguarde um instante.");
        
        //BAIXANDO PRIMEIRO ARQUIVO
        Downloader.downloadArquivo(Downloader.PRIMEIRA_URL);
         
        Programa p = new Programa();
        p.setNome(p.leXml());
        
        //BAIXANDO SEGUNDO ARQUIVO
        Downloader.preparaDownloadDois(p.getNome());
        
        //BAIXANDO TERCEIROs ARQUIVOs
        Downloader.preparaDownloadTres(p.getNome());
        
        //setando valores nos objetos (WORK IN PROGRESS)
        
        List<Element> linhasXml = PegaXml.getElementosXml("xml/contents.xml", "linha");
        
        List<Linha> listaDeLinhas = new ArrayList();
        for(Element linha : linhasXml)
        {
            Linha ln = new Linha();
            ln.setNome(XmlUtils.getStringAttribute(linha, "nome"));
            listaDeLinhas.add(ln);
            
            List<Element> professoresXml = XmlUtils.getElements(linha, "professor");
            List<Professor> listaDeProfessores = new ArrayList();
            
            for(Element professor : professoresXml)
            {
                Professor prof = new Professor();
                prof.setNome(XmlUtils.getStringAttribute(professor, "nome"));
                prof.setCodigo(XmlUtils.getStringAttribute(professor, "codigo"));
                listaDeProfessores.add(prof);
            }
            
            ln.setProfessores(listaDeProfessores);
        }
        
        p.setLinhas(listaDeLinhas);
        
        
        //ToDo salvar as informações no arquivo .txt
        
        
    }
}

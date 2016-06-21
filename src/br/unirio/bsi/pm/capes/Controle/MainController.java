package br.unirio.bsi.pm.capes.Controle;

import br.unirio.bsi.pm.capes.model.Curriculum;
import br.unirio.bsi.pm.capes.model.Linha;
import br.unirio.bsi.pm.capes.model.Professor;
import br.unirio.bsi.pm.capes.model.Programa;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
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
        p.setNome(p.leXml()); //le o arquivo xml e seta o nome do programa no objeto
        
        //BAIXANDO SEGUNDO ARQUIVO
        Downloader.preparaDownloadDois(p.getNome());
        
        //BAIXANDO TERCEIROs ARQUIVOs
        Downloader.preparaDownloadTres(p.getNome());
        
        //BAIXANDO ARQUIVO QUALIS
        Downloader.downloadArquivo(Downloader.QUALIS_URL);
        
        
        //setando valores nos objetos (WORK IN PROGRESS)
        
        p.setLinhas(Linha.leXml());
        
        //PARTE FINAL ==========================================================
        //escrevendo o arquivo txt
        PrintWriter writer = new PrintWriter(CAMINHO_DO_USUARIO + "/" + p.getNome() + ".txt", "UTF-8");
        
        /*writer.println("Nome " + "Participações em bancas de Doutorado " + //printando nomes das colunas da tabela
        "Participações em bancas de Mestrado " + "Participações em bancas de Graduacao " +
        "Orientações de Doutorado concluídas " + "Orientações de Mestrado concluídas " +
        "Orientações de projeto final de Graduação concluídas " + "Orientações de Doutorado em andamento " +
        "Orientações de Doutorado em andamento " + "Orientações de projeto final de Graduação em andamento "
        );*/
        writer.println("");
        
        List<Linha> listaDeLinhas = p.getLinhas();
        for(Linha linha : listaDeLinhas)
        {
            List<Professor> profsDaLinha = linha.getProfessores();
            for(Professor professor : profsDaLinha)
            {
                Curriculum c = professor.getCurriculo();
                int[] dadosCurriculo = c.pegaDadosCurriculo();
                writer.println(professor.getNome() + " " + Arrays.toString(dadosCurriculo)); //toDo melhorar formatação
                writer.println("");
            }
            linha.calculaMediaDaLinha();
            writer.println(linha.getNome() + " " + Arrays.toString(linha.getMedia()));
            writer.println("");
            writer.println("");
        }
        p.calculaMedia();
        writer.println(p.getNome() + " " + Arrays.toString(p.getMedia()));
        writer.close();
    }
}

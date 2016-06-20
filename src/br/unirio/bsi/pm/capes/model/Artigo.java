package br.unirio.bsi.pm.capes.model;

import br.unirio.bsi.pm.capes.Controle.PegaXml;
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
class Artigo {

    private String nome;
    private int ano;
    private String classificacao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }
   
    
    public static List<Artigo> classificaArtigos(List<Element> listaDeArtigos, String tipo) throws ParserConfigurationException, SAXException, IOException
    {
        List<Artigo> listaDeArtigosClassificados = new ArrayList<Artigo>();
        List<Element> entradas = PegaXml.getElementosXml("xml/qualis.xml", "entry");
        
        for(Element elementoArtigo : listaDeArtigos)
        {
            Artigo artigo = new Artigo();
            String nomePublicacao;
            
            if("evento".equalsIgnoreCase(tipo)) //verificando se eh artigo ou revista
            {
                nomePublicacao = XmlUtils.getStringAttribute(elementoArtigo, "NOME-DO-EVENTO");
            }
            else{
                nomePublicacao = XmlUtils.getStringAttribute(elementoArtigo, "TITULO-DO-PERIODICO-OU-REVISTA");
            }
            for(Element entrada : entradas)
            {
                String regex = XmlUtils.getStringAttribute(entrada, "regex");
                if(nomePublicacao == null ? regex == null : nomePublicacao.equalsIgnoreCase(regex)) //verifica se o nome do artigo eh igual a regex
                {
                    artigo.setClassificacao(entrada.getAttribute("class")); //seta classificacao no objeto artigo
                }
                else{
                    artigo.setClassificacao("N/C");
                }
                
                listaDeArtigosClassificados.add(artigo);
            }
            
        }
        
        return listaDeArtigosClassificados;
    }
}

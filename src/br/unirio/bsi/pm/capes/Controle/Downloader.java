
package br.unirio.bsi.pm.capes.Controle;

import java.net.URL;

/**
 *
 * @author Victor
 */
public class Downloader {
    
    public static String downloadArquivo(String url)
    {
        return "todo";
    }
    
    static final String PRIMEIRAURL = "https://s3.amazonaws.com/posgraduacao/programas.xml";
    
    public static String retornaSegundaUrl(String nomePrograma)
    {
        //TODO pegar nomePrograma do xml
        String segundaUrl = "https://s3.amazonaws.com/posgraduacao/" + nomePrograma + "/contents.xml";
        return segundaUrl;
    }
    
    public static String retornaTerceiraUrl(String nomePrograma, String codigoProfessor)
    {
        //TODO pegar infos do xml
        String terceiraUrl = "https://s3.amazonaws.com/posgraduacao/" + nomePrograma + "/" + codigoProfessor + ".zip";
        return terceiraUrl;
    }
}


package br.unirio.bsi.pm.capes.Controle;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor
 */
public class Downloader {
    
    /**
     *
     * @param url
     */
    public static void downloadArquivo(String url)
    {
        String nome = url.substring(url.lastIndexOf("/")); //manipulando a string para pegar somente a ultima parte
        try {
            URL website = new URL(url);
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream("xml" + nome);
            fos.getChannel().transferFrom(rbc, 0, Integer.MAX_VALUE);
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(Downloader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Downloader.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Donwload do arquivo " + nome + " efetuado com sucesso");
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

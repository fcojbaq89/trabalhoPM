package br.unirio.bsi.pm.capes.Controle;

import br.unirio.bsi.pm.capes.Controle.Downloader;
/**
 *
 * @author Victor
 */
public class MainContoller {
    
    public static void main(String[] args)
    {
        System.out.println(""); //todo inserir alguma mensagem de feedback
        Downloader.downloadArquivo(Downloader.PRIMEIRAURL);
        Downloader.downloadArquivo(Downloader.retornaSegundaUrl());
        Downloader.downloadArquivo(Downloader.retornaTerceiraUrl());
        
        
        //todo salvar as informações no arquivo .txt
        
    }
}

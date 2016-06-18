package br.unirio.bsi.pm.capes.Controle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 *
 * @author Victor
 */
public class Unzip {
    
    public void unziparArquivo(String arquivoZipado) throws FileNotFoundException, IOException
    {
        byte[] buffer = new byte[1024];
        ZipInputStream zis = new ZipInputStream(new FileInputStream(arquivoZipado));
        ZipEntry ze = zis.getNextEntry();
        
        File novoArquivo = new File(System.getProperty("user.dir") + File.separator + arquivoZipado); //ToDo tirar .zip
        new File(novoArquivo.getParent()).mkdirs(); //criando diretorio caso nao exista
        FileOutputStream fos = new FileOutputStream(novoArquivo);
        
        int len;
            while ((len = zis.read(buffer)) > 0) {
       		fos.write(buffer, 0, len);
            }
        		
            fos.close();
            
        zis.closeEntry();
    	zis.close();
    }
}

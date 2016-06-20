package br.unirio.bsi.pm.capes.Controle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import br.unirio.bsi.pm.gpxcleaner.xml.XmlUtils;

import static br.unirio.bsi.pm.capes.Controle.MainController.CAMINHO_DO_USUARIO;

/**
 *
 * @author Victor
 */
public class Downloader {

	/**
	 *
	 * @param url
	 */
	@SuppressWarnings("resource")
	public static void downloadArquivo(String url)
	{
		String nome = url.substring(url.lastIndexOf("/")+1); //manipulando a string para pegar somente a ultima parte
		File arquivo = new File(CAMINHO_DO_USUARIO + "/xml/" + nome);
                File diretorio = new File(CAMINHO_DO_USUARIO + "/xml");
                diretorio.mkdir();
		try {
			URL website = new URL(url);
			ReadableByteChannel rbc = Channels.newChannel(website.openStream());
			FileOutputStream fos = new FileOutputStream(arquivo);
			fos.getChannel().transferFrom(rbc, 0, Integer.MAX_VALUE);

		} catch (MalformedURLException ex) {
			Logger.getLogger(Downloader.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(Downloader.class.getName()).log(Level.SEVERE, null, ex);
		}
		System.out.println("Donwload do arquivo " + nome + " efetuado com sucesso");
	}

	static final String PRIMEIRA_URL = "https://s3.amazonaws.com/posgraduacao/programas.xml";

	static final String QUALIS_URL = "https://s3.amazonaws.com/posgraduacao/qualis.xml";

	public static void preparaDownloadDois(String nomePrograma) throws ParserConfigurationException, SAXException, IOException
	{
		String segundaUrl = "https://s3.amazonaws.com/posgraduacao/" + nomePrograma + "/contents.xml";
		downloadArquivo(segundaUrl);
	}

	public static void preparaDownloadTres(String nomePrograma) throws ParserConfigurationException, SAXException, IOException
	{
		List<Element> professores = PegaXml.getElementosXml("xml/contents.xml", "professor");

		for (Element professor : professores) {
			String codigoProfessor = XmlUtils.getStringAttribute(professor, "codigo"); //toDo encapsular logica de ler xml
			String terceiraUrl = "https://s3.amazonaws.com/posgraduacao/" + nomePrograma + "/" + codigoProfessor + ".zip";

			Downloader.downloadArquivo(terceiraUrl);
			Unzip.unziparArquivo(codigoProfessor);
		}
	}
}

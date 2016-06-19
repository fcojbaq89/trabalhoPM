package br.unirio.bsi.pm.capes.model;

import br.unirio.bsi.pm.capes.Controle.PegaXml;
import br.unirio.bsi.pm.gpxcleaner.xml.XmlUtils;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class Curriculum {

    List<Artigo> revistas;
    List<Artigo> eventos;
    private int partMestrado, partDoutorado, partProjFinal, doutoradoConcluido, 
        mestradoConcluido, projFinalConcluido, doutoradoAndamento, 
        mestradoAndamento, projFinalAndamento;

    public int getPartMestrado() {
        return partMestrado;
    }

    public void setPartMestrado(int partMestrado) {
        this.partMestrado = partMestrado;
    }

    public int getPartDoutorado() {
        return partDoutorado;
    }

    public void setPartDoutorado(int partDoutorado) {
        this.partDoutorado = partDoutorado;
    }

    public int getPartProjFinal() {
        return partProjFinal;
    }

    public void setPartProjFinal(int partProjFinal) {
        this.partProjFinal = partProjFinal;
    }

    public int getDoutoradoConcluido() {
        return doutoradoConcluido;
    }

    public void setDoutoradoConcluido(int doutoradoConcluido) {
        this.doutoradoConcluido = doutoradoConcluido;
    }

    public int getMestradoConcluido() {
        return mestradoConcluido;
    }

    public void setMestradoConcluido(int mestradoConcluido) {
        this.mestradoConcluido = mestradoConcluido;
    }

    public int getProjFinalConcluido() {
        return projFinalConcluido;
    }

    public void setProjFinalConcluido(int projFinalConcluido) {
        this.projFinalConcluido = projFinalConcluido;
    }

    public int getDoutoradoAndamento() {
        return doutoradoAndamento;
    }

    public void setDoutoradoAndamento(int doutoradoAndamento) {
        this.doutoradoAndamento = doutoradoAndamento;
    }

    public int getMestradoAndamento() {
        return mestradoAndamento;
    }

    public void setMestradoAndamento(int mestradoAndamento) {
        this.mestradoAndamento = mestradoAndamento;
    }

    public int getProjFinalAndamento() {
        return projFinalAndamento;
    }

    public void setProjFinalAndamento(int projFinalAndamento) {
        this.projFinalAndamento = projFinalAndamento;
    }
    
    public void leXmlCurriculo(String codProf) throws ParserConfigurationException, SAXException, IOException
    {
        String path = "xml/" + codProf + ".xml";
        Element root = PegaXml.getXmlRoot(path);
        List<Element> listaPartDoutorado= XmlUtils.getElements(root, "PARTICIPACAO-EM-BANCA-DE-DOUTORADO"); //ToDo caminhar no DOM até achar o nó correto.
        List<Element> listaPartMestrado= XmlUtils.getElements(root, "PARTICIPACAO-EM-BANCA-DE-MESTRADO");
        List<Element> listaPartProjFinal= XmlUtils.getElements(root, "PARTICIPACAO-EM-BANCA-DE-GRADUACAO");
        
        this.setPartDoutorado(listaPartDoutorado.size());
        this.setPartMestrado(listaPartMestrado.size());
        this.setPartProjFinal(listaPartProjFinal.size());
    }
    
}

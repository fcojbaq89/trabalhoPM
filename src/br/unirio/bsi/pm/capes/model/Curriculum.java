package br.unirio.bsi.pm.capes.model;

import br.unirio.bsi.pm.capes.Controle.PegaXml;
import br.unirio.bsi.pm.gpxcleaner.xml.XmlUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class Curriculum {

    List<Artigo> revistas;
    List<Artigo> eventos;
    private int partMestrado, partDoutorado, partGraduacao, doutoradoConcluido, 
        mestradoConcluido, graduacaoConcluido, doutoradoAndamento, 
        mestradoAndamento, graduacaoAndamento;

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

    public int getPartGraduacao() {
        return partGraduacao;
    }

    public void setPartGraduacao(int partGraduacao) {
        this.partGraduacao = partGraduacao;
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

    public int getGraduacaoConcluido() {
        return graduacaoConcluido;
    }

    public void setGraduacaoConcluido(int graduacaolConcluido) {
        this.graduacaoConcluido = graduacaolConcluido;
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

    public int getGraduacaoAndamento() {
        return graduacaoAndamento;
    }

    public void setGraduacaoAndamento(int graduacaoAndamento) {
        this.graduacaoAndamento = graduacaoAndamento;
    }
    
    public void leXmlCurriculo(String codProf) throws ParserConfigurationException, SAXException, IOException
    {
        List<Element> listaPartDoutorado= PegaXml.getElementosXml("xml/" + codProf + ".xml", "PARTICIPACAO-EM-BANCA-DE-DOUTORADO");
        List<Element> listaPartMestrado= PegaXml.getElementosXml("xml/" + codProf + ".xml", "PARTICIPACAO-EM-BANCA-DE-MESTRADO");
        List<Element> listaPartGraduacao= PegaXml.getElementosXml("xml/" + codProf + ".xml", "PARTICIPACAO-EM-BANCA-DE-GRADUACAO");
        List<Element> listaDoutoradoAndamento= PegaXml.getElementosXml("xml/" + codProf + ".xml", "ORIENTACAO-EM-ANDAMENTO-DE-DOUTORADO");
        List<Element> listaMestradoAndamento= PegaXml.getElementosXml("xml/" + codProf + ".xml", "ORIENTACAO-EM-ANDAMENTO-DE-MESTRADO");
        List<Element> listaGraduacaoAndamento= PegaXml.getElementosXml("xml/" + codProf + ".xml", "OUTRAS-ORIENTACOES-EM-ANDAMENTO");
        List<Element> listaDoutoradoConcluido= PegaXml.getElementosXml("xml/" + codProf + ".xml", "ORIENTACOES-CONCLUIDAS-PARA-DOUTORADO");
        List<Element> listaMestradoConcluido= PegaXml.getElementosXml("xml/" + codProf + ".xml", "ORIENTACOES-CONCLUIDAS-PARA-MESTRADO");
        List<Element> listaGraduacaoConcluido= PegaXml.getElementosXml("xml/" + codProf + ".xml", "OUTRAS-ORIENTACOES-CONCLUIDAS");
        
        this.setPartDoutorado(listaPartDoutorado.size());
        this.setPartMestrado(listaPartMestrado.size());
        this.setPartGraduacao(listaPartGraduacao.size());
        this.setDoutoradoAndamento(listaDoutoradoAndamento.size());
        this.setMestradoAndamento(listaMestradoAndamento.size());
        this.setGraduacaoAndamento(listaGraduacaoAndamento.size());
        this.setDoutoradoConcluido(listaDoutoradoConcluido.size());
        this.setMestradoConcluido(listaMestradoConcluido.size());
        this.setGraduacaoConcluido(listaGraduacaoConcluido.size());
    }
    
    public int[] pegaDadosCurriculo()
    {
        int[] dadosCurriculo = new int[9];
        
        dadosCurriculo[0] = this.getPartDoutorado();
        dadosCurriculo[1] = this.getPartMestrado();
        dadosCurriculo[2] = this.getPartGraduacao();
        dadosCurriculo[3] = this.getDoutoradoConcluido();
        dadosCurriculo[4] = this.getMestradoConcluido();
        dadosCurriculo[5] = this.getGraduacaoConcluido();
        dadosCurriculo[6] = this.getDoutoradoAndamento();
        dadosCurriculo[7] = this.getMestradoAndamento();
        dadosCurriculo[8] = this.getGraduacaoAndamento();
        
        return dadosCurriculo;
    }
    
}

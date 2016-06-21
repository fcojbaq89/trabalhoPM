package br.unirio.bsi.pm.capes.model;

import br.unirio.bsi.pm.capes.Controle.PegaXml;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class Curriculum {

    List<Artigo> revistas;
    List<Artigo> eventos;
    private int partMestrado, partDoutorado, partGraduacao, doutoradoConcluido, 
                mestradoConcluido, graduacaoConcluido, doutoradoAndamento, 
                mestradoAndamento, graduacaoAndamento, revistaA1, revistaA2, revistaB1,
                revistaB2, revistaB3, revistaB4, revistaC, revistaNC,
                eventoA1, eventoA2, eventoB1, eventoB2, eventoB3, eventoB4,
                eventoC, eventoNC;

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
        String path = "xml/" + codProf + ".xml";
        List<Element> listaPartDoutorado= PegaXml.getElementosXml(path, "PARTICIPACAO-EM-BANCA-DE-DOUTORADO");
        List<Element> listaPartMestrado= PegaXml.getElementosXml(path, "PARTICIPACAO-EM-BANCA-DE-MESTRADO");
        List<Element> listaPartGraduacao= PegaXml.getElementosXml(path, "PARTICIPACAO-EM-BANCA-DE-GRADUACAO");
        List<Element> listaDoutoradoAndamento= PegaXml.getElementosXml(path, "ORIENTACAO-EM-ANDAMENTO-DE-DOUTORADO");
        List<Element> listaMestradoAndamento= PegaXml.getElementosXml(path, "ORIENTACAO-EM-ANDAMENTO-DE-MESTRADO");
        List<Element> listaGraduacaoAndamento= PegaXml.getElementosXml(path, "OUTRAS-ORIENTACOES-EM-ANDAMENTO");
        List<Element> listaDoutoradoConcluido= PegaXml.getElementosXml(path, "ORIENTACOES-CONCLUIDAS-PARA-DOUTORADO");
        List<Element> listaMestradoConcluido= PegaXml.getElementosXml(path, "ORIENTACOES-CONCLUIDAS-PARA-MESTRADO");
        List<Element> listaGraduacaoConcluido= PegaXml.getElementosXml(path, "OUTRAS-ORIENTACOES-CONCLUIDAS");
        
        List<Element> listaArtigosEmRevistas = PegaXml.getElementosXml(path, "ARTIGO-PUBLICADO");
        List<Element> listaArtigosEmEventos = PegaXml.getElementosXml(path, "TRABALHO-EM-EVENTOS");
        
        //classificando os artigos de acordo com qualis.xml
        List<Artigo> listaArtigosEventosClassificados = Artigo.classificaArtigos(listaArtigosEmEventos, "evento");
        List<Artigo> listaArtigosRevistasClassificados = Artigo.classificaArtigos(listaArtigosEmRevistas, "revista");
        
        //contagem de revistas
        for(Artigo artigo: listaArtigosRevistasClassificados)
        {
            String classificacao = artigo.getClassificacao();
            switch(classificacao) //A1,	A2, B1, B2, B3, B4, C e	N/C
            {
                case "A1": this.revistaA1++;
                    break;
                case "A2": this.revistaA2++;
                    break;
                case "B1": this.revistaB1++;
                    break;
                case "B2": this.revistaB2++;
                    break;
                case "B3": this.revistaB3++;
                    break;
                case "B4": this.revistaB4++;
                    break;
                case "C": this.revistaC++;
                    break;
                case "N/C": this.revistaNC++;
                    break;
            }
        }
        //contagem de eventos
        for(Artigo artigo: listaArtigosEventosClassificados)
        {
            String classificacao = artigo.getClassificacao();
            switch(classificacao) //A1,	A2, B1, B2, B3, B4, C e	N/C
            {
                case "A1": this.eventoA1++;
                    break;
                case "A2": this.eventoA2++;
                    break;
                case "B1": this.eventoB1++;
                    break;
                case "B2": this.eventoB2++;
                    break;
                case "B3": this.eventoB3++;
                    break;
                case "B4": this.eventoB4++;
                    break;
                case "C": this.eventoC++;
                    break;
                case "N/C": this.eventoNC++;
                    break;
            }
        }
        
        //setando valores orientacao
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
        int[] dadosCurriculo = new int[25];
        
        dadosCurriculo[0] = this.revistaA1;
        dadosCurriculo[1] = this.revistaA2;
        dadosCurriculo[2] = this.revistaB1;
        dadosCurriculo[3] = this.revistaB2;
        dadosCurriculo[4] = this.revistaB3;
        dadosCurriculo[5] = this.revistaB4;
        dadosCurriculo[6] = this.revistaC;
        dadosCurriculo[7] = this.revistaNC;
        dadosCurriculo[8] = this.eventoA1;
        dadosCurriculo[9] = this.eventoA2;
        dadosCurriculo[10] = this.eventoB1;
        dadosCurriculo[11] = this.eventoB2;
        dadosCurriculo[12] = this.eventoB3;
        dadosCurriculo[13] = this.eventoB4;
        dadosCurriculo[14] = this.eventoC;
        dadosCurriculo[15] = this.eventoNC;
        dadosCurriculo[16] = this.getPartDoutorado();
        dadosCurriculo[17] = this.getPartMestrado();
        dadosCurriculo[18] = this.getPartGraduacao();
        dadosCurriculo[19] = this.getDoutoradoConcluido();
        dadosCurriculo[20] = this.getMestradoConcluido();
        dadosCurriculo[21] = this.getGraduacaoConcluido();
        dadosCurriculo[22] = this.getDoutoradoAndamento();
        dadosCurriculo[23] = this.getMestradoAndamento();
        dadosCurriculo[24] = this.getGraduacaoAndamento();
        
        return dadosCurriculo;
    }
    
}

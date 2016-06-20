package br.unirio.bsi.pm.capes.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import br.unirio.bsi.pm.capes.Controle.PegaXml;
import br.unirio.bsi.pm.gpxcleaner.xml.XmlUtils;

/**
* @author fcojbaq89
*/
public class Programa {

	String nome;
	List<Linha> linhas;
        private float[] media;

    public float[] getMedia() {
        return media;
    }

    public void setMedia(float[] media) {
        this.media = media;
    }

	public Programa() {
		super();
	}

	public Programa(String nome) {
		super();
		this.nome = nome;
		this.linhas = new ArrayList<Linha>();
	}

	public Programa(String nome, List<Linha> linhas) {
		super();
		this.nome = nome;
		this.linhas = linhas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((linhas == null) ? 0 : linhas.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Programa other = (Programa) obj;
		if (linhas == null) {
			if (other.linhas != null)
				return false;
		} else if (!linhas.equals(other.linhas))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
                
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Linha> getLinhas() {
		return linhas;
	}

	public void setLinhas(List<Linha> linhas) {
		this.linhas = linhas;
	}

	@Override
	public String toString() {
		if (linhas.isEmpty())
			return "Programa [nome=" + nome + "]";
		else
			return "Programa [nome=" + nome + ", linhas=" + linhas + "]";
	}
        
        public String leXml() throws ParserConfigurationException, SAXException, IOException
        {
            Element programas = PegaXml.getXmlRoot(System.getProperty("user.dir") + "/xml/programas.xml");
            Element programa = XmlUtils.getSingleElement(programas, "programa");
            String nomePrograma = XmlUtils.getStringAttribute(programa, "nome");
            
            return nomePrograma;
        }
        
        public void calculaMedia()
        {
            float[] total = {0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,
                0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,
                0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f};
            List<Linha> lns = this.getLinhas();
            float totalProfessores= 0;
            
            for(Linha linha: lns)
            {
                List<Professor> professores = linha.getProfessores();
                for(Professor professor : professores)
                {
                    Curriculum curriculo = professor.getCurriculo();
                    int [] dadosCurriculo = curriculo.pegaDadosCurriculo();
                    for(int i = 0; i < dadosCurriculo.length; i++)
                    {
                        total[i] = total[i] + dadosCurriculo[i];
                    }
                    totalProfessores++;
                }
                
            }
            
            float [] medias = new float[25];
            for(int j =0; j < 25; j++)
            {
                medias[j] = total[j]/totalProfessores;
            }
            
            this.setMedia(medias);
            
        }

}

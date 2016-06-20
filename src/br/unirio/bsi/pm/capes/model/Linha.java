package br.unirio.bsi.pm.capes.model;

import java.util.ArrayList;
import java.util.List;

public class Linha {

	List<Professor> professores;
        private String nome;
        private float[] media;

    public float[] getMedia() {
        return media;
    }

    public void setMedia(float[] media) {
        this.media = media;
    }
        
        /*private int partMestradoTotal, partDoutoradoTotal, partGraduacaoTotal, doutoradoConcluidoTotal, 
        mestradoConcluidoTotal, graduacaoConcluidoTotal, doutoradoAndamentoTotal, 
        mestradoAndamentoTotal, graduacaoAndamentoTotal;*/

	public Linha() {
		super();
		this.professores = new ArrayList<Professor>();
	}

	public Linha(List<Professor> professores) {
		super();
		this.professores = professores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((professores == null) ? 0 : professores.hashCode());
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
		Linha other = (Linha) obj;
		if (professores == null) {
			if (other.professores != null)
				return false;
		} else if (!professores.equals(other.professores))
			return false;
		return true;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	@Override
	public String toString() {
		return "Linha [professores=" + professores + "]";
	}
        
        public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
        
        public void calculaMediaDaLinha()
        {
            float[] total = {0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,
                0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f};
            List<Professor> profs = this.getProfessores();
            float totalProfessores = profs.size();
            
            for(Professor professor : profs)
            {
                Curriculum curriculo = professor.getCurriculo();
                int[] dadosCurriculo = curriculo.pegaDadosCurriculo();
                for (int i = 0; i < dadosCurriculo.length; i++) 
                {
                    total[i] = total[i] + dadosCurriculo[i];
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

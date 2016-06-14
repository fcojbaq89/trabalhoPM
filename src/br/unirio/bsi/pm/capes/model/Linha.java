package br.unirio.bsi.pm.capes.model;

import java.util.ArrayList;
import java.util.List;

public class Linha {

	List<Professor> professores;
        private String nome;

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

}

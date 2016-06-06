package br.unirio.bsi.pm.capes.model;

import java.util.ArrayList;
import java.util.List;

public class Programa {

	String nome;
	List<Linha> linhas;

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

}

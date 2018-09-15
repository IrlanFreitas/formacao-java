package br.com.alura;

public class Aluno implements Comparable<Aluno>{
	
	private String nome;
	private int numeroMatricula;
	
	public Aluno(String nome, int numeroMatricula) {
		//Utilização de Programação Defensiva
		if (nome == null) {
			throw new NullPointerException("Nome não pode ser nulo");
		}
		this.nome = nome;
		this.numeroMatricula = numeroMatricula;
	}

	public String getNome() {
		return nome;
	}

	public int getNumeroMatricula() {
		return numeroMatricula;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", numeroMatricula=" + numeroMatricula + "]";
	}

	
	
	//Equals e Hashcode
	//Utilizados na comparação e geração de Id,
	//Utilizados na coleção Set para alto nivel
	//de performance em busca e remoção

	
	@Override
	public int hashCode() {

		//Uma ideia do instrutor para geração de 
		//Id´s Unicos por ondem de primeira letra
		//return this.nome.charAt(0);
		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + numeroMatricula;
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
		Aluno other = (Aluno) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroMatricula != other.numeroMatricula)
			return false;
		return true;
	}

	@Override
	public int compareTo(Aluno outro) {
		if (this.numeroMatricula < outro.getNumeroMatricula()) {
			return -1;
		}
		if (this.numeroMatricula > outro.getNumeroMatricula()) {
			return 1;
		}
		return 0;
	}
	
}

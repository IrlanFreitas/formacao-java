package br.com.alura;

import java.util.Iterator;

public class TestaCursoComAluno {

	public static void main(String[] args) {
		
		Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");

		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma aula", 20));
		javaColecoes.adiciona(new Aula("Relacionamento entre coleções", 23));
		
		
		Aluno a1 = new Aluno("Rodrigo Turini", 34672);
		Aluno a2 = new Aluno("Guilherme Silveira", 5617);
		Aluno a3 = new Aluno("Mauricio Aniche", 17645);
		
		javaColecoes.matricula(a1);
		javaColecoes.matricula(a2);
		javaColecoes.matricula(a3);
		
		//O retorno é visivel que o ordem não é
		//definida e imprevisivel, caso seja 
		//necessário, o melhor é utilizar o List
		System.out.println("Todos os alunos matriculados: ");
		for (Aluno aluno : javaColecoes.getAlunos()) {
			System.out.println(aluno);
		}
		
		//Métodos antigos de Iterar a lista
		Iterator<Aluno> iterator = javaColecoes.getAlunos().iterator();
		while (iterator.hasNext()) {
			Aluno type = (Aluno) iterator.next();
			System.out.println(type.getNome());
			System.out.println(type.getNumeroMatricula());
			
		}
		
		
		//Retorna True
		System.out.println("O aluno "+ a1 +" está matriculado?");
		System.out.println(javaColecoes.estaMatriculado(a1));
		
		//Exemplificando o problema de usar coleções
		Aluno turini = new Aluno("Rodrigo Turini", 34672);
		//String nome = "Rodrigo Turini";
		
		//Retorna False, por conta das referencias
		//Então será necessário sobrescrever o método
		//Equals para que atributo a atributo seja comparado
		//Hashcode para a procura de objetos 
		//por meio da tabela de espalhamento
		//Sem Equals e Hashcode não sobrescritos não irá funcionar
		System.out.println("E esse Turini, está matriculado ?");
		System.out.println(javaColecoes.estaMatriculado(turini));
		
		//Depois de sobrescrever o método equals do Aluno funciona
		System.out.println("O a1 é equals ao Turini?");
		System.out.println(a1.equals(turini));
		
		//Testando os Hashcodes
		System.out.println("Testando a ideia do Hashcode:");
		System.out.println(a1.hashCode() == turini.hashCode());
		
	}

}

package br.com.alura;

import java.util.Map;
import java.util.Set;

public class TestaBuscaAlunosNoCurso {
	
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
		
		System.out.println(javaColecoes.getAlunos());
		System.out.println("Quem é o aluno com matricula 5617 ?");
		try{
			Aluno aluno = javaColecoes.buscaMatriculado(5617);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//System.out.println(aluno == null ? "Não encontrado" : aluno);
		
		//Combinando coleções
		//Seria como chavear um numero 
		//para um conjunto de alunos
		Map<Integer, Set<Aluno>> matriculaParaAlunos;
		
	}	
	
}

package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestaCurso2 {

	public static void main(String[] args) {
		
		Curso javaColecoes = new Curso("Dominando as coleções do Java", 
					"Paulo Silveira");
	
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma aula", 20));
		javaColecoes.adiciona(new Aula("Relacionamento entre coleções", 23));
		
		List<Aula> aulasImutaveis = javaColecoes.getAulas();
		//System.out.println(aulasImutaveis);
		
		//Fazendo com que a lista imutavel seja utilizada
		List<Aula> aulasMutaveis = new ArrayList<>(aulasImutaveis);
		
		Collections.sort(aulasMutaveis);
		System.out.println(aulasMutaveis);
		
		//Pegando o total de tempo
		//de forma orientada a objetos e encasulada
		System.out.println(javaColecoes.getTempoTotal());
		
		//Manipulando o toString da classe Curso, 
		//que por sua vez chama a lista de Aulas.
		//que por sua vez chama o toString de Aula
		System.out.println(javaColecoes);
		
	}

}

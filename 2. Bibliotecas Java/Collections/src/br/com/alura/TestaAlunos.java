package br.com.alura;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class TestaAlunos {

	public static void main(String[] args) {
		
		//Testando a Collection Set que tem esse
		//nome Collection pois é filha de Collection
		//não de List
		
		//Sendo ainda mais generico poderia ser
		//utilizado a interface
		
		//Forma proposta
		//Set<String> alunos = new HashSet<>();
		
		//Forma mais generica
		Collection<String> alunos = new HashSet<>();
		alunos.add("Rodrigo Turini");
		alunos.add("Alberto Souza");
		alunos.add("Nico Steppat");
		alunos.add("Sergio Lopes");
		alunos.add("Renan Saggio");
		alunos.add("Mauricio Aniche");
		alunos.add("Mauricio Aniche");
		
		//Algumas Caracteristicas
		//Não há garantias da ordem de saida dos elementos
		//System.out.println(alunos.)
		//Nenhum dos Sets aceita elementos repetidos
		
		//Vantagens
		//Velocidade e performance em caso de uso
		//dessa coleção(Set) em particular, no uso
		//do contains(), método que toda coleção tem por
		//conta da mãe Collection.
		//Muito mais performatico do que a List
		//Performance em busca
		System.out.println(alunos.contains("Paulo Silveira"));
		//Performance em remoção
		System.out.println(alunos.contains("Sergio Lopes"));;
		//Se há um conjunto muito grande de elementos
		//entre 10.000 a mais do que isso,
		//e faz-se buscas muito frequentes é melhor
		//utilizar o Set por conta da sua incrivel 
		//performance
		
		//Imprimindo
		//Usando Lambda
		/*alunos.forEach(string -> {
			System.out.println(string);
		});*/
		
		//Foreach
		for (String s : alunos) {
			System.out.println(s);
		}
		
		//Truque utilizado para poder utilizar metodos de 
		//outra interface sem perder os dados, passando
		//no construtor de outro objeto os dados anteriores
		//fazendo com que cada especidade de uma interface
		//seja usada quando necessário, porem se for muito
		//grande será criado duas listas muito grandes
		List<String> alunosEmLista = new ArrayList<>(alunos);
		
		
	}

}

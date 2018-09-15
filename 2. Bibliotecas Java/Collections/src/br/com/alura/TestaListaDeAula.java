package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestaListaDeAula {

	public static void main(String[] args) {

		Aula a1 = new Aula("Revisitando as ArrayLists", 21);
		Aula a2 = new Aula("Listas de Objetos", 19);
		Aula a3 = new Aula("Relacionamento de listas e objetos", 15);
		Aula a4 = new Aula("Aula 1", 20);
		
		ArrayList<Aula> lista = new ArrayList<>(); 
		lista.add(a1);
		lista.add(a2);
		lista.add(a3);
		lista.add(a4);
		
		System.out.println(lista);
		
		Collections.sort(lista);
		
		System.out.println(lista);
		
		//Mudando a forma de comparar utilizando
		//Uma interface para auxiliar
		//sem mudar o metodo da classe
		
		//Seria como:
		//Eu quero que você compare as aulas pelo metodo getTempo
		Collections.sort(lista, Comparator.comparing(Aula::getTempo));
		
		System.out.println(lista);
		
		lista.sort(Comparator.comparing(Aula::getTempo));
		
	}

}

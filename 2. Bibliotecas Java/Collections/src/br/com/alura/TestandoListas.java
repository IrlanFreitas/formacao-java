package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;

public class TestandoListas {

	public static void main(String[] args) {

		String aula1 = "Conhecendo mais de listas";
		String aula2 = "Modelando a classe aula";
		String aula3 = "Trabalhando com cursos e sets";

		ArrayList<String> aulas = new ArrayList<>();

		aulas.add(aula1);
		aulas.add(aula2);
		aulas.add(aula3);

		// System.out.println(aulas);

		// Removendo pelo indice
		aulas.remove(0);

		/*
		 * for (String s : aulas) { System.out.println("Aula: "+ s); }
		 */

		String primeiraAula = aulas.get(0);
/*		System.out.println(primeiraAula);

		for (int i = 0; i < aulas.size(); i++) {
			System.out.println(aulas.get(i));
		}*/

		//Usando Expressoes Lambda
		/*aulas.forEach(aula -> {
			System.out.println("Percorrendo: ");
			System.out.println("Aula: "+ aula);
		});*/
		
		aulas.add("Aumentando nosso conhecimento");
		
		System.out.println(aulas);
		
		//Usando uma classe que auxilia 
		//no uso de listas
		Collections.sort(aulas);
		
		System.out.println("Ordenados");
		
		System.out.println(aulas);
		

	}

}

package br.com.alura;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ExercicioMap {

	public static void main(String[] args) {

		Map<Integer, String> pessoas = new HashMap<>();

		pessoas.put(21, "Leonardo Cordeiro");
		pessoas.put(27, "Fabio Pimentel");
		pessoas.put(19, "Silvio Mattos");
		pessoas.put(23, "Romulo Henrique");
		
		
		Set<Integer> keySet = pessoas.keySet();
		
		for (Integer integer : keySet) {
			System.out.println(pessoas.get(integer));
		}
		System.out.println("\n");
		Collection<String> values = pessoas.values();
		
		for (String string : values) {
			System.out.println(string);
		}
		
		System.out.println("\nNomes para idade: ");

		Map<String, Integer> nomesParaIdade = new HashMap<>();
		nomesParaIdade.put("Paulo", 31);
		nomesParaIdade.put("Adriano", 25);
		nomesParaIdade.put("Alberto", 33);
		nomesParaIdade.put("Guilherme", 26);
		
		System.out.println("\nChaves: \n");
		nomesParaIdade.keySet().forEach( chaves -> {
			System.out.println(chaves);
		});
		
		System.out.println("Valores: \n");
		nomesParaIdade.values().forEach( valores -> {
			System.out.println(valores);
		});
	}
}

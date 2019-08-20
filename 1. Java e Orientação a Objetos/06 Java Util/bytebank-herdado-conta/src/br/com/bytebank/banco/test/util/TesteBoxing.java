package br.com.bytebank.banco.test.util;

import java.util.ArrayList;
import java.util.List;

public class TesteBoxing {

	public static void main(String[] args) {
		
		int[] idades = new int[5];
		String[] nomes = new String[5];
		
		
		int idade = 29; //Integer
		Integer idadeRef = Integer.valueOf(idade);
		List<Integer> numeros = new ArrayList<>();
		numeros.add(29); //Autoboxing - Transformação automatica de tipo primitivo para objeto e viceversa
		
		/*
			int				 Integer
			Tipo primivo --> Wrapper = Autoboxing
			Tipo primivo <-- Wrapper = Unboxing
		*/
				
	}

}

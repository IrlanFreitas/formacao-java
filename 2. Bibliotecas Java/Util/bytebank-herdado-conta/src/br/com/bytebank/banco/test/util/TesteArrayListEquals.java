package br.com.bytebank.banco.test.util;

import java.util.ArrayList;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteArrayListEquals {
	
	public static void main(String[] args) {
		
		ArrayList<Conta> lista = new ArrayList<>();
		
		Conta conta1 = new ContaCorrente(22,11);
		Conta conta2 = new ContaCorrente(22,22);
		Conta conta3 = new ContaCorrente(22,22);
		
		lista.add(conta1);
		lista.add(conta2);
		
		
		boolean existe = lista.contains(conta3);
		
		System.out.println("Já existe? "+ existe);
		
		for(Conta conta : lista) {
			System.out.println(conta);
		}
		
	}
	
}

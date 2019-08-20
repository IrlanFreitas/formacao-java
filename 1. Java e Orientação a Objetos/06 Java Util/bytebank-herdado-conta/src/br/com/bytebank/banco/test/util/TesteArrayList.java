package br.com.bytebank.banco.test.util;

import java.util.ArrayList;
import java.util.List;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteArrayList {
	
	public static void main(String[] args) {
		
		List<Conta> lista = new ArrayList<>();
		
		Conta conta = new ContaCorrente(22,11);
		Conta conta2 = new ContaCorrente(22,11);
		
		lista.add(conta);
		lista.add(conta2); 
		
		System.out.println(lista.size());
		
	}
	
}

package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.GuardadorDeContas;

public class TestGuardadorContas {

	public static void main(String[] args) {
		
		GuardadorDeContas guardador = new GuardadorDeContas();
		
		Conta conta = new ContaCorrente(22,11);
		Conta conta2 = new ContaCorrente(22,11);
		
		guardador.adicionar(conta);
		guardador.adicionar(conta2);
		
		guardador.elementos();
		
		Conta ref = guardador.getReferencia(1);
		
		System.out.println(ref);
		System.out.println(guardador.tamanho());

	}

}

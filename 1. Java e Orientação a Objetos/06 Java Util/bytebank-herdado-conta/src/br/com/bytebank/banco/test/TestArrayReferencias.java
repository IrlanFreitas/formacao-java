package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TestArrayReferencias {

	public static void main(String[] args) {
		
		Object[] referencias = new Object[5];
		
		ContaCorrente cc1 = new ContaCorrente(3573, 1);
		ContaPoupanca cc2 = new ContaPoupanca(3563, 2);
		Cliente cliente = new Cliente();
		
		referencias[0] = cc1;
		referencias[1] = cc2;
		referencias[2] = cliente;
		
		ContaPoupanca ref = (ContaPoupanca) referencias[1]; //type cast
//		System.out.println(cc2.getNumero());
		System.out.println(((ContaPoupanca) referencias[1]).getNumero());

	}

}

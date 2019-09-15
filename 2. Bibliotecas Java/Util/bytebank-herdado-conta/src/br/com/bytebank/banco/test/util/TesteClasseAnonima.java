package br.com.bytebank.banco.test.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteClasseAnonima {

	public static void main(String[] args) {

		Conta cc1 = new ContaCorrente(22, 33);
		Cliente clienteCC1 = new Cliente();
		clienteCC1.setNome("Nico");
		cc1.setTitular(clienteCC1);
		cc1.deposita(333.0);

		Conta cc2 = new ContaPoupanca(22, 44);
		Cliente clienteCC2 = new Cliente();
		clienteCC2.setNome("Guilherme");
		cc2.setTitular(clienteCC2);
		cc2.deposita(444.0);

		Conta cc3 = new ContaCorrente(22, 11);
		Cliente clienteCC3 = new Cliente();
		clienteCC3.setNome("Paulo");
		cc3.setTitular(clienteCC3);
		cc3.deposita(111.0);

		Conta cc4 = new ContaPoupanca(22, 22);
		Cliente clienteCC4 = new Cliente();
		clienteCC4.setNome("Ana");
		cc4.setTitular(clienteCC4);
		cc4.deposita(222.0);

		List<Conta> lista = new ArrayList<>();
		lista.add(cc1);
		lista.add(cc2);
		lista.add(cc3);
		lista.add(cc4);

		// lista.stream().forEach(System.out::println);

		lista.stream().forEach(conta -> {
			System.out.println(conta.getTitular().getNome());
		});
		
		
		lista.stream().sorted((Conta conta1, Conta conta2) -> {
			return 0;
		});
		
//		Functional Object
		lista.sort(new TitularComparador2());
		
//		Anonymous Class
//		Chamando construtor sem argumentos
		lista.sort( new Comparator<Conta>() { //Classe Anônima
			
			@Override
			public int compare(Conta o1, Conta o2) {
				return o1.compareTo(o2);
			}
		} );

		System.out.println("--------------------------");

		lista.stream().forEach(conta -> {
			System.out.println(conta.getTitular().getNome());
		});

	}

}

//
class TitularComparador2 implements Comparator<Conta> {

	@Override
	public int compare(Conta cc1, Conta cc2) {

		return cc1.getTitular().getNome().compareToIgnoreCase(cc2.getTitular().getNome());
	}

}

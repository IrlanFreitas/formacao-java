package br.com.bytebank.banco.test.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteOrdenacaoNumero {

	public static void main(String[] args) {
		
		Conta cc1 = new ContaCorrente(22, 33);
        cc1.deposita(333.0);

        Conta cc2 = new ContaPoupanca(22, 44); 
        cc2.deposita(444.0);

        Conta cc3 = new ContaCorrente(22, 11);
        cc3.deposita(111.0);

        Conta cc4 = new ContaPoupanca(22, 22);
        cc4.deposita(222.0);

        List<Conta> lista = new ArrayList<>();
        lista.add(cc1);
        lista.add(cc2);
        lista.add(cc3);
        lista.add(cc4);
        
        System.out.println(lista);
        
//        lista.sort( new NumeroContaComparador());
        Collections.sort(lista, new NumeroContaComparador());
        
        System.out.println(lista);
        
        
       
        
	}

}

class NumeroContaComparador implements Comparator<Conta> {
	
	@Override
	public int compare(Conta cc1, Conta cc2) {
		
		return Integer.compare(cc1.getNumero(), cc2.getNumero());
		
//		return cc1.getNumero() - cc2.getNumero();
		
		// Mesmo resultado.
		/*if (cc1.getNumero() > cc2.getNumero()) {
			return 1;
		} else if (cc1.getNumero() < cc2.getNumero()) {
			return -1;
		} else {
			return 0;
		}*/
	}
	
}

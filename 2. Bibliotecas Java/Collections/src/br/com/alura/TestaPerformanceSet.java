package br.com.alura;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class TestaPerformanceSet {

    public static void main(String[] args) {
    	
    	
    	//Usar HashSet<>() e ArrayList<>()
    	//Para comparação, HashSet é muito mais perfomatico
        Collection<Integer> numeros = new HashSet<Integer>();

        long inicio = System.currentTimeMillis();

        for (int i = 1; i <= 50000; i++) {
            numeros.add(i);
        }

        for (Integer numero : numeros) {
            numeros.contains(numero);
        }

        long fim = System.currentTimeMillis();

        long tempoDeExecucao = fim - inicio;

        System.out.println("Tempo gasto: " + tempoDeExecucao);

    }

}

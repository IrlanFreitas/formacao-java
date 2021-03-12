package br.com.caelum.leilao.servico;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class Avaliador {

	private double maiorDeTodos = Double.NEGATIVE_INFINITY;
	private double menorDeTodos = Double.POSITIVE_INFINITY;
	private double valorMedio = 0.0;
	private List<Lance> tresMaiores;

	public void avalia(Leilao leilao) {

		if (leilao.getLances().size() == 0)
			throw new RuntimeException("Não é possível avaliar um leilão sem lances");

		for (Lance lance : leilao.getLances()) {
			if (lance.getValor() > maiorDeTodos)
				maiorDeTodos = lance.getValor();
			if (lance.getValor() < menorDeTodos)
				menorDeTodos = lance.getValor();
			valorMedio += lance.getValor();
		}
		if (valorMedio > 0) {
			valorMedio = Double
					.valueOf(new DecimalFormat("0.00").format(valorMedio / leilao.getLances().size()).replace(",", "."))
					.doubleValue();
		}

		obterTresMaiores(leilao);

	}

	private void obterTresMaiores(Leilao leilao) {
		tresMaiores = new ArrayList<Lance>(leilao.getLances());

		Collections.sort(tresMaiores, new Comparator<Lance>() {
			public int compare(Lance o1, Lance o2) {
				if (o1.getValor() < o2.getValor())
					return 1;
				if (o1.getValor() > o2.getValor())
					return -1;
				return 0;
			}
		});

		tresMaiores = tresMaiores.subList(0, tresMaiores.size() >= 3 ? 3 : tresMaiores.size());
	}

	public List<Lance> getTresMaiores() {
		return tresMaiores;
	}

	public double getMaiorDeTodos() {
		return maiorDeTodos;
	}

	public double getMenorDeTodos() {
		return menorDeTodos;
	}

	public double getValorMedio() {
		return valorMedio;
	}

}

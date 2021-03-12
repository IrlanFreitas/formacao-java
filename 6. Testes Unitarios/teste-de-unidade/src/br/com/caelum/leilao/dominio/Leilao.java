package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Leilao {

	private String descricao;
	private List<Lance> lances;

	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}

	public void propoe(Lance lance) {
		if (lances.isEmpty() || podeDarLance(lance.getUsuario())) {
			lances.add(lance);
		}
	}

	public void dobraMaiorLanceDo(Usuario usuario) {
		if (lances.isEmpty() || podeDarLance(usuario)) {
			Lance lance = lances.stream().sorted((item1, item2) -> {
				if (item1.getValor() < item2.getValor())
					return 1;
				if (item1.getValor() > item2.getValor())
					return -1;
				return 0;
			}).filter(item -> item.getUsuario().equals(usuario)).findFirst().get();

			lances.add(new Lance(usuario, (lance.getValor() * 2)));
		}
	}

	public void dobraUltimoLanceDo(Usuario usuario) {
		if (!lances.isEmpty() && podeDarLance(usuario)) {
			List<Lance> lancesFiltrados = lances.stream().filter(item -> item.getUsuario().equals(usuario))
					.collect(Collectors.toList());

			Lance lance = lancesFiltrados.get(lancesFiltrados.size() - 1);

			lances.add(new Lance(usuario, (lance.getValor() * 2)));
		}
	}

	private boolean podeDarLance(Usuario usuario) {
		return ultimoLanceDado(usuario) && quantidadeDeLancesDo(usuario);
	}

	private boolean ultimoLanceDado(Usuario usuario) {
		return !lances.get(lances.size() - 1).getUsuario().equals(usuario);
	}

	private boolean quantidadeDeLancesDo(Usuario usuario) {
		int quantidadeLances = 0;
		if (lances.size() > 5) {
			quantidadeLances = (int) lances.stream().filter(item -> item.getUsuario().equals(usuario)).count();
		}

		return quantidadeLances <= 4;
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}

}

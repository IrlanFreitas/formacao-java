package br.com.bytebank.banco.modelo;

public class GuardadorDeContas {
	
	private Conta[] referencias;
	private int count;

	public GuardadorDeContas() {
		this.referencias = new Conta[10];
		this.count = 0;
	}

	public void adicionar(Conta conta) {
		this.referencias[this.count] = conta;
		this.count++;
	}
	
	public int tamanho() {
		return this.count;
	}
	
	public void elementos() {
		for (int i = 0; i < this.referencias.length; i++) {
			System.out.println(this.referencias[i]);
		}
	}

	public Conta getReferencia(int posicao) {
		return this.referencias[posicao];
	}

}

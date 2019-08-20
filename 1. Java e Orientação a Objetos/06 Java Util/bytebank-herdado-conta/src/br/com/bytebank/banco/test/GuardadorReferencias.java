package br.com.bytebank.banco.test;

public class GuardadorReferencias {
	
	private Object[] referencias;
	private int count;

	public GuardadorReferencias() {
		this.referencias = new Object[10];
		this.count = 0;
	}

	public void adicionar(Object conta) {
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

	public Object getReferencia(int posicao) {
		return this.referencias[posicao];
	}


}

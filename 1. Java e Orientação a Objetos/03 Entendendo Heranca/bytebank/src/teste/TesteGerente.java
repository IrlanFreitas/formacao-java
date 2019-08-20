package teste;

import bytebank.Gerente;

public class TesteGerente {

	public static void main(String[] args) {
		Gerente g1 = new Gerente();
		g1.setNome("Marco");
		g1.setCpf("2254636-7");
		g1.setSalario(5500.3);
		g1.setSenha(2222);
		
		System.out.println(g1.autentica(2222));
	}

}

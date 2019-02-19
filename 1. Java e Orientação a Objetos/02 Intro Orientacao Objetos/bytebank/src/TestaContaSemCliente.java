public class TestaContaSemCliente {

	public static void main(String[] args) {
		
		Conta contaDaMarcela = new Conta();
		System.out.println(contaDaMarcela.getSaldo());
		
		// Para não dar null pointer.
		contaDaMarcela.setTitular(new Cliente());
		
		contaDaMarcela.getTitular().nome = "Marcela";
		System.out.println(contaDaMarcela.getTitular().nome);
		
	}

}


public class TesteSacaValoresNegativos {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		
		conta.deposita(100);
		conta.saca(200);
		
		System.out.println(conta.getSaldo());
		
		// Proíbido - Encapsulamento
		//conta.saldo -= 200;
		System.out.println(conta.getSaldo());
		
	}

}


public class TestaMetodo {
	
	public static void main(String[] args) {
		Conta contaDoPaulo = new Conta();
		contaDoPaulo.saldo = 100;
		contaDoPaulo.deposita(50);
		System.out.println(contaDoPaulo.saldo);
		
		System.out.println(contaDoPaulo.saca(150));
		System.out.println(contaDoPaulo.saldo);
		
		Conta contaDaMarcela = new Conta();
		contaDaMarcela.deposita(1000);
		
		boolean sucessoTransferencia = contaDaMarcela.transfere(300, contaDoPaulo);
		
		if (sucessoTransferencia) {
			System.out.println("Transferencia com sucesso.");
		} else {
			System.out.println("Falou dinheiro.");
		}
		
		System.out.println("Saldo da conta Marcela: "+ contaDaMarcela.saldo);
		System.out.println("Saldo da conta Paulo: "+ contaDoPaulo.saldo);
		
		
//		contaDoPaulo.titular = "Paulo Silveira";
//		System.out.println(contaDoPaulo.titular);
	}
	
}


public class TesteReferencias {
	
	public static void main(String[] args) {
		Conta primeiraConta = new Conta();
//		primeiraConta.saldo = 300;
		System.out.println("Saldo primeira conta: "+ primeiraConta.getSaldo());
		
		Conta segundaConta = primeiraConta;
		System.out.println("Saldo segunda conta: "+ segundaConta.getSaldo());
		
//		segundaConta.saldo += 100;
		System.out.println("Saldo segunda conta: "+ segundaConta.getSaldo());
		
		System.out.println(primeiraConta.getSaldo());
		
		if (primeiraConta == segundaConta) {
			System.out.println("São a mesmissima conta");
		}
	}
}

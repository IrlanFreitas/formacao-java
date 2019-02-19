public class Conta {

    private double saldo;
    private int agencia;
    private int numero;
    private Cliente titular;
    
    public void deposita(double valor) {
    	this.saldo += valor;
    }
    
    public boolean saca(double valor) {
    	if (this.saldo < valor) {
			return false;
		}
    	this.saldo -= valor;
    	return true;
    }
    
    public boolean transfere(double valor, Conta destino) {
    	if (this.saldo >= valor) {
    		this.saca(valor);
        	destino.deposita(valor);
        	return true;
		}
    	return false;
    }
    
    public double getSaldo() {
    	return this.saldo;
    }

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Cliente getTitular() {
		return titular;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
    
}	
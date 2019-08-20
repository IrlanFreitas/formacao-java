package br.com.alura.java.io.teste.serializacao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TesteSerializacaoCliente {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Cliente cliente = new Cliente();
		cliente.setNome("Irlan");
		cliente.setProfissao("Dev");
		cliente.setCpf("125448965.92");
		
//		ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream("cliente.bin"));
//		oos.writeObject(cliente);
//		oos.close();
		
		
		ObjectInputStream ois = new ObjectInputStream( new FileInputStream("cliente.bin"));
		Cliente cliente2 = (Cliente) ois.readObject();
		System.out.println(cliente2);
		
	}

}

package br.com.alura.java.io.teste.serializacao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TesteSerializacao {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		String nome = "Irlan";
		
//		ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream("objeto.bin"));
//		oos.writeObject(nome);
//		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream( new FileInputStream("objeto.bin"));
		System.out.println(ois.readObject());
		ois.close();
		
	}

}

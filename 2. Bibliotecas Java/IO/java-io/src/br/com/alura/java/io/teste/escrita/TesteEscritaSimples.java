package br.com.alura.java.io.teste.escrita;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TesteEscritaSimples {

	public static void main(String[] args) throws IOException {
		
		FileWriter fw = new FileWriter("saidaFileWriter.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter("saidaFileWriter.txt"));
		
		bw.write("Olá " + System.lineSeparator());
		bw.write("Irlan escrevendo no arquivo " + System.lineSeparator());
		bw.write("Thanks! " + System.lineSeparator());
		
		bw.close();
	}

}

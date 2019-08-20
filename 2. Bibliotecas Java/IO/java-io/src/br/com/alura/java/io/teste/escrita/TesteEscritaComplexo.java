package br.com.alura.java.io.teste.escrita;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class TesteEscritaComplexo {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream fos = new FileOutputStream("saida.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		
		bw.write("Teste1");
		bw.newLine();
		
		bw.write("Teste2");
		bw.newLine();
		
		bw.write("Teste3");
		bw.newLine();
		
		bw.close();
		
	}

}

package br.com.alura.java.io.teste.escrita;

import java.io.IOException;
import java.io.PrintWriter;

public class TesteEscritaMaisSimples {

	public static void main(String[] args) throws IOException {
		
		PrintWriter pw = new PrintWriter("saidaPrintWriter.txt", "UTF-8");
		
		pw.println("Irlan");
		pw.println("Escrevendo no arquivo de maneira mais fácil");
		pw.println("O inimigo agora é outro");
		pw.println("Thanks!");
		
		pw.close();

	}

}

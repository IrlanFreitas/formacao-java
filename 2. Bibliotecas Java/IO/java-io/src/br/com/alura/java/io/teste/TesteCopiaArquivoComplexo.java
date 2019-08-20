package br.com.alura.java.io.teste;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

public class TesteCopiaArquivoComplexo {

	public static void main(String[] args) throws IOException {
		
		new Socket().getInputStream();
		
		
		// Reader
		InputStream fis = System.in;
		Reader isr = new InputStreamReader(fis); // Padrão de Projeto - Template
		BufferedReader br = new BufferedReader(isr);

		// Writer
		OutputStream fos = System.out;
		Writer osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);

		String linha = br.readLine();

		while (linha != null && !linha.isEmpty()) {
			bw.write(linha);
			bw.newLine();
			linha = br.readLine();
		}

		br.close();
		bw.close();

	}

	public static void copiaArquivo() throws IOException {
		// Reader
		InputStream fis = new FileInputStream("entrada.txt"); // Padrão de Projeto - Template
		Reader isr = new InputStreamReader(fis); // Padrão de Projeto - Template
		BufferedReader br = new BufferedReader(isr);

		// Writer
		FileOutputStream fos = new FileOutputStream("copiado1.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);

		while (br.ready()) {
			bw.write(br.readLine());
			bw.newLine();
		}

		br.close();
		bw.close();
	}

}

package br.com.alura.java.io.teste;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class TesteUnicodeEncondig {

	public static void main(String[] args) throws IOException {
		
		String s = "ç";
		System.out.println(s.codePointAt(0));
		
		
		Charset defaultCharset = Charset.defaultCharset();
		System.out.println(defaultCharset.displayName());
		
		byte[] bytes = s.getBytes();
		System.out.print(bytes.length + ", windows-1252 ");
		System.out.print(new String(bytes) + ", bytes");
		System.out.println();
		
		bytes = s.getBytes("UTF-16");
		System.out.print(bytes.length + ", UTF-16 ");
		System.out.print(new String(bytes) + ", bytes");
		System.out.println();
		
		bytes = s.getBytes("UTF-8");
		System.out.print(bytes.length + ", UTF-8 ");
		System.out.print(new String(bytes) + ", bytes");
		System.out.println();
		
		bytes = s.getBytes(StandardCharsets.US_ASCII);
		System.out.print(bytes.length + ", US-ASCII ");
		System.out.print(new String(bytes) + ", bytes");
		System.out.println();
		
		
	}

}

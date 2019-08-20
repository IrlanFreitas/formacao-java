package br.com.alura.java.io.teste.leitura;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class TesteLeituraSimples {

	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(new File("contas.csv"), "UTF-8");

		while (scan.hasNextLine()) {
			// System.out.println(scan.nextLine());

			Scanner linhaScanner = new Scanner(scan.nextLine());
			linhaScanner.useLocale(Locale.US);
			linhaScanner.useDelimiter(",");

			System.out.println("-----------------------");
			// while (linhaScanner.hasNext()) {
			// System.out.println(linhaScanner.next());
			// }

			String tipoConta = linhaScanner.next();
			int agencia = linhaScanner.nextInt();
			int numero = linhaScanner.nextInt();
			String titular = linhaScanner.next();
			double saldo = linhaScanner.nextDouble();

//			 System.out.format("%s - %04d-%08d, %s: %f", tipoConta, agencia, numero, titular, saldo);
			System.out.println(tipoConta + agencia + numero + titular + saldo);

			System.out.println("-----------------------");

			linhaScanner.close();
		}

		scan.close();

	}

}

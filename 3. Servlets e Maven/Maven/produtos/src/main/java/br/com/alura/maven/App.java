package br.com.alura.maven;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		Produto produto = new Produto("Bala Juquinha saber tangerina", 0.15);
		
		System.out.println("Hello World! + "+ produto.getNome());
	}
}

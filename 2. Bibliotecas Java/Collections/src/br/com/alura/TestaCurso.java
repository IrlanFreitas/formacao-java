package br.com.alura;

public class TestaCurso {

	public static void main(String[] args) {
		
		Curso javaColecoes = new Curso("Dominando as coleções do Java", 
					"Paulo Silveira");
		
		//Igualando as referencias
		//Isso poderia ser feito de outra forma
		/*List<Aula> aulas = javaColecoes.getAulas();
		System.out.println(aulas);
		System.out.println(aulas == javaColecoes.getAulas());
		System.out.println(aulas);*/
		
		//A outra forma de manipular a lista
		//O getAulas retorna um List e 
		//Todo o list tem o método add
		//Porem como foi modificado para 
		//return Collections.unmodifiableList(aulas);
		//Nenhum metodo pode ser acessado ou modificado
		//Fazendo que que a classe javaColecoes tenha 
		//total responsabilidade de adicionar ou remover
		//javaColecoes.getAulas().add(new Aula("Trabalhando com ArrayList", 21));
		
		//Fazendo com que a classe adicione
		//Para que não seja tratado com a lista
		//a lista não pode ser manipulada
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma aula", 20));
		javaColecoes.adiciona(new Aula("Relacionamento entre coleções", 23));
		
		
		//Não está vazio pois a refenrencia é a mesma
		System.out.println(javaColecoes.getAulas());
		
	}

}

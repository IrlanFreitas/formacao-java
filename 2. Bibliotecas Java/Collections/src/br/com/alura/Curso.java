package br.com.alura;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;

public class Curso {

	//private int tempoTotal;
	private String nome;
	private String instrutor;
	
	// Usando ArrayList prende muito a classe
	// o correto é utilizar uma interface List
	// Usando arraylist ou linkedlist não faz muita
	// diferença pois ambas adicionam elementos na ordem
	// e deixam adicionar elementos repetidos
	// exato pelo caso da perfomance é onde as diferenças
	// começam
	private List<Aula> aulas = new LinkedList<Aula>();

	//Map
	//Que basicamente não é uma coleção pois não é
	//filha de collection, funciona com o mapeamento
	//chave e valor que é passado para o map, ex:
	//Map<Integer, Aluno> localizador = new Map<>();
	//abaixo a utilização do map é referente a busca
	//rápida de alunos pela matricula.
	//Sua implementação mais usada é o HashMap, porem
	//há uma implementação antiga e thread-safe 
	//chamada Hashtable()
	
	private Map<Integer, Aluno> matriculaParaAluno = new HashMap<>();
	
	//Usando Sets(Interface) e suas implementações
	//como:
	//HashSet e LinkedHashSet
	//que basicamente não tem muita diferença
	//exceto que o LinkedHashSet mesmo que 
	//não seja possivel acessar a enesima posicão
	//mas ele devolve os itens da ordem que foram 
	//adicionados
	
	//TreeSet
	//só funciona para as classes que são comparable
	//pois coloca os itens na sua ordem natural, 
	//de ordenação.
	//Para entender a sua grande diferença
	//na performance, o ponto negativo é o entendimento
	//necessário com os métodos 
	//Equals, quer serve de comparação de atributos da 
	//classe para que seja confirmado na comparação 
	//e Hashcode, que faz a geração de numeros identificadores
	//de cada instancia da classe, 
	//Lembrando que sempre tem que ser reescritos ambos
	//para que a sua utilização seja realmente válida
	private Set<Aluno> alunos = new TreeSet<>();
	
	// ArrayList
	// Trabalha internamente como um vetor[]
	// e é muito rápida para adicionar elementos
	// no final e obter elementos atraves do indice
	// get(n), problemas para deletar elementos,
	// pois terá que mover os elementos

	// LinkedList
	// Lido do javaDoc, que é muito rápido para
	// adicionar elementos no inicio da lista
	// e remover, por conta da estrutura de dados
	// porem é muito lenta para obter elementos
	// independete da posição

	public Curso(String nome, String instrutor) {
		this.nome = nome;
		this.instrutor = instrutor;
	}

	public String getNome() {
		return nome;
	}

	public String getInstrutor() {
		return instrutor;
	}

	public List<Aula> getAulas() {
		// A ideia de programar defensivamente
		// Ler effective java
		// Esse retorno retorna uma lista que
		// só pode ser lida seus metodos
		// que modificam como add, remove
		// não serão acessados, gerando
		// exceções.
		return Collections.unmodifiableList(aulas);
	}

	public void adiciona(Aula aula) {
		this.aulas.add(aula);
	}

	public int getTempoTotal() {
		// Usando Java 8, isso é muito doido!
		// Mostrando as possibilidades para resolver o mesmo problema
		return this.aulas.stream().mapToInt(Aula::getTempo).sum();
	}

	/*public void setTempoTotal(int tempoTotal) {
		this.tempoTotal = tempoTotal;
	}*/

	@Override
	public String toString() {
		return "[ Curso: " + this.nome + ", Instrutor: " + this.instrutor + ", Tempo total: " + this.getTempoTotal()
				+ " Aulas :" + this.aulas + "]";
	}
	
	//Usando o encapsulamento
	public void matricula(Aluno aluno) {
		this.alunos.add(aluno);
		this.matriculaParaAluno.put(aluno.getNumeroMatricula(), aluno);
	}
	
	//Usando a programação defensiva
	public Set<Aluno> getAlunos() {
		return Collections.unmodifiableSet(alunos);
	}
	
	//Delegando algumas reponsabilidades
	public boolean estaMatriculado(Aluno aluno){
		return alunos.contains(aluno);
	}

	public Aluno buscaMatriculado(int numero) {
		//pode ser feito com o for
		//e comparando porem, será
		//modificado para o uso 
		//dos mapas, por conta da frequencia de uso
		//e da quantidade de registros
		/*for (Aluno aluno : alunos) {
			if (aluno.getNumeroMatricula() == numero) {
				return aluno;
			}
		}
		throw new NoSuchElementException("Matrícula não encontrada "+ numero);*/
		
		//Usando o mapa para facilitar a busca
		//usando a chave utilizada no primeiro 
		//parametro.
		if (!matriculaParaAluno.containsKey(numero))
			throw new NoSuchElementException("Matrícula não encontrada "+ numero);
		return this.matriculaParaAluno.get(numero);
	}
	

}

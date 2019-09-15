package br.com.alura.gerenciador.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.gerenciador.model.Empresa;

public class Banco {
	
	private static List<Empresa> empresas = new ArrayList<Empresa>();
	private static Integer chaveSequencial = 1;
	
//	Bloco estático ligado diretamente a classe
//	e não a instância do objeto
	
	static {
		Empresa empresa1 = new Empresa();
		empresa1.setId(chaveSequencial++);
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa1.setNome("Alura");
		empresa2.setNome("Caelum");
		empresas.add(empresa1);
		empresas.add(empresa2);
	}
	
	public void adicionar(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.empresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return Banco.empresas;
	}
	
	public void remover(Integer id) {
		Banco.empresas.removeIf(empresa -> empresa.getId() == id);
	}
	
	public Empresa get(Integer id) {
		
		return Banco.empresas.stream()
							.filter(empresa -> empresa.getId() == id)
							.findFirst()
							.orElse(null);
	}
	
}

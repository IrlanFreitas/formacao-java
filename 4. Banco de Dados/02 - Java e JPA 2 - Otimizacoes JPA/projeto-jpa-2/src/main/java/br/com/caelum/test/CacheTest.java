package br.com.caelum.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.caelum.JpaConfigurator;
import br.com.caelum.model.Produto;

public class CacheTest {

	public static void main(String[] args) {

//		cachePrimeiroNivelUmEntityManager();
		cachePrimeiroNivelDoisEntitysManagers();
	}

	public static void cachePrimeiroNivelUmEntityManager() {

		/*
		 * Como é o spring que cria o EntityManager é necessário o contexto do Spring
		 * para que ele possa ser criado, injetado aqui.
		 */
		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JpaConfigurator.class);

		EntityManagerFactory factory = ctx.getBean(EntityManagerFactory.class);

		EntityManager em = factory.createEntityManager();

//		Não é necessário
//		em.getTransaction().begin();

		// Duas buscas, um select somente se for somente o no mesmo EntityManager
		Produto prod1 = em.find(Produto.class, 1);
		Produto prod2 = em.find(Produto.class, 1);

		System.out.println(prod1.getNome());
		System.out.println(prod2.getNome());

		em.close();

	}

	public static void cachePrimeiroNivelDoisEntitysManagers() {

		/*
		 * Como é o spring que cria o EntityManager é necessário o contexto do Spring
		 * para que ele possa ser criado, injetado aqui.
		 */
		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JpaConfigurator.class);

		EntityManagerFactory factory = ctx.getBean(EntityManagerFactory.class);

		EntityManager em = factory.createEntityManager();
		EntityManager em1 = factory.createEntityManager();

//		em.getTransaction().begin();

		// Duas buscas, um select somente se for somente o no mesmo EntityManager
		// Com dois entitys managers, isso não acontece pois, separadamente 
		// que os caches ficam
		Produto prod1 = em.find(Produto.class, 1);
		Produto prod2 = em1.find(Produto.class, 1);

		System.out.println(prod1.getNome());
		System.out.println(prod2.getNome());

		em.close();

	}

}

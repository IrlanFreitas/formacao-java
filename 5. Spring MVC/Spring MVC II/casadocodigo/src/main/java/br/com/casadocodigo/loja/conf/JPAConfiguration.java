package br.com.casadocodigo.loja.conf;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement //Habilitar que o Spring cuide das transações
public class JPAConfiguration {
	
	@Bean //Para ser conhecido pelo Spring
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		
		Properties props = aditionalProperties();

		//Indicando ao Spring que será usado Hibernate
		factory.setJpaVendorAdapter(vendorAdapter); 
		
		//Indicando o banco, login, senha e qual o tipo do banco
		factory.setDataSource(dataSource);
		
		//Indicando configurações essenciais como o dialeto do banco e extras como exibição
		// de sql e geração e manutenção de tabelas pelo hibernate
		factory.setJpaProperties(props); 
		
		//Indicar onde estão as entidades
		factory.setPackagesToScan("br.com.casadocodigo.loja.models");
		
		return factory;
	}
	
	@Bean
	@Profile("dev")
	public DataSource dataSource(){
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setUsername("root");
	    dataSource.setPassword("root");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/casadocodigo");
	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    return dataSource;
	}
	
	private Properties aditionalProperties(){
	    Properties props = new Properties();
	    props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	    props.setProperty("hibernate.show_sql", "true");
	    props.setProperty("hibernate.hbm2ddl.auto", "update");
	    return props;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		
		return new JpaTransactionManager(emf);
	}
	
}

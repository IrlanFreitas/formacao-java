package br.com.caelum;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
public class JpaConfigurator {

	@Bean
	public DataSource getDataSource() throws PropertyVetoException {
		//Usando o c3p0 para gerenciamento do pool de conexões
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost/projeto_jpa");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		
		//Treads para auxiliar a utilização do pool de conexões
		//Melhorando a performance
		dataSource.setNumHelperThreads(15);
		//Numero de conexões criadas de ante mão para o usuário
		dataSource.setMinPoolSize(3);
		//Máximo de conexões criadas
		dataSource.setMaxPoolSize(5);
		//a cada um segundo testamos as conexões ociosas
		dataSource.setIdleConnectionTestPeriod(1); 
		
	    return dataSource;
	}
	
	@Bean
	public Statistics statistics(EntityManagerFactory emf) {
		SessionFactory factory = emf.unwrap(SessionFactory.class);
		return factory.getStatistics();
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();

		entityManagerFactory.setPackagesToScan("br.com.caelum");
		entityManagerFactory.setDataSource(dataSource);

		entityManagerFactory
				.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

		Properties props = new Properties();

		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		props.setProperty("hibernate.show_sql", "true");
		// Hibernate Mappging - Link ref: https://pt.stackoverflow.com/questions/90723/como-funciona-hibernate-hbm2ddl-auto
		props.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		
		//Habilitando cache de segundo nível
//		<property name="hibernate.cache.use_second_level_cache" value="true" />
		props.setProperty("hibernate.cache.use_second_level_cache", "true");
		//Indicando o Provider do cache de segundo nível - EhCache
//		<property name="hibernate.cache.region.factory_class" value="org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory" />
		props.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory");
		
		//Habilitando o cache de queries
		props.setProperty("hibernate.cache.use_query_cache", "true");
		
		//Habilitando o Statistics do Hibernate
		props.setProperty("hibernate.generate_statistics", "true");

		entityManagerFactory.setJpaProperties(props);
		return entityManagerFactory;
	}

	@Bean
	public JpaTransactionManager getTransactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;
	}

}

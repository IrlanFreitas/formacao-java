package br.com.casadocodigo.loja.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.casadocodigo.loja.controllers.HomeController;
import br.com.casadocodigo.loja.dao.ProdutoDAO;

//Classe de configuração do servlet do SpringMVC
@EnableWebMvc
//Recebe um array de classes de onde o SpringMVC pode extrair os pacotes nos quais ele pode encontrar os controllers
@ComponentScan(basePackageClasses = {HomeController.class, ProdutoDAO.class}) 
public class AppWebConfiguration {
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		
		//Configurar o projeto para que o SpringMVC consiga encontrar as views.
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
	
}

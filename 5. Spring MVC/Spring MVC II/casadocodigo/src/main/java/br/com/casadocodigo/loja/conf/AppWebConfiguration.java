package br.com.casadocodigo.loja.conf;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.casadocodigo.loja.controllers.HomeController;
import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.infra.FileSaver;
import br.com.casadocodigo.loja.models.CarrinhoCompras;

//Classe de configuração do servlet do SpringMVC
@EnableWebMvc
//Recebe um array de classes de onde o SpringMVC pode extrair os pacotes nos quais ele pode encontrar os controllers
@ComponentScan(basePackageClasses = {HomeController.class, ProdutoDAO.class, FileSaver.class, CarrinhoCompras.class}) 
public class AppWebConfiguration extends WebMvcConfigurerAdapter{
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		
		//Configurar o projeto para que o SpringMVC consiga encontrar as views.
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		resolver.setExposedContextBeanNames("carrinhoCompras");;
		
		return resolver;
	}
	
	//Configurando as mensagens padrões
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("/WEB-INF/messages");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(1);
		
		return messageSource;
	}
	
	@Bean
	public FormattingConversionService mvcConversionService() {
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
		DateFormatterRegistrar registrar = new DateFormatterRegistrar();
		
		registrar.setFormatter(new DateFormatter("dd/MM/yyyy"));
		registrar.registerFormatters(conversionService);
		
		return conversionService;
	}
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }
	
	@Bean
	public MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}

package br.com.alura.gerenciador.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.interfaces.Acao;

@WebFilter("/ControladorFilter")
public class ControladorFilter implements Filter {

	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("ControladorFilter");

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String paramAcao = request.getParameter("acao");

		String redirect = null;
		String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;

		Class<Acao> classe;

		try {
			System.out.println(nomeDaClasse);
			classe = (Class<Acao>) Class.forName(nomeDaClasse);
			@SuppressWarnings("deprecation")
			Acao instancia = (Acao) classe.newInstance();
			redirect = instancia.executa(request, response);

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

		String[] infoRedirect = redirect.split(":");

		if (infoRedirect[0].equals("forward")) {
			request.getRequestDispatcher("WEB-INF/view/" + infoRedirect[1]).forward(request, response);
		} else {
			response.sendRedirect(infoRedirect[1]);
		}
		
	}

}

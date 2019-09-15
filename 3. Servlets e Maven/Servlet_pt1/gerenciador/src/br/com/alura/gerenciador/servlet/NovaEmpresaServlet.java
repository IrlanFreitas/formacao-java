package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.dao.Banco;
import br.com.alura.gerenciador.model.Empresa;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		System.out.println("Cadastrando nova empresa");
		
		String nome = req.getParameter("nome");
		
		Date dataAbertura = null;
		
		try {
			dataAbertura = new SimpleDateFormat("yyyy-MM-dd").parse( req.getParameter("data") );
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa();
		empresa.setNome(nome);
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adicionar(empresa);
		
//		Usando ClientSideRedirect
		req.setAttribute("empresa", empresa.getNome());
		resp.sendRedirect("listarEmpresas");
				
		// Não usar mais ServerSideRedirect
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/listarEmpresas");
//		req.setAttribute("empresa", empresa.getNome());
//		dispatcher.forward(req, resp);

	}

}

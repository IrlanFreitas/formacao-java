package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.dao.Banco;
import br.com.alura.gerenciador.interfaces.Acao;
import br.com.alura.gerenciador.model.Empresa;

public class CadastrarEmpresa implements Acao {

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		resp.sendRedirect("entrada?acao=ListarEmpresas");
				
	}

}

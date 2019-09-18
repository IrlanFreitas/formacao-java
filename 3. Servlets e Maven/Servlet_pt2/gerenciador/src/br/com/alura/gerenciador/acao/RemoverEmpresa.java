package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.dao.Banco;
import br.com.alura.gerenciador.interfaces.Acao;

public class RemoverEmpresa implements Acao {

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt( req.getParameter("id") );
		Banco banco = new Banco();
		banco.remover(id);
		resp.sendRedirect("entrada?acao=ListarEmpresas");

	}

}

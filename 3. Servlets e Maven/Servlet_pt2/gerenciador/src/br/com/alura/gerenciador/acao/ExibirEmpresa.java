package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.dao.Banco;
import br.com.alura.gerenciador.interfaces.Acao;
import br.com.alura.gerenciador.model.Empresa;

public class ExibirEmpresa implements Acao {

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.valueOf(req.getParameter("id"));

		Banco banco = new Banco();
		Empresa empresa = banco.get(id);
		req.setAttribute("empresa", empresa);
		req.getRequestDispatcher("/formAlteraEmpresa.jsp").forward(req, resp);
	}

}

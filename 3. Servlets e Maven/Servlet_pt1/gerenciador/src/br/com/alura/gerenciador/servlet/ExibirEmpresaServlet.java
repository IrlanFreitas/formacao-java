package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.dao.Banco;
import br.com.alura.gerenciador.model.Empresa;

/**
 * Servlet implementation class ExibirEmpresaServlet
 */
@WebServlet("/exibirEmpresa")
public class ExibirEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer id = Integer.valueOf(req.getParameter("id"));

		Banco banco = new Banco();
		Empresa empresa = banco.get(id);
		req.setAttribute("empresa", empresa);
		req.getRequestDispatcher("/formAlteraEmpresa.jsp").forward(req, resp);
	}

}

package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.dao.Banco;

/**
 * Servlet implementation class RemoverEmpresa
 */
@WebServlet("/removerEmpresa")
public class RemoverEmpresaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			Integer id = Integer.parseInt( req.getParameter("id") );
			Banco banco = new Banco();
			banco.remover(id);
			resp.sendRedirect("listarEmpresas");
		
		}
}

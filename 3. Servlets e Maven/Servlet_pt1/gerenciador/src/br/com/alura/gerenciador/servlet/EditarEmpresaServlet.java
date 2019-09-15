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
 * Servlet implementation class EditarEmpresaServlet
 */
@WebServlet("/editarEmpresa")
public class EditarEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			Integer id = Integer.valueOf(req.getParameter("id"));
			
			Banco banco = new Banco();
			
			String nome = req.getParameter("nome");
			
			Date dataAbertura = null;
			
			try {
				dataAbertura = new SimpleDateFormat("yyyy-MM-dd").parse( req.getParameter("data") );
			} catch (ParseException e) {
				throw new ServletException(e);
			}
			
			Empresa empresa = banco.get(id);
			empresa.setNome(nome);
			empresa.setDataAbertura(dataAbertura);
			
			resp.sendRedirect("listarEmpresas");
		}

}

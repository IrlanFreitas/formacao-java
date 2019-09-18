package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.dao.Banco;


//@WebServlet("/listarEmpresas")
@Deprecated
public class ListarEmpresasServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Banco banco = new Banco();
		request.setAttribute("empresas", banco.getEmpresas());
		request.getRequestDispatcher("/listarEmpresas.jsp").forward(request, response);
		
	}


}

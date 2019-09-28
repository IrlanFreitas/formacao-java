package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.dao.Banco;
import br.com.alura.gerenciador.interfaces.Acao;

public class ListarEmpresas implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Banco banco = new Banco();
		request.setAttribute("empresas", banco.getEmpresas());
//		request.getRequestDispatcher("/listarEmpresas.jsp").forward(request, response);
		return "forward:listarEmpresas.jsp";

	}

}

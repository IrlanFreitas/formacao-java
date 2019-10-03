package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.interfaces.Acao;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
//@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//			HttpSession session = req.getSession();			
//			boolean usuarioNaoLogado = session.getAttribute("usuarioLogado") == null;
//			boolean ehUmaAcaoProtegiado = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
//			
//			
//			if (usuarioNaoLogado && ehUmaAcaoProtegiado) {
//				resp.sendRedirect("entrada?acao=LoginForm");
//				return;
//			}

		String paramAcao = req.getParameter("acao");

		String redirect = null;
		String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;

		Class<Acao> classe;

		try {
			System.out.println(nomeDaClasse);
			classe = (Class<Acao>) Class.forName(nomeDaClasse);
			@SuppressWarnings("deprecation")
			Acao instancia = (Acao) classe.newInstance();
			redirect = instancia.executa(req, resp);

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

		String[] infoRedirect = redirect.split(":");

		if (infoRedirect[0].equals("forward")) {
			req.getRequestDispatcher("WEB-INF/view/" + infoRedirect[1]).forward(req, resp);
		} else {
			resp.sendRedirect(infoRedirect[1]);
		}

	}

}

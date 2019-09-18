package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.CadastrarEmpresa;
import br.com.alura.gerenciador.acao.EditarEmpresa;
import br.com.alura.gerenciador.acao.ExibirEmpresa;
import br.com.alura.gerenciador.acao.ListarEmpresas;
import br.com.alura.gerenciador.acao.RemoverEmpresa;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			String paramAcao = req.getParameter("acao");
			
			if(paramAcao.equals("ListarEmpresas")) {
				System.out.println("Listando empresas");
				
				ListarEmpresas acao = new ListarEmpresas();
				acao.executa(req, resp);
				
			} else  if (paramAcao.equals("RemoverEmpresa")) {
				System.out.println("Removendo empresas");
				
				RemoverEmpresa acao = new RemoverEmpresa();
				acao.executa(req, resp);
				
			} else  if (paramAcao.equals("ExibirEmpresa")) {
				System.out.println("Exibindo dados da empresa");
				
				ExibirEmpresa acao = new ExibirEmpresa();
				acao.executa(req, resp);
				
			} else  if (paramAcao.equals("CadastrarEmpresa")) {
				System.out.println("Cadastrando dados da empresa");
				
				CadastrarEmpresa acao = new CadastrarEmpresa();
				acao.executa(req, resp);
				
			} else  if (paramAcao.equals("EditarEmpresa")) {
				System.out.println("Editando dados da empresa");
				
				EditarEmpresa acao = new EditarEmpresa();
				acao.executa(req, resp);
			}
		
		}
	
}

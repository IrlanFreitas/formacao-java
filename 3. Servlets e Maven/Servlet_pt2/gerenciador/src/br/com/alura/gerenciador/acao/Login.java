package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.dao.Banco;
import br.com.alura.gerenciador.interfaces.Acao;
import br.com.alura.gerenciador.model.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);
				
		Banco banco = new Banco();
		
		if (banco.validaUsuario(usuario)) {
			HttpSession sessao = req.getSession();
			sessao.setAttribute("usuarioLogado", usuario);
			return "redirect:entrada?acao=ListarEmpresas";
		} else {
			return "redirect:entrada?acao=LoginForm";
		}

	}

}

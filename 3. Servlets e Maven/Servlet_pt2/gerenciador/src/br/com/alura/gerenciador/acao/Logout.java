package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.interfaces.Acao;

public class Logout implements Acao {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
//		session.removeAttribute("usuarioLogado");
//      Melhor do que ficar removendo os atributos
//		pois os cookies continuavam.
		
		session.invalidate();
		return "redirect:entrada?acao=LoginForm";
	}

}

package br.com.alura.gerenciador.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.dao.Banco;
import br.com.alura.gerenciador.model.Empresa;

@WebServlet("/empresas")
public class ListarEmpresasService extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Banco banco = new Banco();
		List<Empresa> empresas = banco.getEmpresas();

		String headerAccept = request.getHeader("Accept");

		if (headerAccept.contains("xml")) {
			XStream xStream = new XStream();
			String xml = xStream.toXML(empresas);
			PrintWriter writer = response.getWriter();

			response.setContentType("application/xml");
			writer.print(xml);

		} else if (headerAccept.contains("json")) {
		
			Gson gson = new Gson();
			String json = gson.toJson(empresas);
			PrintWriter writer = response.getWriter();
			response.setContentType("application/json");
			writer.print(json);
		} else {
			PrintWriter writer = response.getWriter();
			response.setContentType("application/json");
			writer.print("{'message': 'no content'}");
		}

//			

	}

}

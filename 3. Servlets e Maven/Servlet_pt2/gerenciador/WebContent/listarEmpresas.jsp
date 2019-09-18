<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="br.com.alura.gerenciador.model.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listagem de Empresas Cadastradas</title>
</head>
<body>

	<c:if test="${not empty empresa}">

		Empresa ${empresa} cadastrada com sucesso!
		
	</c:if>
	<br> Adicionar Empresa:
		<a href="/gerenciador/formNovaEmpresa.jsp">Adicionar</a>
	<br>
	
	<br> Lista de Empresas:
	<br>

	<ul>
		<c:forEach items="${empresas}" var="empresa">
			<li> ${empresa.nome} - 
					<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" /> - 
					<a href="/gerenciador/entrada?acao=ExibirEmpresa&id=${empresa.id}">editar</a> - 
					<a href="/gerenciador/entrada?acao=RemoverEmpresa&id=${empresa.id}">remover</a>
			</li>
		</c:forEach>

	</ul>

</body>
</html>
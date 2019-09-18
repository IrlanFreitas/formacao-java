<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:url value="/novaEmpresa" var="contextServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Cadastro Nova Empresa</title>
</head>
<body>
	
	
	<!-- o c:url pega o contexto atual do projeto, podendo ser
		qualquer um e mesmo assim funciona, como uma variável
		de ambiente -->
	<form action="<c:url value="/entrada?acao=EditarEmpresa"/>" method="post">
		
		<input hidden="true" name="id" value="${empresa.id}"  >
		Nome: <input type="text" name="nome" value="${empresa.nome}" >
		Data Abertura: <input type="date" name="data" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="yyyy-MM-dd" />"   >
		
		<input type="submit" value="Enviar" >
		
	</form>

</body>
</html>
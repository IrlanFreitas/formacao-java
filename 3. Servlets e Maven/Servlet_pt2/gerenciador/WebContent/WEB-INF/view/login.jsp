<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novaEmpresa" var="contextServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login</title>
</head>
<body>
	
	
	<!-- o c:url pega o contexto atual do projeto, podendo ser
		qualquer um e mesmo assim funciona, como uma variável
		de ambiente -->
	<form action="<c:url value="/entrada?acao=Login"/>" method="post">
		
		Nome: <input type="text" name="login" >
		Senha: <input type="password" name="senha" >
		
		<input type="submit" value="Enviar" >
		
	</form>

</body>
</html>
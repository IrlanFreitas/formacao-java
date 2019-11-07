<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Casa do Código</title>
</head>
<body>

	<h1>Lista de Produtos</h1>

	<div>${mensagem}</div>
	<br>
	<br>
	
	<table>
		<thead>
			<tr>
				<td colspan="5" style="text-align: center">Livros</td>
			</tr>
			<tr>
				<td>Id</td>
				<td>Título</td>
				<td>Descrição</td>
				<td>Páginas</td>
				<td>Preços</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${produtos}" var="produto">
				<tr>
					
						<td>${produto.id}</td>
						<td>
							<a href="${s:mvcUrl('PC#detalhe').arg(0, produto.id).build() }">
								${produto.titulo}
							</a>
						</td>
						<td>${produto.descricao}</td>
						<td>${produto.paginas}</td>
						<td></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>
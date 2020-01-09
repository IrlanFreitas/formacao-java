<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Casa do Código</title>
<c:url value="/resources/css" var="cssPath" />
<link rel="stylesheet" href="${cssPath}/bootstrap.min.css" />
<link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css" />

</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${s:mvcUrl('HC#index').build() }">Casa
					do Código</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="${s:mvcUrl('PC#lista').build() }">Lista de
							Produtos</a></li>
					<li><a href="${s:mvcUrl('PC#form').build() }">Cadastro de
							Produtos</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><security:authentication
								property="principal.username" /></a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
	</nav>

	<div class="container">
		<h1>Lista de Produtos</h1>

		<div>${mensagem}</div>
		<br> <br>

		<table class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th>Id</th>
					<th>Título</th>
					<th>Descrição</th>
					<th>Páginas</th>
					<th>Preços</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${produtos}" var="produto">
					<tr>

						<td>${produto.id}</td>
						<td><a
							href="${s:mvcUrl('PC#detalhe').arg(0, produto.id).build() }">
								${produto.titulo} </a></td>
						<td>${produto.descricao}</td>
						<td>${produto.paginas}</td>
						<td>${produto.precos}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


</body>
</html>
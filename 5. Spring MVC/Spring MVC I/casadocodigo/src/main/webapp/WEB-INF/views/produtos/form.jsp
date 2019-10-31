<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html>
<html>  
	<head>
		<meta charset="UTF-8">
		<title>Casa do Código</title>
	</head>
<body>

	<form:form action="${s:mvcUrl('PC#gravar').build() }" method="post" 
		commandName="produto" enctype="multipart/form-data">
		
		<div>
			<label>Título</label> 
			<form:input path="titulo" />
			<form:errors path="titulo" />
		</div>
		<div>
			<label>Descrição</label>
			<form:textarea rows="10" cols="20" path="descricao" />
			<form:errors path="descricao" />
		</div>
		<div>
			<label>Páginas</label> 
			<form:input path="paginas" />
			<form:errors path="paginas" />
		</div>
		<div>
			<label>Data de Lançamento</label> 
			<form:input path="dataLancamento" />
			<form:errors path="dataLancamento" />
		</div>
		<div>
			<c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
				<div>
					<label>${tipoPreco}</label> 
					<form:input path="precos[${status.index}].valor" /> 
					<form:hidden path="precos[${status.index}].tipo" value="${tipoPreco}" />
				</div>

			</c:forEach>
		</div>
		<div>
			<label>Sumário</label>
			<input name="sumario" type="file" />
		
		</div>
		
		<button type="submit">Cadastrar</button>
	</form:form>

</body>
</html>
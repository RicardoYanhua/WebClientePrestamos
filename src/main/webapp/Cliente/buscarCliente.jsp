<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>
<%
String url = "http://localhost:8080/Practica_poo2/";
%>
	<form action="<%=url%>ClienteController">
	
		<input type = "hidden" name = "op" value = "buscar">
		
	
		<label for = "buscar">Buscar Cliente por Nombres o Apellidos</label> <br>
		<input type ="text" id ="buscar" name = "buscar" required>
		
		<input type = "submit" value = "Buscar Cliente"> <br>
		<a type = "button" href ="<%=url%>ClienteController">Volver</a>



	</form>
	

</div>
</body>
</html>
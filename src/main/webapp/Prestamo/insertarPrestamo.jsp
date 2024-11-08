<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "com.unu.practicapoo2.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%
String url = "http://localhost:8080/Practica_poo2/";
int idcliente = (int) request.getAttribute("idcliente");
%>

</head>
<body>

<div>
		<h3>REGISTRAR DEL PRESTAMO DEL CLIENTE <%=idcliente%></h3> <br>
		<form rol = "form "action="<%=url%>PrestamoController">
			<input type = "hidden" name = "op" value= "insertar">
			<input type = "hidden" name = "referenciaCliente" value= "<%=idcliente%>">
			
				<label for = "fecha">Fecha</label>
				<input type = "date" id = "fecha" name = "fecha" required> <br>
				
				<label for = "monto">Monto</label>
				<input type = "number" id = "monto" name = "monto" min = "0" required> <br>
				
				<label for = "interes">Interes</label>
				<input type = "number" id = "interes" name = "interes" step="0.01" min="0" required> <br>
				
				<label for = "cuotas">Cuota</label>
				<input type = "number" id = "cuotas" name = "cuotas"  min="0" required> <br>
			
			<input type = "submit" value="Registrar Prestamo del cliente"> <br>
			<a type = "button" href = "<%=url%>PrestamoController">Volver Lista de Prestamos</a>
		
		
		
		</form>
	
	
	</div>
</body>
</html>
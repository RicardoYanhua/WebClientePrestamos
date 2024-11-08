<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error 404</title>
</head>

<%
String Message = String.valueOf(request.getAttribute("message"));

String url = "http://localhost:8080/Practica_poo2/";

%>
<body>
<div>
<h2>Mensaje del sistemas</h2> <br>
<h3><%=Message%></h3><br>
<a type = "button" href = "<%=url%>">Volver al Menu de Opciones</a>
</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	
	body{
		display: flex;
		justify-content: center;
		align-items: center;
		height: 100vh;
		margin: 0;
		background-color: rgb(245,245,255);
	}
	
	div{
		width: 80%;
		border : 1px solid rgb(220,220,220);
		box-shadow: 0px 0px 10px 5px rgba(0,0,0,0.2);
		background-color: rgb(255,255,255);
		border-radius: 8px;
		padding: 15px;
	}


</style>

<%
String url = "http://localhost:8080/Practica_poo2/";
%>
</head>
<body>

	<div>
		
		<h3>Menu</h3>
		
		<a type = "button" href = "ClienteController">Clientes</a> <br>
		<a type = "button" href = "PrestamoController">Prestamos</a>
		
	</div>


</body>
</html>
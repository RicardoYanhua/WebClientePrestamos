<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%
String url = "http://localhost:8080/Practica_poo2/";
%>
<script>
    function confirmarAccion() {
        return confirm("¿Estás seguro de que deseas realizar esta acción?");
    }
</script>
</head>
<body>


	<div>
		<h3>DATOS DEL CLIENTE NUEVO</h3> <br>
		<form rol = "form "action="<%=url%>ClienteController">
			<input type = "hidden" name = "op" value= "insertar">
			
				<label for = "nombres">Nombres</label>
				<input type = "text" id = "nombres" name = "nombres" required> <br>
				
				<label for = "apellidos">Apellidos</label>
				<input type = "text" id = "apelldos" name = "apellidos" required> <br>
				
				<label for = "dni">DNI</label>
				<input type = "text" id = "dni" name = "dni" required> <br>
				
				<label for = "fechaNacimiento">Fecha de nacimiento</label>
				<input type = "date" id = "fechaNacimiento" name = "fechaNacimiento" required> <br>
			
				<label for = "direccion">Direccion</label>
				<input type = "text" id = "direccion" name = "direccion" required> <br>
			
			<input type = "submit" onclick="return confirmarAccion()"  value="Registrar Cliente"> <br>
			<a type = "button" href = "<%=url%>ClienteController">Volver Lista Clientes</a>
		
		
		
		</form>
	
	
	</div>

</body>
</html>
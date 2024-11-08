<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "com.unu.practicapoo2.beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%
String url = "http://localhost:8080/Practica_poo2/";
Cliente cliente;
if(request.getAttribute("clienteEditar") !=null){
	cliente = (Cliente) request.getAttribute("clienteEditar");
}else{
	cliente  = new Cliente();
}
%>
</head>
<body>


	<div>
		<h3>DATOS DEL CLIENTE</h3> <br>
		
		<form rol = "form "action="<%=url%>ClienteController">
			<input type = "hidden" name = "op" value= "modificar">
			<input type = "hidden" name = "id" value= "<%=cliente.getIDCliente()%>">
			
				<label for = "nombres">Nombres</label>
				<input type = "text" id = "nombres" name = "nombres" value = "<%=cliente.getNombres()%>"> <br>
				
				<label for = "apellidos">Apellidos</label>
				<input type = "text" id = "apelldos" name = "apellidos" value = "<%=cliente.getApellidos()%>"> <br>
				
				<label for = "dni">DNI</label>
				<input type = "text" id = "dni" name = "dni" value = "<%=cliente.getDNI()%>"> <br>
				
				<label for = "fechaNacimiento">Fecha de nacimiento</label>
				<input type = "date" id = "fechaNacimiento" name = "fechaNacimiento" value = "<%=cliente.getFechaNacimiento()%>"> <br>
			
				<label for = "direccion">Direccion</label>
				<input type = "text" id = "direccion" name = "direccion" value = "<%=cliente.getDireccion()%>"> <br>
			
			<input type = "submit" value="Guargar Cliente">
			<a type = "button" href = "<%=url%>ClienteController">Volver Lista Clientes</a>
		
		
		
		</form>
	
	
	</div>

</body>
</html>
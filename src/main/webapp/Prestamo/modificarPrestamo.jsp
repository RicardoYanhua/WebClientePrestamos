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
Prestamo prestamo;
if(request.getAttribute("prestamoEditar") !=null){
	prestamo = (Prestamo) request.getAttribute("prestamoEditar");
}else{
	prestamo  = new Prestamo();
}
%>
</head>
<body>


	<div>
		<h3>Prestamo del cliente</h3> <br>
		
		<form rol = "form "action="<%=url%>PrestamoController">
			<input type = "hidden" name = "op" value= "modificar">
			<input type = "hidden" name = "id" value= "<%=prestamo.getIDPrestamo()%>">
			<input type = "hidden" name = "referenciaCliente" value= "<%=prestamo.getReferenciaCliente()%>">
			
				<label for = "fecha">Fecha</label>
				<input type = "date" id = "fecha" name = "fecha" value = "<%=prestamo.getFecha()%>"> <br>
				
				<label for = "monto">Monto</label>
				<input type = "number" id = "monto" name = "monto" min = "0" value = "<%=prestamo.getMonto()%>"> <br>
				
				<label for = "interes">Interes</label>
				<input type = "number" id = "interes" name = "interes" step="0.01" min="0" value = "<%=prestamo.getInteres()%>"> <br>
				
				<label for = "cuotas">Cuota</label>
				<input type = "number" id = "cuotas" name = "cuotas"  min="0" value = "<%=prestamo.getCuotas()%>"> <br>
			
			
			
			<input type = "submit" value="Guargar Prestamo">
			<a type = "button" href = "<%=url%>ClienteController">Volver Lista Clientes</a>
		
		
		
		</form>
	
	
	</div>

</body>
</html>
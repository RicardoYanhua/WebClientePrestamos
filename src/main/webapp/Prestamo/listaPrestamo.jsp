<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import= "com.unu.practicapoo2.beans.*" %>
    <%@page import= "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<%
	String url = "http://localhost:8080/Practica_poo2/";
	List<Prestamo> listaPrestamo = (List<Prestamo>) request.getAttribute("listaPrestamo");
	%>

</head>
<body>

<h3>Lista de Prestamos</h3>
	<div>
	
		<table>
		
			<thead>
				<tr>
					<th>ID Prestamo</th>
					<th>FECHA PRESTAMO	</th>
					<th>MONTO</th>
					<th>REFERENCIA DEL CLIENTE</th>
					<th>INTERES</th>
					<th>N° CUOTAS</th>
					
				</tr>
			
			</thead>
			
			<tbody>
				<%
				
				if(listaPrestamo !=null){
					for(Prestamo p: listaPrestamo){
				%>	
				<tr>
					<td><%=p.getIDPrestamo()%></td>
					<td><%=p.getFecha()%></td>
					<td><%=p.getMonto()%></td>
					<td><%=p.getReferenciaCliente()%></td>
					<td><%=p.getInteres()%></td>
					<td><%=p.getCuotas()%></td>
					
				</tr>
				<%	
				}}else{
				%>
				
				<tr>
					<td colspan = "7">Sin datos de clientes</td>
				</tr>
				
				<%
				}
				%>
				
				
			
			
			</tbody>
		
		
		</table>
		<a type = "button" href = "<%=url%>"> volver</a>
	
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import= "com.unu.practicapoo2.beans.*" %>
    <%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<%
	String url = "http://localhost:8080/Practica_poo2/";
	int id = (int)(request.getAttribute("idCliente"));
	
	%>
<script>
    function confirmarAccion() {
        return confirm("¿Estás seguro de que deseas realizar esta acción?");
    }
</script>
</head>
<body>

<h3>Lista de Prestamos del Cliente <%=id%></h3>
	<div>
	<a type = "button" href = "<%=url%>PrestamoController?op=nuevo&id=<%=id%>"> Nuevo Prestamo</a>
		<table>
		
			<thead>
				<tr>
					<th>N°</th>
					<th>ID PRESTAMO</th>
					<th>FECHA PRESTAMO</th>
					<th>NOMBRE CIENTE</th>
					<th>MONTO </th>
					<th>INTERES </th>
					<th>N° CUOTAS</th>
					<th>OPERACIONES</th>
				</tr>
			
			</thead>
			
			<tbody>
				<%
				List<Object[]> listaPrestamosCliente = (List<Object[]>)request.getAttribute("listaPrestamosCliente");
				if(listaPrestamosCliente !=null){
					for(Object[] c: listaPrestamosCliente){
				%>	
				<tr>
					<td><%=c[0]%></td>
					<td><%=c[1]%></td>
					<td><%=c[2]%></td>
					<td><%=c[3]%></td>
					<td><%=c[4]%></td>
					<td><%=c[5]%></td>
					<td><%=c[6]%></td>
					<td>
						<a type = "button" href = "<%=url%>PrestamoController?op=obtener&id=<%=c[1]%>"> Modificar</a>
						<a type = "button" onclick="return confirmarAccion()" href = "<%=url%>PrestamoController?op=eliminar&id=<%=c[1]%>&cliente=<%=id%>"> Eliminar</a>
						
						
					
					</td>
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
		<a type = "button" href = "<%=url%>ClienteController"> volver</a>
	
	</div>
</body>
</html>
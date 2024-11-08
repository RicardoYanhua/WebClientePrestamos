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
	List<Cliente> listaClientes = (List<Cliente>) request.getAttribute("listaClientes");
	%>

</head>
<body>

<h3>Lista de clientes</h3>
	<div>
	<a type = "button" href = "<%=url%>ClienteController?op=nuevo"> Nuevo Cliente</a><br>
	
	<a type = "button" href = "<%=url%>ClienteController?op=busqueda"> Buscar Cliente</a><br>
	<a type = "button" href = "<%=url%>ClienteController"> Todos los clientes</a><br>
	
	
		<table>
		
			<thead>
				<tr>
					<th>ID Cliente</th>
					<th>NOMBRES</th>
					<th>APELLIDOS</th>
					<th>DNI</th>
					<th>FECHA NACIMIENTO</th>
					<th>DIRECCION</th>
					<th>OPERACIONES</th>
				</tr>
			
			</thead>
			
			<tbody>
				<%
				
				if(listaClientes !=null){
					for(Cliente c: listaClientes){
				%>	
				<tr>
					<td><%=c.getIDCliente()%></td>
					<td><%=c.getNombres()%></td>
					<td><%=c.getApellidos()%></td>
					<td><%=c.getDNI()%></td>
					<td><%=c.getFechaNacimiento()%></td>
					<td><%=c.getDireccion()%></td>
					<td>
						<a type = "button" href = "<%=url%>ClienteController?op=obtenerCliente&id=<%=c.getIDCliente()%>"> Modificar Datos</a>
						<a type = "button" href = "<%=url%>ClienteController?op=eliminar&id=<%=c.getIDCliente()%>"> Eliminar Cliente</a>
						<a type = "button" href = "<%=url%>PrestamoController?op=cargarPrestamosCliente&id=<%=c.getIDCliente()%>"> Prestamo</a>
						
					
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
		<a type = "button" href = "<%=url%>"> volver</a>
	
	</div>
</body>
</html>
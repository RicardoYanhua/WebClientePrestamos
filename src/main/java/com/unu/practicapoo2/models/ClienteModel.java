package com.unu.practicapoo2.models;

import java.security.Timestamp;
import java.sql.*;
import java.sql.Date;
import java.util.*;

import com.unu.practicapoo2.beans.Cliente;
import com.unu.practicapoo2.utils.Conexion;

public class ClienteModel  extends Conexion{
	
	CallableStatement cs ;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	
	public List<Object[]> listIDandNameCliente(){
		try {
			this.abrirConexion();
			List<Object[]> lista = new ArrayList<>();
			String sql = "select idcliente,nombres,apellidos from cliente";
			st = conexion.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				lista.add(new Object[] {rs.getInt("idcliente"),rs.getString("nombres") + " "  + rs.getString("apellidos")});
			}
			return lista;
			
		} catch (SQLException e) {
			System.out.println("Error en ClienteModel.listIDandNameCliente()  : \n " + e.getMessage().toString());
			return null;
		}finally {
			this.cerrarUtilidades(cs,st,pst,rs);
			this.cerrarConexion();
		}
	}
	
	public String getnameClientebyIdCliente(int idCliente) {
		try {
			
			this.abrirConexion();
			String sql = "select nombres,apellidos from cliente where idcliente = ?";
			pst = conexion.prepareStatement(sql);
			pst.setInt(1, idCliente);
			rs = pst.executeQuery();
			rs.next();
			return "" + rs.getString("nombres") + ", "+  rs.getString("apellidos");
			
		} catch (SQLException e) {
			System.out.println("Error en ClienteModel.getnameClientebyIdCliente()  : \n " + e.getMessage().toString());
			return null;
		}finally {
			this.cerrarUtilidades(cs,st,pst,rs);
			this.cerrarConexion();
		}
	}
	
	public List<Cliente> listarClientes() {
		
		try {
			this.abrirConexion();
			List<Cliente> lista = new ArrayList<>();
			String sql = "select * from cliente";
			st = conexion.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setIDCliente(rs.getInt("idcliente"));
				cliente.setNombres(rs.getString("nombres"));
				cliente.setApellidos(rs.getString("apellidos"));
				cliente.setDNI(rs.getString("dni"));
				cliente.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
				cliente.setDireccion(rs.getString("direccion"));
				lista.add(cliente);
			}
			return lista;
			
		} catch (SQLException e) {
			System.out.println("Error en ClienteModel.listarClientes()  : \n " + e.getMessage().toString());
			return null;
		}finally {
			this.cerrarUtilidades(cs,st,pst,rs);
			this.cerrarConexion();
		}
		
	}
	
	public int insertarCliente(Cliente nuevoCliente) {
		
		try {
			this.abrirConexion();
			int filasAfectadas =0;
			
			String sql = ""
					+ "insert into cliente ("
					+ "idcliente,nombres,apellidos,dni,fechaNacimiento,direccion) "
					+ "values(?,?,?,?,?,?)";
			
			pst = conexion.prepareStatement(sql);
			pst.setInt(1, 0);
			pst.setString(2, nuevoCliente.getNombres());
			pst.setString(3, nuevoCliente.getApellidos());
			pst.setString(4, nuevoCliente.getDNI());
			pst.setDate(5,Date.valueOf(nuevoCliente.getFechaNacimiento()));
			pst.setString(6, nuevoCliente.getDireccion());
			filasAfectadas = pst.executeUpdate();
			
			
			return filasAfectadas;
			
		} catch (SQLException e) {
			System.out.println("Error en ClienteModel.insertarCliente()  : \n " + e.getMessage().toString());
			return 0;
		}finally {
			this.cerrarUtilidades(cs,st,pst,rs);
			this.cerrarConexion();
		}
		
	}
	
	public int modificarCliente(Cliente modificarCliente) {
		
		try {
			this.abrirConexion();
			int filasAfectadas =0;
			
			String sql = ""
					+ "update cliente "
					+ "set "
					+ "nombres = ?, "
					+ "apellidos = ?, "
					+ "dni = ?, "
					+ "fechaNacimiento = ?, "
					+ "direccion = ? "
					+ "where idcliente = ?";
			
			pst = conexion.prepareStatement(sql);
			pst.setString(1, modificarCliente.getNombres());
			pst.setString(2, modificarCliente.getApellidos());
			pst.setString(3, modificarCliente.getDNI());
			pst.setDate(4,Date.valueOf(modificarCliente.getFechaNacimiento()));
			pst.setString(5, modificarCliente.getDireccion());
			pst.setInt(6, modificarCliente.getIDCliente());
			filasAfectadas = pst.executeUpdate();
			
			
			return filasAfectadas;
			
		} catch (SQLException e) {
			System.out.println("Error en ClienteModel.modificarCliente()  : \n " + e.getMessage().toString());
			return 0;
		}finally {
			this.cerrarUtilidades(cs,st,pst,rs);
			this.cerrarConexion();
		}
		
	}
	public Cliente obtenerCliente(int idCliente) {
		
		try {
			this.abrirConexion();
			
			String sql = ""
					+ "select * from cliente "
					+ "where idcliente = ?";
			
			pst = conexion.prepareStatement(sql);
			pst.setInt(1, idCliente);
			rs = pst.executeQuery();
			rs.next();
			Cliente cliente = new Cliente();
			cliente.setIDCliente(rs.getInt("idcliente"));
			cliente.setNombres(rs.getString("nombres"));
			cliente.setApellidos(rs.getString("apellidos"));
			cliente.setDNI(rs.getString("dni"));
			cliente.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
			cliente.setDireccion(rs.getString("direccion"));
			return cliente;
			
		} catch (SQLException e) {
			System.out.println("Error en ClienteModel.modificarCliente()  : \n " + e.getMessage().toString());
			return null;
		}finally {
			this.cerrarUtilidades(cs,st,pst,rs);
			this.cerrarConexion();
		}
		
	}
	
	public List<Cliente> obtenerClienteBusquedaByNombresAndApellidos(String nombreAndApelldiosCliente) {
		
		try {
			this.abrirConexion();
			
			String sql = ""
					+ "select * from cliente "
					+ "where nombres like ?";
			List<Cliente> listaBusqueda = new ArrayList<>();
			pst = conexion.prepareStatement(sql);
			pst.setString(1, '%' + nombreAndApelldiosCliente + '%');
			//pst.setString(2, "%" + nombreAndApelldiosCliente);
			rs = pst.executeQuery();
			while(rs.next()) {
			Cliente cliente = new Cliente();
			cliente.setIDCliente(rs.getInt("idcliente"));
			cliente.setNombres(rs.getString("nombres"));
			cliente.setApellidos(rs.getString("apellidos"));
			cliente.setDNI(rs.getString("dni"));
			cliente.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
			cliente.setDireccion(rs.getString("direccion"));
			listaBusqueda.add(cliente);
			System.out.println("hola");
			}
			return listaBusqueda;
			
		} catch (SQLException e) {
			System.out.println("Error en ClienteModel.modificarCliente()  : \n " + e.getMessage().toString());
			return null;
		}finally {
			this.cerrarUtilidades(cs,st,pst,rs);
			this.cerrarConexion();
		}
		
	}
	
	public int eliminarCliente(int idCliente) {
		
		try {
			this.abrirConexion();
			int filasAfectadas =0;
			
			String sql = ""
					+ "delete from cliente "
					+ "where idcliente = ?";
			
			pst = conexion.prepareStatement(sql);
			pst.setInt(1, idCliente);
			filasAfectadas = pst.executeUpdate();
			
			return filasAfectadas;
			
		} catch (SQLException e) {
			System.out.println("Error en ClienteModel.eliminarCliente()  : \n " + e.getMessage().toString());
			return 0;
		}finally {
			this.cerrarUtilidades(cs,st,pst,rs);
			this.cerrarConexion();
		}
		
	}
	
	

}

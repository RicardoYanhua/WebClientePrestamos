package com.unu.practicapoo2.models;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.unu.practicapoo2.beans.Cliente;
import com.unu.practicapoo2.beans.Prestamo;
import com.unu.practicapoo2.utils.Conexion;

public class PrestamoModel extends Conexion{
	
	CallableStatement cs ;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	
	public List<Prestamo> listarPrestamo() {
		
		try {
			this.abrirConexion();
			List<Prestamo> lista = new ArrayList<>();
			
			String sql = "select * from prestamo";
			st = conexion.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Prestamo prestamo = new Prestamo();
				prestamo.setIDPrestamo(rs.getInt("idprestamo"));
				prestamo.setFecha(rs.getDate("fecha").toLocalDate());
				prestamo.setMonto(rs.getDouble("monto"));
				prestamo.setReferenciaCliente(rs.getInt("referenciaCliente"));
				prestamo.setInteres(rs.getDouble("interes"));
				prestamo.setCuotas(rs.getInt("cuotas"));
				lista.add(prestamo);
			}
			return lista;
			
		} catch (SQLException e) {
			System.out.println("Error en PrestamoModel.listarPrestamo()  : \n " + e.getMessage().toString());
			return null;
		}finally {
			this.cerrarUtilidades(cs,st,pst,rs);
			this.cerrarConexion();
		}
		
	}
	
	public List<Object[]> listaPrestamosCliente(int idCliente) {
		
		try {
			this.abrirConexion();
			ClienteModel modelCliente = new ClienteModel();
			List<Object[]> lista = new ArrayList<>();
			int filas = 0;
			String sql = "select * from prestamo where referenciaCliente = ?";
			pst = conexion.prepareStatement(sql);
			pst.setInt(1, idCliente);
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				filas++;
				lista.add(new Object[] {
						filas,
						rs.getInt("idprestamo"),
						rs.getDate("fecha").toLocalDate(),
						modelCliente.getnameClientebyIdCliente(rs.getInt("referenciaCliente")),
						rs.getDouble("monto"),
						rs.getDouble("interes"),
						rs.getInt("cuotas")
						//rs.getInt("referenciaCliente")
						
				});
				
				
				}
			
			return lista;
			
		} catch (SQLException e) {
			System.out.println("Error en PrestamoModel.listaPrestamosCliente()  : \n " + e.getMessage().toString());
			return null;
		}finally {
			this.cerrarUtilidades(cs,st,pst,rs);
			this.cerrarConexion();
		}
	}
	
	public int insertarPrestamo(Prestamo nuevoPrestamo) {
		
		try {
			this.abrirConexion();
			int filasAfectadas =0;
			
			String sql = ""
					+ "insert into prestamo ("
					+ "idprestamo,fecha,monto,referenciaCliente,interes,cuotas) "
					+ "values(?,?,?,?,?,?)";
			
			pst = conexion.prepareStatement(sql);
			pst.setInt(1, 0);
			pst.setDate(2, Date.valueOf(nuevoPrestamo.getFecha()));
			pst.setDouble(3, nuevoPrestamo.getMonto());
			pst.setInt(4, nuevoPrestamo.getReferenciaCliente());
			pst.setDouble(5,nuevoPrestamo.getInteres());
			pst.setInt(6, nuevoPrestamo.getCuotas());
			filasAfectadas = pst.executeUpdate();
			
			return filasAfectadas;
			
		} catch (SQLException e) {
			System.out.println("Error en PrestamoModel.insertarPrestamo()  : \n " + e.getMessage().toString());
			return 0;
		}finally {
			this.cerrarUtilidades(cs,st,pst,rs);
			this.cerrarConexion();
		}
		
	}
	public int modificarPrestamo(Prestamo modificarPrestamo) {
		
		try {
			this.abrirConexion();
			int filasAfectadas =0;
			
			String sql = ""
					+ "update prestamo "
					+ "set "
					+ "fecha = ?, "
					+ "monto = ?, "
					+ "referenciaCliente = ?, "
					+ "interes = ?, "
					+ "cuotas = ? "
					+ "where idprestamo = ?";
			
			pst = conexion.prepareStatement(sql);
			pst.setDate(1, Date.valueOf(modificarPrestamo.getFecha()));
			pst.setDouble(2, modificarPrestamo.getMonto());
			pst.setInt(3, modificarPrestamo.getReferenciaCliente());
			pst.setDouble(4, modificarPrestamo.getInteres());
			pst.setInt(5, modificarPrestamo.getCuotas());
			pst.setInt(6, modificarPrestamo.getIDPrestamo());
			filasAfectadas = pst.executeUpdate();
			
			return filasAfectadas;
			
		} catch (SQLException e) {
			System.out.println("Error en PrestamoModel.modificarPrestamo()  : \n " + e.getMessage().toString());
			return 0;
		}finally {
			this.cerrarUtilidades(cs,st,pst,rs);
			this.cerrarConexion();
		}
		
	}
	public Prestamo obtenerPrestamo(int idPrestamo) {
		
		try {
			this.abrirConexion();
			
			String sql = ""
					+ "select * from prestamo "
					+ "where idprestamo = ?";
			
			pst = conexion.prepareStatement(sql);
			pst.setInt(1, idPrestamo);
			rs = pst.executeQuery();
			rs.next();
			Prestamo prestamo = new Prestamo();
			prestamo.setIDPrestamo(rs.getInt("idprestamo"));
			prestamo.setFecha(rs.getDate("fecha").toLocalDate());
			prestamo.setMonto(rs.getDouble("monto"));
			prestamo.setReferenciaCliente(rs.getInt("referenciaCliente"));
			prestamo.setInteres(rs.getDouble("interes"));
			prestamo.setCuotas(rs.getInt("cuotas"));
			return prestamo;
			
		} catch (SQLException e) {
			System.out.println("Error en PrestamoModel.obtenerPrestamo()  : \n " + e.getMessage().toString());
			return null;
		}finally {
			this.cerrarUtilidades(cs,st,pst,rs);
			this.cerrarConexion();
		}
		
	}
	
	public int eliminarPrestamo(int idPrestamo) {
		
		try {
			this.abrirConexion();
			int filasAfectadas =0;
			
			String sql = ""
					+ "delete from prestamo "
					+ "where idprestamo = ?";
			
			pst = conexion.prepareStatement(sql);
			pst.setInt(1, idPrestamo);
			filasAfectadas = pst.executeUpdate();
			
			return filasAfectadas;
			
		} catch (SQLException e) {
			System.out.println("Error en PrestamoModel.eliminarPrestamo()  : \n " + e.getMessage().toString());
			return 0;
		}finally {
			this.cerrarUtilidades(cs,st,pst,rs);
			this.cerrarConexion();
		}
		
	}
}

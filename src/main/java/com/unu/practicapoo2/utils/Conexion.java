package com.unu.practicapoo2.utils;

import java.sql.*;

public class Conexion {

	protected Connection conexion;

	public void abrirConexion() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/practicapoo2", "root",
					"123456");
			if (conexion != null) {
				System.out.println("Conexion Exitosa");
			}

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error en  Conexion.abrirConexion() \n" + e.getMessage().toString());
		}

	}

	public void cerrarUtilidades(AutoCloseable...close ) {
		try {
		
			for(AutoCloseable c : close) {
				if(c !=null) {
					c.close();
				}
				
			}
			
		} catch (Exception e) {
			System.out.println("Error en  Conexion.cerrarConexion() \n" + e.getMessage().toString());
		}
	}

	public void cerrarConexion() {
		try {
			if(conexion !=null || !conexion.isClosed()) {
				conexion.close();
			}
			
		} catch (SQLException e) {
			System.out.println("Error en  Conexion.cerrarConexion() \n" + e.getMessage().toString());
		}
	}

}

package com.unu.practicapoo2.beans;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Cliente {
	
	private int IDCliente;
	private String Nombres;
	private String Apellidos;
	private String DNI;
	private LocalDate  FechaNacimiento;
	private String Direccion;
	
	public Cliente() {
		this(0,"","","",LocalDate.now(),"");
	}
	
	public Cliente(int iDClientes, String nombres, String apellidos, String dNI, LocalDate fechaNacimiento,
			String direccion) {
		super();
		IDCliente = iDClientes;
		Nombres = nombres;
		Apellidos = apellidos;
		DNI = dNI;
		FechaNacimiento = fechaNacimiento;
		Direccion = direccion;
	}
	
	public int getIDCliente() {
		return IDCliente;
	}
	public void setIDCliente(int iDClientes) {
		IDCliente = iDClientes;
	}
	public String getNombres() {
		return Nombres;
	}
	public void setNombres(String nombres) {
		Nombres = nombres;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public LocalDate getFechaNacimiento() {
		return FechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

}

package com.unu.practicapoo2.beans;

import java.time.LocalDate;

public class Prestamo {
	
	private int IDPrestamo;
	private LocalDate Fecha;
	private double Monto;
	private int ReferenciaCliente;
	private double Interes;
	private int cuotas;
	
	public Prestamo() {
		this(0,LocalDate.now(),0.0,0,0.0,0);
	}
	
	public Prestamo(int iDPrestamo, LocalDate fecha, double monto, int referenciaCliente, double interes,
			int cuotas) {
		super();
		IDPrestamo = iDPrestamo;
		Fecha = fecha;
		Monto = monto;
		ReferenciaCliente = referenciaCliente;
		Interes = interes;
		this.cuotas = cuotas;
	}
	
	
	public int getIDPrestamo() {
		return IDPrestamo;
	}
	public void setIDPrestamo(int iDPrestamo) {
		IDPrestamo = iDPrestamo;
	}
	public LocalDate getFecha() {
		return Fecha;
	}
	public void setFecha(LocalDate fecha) {
		Fecha = fecha;
	}
	public double getMonto() {
		return Monto;
	}
	public void setMonto(double monto) {
		Monto = monto;
	}
	public int getReferenciaCliente() {
		return ReferenciaCliente;
	}
	public void setReferenciaCliente(int referenciaCliente) {
		ReferenciaCliente = referenciaCliente;
	}
	public double getInteres() {
		return Interes;
	}
	public void setInteres(double interes) {
		Interes = interes;
	}
	public int getCuotas() {
		return cuotas;
	}
	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}
	
	
	
	

}

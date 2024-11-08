package com.unu.practicapoo2.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.unu.practicapoo2.beans.Cliente;
import com.unu.practicapoo2.beans.Prestamo;
import com.unu.practicapoo2.models.ClienteModel;
import com.unu.practicapoo2.models.PrestamoModel;

@WebServlet("/PrestamoController")
public class PrestamoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrestamoModel model = new PrestamoModel();
  
    public PrestamoController() {super();}
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String op = request.getParameter("op") == null? "" : request.getParameter("op");
			
			switch (op) {
			case "insertar": 
				insertarPrestamo(request, response);
				break;
			case "nuevo":
				nuevoPrestamo(request,response);
				break;
			case "cargarPrestamosCliente":
				cargarPrestamosCliente(request,response);
				break;
			case "obtener":
				obtenerPrestamo(request,response);
				break;
			case "modificar":
				modificarPrestamo(request,response);
				break;
			case "eliminar":
				eliminarPrestamo(request,response);
				break;
			default:
				listarPrestamo(request,response);
			}
			
			
			
		} catch (Exception e) {
			System.out.println("Error en PrestamoController.processRequest() \n " + e.getMessage().toString());
			e.printStackTrace();
		}
	}
    
    private void eliminarPrestamo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			if(model.eliminarPrestamo(id) > 0) {
				
				response.sendRedirect(request.getContextPath() + "/PrestamoController?op=cargarPrestamosCliente&id=" + request.getParameter("cliente"));
			} else {
				
				request.setAttribute("message", "Error de Eliminacion");
				request.getRequestDispatcher("/Error404.jsp").forward(request, response);
			}
			
			
		} catch (Exception e) {
			System.out.println("Error en PrestamoController.eliminarPrestamo() \n " + e.getMessage().toString());
			e.printStackTrace();
		}
	}
	
	private void obtenerPrestamo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Prestamo obtenerPrestamo = model.obtenerPrestamo(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("prestamoEditar",obtenerPrestamo);
			request.getRequestDispatcher("/Prestamo/modificarPrestamo.jsp").forward(request, response);
			
		} catch (Exception e) {
			System.out.println("Error en PrestamoController.obtenerPrestamo() \n " + e.getMessage().toString());
			e.printStackTrace();
		}
	}
	private void modificarPrestamo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			Prestamo modificarPrestamo = new Prestamo();
			modificarPrestamo.setIDPrestamo(Integer.parseInt(request.getParameter("id")));
			LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));
			modificarPrestamo.setFecha(fecha);
			modificarPrestamo.setMonto(Double.parseDouble(request.getParameter("monto")));
			modificarPrestamo.setReferenciaCliente(Integer.parseInt(request.getParameter("referenciaCliente")));
			modificarPrestamo.setInteres(Double.parseDouble(request.getParameter("interes")));
			modificarPrestamo.setCuotas(Integer.parseInt(request.getParameter("cuotas")));
			
			if(model.modificarPrestamo(modificarPrestamo) > 0) {
				
				response.sendRedirect(request.getContextPath() + "/PrestamoController?op=cargarPrestamosCliente&id=" + modificarPrestamo.getReferenciaCliente());
			} else {
				
				request.setAttribute("message", "Error de Modificacion");
				request.getRequestDispatcher("/Error404.jsp").forward(request, response);
			}
			
			
		} catch (Exception e) {
			System.out.println("Error en PrestamoController.modificarPrestamo() \n " + e.getMessage().toString());
			e.printStackTrace();
		}
	}
    
    private void cargarPrestamosCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int idCliente = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("idCliente", idCliente);
			request.setAttribute("listaPrestamosCliente", model.listaPrestamosCliente(idCliente));
			request.getRequestDispatcher("/Cliente/listadoPrestamosCliente.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			System.out.println("Error en PrestamoController.cargarPrestamosCliente() \n " + e.getMessage().toString());
			e.printStackTrace();
		}
	}
    
	private void listarPrestamo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("listaPrestamo", model.listarPrestamo());
			request.getRequestDispatcher("/Prestamo/listaPrestamo.jsp").forward(request, response);
			
		} catch (Exception e) {
			System.out.println("Error en PrestamoController.listarPrestamo() \n " + e.getMessage().toString());
			e.printStackTrace();
		}
	}
	private void nuevoPrestamo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("idcliente", Integer.parseInt(request.getParameter("id")));
			request.getRequestDispatcher("/Prestamo/insertarPrestamo.jsp").forward(request, response);
			
		} catch (Exception e) {
			System.out.println("Error en PrestamoController.nuevoPrestamo() \n " + e.getMessage().toString());
			e.printStackTrace();
		}
	}
	
	
	private void insertarPrestamo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			Prestamo nuevo = new Prestamo();
			LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));
			nuevo.setFecha(fecha);
			nuevo.setMonto(Double.parseDouble(request.getParameter("monto")));
			nuevo.setReferenciaCliente(Integer.parseInt(request.getParameter("referenciaCliente")));
			nuevo.setInteres(Double.parseDouble(request.getParameter("interes")));
			nuevo.setCuotas(Integer.parseInt(request.getParameter("cuotas")));
			
			if(model.insertarPrestamo(nuevo) > 0) {
				
				request.setAttribute("idCliente", nuevo.getReferenciaCliente());
				request.setAttribute("listaPrestamosCliente", model.listaPrestamosCliente(nuevo.getReferenciaCliente()));
				request.getRequestDispatcher("/Cliente/listadoPrestamosCliente.jsp").forward(request, response);
			} else {
				
				request.setAttribute("message", "Error de Insercion");
				request.getRequestDispatcher("/Error404.jsp").forward(request, response);
			}
			
			
			
			
		} catch (Exception e) {
			System.out.println("Error en PrestamoController.insertarPrestamo() \n " + e.getMessage().toString());
			e.printStackTrace();
		}
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}

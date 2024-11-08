package com.unu.practicapoo2.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Iterator;

import com.unu.practicapoo2.beans.Cliente;
import com.unu.practicapoo2.models.ClienteModel;

@WebServlet("/ClienteController")
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClienteModel model = new ClienteModel();

	public ClienteController() {
		super();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String op = request.getParameter("op") == null ? "" : request.getParameter("op");

			switch (op) {
			case "insertar":
				insertarCliente(request, response);
				break;
			case "nuevo":
				nuevoCliente(request, response);
				break;
			case "obtenerCliente":
				obtenerCliente(request, response);
				break;
			case "modificar":
				modificarCliente(request, response);
				break;
			case "eliminar":
				eliminarCliente(request, response);
				break;
			case "busqueda":
				busquedaCliente(request, response);
				break;
			case "buscar":
				listarBusquedaCliente(request, response);
				break;

			default:
				listarClientes(request, response);
			}

		} catch (Exception e) {
			System.out.println("Error en ClienteController.processRequest() \n " + e.getMessage().toString());
			e.printStackTrace();
		}
	}

	private void listarBusquedaCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setAttribute("listaClientes",
					model.obtenerClienteBusquedaByNombresAndApellidos(request.getParameter("buscar")));
			request.getRequestDispatcher("/Cliente/listaCliente.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println("Error en ClienteController.listarClientes() \n " + e.getMessage().toString());
			e.printStackTrace();
		}
	}

	private void busquedaCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			request.getRequestDispatcher("/Cliente/buscarCliente.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println("Error en ClienteController.obtenerCliente() \n " + e.getMessage().toString());
			e.printStackTrace();
		}
	}

	private void eliminarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			int id = Integer.parseInt(request.getParameter("id"));

			if (model.eliminarCliente(id) > 0) {
				response.sendRedirect(request.getContextPath() + "/ClienteController");
			} else {
				request.setAttribute("message", "Error de Eliminacion");
				request.getRequestDispatcher("/Error404.jsp").forward(request, response);
			}

		} catch (Exception e) {
			System.out.println("Error en ClienteController.obtenerCliente() \n " + e.getMessage().toString());
			e.printStackTrace();
		}
	}

	private void obtenerCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Cliente obtenerCliente = model.obtenerCliente(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("clienteEditar", obtenerCliente);
			request.getRequestDispatcher("/Cliente/modificarCliente.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println("Error en ClienteController.obtenerCliente() \n " + e.getMessage().toString());
			e.printStackTrace();
		}
	}

	private void modificarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			Cliente ClienteModificado = new Cliente();
			ClienteModificado.setIDCliente(Integer.parseInt(request.getParameter("id")));
			ClienteModificado.setNombres(request.getParameter("nombres"));
			ClienteModificado.setApellidos(request.getParameter("apellidos"));
			ClienteModificado.setDireccion(request.getParameter("direccion"));
			ClienteModificado.setDNI(request.getParameter("dni"));
			LocalDate fecha = LocalDate.parse(request.getParameter("fechaNacimiento"));
			ClienteModificado.setFechaNacimiento(fecha);

			if (model.modificarCliente(ClienteModificado) > 0) {
				response.sendRedirect(request.getContextPath() + "/ClienteController");
			} else {
				request.setAttribute("message", "Error de Modificacion");
				request.getRequestDispatcher("/Error404.jsp").forward(request, response);
			}

		} catch (Exception e) {
			System.out.println("Error en ClienteController.modificarCliente() \n " + e.getMessage().toString());
			e.printStackTrace();
		}
	}

	private void listarClientes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setAttribute("listaClientes", model.listarClientes());
			request.getRequestDispatcher("/Cliente/listaCliente.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println("Error en ClienteController.listarClientes() \n " + e.getMessage().toString());
			e.printStackTrace();
		}
	}

	private void nuevoCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.getRequestDispatcher("/Cliente/insertarCliente.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println("Error en ClienteController.nuevoCliente() \n " + e.getMessage().toString());
			e.printStackTrace();
		}
	}

	private void insertarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			Cliente nuevo = new Cliente();
			nuevo.setNombres(request.getParameter("nombres"));
			nuevo.setApellidos(request.getParameter("apellidos"));
			nuevo.setDireccion(request.getParameter("direccion"));
			nuevo.setDNI(request.getParameter("dni"));

			LocalDate fecha = LocalDate.parse(request.getParameter("fechaNacimiento"));
			nuevo.setFechaNacimiento(fecha);

			if (model.insertarCliente(nuevo) > 0) {
				response.sendRedirect(request.getContextPath() + "/ClienteController");
			} else {
				request.setAttribute("message", "Error de Insersion");
				request.getRequestDispatcher("/Error404.jsp").forward(request, response);
			}

		} catch (Exception e) {
			System.out.println("Error en ClienteController.insertarCliente() \n " + e.getMessage().toString());
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

}

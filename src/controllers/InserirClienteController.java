package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import service.ClienteService;

/**
 * Servlet implementation class InserirClienteController
 */

@WebServlet("/InserirCliente.do")
public class InserirClienteController extends HttpServlet {

	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		int rg = Integer.parseInt(request.getParameter("rg"));
		int cpf = Integer.parseInt(request.getParameter("cpf"));
		int telefone = Integer.parseInt(request.getParameter("telefone"));

		//instanciar o Model
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setRg(rg);
		cliente.setCpf(cpf);
		cliente.setTelefone(telefone);

		//intanciar o Service
		ClienteService clienteService = new ClienteService();
		int idCliente = clienteService.criar(cliente);
		cliente.setId(idCliente);

		request.setAttribute("cliente", cliente);

		RequestDispatcher view = 
				request.getRequestDispatcher("Cliente.jsp");
		view.forward(request, response);

	}


}

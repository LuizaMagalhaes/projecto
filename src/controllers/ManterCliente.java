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
import service.ProdutoService;

/**
 * Servlet implementation class ManterclienteController
 */
@WebServlet("/ManterCliente.do")
public class ManterCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		int rg = Integer.parseInt(request.getParameter("rg"));
		int id = Integer.parseInt(request.getParameter("id"));
		int cpf = Integer.parseInt(request.getParameter("cpf"));
		int telefone = Integer.parseInt(request.getParameter("telefone"));
		
		//instanciar o javabean
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setRg(rg);
		cliente.setCpf(cpf);
		cliente.setTelefone(telefone);
		cliente.setId(id);
		
		//instanciar o service
		ClienteService cs = new ClienteService();
		RequestDispatcher dispatcher = null;
		
//		switch(acao){
//		case "Incluir":
			cs.criar(cliente);
			cliente = cs.carregar(cliente.getId());
			
			//manda parametro para o JSP via request
			request.setAttribute("cliente", cliente);
			dispatcher = request.getRequestDispatcher("cliente.jsp");
//			break;
//		case "Listar":
//			ArrayList<Cliente> clientes = ps.listarTodos();
//			request.setAttribute("clientes", clientes);
//			dispatcher = request.getRequestDispatcher("cliente.jsp");
//		}
		
		
		//despachar para o JSP correto
		dispatcher.forward(request, response);
		
	}

}


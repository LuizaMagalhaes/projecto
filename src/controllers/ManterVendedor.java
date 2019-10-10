package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import model.Vendedor;
import service.ClienteService;
import service.ProdutoService;
import service.VendedorService;

/**
 * Servlet implementation class ManterVendedorController
 */
@WebServlet("/ManterVendedor.do")
public class ManterVendedor extends HttpServlet {
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
		int produtosVendidos = Integer.parseInt(request.getParameter("produtosVendidos"));
		
		//instanciar o javabean
		Vendedor vendedor = new Vendedor();
		vendedor.setNome(nome);
		vendedor.setRg(rg);
		vendedor.setCpf(cpf);
		vendedor.setTelefone(telefone);
		vendedor.setProdutosVendidos(produtosVendidos);
		vendedor.setId(id);
		
		//instanciar o service
		VendedorService vs = new VendedorService();
		RequestDispatcher dispatcher = null;
		
//		switch(acao){
//		case "Incluir":
			vs.criar(vendedor);
			vendedor = vs.carregar(vendedor.getId());
			
			//manda parametro para o JSP via request
			request.setAttribute("vendedor", vendedor);
			dispatcher = request.getRequestDispatcher("vendedor.jsp");
//			break;
//		case "Listar":
//			ArrayList<Vendedor> vendedores = ps.listarTodos();
//			request.setAttribute("vendedores", vendedores);
//			dispatcher = request.getRequestDispatcher("vendedor.jsp");
//		}
		
		
		//despachar para o JSP correto
		dispatcher.forward(request, response);
		
	}

}


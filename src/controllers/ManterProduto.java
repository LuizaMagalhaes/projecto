package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import model.Produto;
import service.ClienteService;
import service.ProdutoService;

/**
 * Servlet implementation class ManterClienteController
 */
@WebServlet("/ManterProduto.do")
public class ManterProduto extends HttpServlet {
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
		double preco = Double.parseDouble(request.getParameter("preço"));
		int quantidade = Integer.parseInt(request.getParameter("quantidade"));
		int id = Integer.parseInt(request.getParameter("id"));
		String descricao = request.getParameter("descrição");
		int tamanho = Integer.parseInt(request.getParameter("tamanho"));
		
		//instanciar o javabean
		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setPreco(preco);
		produto.setQuantidade(quantidade);
		produto.setDescricao(descricao);
		produto.setTamanho(tamanho);
		produto.setId(id);
		
		//instanciar o service
		ProdutoService ps = new ProdutoService();
		RequestDispatcher dispatcher = null;
		
//		switch(acao){
//		case "Incluir":
			ps.criar(produto);
			produto = ps.carregar(produto.getId());
			
			//manda parametro para o JSP via request
			request.setAttribute("produto", produto);
			dispatcher = request.getRequestDispatcher("produto.jsp");
//			break;
//		case "Listar":
//			ArrayList<Produto> produtos = ps.listarTodos();
//			request.setAttribute("produtos", produtos);
//			dispatcher = request.getRequestDispatcher("ListaDeProduto.jsp");
//		}
		
		
		//despachar para o JSP correto
		dispatcher.forward(request, response);
		
	}

}


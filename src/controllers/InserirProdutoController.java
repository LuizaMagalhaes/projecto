package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;
import service.ProdutoService;

/**
 * Servlet implementation class InserirProdutoController
 */

@WebServlet("/InserirProduto.do")
public class InserirProdutoController extends HttpServlet {

	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	String nome;
	  private double preco;
	  private int quantidade;
	  private String descricao;
	  private int tamanho;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		int quantidade = Integer.parseInt(request.getParameter("quantidade"));
		String descricao = request.getParameter("descricao");
		int tamanho = Integer.parseInt(request.getParameter("tamanho"));

		//instanciar o Model
		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setQuantidade(quantidade);
		produto.setDescricao(descricao);
		produto.setTamanho(tamanho);

		//intanciar o Service
		ProdutoService produtoService = new ProdutoService();
		int idProduto = produtoService.criar(produto);
		produto.setId(idProduto);

		request.setAttribute("produto", produto);

		RequestDispatcher view = 
				request.getRequestDispatcher("Produto.jsp");
		view.forward(request, response);

	}


}

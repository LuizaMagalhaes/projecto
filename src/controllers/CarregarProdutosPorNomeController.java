package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import service.ProdutoService;


/**
 * Servlet implementation class InserirClienteController
 */

@WebServlet("/CarregarProdutosPorNome.do")
public class CarregarProdutosPorNomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//instanciar o Model
    	String nomeProduto = request.getParameter("nome");
    	Produto produto = new Produto();
    	Produto listaProduto = new ArrayList<>();
    	
    	//intanciar o Service
    	ProdutoService ps = new ProdutoService();
    	produto = ps.carregarProdutoPorNome(nomeProduto);
    	
    	if(produto.getNome().isEmpty()) {
    	    listaProduto = ps.carregarProdutoPorNome(nomeProduto);
    	    request.setAttribute("listaProduto", listaProduto);
    	    
    	    RequestDispatcher view = 
    	            request.getRequestDispatcher("Produtos.jsp");
    	            view.forward(request, response);
    	    
    	}else {
    	
    	 request.setAttribute("produto", produto);
    	 RequestDispatcher view = 
    	         request.getRequestDispatcher("Produto.jsp");
    	         view.forward(request, response);
    	}
    	
    }
    
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
    	}
        
       
    }
package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Vendedor;
import service.VendedorService;

/**
 * Servlet implementation class InserirVendedorController
 */

@WebServlet("/InserirVendedor.do")
public class InserirVendedorController extends HttpServlet {

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
    	int produtosVendidos = Integer.parseInt(request.getParameter("produtoVendidos"));
    	
    	//instanciar o Model
    	Vendedor vendedor = new Vendedor();
    	vendedor.setNome(nome);
    	vendedor.setRg(rg);
    	vendedor.setCpf(cpf);
    	vendedor.setTelefone(telefone);
    	vendedor.setProdutosVendidos(produtosVendidos);
    	
    	//intanciar o Service
    	VendedorService vendedorService = new VendedorService();
    	int idVendedor = vendedorService.criar(vendedor);
    	vendedor.setId(idVendedor);
    	
    	 request.setAttribute("vendedor", vendedor);

         RequestDispatcher view = 
         request.getRequestDispatcher("Vendedor.jsp");
         view.forward(request, response);
    	
    	}
       
    }
	
	
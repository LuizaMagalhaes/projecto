package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import model.Marca;
import model.Produto;
import service.ClienteService;
import service.MarcaService;
import service.ProdutoService;

/**
 * Servlet implementation class ManterMarcaController
 */
@WebServlet("/ManterMarca.do")
public class ManterMarca extends HttpServlet {
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
		String modelo = request.getParameter("modelo");
		int id = Integer.parseInt(request.getParameter("id"));
		
		//instanciar o javabean
		Marca marca = new Marca();
		marca.setNome(nome);
		marca.setModelo(modelo);
		marca.setId(id);
		
		//instanciar o service
		MarcaService ms = new MarcaService();
		RequestDispatcher dispatcher = null;
		
//		switch(acao){
//		case "Incluir":
			ms.criar(marca);
			marca = ms.carregar(marca.getId());
			
			//manda parametro para o JSP via request
			request.setAttribute("marca", marca);
			dispatcher = request.getRequestDispatcher("marca.jsp");
//			break;
//		case "Listar":
//			ArrayList<Produto> marcas = ps.listarTodos();
//			request.setAttribute("marcas", marcas);
//			dispatcher = request.getRequestDispatcher("marca.jsp");
//		}
		
		
		//despachar para o JSP correto
		dispatcher.forward(request, response);
		
	}

}


package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Endereco;
import service.EnderecoService;

/**
 * Servlet implementation class ManterEnderecoController
 */
@WebServlet("/ManterEndereco.do")
public class ManterEndereco extends HttpServlet {
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
		String rua = request.getParameter("rua");
		int cep = Integer.parseInt(request.getParameter("cep"));
		int id = Integer.parseInt(request.getParameter("id"));
		int numero = Integer.parseInt(request.getParameter("numero"));
		String uf = request.getParameter("uf");
		String pais = request.getParameter("pais");
		
		//instanciar o javabean
		Endereco endereco = new Endereco();
		endereco.setRua(rua);
		endereco.setCep(cep);
		endereco.setNumero(numero);
		endereco.setUf(uf);
		endereco.setPais(pais);
		endereco.setId(id);
		
		//instanciar o service
		EnderecoService es = new EnderecoService();
		RequestDispatcher dispatcher = null;
		
//		switch(acao){
//		case "Incluir":
			es.criar(endereco);
			endereco = es.carregar(endereco.getId());
			
			//manda parametro para o JSP via request
			request.setAttribute("endereco", endereco);
			dispatcher = request.getRequestDispatcher("endereco.jsp");
//			break;
//		case "Listar":
//			ArrayList<Endereco> enderecos = ps.listarTodos();
//			request.setAttribute("enderecos", enderecos);
//			dispatcher = request.getRequestDispatcher("endereco.jsp");
//		}
		
		
		//despachar para o JSP correto
		dispatcher.forward(request, response);
		
	}

}


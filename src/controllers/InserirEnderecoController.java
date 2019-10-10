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
 * Servlet implementation class InserirEnderecoController
 */

@WebServlet("/InserirEndereco.do")
public class InserirEnderecoController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int id = Integer.parseInt(request.getParameter("id"));
    	String rua = request.getParameter("rua");
    	int cep = Integer.parseInt(request.getParameter("cep"));
    	int numero = Integer.parseInt(request.getParameter("numero"));
    	String uf = request.getParameter("uf");
    	String pais = request.getParameter("pais");
    	
    	//instanciar o Model
    	Endereco endereco = new Endereco();
    	endereco.setRua(rua);
    	endereco.setCep(cep);
    	endereco.setNumero(numero);
    	endereco.setUf(uf);
    	endereco.setPais(pais);

    	
    	//intanciar o Service
    	EnderecoService enderecoService = new EnderecoService();
    	int idEndereco = enderecoService.criar(endereco);
    	endereco.setId(idEndereco);
    	
    	 request.setAttribute("endereco", endereco);

         RequestDispatcher view = 
         request.getRequestDispatcher("Endereco.jsp");
         view.forward(request, response);
    	
    	}
       
    }

	
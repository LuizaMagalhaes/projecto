package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Marca;
import service.MarcaService;

/**
 * Servlet implementation class InserirMarcaController
 */

@WebServlet("/InserirMarca.do")
public class InserirMarcaController extends HttpServlet {

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
    	String modelo =request.getParameter("modelo");
    	
    	//instanciar o Model
    	Marca marca = new Marca();
    	marca.setNome(nome);
    	marca.setModelo(modelo);
    	
    	//intanciar o Service
    	MarcaService marcaService = new MarcaService();
    	int idMarca = marcaService.criar(marca);
    	marca.setId(idMarca);
    	
    	 request.setAttribute("marca", marca);

         RequestDispatcher view = 
         request.getRequestDispatcher("Marca.jsp");
         view.forward(request, response);
    	
    	}
       
    }
	
	
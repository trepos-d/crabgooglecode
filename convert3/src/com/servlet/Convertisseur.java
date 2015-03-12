package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metier.Temperature;

@WebServlet("/Convertisseur")
public class Convertisseur extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Convertisseur() {
        super();
          }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request.getRequestDispatcher("Demande.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String valCelsius = request.getParameter("celsius");
		  double celsius=0;
		  String message=null;
		          if (valCelsius.isEmpty()) {
		          	    message="vous n'avez rien saisi, on vous donne par dÃ©faut la conversion pour 20 degrÃ©s";
		                  // Pas de valeur: il faudrait afficher un message, etc.
		                  valCelsius = "20";
		          }
		          try
		          {
		        	  celsius=Double.valueOf(valCelsius);
		        	  Temperature t= new Temperature(Double.valueOf(valCelsius));
			          request.setAttribute("t", t);
		          }
		          catch (NumberFormatException e)
		          {
		    	   message="la valeur saisie doit Ãªtre numÃ©rique";
		          }
		          request.setAttribute("message", message);
		          // Transfert ï¿½ la vue
		          request.getRequestDispatcher("vue/Resultat.jsp").forward(request, response); 
	}

}

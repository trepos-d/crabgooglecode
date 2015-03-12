package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.metier.*;
import modele.persistance.AccesData;

/**
 * Servlet implementation class AjoutBorneServAjax
 */
@WebServlet("/AjoutBorneServAjax")
public class AjoutBorneServAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutBorneServAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Station> listeStation=AccesData.getListeStation();
		request.setAttribute("listeStation", listeStation);
		
		List<TypeCharge> listeTypeCharge=AccesData.getListeTypeCharge();
		request.setAttribute("listeTypeCharge", listeTypeCharge);
		
		request.getRequestDispatcher("vue/AjoutBorneJspAjax.jsp").forward(request , response);
	}

}


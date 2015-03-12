package controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.metier.*;
import modele.persistance.AccesData;
import modele.util.*;

/**
 * Servlet implementation class AjoutBorneServJsp
 */
@WebServlet("/AjoutBorneServJsp")
public class AjoutBorneServJsp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutBorneServJsp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// appel au modele pour récupérer les données sur les stations
		List<Station> listeStation=AccesData.getListeStation();
		Station sa = listeStation.get(0);
		request.setAttribute("listeStation", listeStation);	
		request.setAttribute("sa", sa);	
		List<TypeCharge> listeTypeCharge=AccesData.getListeTypeCharge();				
		TypeCharge t = listeTypeCharge.get(0);
		request.setAttribute("listeTypeCharge", listeTypeCharge);
		request.setAttribute("t", t);
		String messageInfo = "Veuillez saisir les informations";
		request.setAttribute("message", messageInfo);		
		request.getRequestDispatcher("vue/AjoutBorneJsp.jsp").forward(request , response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idStation= Integer.parseInt(request.getParameter("idStation"));
		int codeTypeCharge= Integer.parseInt(request.getParameter("codeTypeCharge"));
		String date = request.getParameter("saisieDate");
		
		List<Station> listeStation=AccesData.getListeStation();
		Station sa = AccesData.getStation(idStation);
		
		
		List<TypeCharge> listeTypeCharge=AccesData.getListeTypeCharge();
		TypeCharge t = AccesData.getTypeCharge(codeTypeCharge);
			
		
		String messageInfo;
		
		if(VerifDate.ConvertChaineDate(date) == true)
		{
			Borne b = new Borne(date, sa, t);
			AccesData.addBorne(b);
			if(AccesData.addBorne(b) == true)
			{
				messageInfo = "Ajout effectue";
			}
			else
			{
				messageInfo = "Ajout non effectue";
			}
		}
		else
		{
			messageInfo = "Date incorrecte";
		}
				
		
		request.setAttribute("message", messageInfo);
		request.setAttribute("sa", sa);
		request.setAttribute("listeStation", listeStation);
		request.setAttribute("t", t);
		request.setAttribute("listeTypeCharge", listeTypeCharge);
		request.getRequestDispatcher("vue/AjoutBorneJsp.jsp").forward(request , response);
	}

}

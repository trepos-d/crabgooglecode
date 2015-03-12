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
 * Servlet implementation class AjoutBorneAjax
 */
@WebServlet("/AjoutBorneAjax")
public class AjoutBorneAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutBorneAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// appel au modele pour récupérer les données sur les stations
				/*List<Station> listeStation=AccesData.getListeStation();
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
				*/
				
				response.setContentType("text/html");
				response.setHeader("Cache-Control",  "no-cache");
				
				//récupération identifiant selectionné
				int idStation= Integer.parseInt(request.getParameter("idStation"));
				int codeTypeCharge= Integer.parseInt(request.getParameter("codeTypeCharge"));
				String date = request.getParameter("saisieDate");
				
				//récupération des bornes de la station selectionée
				List<Station> listeStation=AccesData.getListeStation();
				Station sa = AccesData.getStation(idStation);
				
				List<TypeCharge> listeTypeCharge=AccesData.getListeTypeCharge();
				Station sa = AccesData.getStation(idStation);
				String reponse;

					//récupération des bornes de la station selectionné
					
					reponse ="<table border=1>";
					reponse=reponse+"<tr>";
					reponse=reponse+"<td>Id de la Borne</td>";
					reponse=reponse+"<td>Date de mise en service</td>";
					reponse=reponse+"<td>Type de charge</td>";
					
					for(Borne b : listeBorne)
					{
						reponse=reponse+"<tr>";
						reponse=reponse+"<td>"+b.getIdBorne()+"</td>";
						reponse=reponse+"<td>"+b.getDateMiseEnService()+"</td>";
						reponse=reponse+"<td>"+b.getTypeCharge()+"</td>";
						reponse=reponse+"<tr>";
						reponse=reponse + "</table>";
					}
				}
				else {
					reponse="<p>Aucune borne pour cette station n'a ete trouve</p>";
					response.getWriter().write(reponse);
				}
				
				
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

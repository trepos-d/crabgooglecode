package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.metier.Borne;
import modele.persistance.AccesData;

/**
 * Servlet implementation class BorneStationAjax
 */
@WebServlet("/BorneStationAjax")
public class BorneStationAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorneStationAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Contenu réponse au format html
		response.setContentType("text/html");
		response.setHeader("Cache-Control",  "no-cache");
		
		//récupération identifiant selectionné
		int idStation= Integer.parseInt(request.getParameter("idStation"));
		
		//récupération des bornes de la station selectionée
		List<Borne> listeBorne=AccesData.getListeBorneStation(idStation);
		
		String reponse;
		//Si nombre de bornes différent de 0 alors
		if(listeBorne.size()!=0) {
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
		
	}
	
}

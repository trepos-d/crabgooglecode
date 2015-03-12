package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.metier.Station;
import modele.persistance.AccesData;

@WebServlet("/StationServ")
public class StationServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public StationServ() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// appel au modele pour récupérer les données sur les stations
		List<Station> listeStation=AccesData.getListeStation();
		int nbBorne=0;
		// calcul du nombre de bornes
		for (Station s : listeStation)
			{
			nbBorne=nbBorne+ s.getLesBornes().size();
			}
		// on génére la sortie html qui met en page les données
		response.setContentType("text/html");
		response.setCharacterEncoding( "UTF-8" );
		// instanciation d'un objet Printer
		PrintWriter out = response.getWriter();
		// entete page html
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\" />");
		out.println("<title>Affichage infos parc de stations</title>");
		out.println("</head>");
		out.println("<body>");
		//out.println("<p><a href='./Menu'> retour menu</a>");
		// affichage nombre de stations et de bornes
		out.println("<p><h1>Liste des stations au nombre de " +  listeStation.size()+" </h1></p>" );
		out.println("<p><h2>Nombre de bornes : " +nbBorne +" </h2></p>" );
		// affichage du tableau
		out.println("<table border=1>");
		out.println("<tr>");
		out.println("<th>Numéro de la station </th>");
		out.println("<th>Emplacement de la station </th>");
		out.println("<th>Nombre de bornes </th>");
		out.println("</tr>");
		for (Station s : listeStation)
				{
					out.println("<tr>");
					out.println("<td>"+ s.getIdStation()+ "</td>");
					out.println("<td>"+ s.getLibelleEmplacement()+ "</td>");
					out.println("<td>"+ s.getLesBornes().size()+ "</td>");
					out.println("</tr>");
				}
		// liste borne de la premiï¿½re station
		out.println("</table>");
		out.println("</body></html>");
	}

	}

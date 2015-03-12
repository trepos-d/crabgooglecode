package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import modele.metier.Station;
import modele.persistance.AccesData;

@WebServlet("/StationServJSP")
public class StationServJSP extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public StationServJSP() {
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
		request.setAttribute("listeStation", listeStation);
		request.setAttribute("nbBorne", nbBorne);
		
		request.getRequestDispatcher("vue/AfficheListeStation.jsp").forward(request , response);
	}
	
	protected void doPostt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}


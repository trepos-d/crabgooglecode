package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import modele.metier.*;
import modele.persistance.AccesData;

@WebServlet("/BorneStationJspJslt")
public class BorneStationJspJslt extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BorneStationJspJslt() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// appel au modele pour récupérer les données sur les stations
		List<Station> listeStation=AccesData.getListeStation();
		List<Borne> listeBorne=AccesData.getListeBorneStation(1);
		Station sa = listeStation.get(0);
		request.setAttribute("listeBorne", listeBorne);
		request.setAttribute("listeStation", listeStation);
		request.setAttribute("sa", sa);
		//System.out.println(sa.getIdStation());
		request.getRequestDispatcher("vue/BorneStationJslt.jsp").forward(request , response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Station> listeStation=AccesData.getListeStation();
		
		int idStation= Integer.parseInt(request.getParameter("idStation"));
		List<Borne> listeBorne=AccesData.getListeBorneStation(idStation);
		Station sa = AccesData.getStation(idStation);
		request.setAttribute("listeBorne", listeBorne);
		request.setAttribute("sa", sa);
		//System.out.println(sa.getIdStation());
		request.setAttribute("listeStation", listeStation);
		request.getRequestDispatcher("vue/BorneStationJslt.jsp").forward(request , response);
	}

}

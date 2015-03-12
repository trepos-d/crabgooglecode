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
 * Servlet implementation class BorneStationServJspAjax
 */
@WebServlet("/BorneStationServJspAjax")
public class BorneStationServJspAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorneStationServJspAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// appel au modele pour récupérer les données sur les stations
		List<Station> listeStation=AccesData.getListeStation();
		request.setAttribute("listeStation", listeStation);
		request.getRequestDispatcher("vue/BorneStationJlstAjax.jsp").forward(request , response);
	}

}

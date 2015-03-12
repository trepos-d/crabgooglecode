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

@WebServlet("/typeChargeJSP")
public class typeChargeJSP extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public typeChargeJSP() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// appel au modele pour récupérer les données sur les stations
		List<Borne> listeBorne=AccesData.getListeBorne();
		int nbBorne=0;
		// calcul du nombre de bornes
		for (Borne b : listeBorne)
			{
			nbBorne=nbBorne+ s.getLesBornes().size();
			}
		// on génére la sortie html qui met en page les données
		request.setAttribute("listeBorne", listeBorne);
		request.setAttribute("nbBorne", nbBorne);
		
		request.getRequestDispatcher("vue/AffichageListeBorneTypeCharge.jsp").forward(request , response);
	}

}


//code borne station.jsp à garder 
<%  for (Borne b : listeBorne)
{ %>
	<tr>
		<td><%out.println(b.getIdBorne()); %></td>
		<td><%out.println(b.getDateMiseEnService()) ; %></td>
		<td><%out.println(b.getTypeCharge().getLibelleTypeCharge()) ;%></td>
	</tr>
<%		}%>


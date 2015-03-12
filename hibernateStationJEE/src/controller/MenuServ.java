package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.metier.*;
import modele.persistance.AccesData;
import modele.util.*;
/**
 * Servlet implementation class MenuServ
 */
@WebServlet("/MenuServ")
public class MenuServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("vue/Menu.jsp").forward(request , response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String station = request.getParameter("action");
		System.out.println(station);
		switch(station)
		{
			case "StationServ":{
				response.sendRedirect("./StationServ");
				break;
			}
			
			case "StationServJsp":{
				response.sendRedirect("./StationServJSP");
				break;
			}
			
			case "StationServJspJslt":{
				response.sendRedirect("./StationServJspJslt");
				break;
			}

			case "BorneStationServJsp":{
				response.sendRedirect("./BorneStationServJsp");
				break;
			}

			case "BorneStationJspJslt":{
				response.sendRedirect("./BorneStationJspJslt");
				break;
			}

			case "BorneStationServJspAjax":{
				response.sendRedirect("./BorneStationServJspAjax");
				break;
			}

			case "typeChargeJSPNonFini":{
				response.sendRedirect("./MenuServ");
				break;
			}
			case "typeChargeAjaxNonCommence":{
				response.sendRedirect("./MenuServ");
				break;
			}

			case "AjoutBorneServJsp":{
				response.sendRedirect("./AjoutBorneServJsp");
				break;
			}
		
		}
	}
}

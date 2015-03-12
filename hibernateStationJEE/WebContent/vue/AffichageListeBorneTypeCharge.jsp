<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, modele.metier.Station" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Affichage infos parc de stations</title>
</head>
<body>
<%
List<Station> listeStation=(List<Station>) request.getAttribute("listeStation");
int nbBorne = (Integer) request.getAttribute("nbBorne");
out.println("<h1><p>Liste des stations au nombre de : " + listeStation.size() + "</p></h1>");
out.println("<h1><p>Nombre de bornes : " + nbBorne + "</p></h1>");
%>

		<table border=1>
			<tr>
				<th>Numéro de la station </th>
				<th>Emplacement de la station </th>
				<th>Nombre de bornes </th>
			</tr>
			<%  for (Station s : listeStation)
				{ %>
					<tr>
					<td><%out.println(s.getIdStation()); %></td>
					<td><%out.println(s.getLibelleEmplacement()); %></td>
					<td><%out.println(s.getLesBornes().size()) ;%></td>
					</tr>
			<%		}%>

		</table>
		</body></html>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, modele.metier.*" %> 
<style type="text/css" media="screen">@import url(./style.css);</style>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Affichage borne par station</title>
</head>
	<body>
		<center>
		<h1>Choisir une station</h1>
		<%
		List<Station> listeStation=(List<Station>) request.getAttribute("listeStation");
		List<Borne> listeBorne=(List<Borne>) request.getAttribute("listeBorne");
		Station sa = (Station) request.getAttribute("sa");
	
		%>
			<form method="POST" action="./BorneStationServJsp">
				<select name ="idStation" onChange="submit();">
				<%  for (Station s : listeStation)
								{
								if(sa.getIdStation()==s.getIdStation())
								{
									out.println("<option selected='selected' value="+ s.getIdStation() +"> "+ s.getLibelleEmplacement()+ "</option>");
								}
								else
								{
									out.println("<option value="+ s.getIdStation() +"> "+ s.getLibelleEmplacement()+ "</option>");
								}
				}%>
				</select>
			</form>
			<h1>Borne de chaque station</h1>	
			<br>
			<%
			if(listeBorne.size()==0)
			{
				out.println("aucune borne dans cette station");
				
			}
			else
			{	
			%>
			<h2>Liste bornes de la station</h2>
			<table>
				<tr>
					<td>id borne </td>
					<td>date de mise en service </td>
					<td>type de charge </td>
				</tr>
				<% 
				for (Borne b : listeBorne)
						{
							out.println("<tr>");
								out.println("<td>"+ b.getIdBorne() + "</td>");
								out.println("<td>"+ b.getDateMiseEnService() + "</td>");
								out.println("<td>"+ b.getTypeCharge().getLibelleTypeCharge() + "</td>");
							out.println("</tr>");
						}
				}
			%>
				
			</table>	
		</center>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List, modele.metier.*" %> 
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
		Station sa = (Station) request.getAttribute("sa");
		%>
			<form method="POST" action="./BorneStationServJslt">
				<select name ="idStation" onChange="submit();">
						<c:forEach var="s" items="${listeStation}">
								<c:choose>
									<c:when test="${sa.IdStation==listeStation.IdStation}">								
										<option selected='selected' value="+ s.getIdStation() +"> "+ s.getLibelleEmplacement()+"</option>
									</c:when>
									<c:otherwise>
										<option value="+ s.getIdStation() +"> "+ s.getLibelleEmplacement()+ "</option>
									</c:otherwise>
								</c:choose>
						</c:forEach>
				</select>
			</form>
			<h1>Borne de chaque station</h1>	
			<br>
			
			<c:choose>
				<c:when test="${listeBorne.size()==0}">
					aucune borne dans cette station
				</c:when>
			</c:choose>
			if(listeBorne.size()==0)
			{
				out.println("aucune borne dans cette station");
				
			}
			else
			{	
			%>
			<h2>Liste bornes de la station</h2>
			<table border="1">
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
				
			%>
				
			</table>	
		</center>
	</body>
</html>
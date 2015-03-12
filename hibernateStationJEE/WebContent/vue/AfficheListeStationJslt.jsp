<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List, modele.metier.Station" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Affichage infos parc de stations</title>
</head>
<body>

		<table border=1>
			<tr>
				<th>Numéro de la station </th>
				<th>Emplacement de la station </th>
				<th>Nombre de bornes </th>
			</tr>
			<c:forEach var="s" items="${listeStation}">
				<tr>
					<td><c:out value="${s.idStation}"/></td>
					<td><c:out value="${s.libelleEmplacement}"/></td>
					<td><c:out value="${s.lesBornes.size()}"/></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>

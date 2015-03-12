<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List, modele.metier.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<script src="scriptAjaxStation.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Affichage borne par station en ajax</title>
	</head>
	<body>
		<center>
		<h1>Choisir une station</h1>
				<select name="choixStation" id="idStation" onchange="valider(this.value);" size="1">
						<c:forEach var="station" items="${listeStation}">
 							<option value=<c:out value="${station.idStation}"/>><c:out value="${station.libelleEmplacement}"/></option>
						 </c:forEach>
				</select>
			<h1>Liste des bornes de la station</h1>	
			<div id="listeBorne"></div>
			<script type="text/javascript" valider(document.getElementById("idStation").children[0].value);></script>
		</center>
	</body>
</html>
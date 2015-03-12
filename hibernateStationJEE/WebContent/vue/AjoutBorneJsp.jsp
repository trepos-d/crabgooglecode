<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List, modele.metier.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout d'une borne</title>
</head>
	<body>
		<h1>Ajout Borne</h1>
			<form method="POST" action="./AjoutBorneServJsp">
			Station : 
				<select name ="idStation">
						<c:forEach var="s" items="${listeStation}">
								<c:choose>
									 <c:when test="${sa.idStation == s.idStation}">						
										<option selected="selected" value=<c:out value="${s.idStation}"/>><c:out value="${s.libelleEmplacement}"/></option>
									</c:when>
									<c:otherwise>
										<option value=<c:out value="${s.idStation}"/>><c:out value="${s.libelleEmplacement}"/></option>
									</c:otherwise>
								</c:choose>
						</c:forEach>
				</select>
				</br>
				Type charge : 
				<select name ="codeTypeCharge">
				<h1>Type Charge</h1>
						<c:forEach var="tca" items="${listeTypeCharge}">
								<c:choose>
									<c:when test="${tca.codeTypeCharge == t.codeTypeCharge}">								
										<option selected='selected' value=<c:out value="${tca.codeTypeCharge}"/>><c:out value="${tca.libelleTypeCharge}"/></option>
									</c:when>
									<c:otherwise>
										<option value=<c:out value="${tca.codeTypeCharge}"/>><c:out value="${tca.libelleTypeCharge}"/></option>
									</c:otherwise>
								</c:choose>
						</c:forEach>
				</select>	
				</br>
				Date de mise en service : 
				<input type="text" name="saisieDate"/>
				</br>
				<input type="submit" value="valider"/>
				<input type="reset" value = "effacer">
			</form>
			
			<script type="text/javascript">
			alert('<c:out value="${message}"/>')
			</script>
	</body>
</html>
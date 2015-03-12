<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="A_rename"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Ajout borne Ajax</title>
</head>
<body>
	<h1>Ajout Borne</h1>
			Station : 
				<select name ="idStation" id="idStation" onchange="valider(this.value);" size="1">
						<c:forEach var="s" items="${listeStation}">				
										<option value=<c:out value="${s.idStation}"/>><c:out value="${s.libelleEmplacement}"/></option>
						</c:forEach>
				</select>
				Type charge : 
				<select name ="codeTypeCharge">
				<h1>Type Charge</h1>
						<c:forEach var="tca" items="${listeTypeCharge}">							
										<option value=<c:out value="${tca.codeTypeCharge}"/>><c:out value="${tca.libelleTypeCharge}"/></option>
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
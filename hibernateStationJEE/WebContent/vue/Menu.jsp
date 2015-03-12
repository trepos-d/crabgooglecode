<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu JAVA EE</title>
</head>
<body>
	<H1>Menu JEE</H1>
	<form method="POST" action="./MenuServ">
	<table border="1">
		<tr>
			<td>Liste des stations (servlet - jsp - scriptlet)</td>
			<td><input type="submit" name="action" value="StationServ"/></td>
		</tr>
		<tr>
			<td>Listes des stations (servlet - jsp - jslt)</td>
			<td><input type="submit" name="action" value="StationServJSP"/></td>
		</tr>
		<tr>
			<td>Listes des stations (servlet)</td>
			<td><input type="submit" name="action" value="StationServJspJslt"/></td>
		</tr>
		<tr>
			<td>Bornes par station (servlet - jsp - scriptlet)</td>
			<td><input type="submit" name="action" value="BorneStationServJsp"/></td>
		</tr>
		<tr>
			<td>Bornes par station (servlet - jsp - jslt)</td>
			<td><input type="submit" name="action" value="BorneStationJspJslt"/></td>
		</tr>
		<tr>
			<td>Bornes par station (servlet - jsp - jslt - ajax)</td>
			<td><input type="submit" name="action" value="BorneStationServJspAjax"/></td>
		</tr>
		<tr>
			<td>Bornes par type de charge (servlet)</td>
			<td><input type="submit" name="action" value="typeChargeJSPNonFini"/></td>
		</tr>
		<tr>
			<td>Bornes par type de charge en ajax (servlet - jsp - ajax)</td>
			<td><input type="submit" name="action" value="typeChargeAjaxNonCommence"/></td>
		</tr>
		<tr>
			<td>Ajotu borne (servlet - jsp - ajax)</td>
			<td><input type="submit" name="action" value="AjoutBorneServJsp"/></td>
		</tr>
	</table>
	</form>
</body>
</html>
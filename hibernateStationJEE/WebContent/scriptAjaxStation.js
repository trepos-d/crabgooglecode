var requete;
function valider(valeur) {
	 var url = "./BorneStationAjax?valeur="+valeur;
	 if (window.XMLHttpRequest) {
		 requete = new XMLHttpRequest();
		 } else if (window.ActiveXObject) {
		 requete = new ActiveXObject("Microsoft.XMLHTTP");
		 }
		 requete.open("GET", url, true);
		 requete.onreadystatechange = majIHM;
	     requete.send(null);
	 }

	 function majIHM() {
	 if (requete.readyState == 4) {
	 if (requete.status == 200) {
	 	document.getElementById("listeBorne").innerHTML = requete.responseText;
	  }
	 else
	 	alert("pb  dans ajax");
	 }
}
	 
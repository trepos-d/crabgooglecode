<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import= "com.metier.Temperature" %>

 <html>
  <head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>Résultat de la conversion</title>
 </head>
 <body>
  <% Temperature t=(Temperature) request.getAttribute("t"); %>
      <% if (request.getAttribute("message")!=null)
       	  { 
    	  out.println("<p>" + request.getAttribute("message").toString() +"</p>");
          }
          else { 
          out.println("<p>Vous avez demandé la conversion en Fahrenheit de la valeur en  Celsius=" + t.getCelsius() +"</p>");   
              }  
           %>
       <p>
       <% if (t!=null)  {%>
               <b>Et le résultat est: ${requestScope.t.fahrenheit}  degrés Fahrenheit </b> 
        <% } %>
      </p>
      <p><a href='vue/Demande.jsp'> retour formulaire</a>
 </body>
</html>

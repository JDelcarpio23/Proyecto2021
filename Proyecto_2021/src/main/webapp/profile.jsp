<%@page import="util.Constante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>

<%@ include file="snippet/header.jsp" %>

</head>
<body>

<div class="container">
	
	<%@ include file="snippet/nav_main.jsp" %>
	<br>
	
	<% String nombre = (String)session.getAttribute(Constante.NOMBRE); %>
	<% String apellido = (String)session.getAttribute(Constante.APELLIDOS); %>
	<% String email = (String)session.getAttribute(Constante.EMAIL); %>
	<% String fecha = (String)session.getAttribute(Constante.FECHA); %>

	<div class="card-deck mb-3 text-center">
	    <div class="card mb-4 shadow-sm">
	      <div class="card-header">
	      	<h2><%=nombre + " " + apellido %></h2>
	      </div>
	      
	      <div class="card-body">
	        <h2><small class="text-muted"><%=fecha %></small></h2>
	        <h2><small class="text-muted"><%=email %></small></h2>
	      </div>
	    
		</div>	

	</div>

</div>


</body>

<%@ include file="snippet/footer.jsp" %>

</html>
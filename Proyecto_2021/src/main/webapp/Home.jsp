<%@page import="util.Constante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<%@include file="snippet/header.jsp"%>
</head>
<body>
<div class="container">
	<%@include file="snippet/nav_main.jsp"%>
        <div class="row align-items-center vh-100 espacio">
            <div class="col-lg-11 mx-auto ">
                <div class="p-5 rounded shadow fondo-claro">
                    <div class="jumbotron">
                    
                    	<% 
                    	
                    		String Nombre = (String) session.getAttribute(Constante.NOMBRE); 
                    		String Email = (String) session.getAttribute(Constante.EMAIL);

                    	%>
                        <h1 class="display-4" style="font-size: 2.6rem;">¡Bienvenido <i><%=Nombre %></i>, al Sistema</h1>
                        <p class="lead">Este Sistema Tiene como fin la gestión de una empresa de Cine.</p>
                        <hr class="my-4">
                        <p>Este Sistema esta de Desarrollo,por ende, esta en constante Actualización.</p>
                        <p>Este Sistema Tiene las Funciones:</p>
                        <br>
                        <ul class="list-group col-lg-4">
                            <li class="list-group-item list-group-item-action active">Equipo</li>
                            <li class="list-group-item ">NOMBRE</li>
                            <li class="list-group-item list-group-item-action active">Departamento</li>
                            <li class="list-group-item ">DEPARTAMENTO</li>
                            <li class="list-group-item list-group-item-action active">Provincia</li>
                            <li class="list-group-item ">PROVINCIA</li>
                            <li class="list-group-item list-group-item-action active">Distrito</li>
                            <li class="list-group-item ">DISTRITO</li>
                            
                          </ul>
                      </div>
                </div>
            </div>
        </div>
</div>
	

<%@include file="snippet/Footer-Pie.jsp" %>
</body>
<%@include file="snippet/footer.jsp" %>
</html>
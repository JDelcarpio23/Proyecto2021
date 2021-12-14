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
<%@include file="snippet/nav_main.jsp"%>
	
	<div class="container">
        <div class="row align-items-center vh-100 espacio">
            <div class="col-lg-11 mx-auto ">
                <div class="p-5 rounded shadow fondo-claro">
                    <div class="jumbotron">
                    
                    	<% 
                    	
                    		String Nombre = (String) session.getAttribute("Nombre"); 
                    		String Email = (String) session.getAttribute("Email");
                    		String Direccion = (String) session.getAttribute("Direccion");
                    		String Telefono = (String) session.getAttribute("Telefono");
                    	%>
                        <h1 class="display-4" style="font-size: 2.6rem;">¡Bienvenido <i><%=Nombre %></i>, al Sistema CinePlus!</h1>
                        <p class="lead">Este Sistema Tiene como fin la gestión de una empresa de Cine.</p>
                        <hr class="my-4">
                        <p>Este Sistema esta de Desarrollo,por ende, esta en constante Actualización.</p>
                        <p>Este Sistema Tiene las Funciones:</p>
                        <br>
                        <ul class="list-group col-lg-4">
                            <li class="list-group-item list-group-item-action active">Mantenimiento Clientes</li>
                            <li class="list-group-item ">Mantenimiento Usuarios</li>
                            <li class="list-group-item list-group-item-action active">Mantenimiento Comestibles</li>
                            <li class="list-group-item ">Mantenimiento Peliculas</li>
                            <li class="list-group-item list-group-item-action active">Mantenimiento Proveedores</li>
                            <li class="list-group-item ">Reporte ventas</li>
                            <li class="list-group-item list-group-item-action active">Reporte Clientes</li>
                            <li class="list-group-item ">Boleta</li>
                            
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
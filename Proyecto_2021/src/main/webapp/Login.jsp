<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sistema Deportivo</title>

<%@ include file="snippet/header.jsp" %>

</head>
<body>

<div class="container">
	
	<h1 align="center">Sistema Deportivo</h1>
	
	<h2 align="center">Inicio de Sesión</h2>
	
	<br>
	<br>
	<center>
	<div class="cuerpo">
		<div >
	
		<form action="AuthServlet" method="post" id="index_form">
			
			<input type="hidden" name="type" value="login">
			
			<div class="form-group">
				<label>Correo</label>
				<input class="form-control" type="text" name="txtCorreo" >
			</div>
			
			<div class="form-group">
				<label>Contraseña</label>
				<input class="form-control" type="password" name="txtClave" >
			</div>
			
			<input name="validateBtn" type="submit" class="btn btn-primary" value="Ingresar">
		
		</form>
		
		<% 
		String message = (String)request.getAttribute("msj");
		if (message != null) {
		%>
		
		<div class="alert alert-danger">
			<strong>Error!</strong> <%=message %>
		</div>
			
	    <%	
		}
		%>		
		</div>
	
	</div>
	</center>
</div>

</body>


<%@ include file="snippet/footer.jsp" %>

<%@ include file="snippet/Validator.jsp" %>

</html>
<%@page import="Entities.Jugador"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="libCombo" prefix="etiqueta" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jugador</title>

<%@ include file="snippet/header.jsp" %>

</head>
<body>

<div class="container">
	
	<%@ include file="snippet/nav_main.jsp" %>
	
	<%
	
	Jugador jugForm = (Jugador) request.getAttribute("JugadorData");
	
	%>
	

	<div class="col-lg-4">
		<h2>Registrar un Jugador</h2>
		<br>
		<br>
		
		<form action="JugadorServlet" method="post" id="id_form">
			
			<input type="hidden" name="type" value="register">
			<input type="hidden" name="idJugador" value="<%=(jugForm!=null)?jugForm.getIdJugador():""%>">
						
			<div class="form-group">
				<label>Nombres</label>
				<input class="form-control" type="text" name="txtNombres" 
				value="<%=(jugForm!=null)?jugForm.getNombres():""%>">
			</div>
			
			<div class="form-group">
				<label>Apellidos</label>
				<input class="form-control" type="text" name="txtApellidos" 
				value="<%=(jugForm!=null)?jugForm.getApellidos():""%>">
			</div>
			
			<div class="form-group">
				<label>DNI</label>
				<input class="form-control" type="text" name="txtDni"
				value="<%=(jugForm!=null)?jugForm.getDni():""%>" >
			</div>
			
			<div class="form-group">
				<label>Fecha de Nacimiento</label>
				<input class="form-control" type="date" name="txtFecNac" 
				value="<%=(jugForm!=null)?jugForm.getFecNac():""%>">
			</div>
			
			<div class="form-group">
				<label>Telefono</label>
				<input class="form-control" type="text" name="txtTelefono" 
				value="<%=(jugForm!=null)?jugForm.getTelefono():""%>">
			</div>
			
			<div class="form-group">
				<label>Talla</label>
				<input class="form-control" type="text" name="txtTalla" 
				value="<%=(jugForm!=null)?jugForm.getTalla():""%>">
			</div>
			
			<div class="form-group">
				<label>Peso</label>
				<input class="form-control" type="text" name="txtPeso" 
				value="<%=(jugForm!=null)?jugForm.getPeso():""%>">
			</div>
			
			<div class="form-group">
				<label>Posicion</label>
				<etiqueta:TagComboPosicion name="txtPosicion"/>
				
			</div>
			
			<div class="form-group">
				<label>Categoria</label>
				<etiqueta:TagComboCategoria name="txtCategoria"/>
				
			</div>
			
			<input type="submit" class="btn btn-primary" value="Enviar Datos">
			
		</form>
	
	</div>

	<div class="col-lg-8">
		<h2>Jugadores Disponibles</h2>
		
		<table class="table">
			<thead>
				<tr>
					<th>id</th>
					<th>Nombres</th>
					<th>Apellidos</th>
					<th>DNI</th>
					<th>Fecha de Nacimiento</th>
					<th>Telefono</th>
					<th>Talla</th>
					<th>Peso</th>
					<th>Posicion</th>
					<th>Categoria</th>
					<th>Fecha de Registro</th>
					<th>Acciones</th>
				</tr>
			</thead>
			
			<tbody>
			
			<%
			
			List<Jugador> listJugador = (List<Jugador>)request.getAttribute("data");
			
			if (listJugador != null) {
				
				for(Jugador item: listJugador) {
					
			%>
				<tr class="grilla_campo">
					<td><%=item.getIdUsuario() %></td>
					<td><%=item.getNombres() %></td>
					<td><%=item.getApellidos() %></td>
					<td><%=item.getDni() %></td>
					<td><%=item.getFecNac() %></td>
					<td><%=item.getTelefono() %></td>
					<td><%=item.getTalla() %></td>
					<td><%=item.getPeso() %></td>
					<td><%=item.getIdPosicionB() %></td>
					<td><%=item.getIdCategoriaB() %></td>
					<td><%=item.getFecRegJugador() %></td>
					<td>
						<a href="JugadorServlet?type=info&idSol_Atencion=<%=item.getIdJugador()%>"><img alt="" src="img/ic_edit.svg" width="20" height="20" title="Editar"></a>
						<a href="JugadorServlet?type=delete&id=<%=item.getIdJugador()%>"><img alt="" src="img/ic_delete.svg" width="20" height="20" title="Eliminar"></a>
					</td>
				</tr>
			
			<%
					
				}
			}
			
			%>
			
			</tbody>
			
		</table>
		
	</div>

</div>


</body>

<%@ include file="snippet/footer.jsp" %>

</html>
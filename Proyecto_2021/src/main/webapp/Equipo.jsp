<%@page import="Entities.Equipo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mantenimiento Equipo</title>
<%@include file="snippet/header.jsp"%>
</head>
<body>
<div class="container">
	<%@include file="snippet/nav_main.jsp"%>
	<% 
		Equipo equipoForm = (Equipo) request.getAttribute("EquipoData");
	%>
	
	<div class="col-lg-3">
		<h2>Registrar un Equipo</h2>
		
		<form action="EquipoServlet" method="post" id="id_form">
			<input type="hidden" name="type" value="register">
			<input type="hidden" name="idEquipo" value="<%=(equipoForm!=null)?equipoForm.getIdEquipo():""%>">
		
			<div class="form-group">
				<label>Nombre Equipo</label>
				<input class="form-control" type="text" name="txtNombre"
				value="<%=(equipoForm!=null)? equipoForm.getNombreEquipo():"" %>">
			</div>
			
			<div class="form-group">
				<label>Departamento</label>
				<input class="form-control" type="text" name="txtIdDepartamento"
				value="<%=(equipoForm!=null)? equipoForm.getIdDepartamento():"" %>">
			</div>
			
			<div class="form-group">
				<label>Provincia</label>
				<input class="form-control" type="text" name=txtIdProvincia
				value="<%=(equipoForm!=null)? equipoForm.getIdProvincia():"" %>">
			</div>
			
			<div class="form-group">
				<label>Distrito</label>
				<input class="form-control" type="text" name="txtIdDistrito"
				value="<%=(equipoForm!=null)? equipoForm.getIdDistrito():"" %>">
			</div>
			
			<div class="form-group">
				<label>Usuario</label>
				<input class="form-control" type="text" name="txtIdUsuario"
				value="<%=(equipoForm!=null)? equipoForm.getIdUsuario():"" %>">
			</div>
			
			<div class="form-group">
				<label>Fecha de Registro</label>
				<input class="form-control" type="date" name="txtFechaReg"
				value="<%=(equipoForm!=null)? equipoForm.getFechaRegistroEqu():"" %>">
			</div>
			
			<center>
			<input type="submit" class="btn btn-primary" value="Enviar Datos">
			</center>
		</form>
	</div>
	
	<div class="col-lg-8">
		<h2>Equipo Registrado</h2>
		<table class="table">
			<thead>
				<tr>
					<th>IdEquipo</th>
					<th>Nombre Equipo</th>
					<th>Departamento</th>
					<th>Provincia</th>
					<th>Distrito</th>
					<th>Usuario</th>
					<th>Fecha de Registro</th>
					<th>Acciones</th>
				</tr>
			</thead>
			
			<tbody>
			<%
			List<Equipo> listEquipo = (List<Equipo>)request.getAttribute("data");
			if(listEquipo != null){
				for(Equipo item: listEquipo) {
			%>
				<tr class="grilla_campo">
					<td><%=item.getIdEquipo() %></td>
					<td><%=item.getNombreEquipo() %></td>
					<td><%=item.getIdDepartamento() %></td>
					<td><%=item.getIdProvincia() %></td>
					<td><%=item.getIdDistrito() %></td>
					<td><%=item.getIdUsuario() %></td>
					<td><%=item.getFechaRegistroEqu() %></td>
					<td>
						<a href="EquipoServlet?type=info&idEquipo=<%=item.getIdEquipo()%>"><img alt="" src="images/ic_edit.svg" width="20" height="20" title="Editar"></a>
						<a href="EquipoServlet?type=delete&idEquipo=<%=item.getIdEquipo()%>"><img alt="" src="images/ic_delete.svg" width="20" height="20" title="Eliminar"></a>
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
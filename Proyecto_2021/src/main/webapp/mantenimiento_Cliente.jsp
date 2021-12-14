<%@page import="Entities.Cliente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Mantenimiento Cliente</title>
<%@include file="Snippet/Header.jsp"%>
</head>
<body>

	<%@include file="Snippet/nav_main.jsp"%>
	<div class="container espacio">
	 
	 	<br>
	
	<%
	
	Cliente clienteForm = (Cliente) request.getAttribute("clienteData");
	
	%>


		<div class="row">
			<div class="col-lg-3">

				<br>
				<h2 class="text-left">Cliente</h2>


				<form action="ClienteServlet" method="post" id="id_from">

					<input type="hidden" name="type" value="register">
					<input type="hidden" name="codcliente" value="<%=(clienteForm!=null)? clienteForm.getIdCliente():""%>">
					<div class="form-group">
						<label>Nombre :</label> <input class="form-control sombra"
							type="text" name="txtNombre" placeholder="Usuario..."value="<%=(clienteForm!=null)? clienteForm.getNombre():""%>">
					</div>

					<div class="form-group">
						<label>Teléfono :</label> <input class="form-control sombra"
							type="text" name="txtTelefono" placeholder="Teléfono..."value="<%=(clienteForm!=null)? clienteForm.getTelefono():""%>">
					</div>

					<div class="form-group">
						<label>Dirección :</label> <input class="form-control sombra"
							type="text" name="txtDireccion" placeholder="Dirección..."value="<%=(clienteForm!=null)? clienteForm.getDireccion():""%>">
					</div>

					<div class="form-group">
						<label>Email :</label> <input class="form-control sombra"
							type="text" name="txtEmail" placeholder="Email..."value="<%=(clienteForm!=null)? clienteForm.getEmail():""%>">
					</div>

					<div class="form-group">
						<label>Estado :</label> <input class="form-control sombra"
							type="text" name="txtEstado" placeholder="Estado..."value="<%=(clienteForm!=null)? clienteForm.getEstado():""%>">
					</div>

					<br>
					<div class="d-flex justify-content-end">
						<input type="submit" class="btn btn-primary btn-lg"
							name="validateBtn" value="Enviar">
					</div>



				</form>
					<% 
		
		String message = (String) request.getAttribute("msj");
		
		if (message != null){
			
		%>
			<br>
			<div class="alert alert-danger">
				<strong>Error! </strong> <%=message %>
			</div>
			
		<%
		
		}
		
		%>
			</div>

			<div class="col-lg-9">
				<br>
				<h2 class="texto-right">Listado de Clientes</h2>
				<br>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>ID</th>
							<th>Usuario</th>
							<th>Teléfono</th>
							<th>Dirección</th>
							<th>Email</th>
							<th>Estado</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
					<%
			
			List<Cliente> listCliente = (List<Cliente>) request.getAttribute("data");
			if (listCliente != null) {
				
				for(Cliente item : listCliente) {
					
			%>


						
					<tr class="grilla_campo">
					<td><%=item.getIdCliente() %></td>
					<td><%=item.getNombre() %></td>
					<td><%=item.getTelefono() %></td>
					<td><%=item.getDireccion() %></td>
					<td><%=item.getEmail() %></td>
					<td><%=item.getEstado() %></td>
					<td>
					<a href="ClienteServlet?type=info&idCliente=<%=item.getIdCliente() %>" title="Editar"><i class="fas fa-info-circle " style="font-size: 1.5rem;color: #34313D;"></i></a>
					<a href="ClienteServlet?type=delete&idCliente=<%=item.getIdCliente() %>" title="Eliminar" ><i class="fas fa-trash " style="font-size: 1.5rem;color: #34313D;"></i></a>
				
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
	</div>


	<%@include file="Snippet/Footer-Pie.jsp"%>
</body>
<%@include file="Snippet/Footer.jsp"%>
<script type="text/javascript">

$(document).ready(function() {
	$('#id_from').bootstrapValidator({
		feedbackIcons : {
			 valid: 'glyphicon glyphicon-ok',
             invalid: 'glyphicon glyphicon-remove',
             validating: 'glyphicon glyphicon-refresh'
		},
		fields : {
				txtNombre : {
					validators : {
					notEmpty : {
						message : "El Nombre es requerido"
					},
					stringLength: {
                        min: 5,
                        max: 40,
                        message: "La longitud del Nombre es de 5 a 40 caracteres"
                    }
				}
			},
			txtTelefono : {
				validators : {
					notEmpty : {
						message : "El Teléfono es requerido"
					},
					stringLength: {
                        min: 9,
                        max: 9,
                        message: "La longitud del Teléfono es de 9 digítos"
                    }
				}

			},
			txtDireccion : {
				validators : {
					notEmpty : {
						message : "La Dirección es requerido"
					},
					stringLength: {
                        min: 5,
                        max: 100,
                        message: "La longitud de la Dirección es de 20 a 100 caracteres"
                    }
				}

			},
			txtEmail : {
				validators : {
					notEmpty : {
						message : "El Email es requerido"
					},
					emailAddress: {
                        message: "El Formato del Email no es correcto"
                    }
				}

			},
			txtEstado : {
				validators : {
					notEmpty : {
						message : "El Estado es requerido"
					},
					stringLength: {
                        min: 1,
                        max: 1,
                        message: "La longitud del Estado es de 1 caracter"
                    }
				}
			}
			
		}
	});

	$('#validateBtn').click(function() {
		$('#id_from').bootstrapValidator('validate');
	});

});
</script>
</html>
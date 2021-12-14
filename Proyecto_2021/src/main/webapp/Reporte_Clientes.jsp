<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="Entities.Cliente"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reporte de Clientes</title>
<%@include file="Snippet/Header.jsp"%>
</head>
<body>
<%@include file="Snippet/nav_main.jsp"%>



 <div class="container espacio">

        <div class="row">
            <div class="d-flex justify-content-center">
                <div class="col-lg-3">
                
                    <br>
                    <h2 class="text-left" style="font-size: 1.9rem" >Reporte de Clientes</h2>
                    <br>
        
                        <form action="ReporteClientesSerlvet" method="post" id="id_from">
        
                            <input type="hidden" name="type" value="consultar">
                            <div class="form-group">
                                <label>Estado :</label> <input class="form-control sombra" type="text" name="txtEstado" placeholder="Estado...">
                            </div>
       
                            <br>
                            <div class="d-flex justify-content-end">
                                <input type="submit" class="btn btn-primary btn-lg" name="validateBtn" value="Consultar">
                            </div>
                    
                        </form>
        
        
                </div>

            </div>
           
            <div class="d-flex justify-content-center">
                <div class="col-lg-11">
                    <br>
                    <table class="table table-striped">
                        <tbody class="borde-reporte">
                        
                        <%
                        	List<Cliente> listadoClientes = (List<Cliente>) request.getAttribute("data");
                        if (listadoClientes != null) {	
                        	%>
	            				<tr>
	            					<th>IdCliente</th>
	            					<th>Nombre</th>
	            					<th>Télefono</th>
	            					<th>Dirección</th>
	            					<th>Email</th>
	            					<th>Estado</th>
	            				</tr>
            				<%
                        
                        	for(Cliente item : listadoClientes){
                        		
                        		%>
                        	<tr class="grilla_campo">
                                <td><%=item.getIdCliente() %></td>
                                <td><%=item.getNombre() %></td>
                                <td><%=item.getTelefono() %></td>
                                <td><%=item.getDireccion() %></td>
                                <td><%=item.getEmail() %></td>
                                <td><%=item.getEstado()%></td>
                            </tr>
                        		<%
                        	}
                        }
                        %>
                            

                        </tbody>
                    </table>
                    <div class="d-flex justify-content-end">

                        <a href="ReporteClientesSerlvet?type=reporte" type="submit" class="btn btn-secondary"><i class="far fa-file-pdf"></i>  Exportar PDF</a>
                    </div>    
                </div>

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
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
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
<script type="text/javascript">

$(document).ready(function() {
	$('#idform').bootstrapValidator({
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		fields: {
			txtNombre: {
				validators: {
					notEmpty: {
						message: "Este campo es obligatorio"
					},
					stringLength: {
						min: 4,
						max: 60,
						message: "Este campo debe entre 4 y 60 caracteres"
					}
				}
			},
			txtApellidos: {
				validators: {
					notEmpty: {
						message: "Este campo es obligatorio"
					},
					stringLength: {
						min: 4,
						max: 20,
						message: "Este campo debe entre 4 y 20 caracteres"
					}
				}
			},
			txtFecha:{
				validators:{
					notEmpty:{
						message: "Este campo es obligatorio"
					},
					date:{
						format: "DD-MM-YYYY",
						message: "El formato de la fecha es DD-MM-YYYY"
					}
				}
			},
			txtEmail:{
				validators:{
					notEmpty:{
						message:"Este campo es obligatorio"
					},
					emailAddress: {
						message: "El formato del correo es incorrecto"
					}
				}
			},
			txtPassword:{
				validators:{
					notEmpty:{
						message:"Este campo es obligatorio"
					}
				}
			}
		}
	});
	$('#btnRegistrar').click(function() {
		$('#idform').bootstrapValidator('validate');
	});
});

$(document).ready(function() {
	
	$('#index_form').bootstrapValidator({
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		fields: {
			txtCorreo: {
				validators: {
					notEmpty: {
						message: "Este campo es obligatorio"
					},
					emailAddress: {
						message: "El formato del correo es incorrecto"
					}
				}
			}, 
			txtPass : {
				validators : {
					notEmpty : {
						message: "Este campo es obligatorio"
					}
				}
			}
		}
	});
	
	$('#validateBtn').click(function() {
		$('#index_form').bootstrapValidator('validate');
	});
	
});


</script>
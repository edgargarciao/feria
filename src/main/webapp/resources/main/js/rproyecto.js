$(document).ready(function() {
    $("#submit").click(function(){
    	var cod = $( "#cod" ).val();
    	var titulo = $( "#titulo" ).val();
    	var resumen = $( "#resumen" ).val();
    	var codigoEstudiante1 = $( "#codigoEstudiante1" ).val();
    	var codigoEstudiante2 = $( "#codigoEstudiante2" ).val();
    	var file = $( "#file" ).val();

    	if(contrasena != contrasen2){
    		alert("Las contraseñas deben ser iguales");
    	}
    	else if(cod == "" || titulo == "" || resumen == "" || codigoEstudiante1 == "" || file == "") {
    		alert("Digite todos los campos");
    	}else{
			var str = $("#formRP").serialize();
	    	
	    	$.ajax({
			type : "POST",
			url : "http://localhost:8080/ufps-feria/guardarProyecto",
			data : str,
			timeout : 100000,
			success : function(data) {		

				//location.href = "http://localhost:8080/ufps-feria#contact-section";
				$('#formRP').trigger("reset");
				alert("Proyecto registrado");
			},
			error : function(e) {
				console.log("ERROR: ", e);
				
			},
			done : function(e) {
				console.log("DONE");
			}
		});


    }

        return false;
    }); 
});
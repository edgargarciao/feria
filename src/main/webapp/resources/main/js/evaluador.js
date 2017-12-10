echo("cargos JS");
$(document).ready(function() {
    $("#submit").click(function(){
    	var codigo = $( "#codigo" ).val();
    	var nombre = $( "#nombre" ).val();
    	var apellido = $( "#apellido" ).val();
    	var email = $( "#email" ).val();
    	var contrasena = $( "#contraseña" ).val();
    	var contrasen2 = $( "#contraseñas" ).val();

    	if(contrasena != contrasen2){
    		alert("Las contraseñas deben ser iguales");
    	}
    	else if(codigo == "" || nombre == "" || apellido == "" || email == ""  ||  contrasena == ""){
    		alert("Digite todos los campos");
    	}else{
			var str = $("#formEst").serialize();
	    	
	    	$.ajax({
			type : "POST",
			url : "http://localhost:8080/ufps-feria/guardarEvaluadores",
			data : str,
			timeout : 100000,
			success : function(data) {		

				//location.href = "http://localhost:8080/ufps-feria#contact-section";
				$('#formEst').trigger("reset");
				alert("Evaluador registrado");
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
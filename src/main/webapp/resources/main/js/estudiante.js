
$(document).ready(function() {
    $("#submit").click(function(){
    	var codigo = $( "#codigo" ).val();
    	var nombre = $( "#nombre" ).val();
    	var apellido = $( "#apellido" ).val();
    	var email = $( "#email" ).val();
    	var telefono = $( "#telefono" ).val();
    	var semestre = $( "#semestre" ).val();
    	var contrasena = $( "#contrasena" ).val();
    	var contrasen2 = $( "#contrasena2" ).val();

    	if(contrasena != contrasen2){
    		alert("Las contraseñas deben ser iguales");
    	}
    	else if(codigo == "" || nombre == "" || apellido == "" || email == "" || telefono == "" || semestre == "" || contrasena == ""){
    		alert("Digite todos los campos");
    	}else{
			var str = $("#formEst").serialize();
	    	
	    	$.ajax({
			type : "POST",
			url : "http://localhost:8080/ufps-feria/guardarEstudiante",
			data : str,
			timeout : 100000,
			success : function(data) {		

				//location.href = "http://localhost:8080/ufps-feria#contact-section";
				$('#formEst').trigger("reset");
				alert("Estudinte registrado");
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
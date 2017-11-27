$(document).ready(function(){
  $("#RP").click(function(){
    var tok = document.getElementById("tok");
    alert("took --> "+tok);
    alert("3 --> "+tok.value);

    $.ajax({
    type:'GET',
    url :"http://localhost:8080/ufps-feria/registrarProyecto",
    data : {"token" : tok.value },
    success: function(data) {
       location.href = "http://localhost:8080/ufps-feria/registrarProyecto";
    },
    error:function(exception){alert('Exeption:'+exception);}
    }); 

    return false;
  });
});

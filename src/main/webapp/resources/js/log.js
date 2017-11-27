
$(document).ready(function(){
  $("#logout").click(function(){
    var t = $("#tok").val();
  
    $.ajax({
      type: 'GET',
      url: 'http://localhost:8080/ufps-feria/logout',
      data: {"t" : t},
      success: function(response) {
          window.location.href = 'http://localhost:8080/ufps-feria/index';
      }
      });

        return false;
  });
});

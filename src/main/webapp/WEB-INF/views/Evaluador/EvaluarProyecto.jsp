
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>

<html>
  <head>
    <meta charset="UTF-8">
    <title>Feria de Proyectos</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- Bootstrap 3.3.2 -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- Font Awesome Icons -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
    <link href="http://code.ionicframework.com/ionicons/2.0.0/css/ionicons.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="resources/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <!-- AdminLTE Skins. Choose a skin from the css/skins 
         folder instead of downloading all of them to reduce the load. -->
    <link href="resources/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>
  <body class="skin-blue">

  <script type="text/javascript">
    function actualizarResultado(){
      var promedio = 0;
      for(var i = 1;i<=9;i++){
        promedio += (  parseFloat($("#calificacion"+i).val()) * $("#valoracion"+i).val() / 100);
      }

      $('#calificacion10').attr('value', promedio)
      
    }
  </script>
    <%
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        String t =String.valueOf(request.getAttribute("token"));
        String nombre = (String)request.getSession().getAttribute("user");
        int codigo = Integer.parseInt(request.getSession().getAttribute("codigo").toString());
    %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    
    <div class="wrapper">
      
      <header class="main-header">
        <a href="${contextPath}/indexEvaluador?t=<%=t%>" class="logo"><b>Feria De Poroyectos</b></a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top" role="navigation">
          <!-- Sidebar toggle button-->
          <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>

        </nav>
      </header>
      <!-- Left side column. contains the logo and sidebar -->
      <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
          <!-- Sidebar user panel -->

          <div class="user-panel">

            <div class="pull-left image">
              <img src="resources/img/evaluador.jpg" class="img-circle" alt="User Image" />
            </div>
            <div class="pull-left info">
              <p><%=nombre%></p>

              <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
          </div>

          <!-- search form -->
          
          <!-- /.search form -->
          <!-- sidebar menu: : style can be found in sidebar.less -->

          <ul class="sidebar-menu">
            <li class="header">Opciones del Evaluador</li>
           <li class="treeview">
              <a href="${contextPath}/evaluarProyectos?t=<%=t%>&cod=<%=codigo%>">
                <i class="fa fa-check-square-o"></i><span> Evaluar proyectos</span>
              </a>
              <a href="${contextPath}/visualizarProyectos?t=<%=t%>&cod=<%=codigo%>">
                <i class="fa fa-eye"></i> <span> Ver proyectos evaluados</span>
              </a>
              <a href="${contextPath}/logout?t=<%=t%>">
                <i class="fa fa-power-off"></i><span> Salir</span>
              </a>  
            </li>
          </ul>
        </section>
        <!-- /.sidebar -->
      </aside>

      <!-- Right side column. Contains the navbar and content of the page -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            EVALUAR PROYECTOS
            
          </h1>
         
        </section>


        <!-- Main content -->
        <section class="content">
          <div class="row">
            <!-- left column -->
            <div class="col-md-12">
              <!-- general form elements -->
              <c:if test="${not empty wrong}">
                  <div class="alert alert-warning alert-dismissable">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    <h4><i class="icon fa fa-warning"></i> Debes llenar los campos correctamente.</h4>
                    Debes llenar todos los campos. Recuerda que la calificación es de 0 hasta 5.0.
                  </div>
              </c:if>

              <div class="box box-danger">
                <div class="box-header">
                <h3 class="box-title">A continuacion puede evaluar el proyecto.</h3>
                  
              </div>

                </div><!-- /.box-body -->
                <form:form action="evaluarProyecto" method="post" modelAttribute="evaluacion">

                  <input type="hidden" name="t" id="t"  value="<%= t %>" />
                  <input type="hidden" name="codigoP" id="codigoP"  value="${idProyecto}" />
                  <input type="hidden" name="codigoEvaluador" id="codigoEvaluador"  value="<%= codigo %>" />

                    <div class="form-group">
                      <label class="form-control-label">Código del proyecto</label>

                      <form:input path="codigoProyecto" class="form-control" value = "${idProyecto}" disabled="true"/>
                    </div>

                      <p> Presentación (20 Puntos) </p>
                      <table class="table table-hover">  
                          <tr>
                              <th width="39%">CRITERIO DE EVALUACIÓN</th>
                              <th width="8%">Valoración</th>
                              <th width="8%">Calificación</th>
                              <th align="center" width="45%">Observaciones</th>
                          </tr>  
                           <tr>  
                               <td width="39%" align="justify">1. Creatividad y Diseño: el evaluador debe determinar 
                                                        si presenta una organización y diseño que faciliten la 
                                                        presentación del proyecto de aula.</td>  
                               <td width="8%" align="center">
                               <form:input path="valoracion1" id="valoracion1" class="form-control" readonly="true" value="10" />
                                                
                               <td width="8%">
                                  <form:input path="calificacion1" id="calificacion1" class="form-control" type="number" min="0" max="5.0" step="0.01" required="true" onchange="actualizarResultado()"/>
                                </td>  
                               <td width="45%" align="center"><form:textarea path="observacion1" class="form-control" placeholder="" required ="true"/></td>
                            
                           </tr>  

                            <tr>  
                               <td width="39%" align="justify">2.Puntualidad y Responsabilidad: Todos los participantes  deben  estar    presentes en la evaluación</td>  
                               <td width="8%" align="center"><input name="valoracion2" id="valoracion2" class="form-control" value="10" readonly="true" /></td> 
                               <td width="8%">
                                  <form:input path="calificacion2" id="calificacion2" class="form-control" type="number" min="0" max="5.0" step="0.01" required ="true" onchange="actualizarResultado()"/>
                                </td>  
                               <td width="45%" align="center"><form:textarea path="observacion2" class="form-control" required ="true"/></td>                  
                           </tr>  
                     </table>

                             <p> Proyecto de Aula (80 Puntos)</p>
                      <table class="table table-hover">  
                          <tr>
                              <th width="39%">CRITERIO DE EVALUACIÓN</th>
                              <th width="8%">Valoración</th>
                              <th width="8%">Calificación</th>
                              <th align="center" width="45%">Observaciones</th>
                          </tr>  
                            <tr>  
                               <td width="39%" align="justify">1. Pertinencia: adecuación de los objetivos a las necesidades de la asignatura impartida </td>  
                               <td width="8%" align="center"><input name="valoracion3" id="valoracion3"  class="form-control" value="10" readonly="true" /></td> 
                               <td width="8%">
                                  <form:input path="calificacion3" id="calificacion3" class="form-control" type="number" min="0" max="5.0" step="0.01" required ="true" onchange="actualizarResultado()"/>
                                </td>  
                               <td width="45%" align="center"><form:textarea path="observacion3" class="form-control" required ="true"/></td>                   
                           </tr>      

                            <tr>  
                               <td width="39%" align="justify">2.Participación: Se evidencia la participación del docente en el seguimiento al proyecto de aula. </td>  
                               <td width="8%" align="center"><input name="valoracion4" id="valoracion4" class="form-control" value="10" readonly="true" /></td> 
                               <td width="8%">
                                  <form:input path="calificacion4" id="calificacion4" class="form-control" type="number" min="0" max="5.0" step="0.01" required ="true" onchange="actualizarResultado()"/>
                                </td>  
                               <td width="45%" align="center"><form:textarea path="observacion4" class="form-control" required ="true"/></td>                      
                           </tr> 
                            <tr>  
                               <td width="39%" align="justify">3.Utilidad: grado de aprovechamiento pedagógico de las experiencias y resultados del proyecto. </td>  
                               <td width="8%" align="center"><input name="valoracion5" id="valoracion5" class="form-control" value="20" readonly="true" /></td> 
                               <td width="8%">
                                  <form:input path="calificacion5" id="calificacion5" type="number" class="form-control" min="0" max="5.0" step="0.01" required ="true" onchange="actualizarResultado()"/>
                                </td>  
                               <td width="45%" align="center"><form:textarea path="observacion5" class="form-control" required ="true"/></td>                    
                           </tr>      
                            <tr>  
                               <td width="39%" align="justify">4. Programación: capacidad para organizar y racionalizar todos los pasos preestablecidos.</td>  
                               <td width="8%" align="center"><input name="valoracion6" id="valoracion6" class="form-control" value="10" readonly="true" /></td> 
                               <td width="8%">
                                  <form:input path="calificacion6" id="calificacion6" type="number" class="form-control" min="0" max="5.0" step="0.01" required ="true" onchange="actualizarResultado()"/>
                                </td>  
                               <td width="45%" align="center"><form:textarea path="observacion6" class="form-control" required ="true"/></td>                 
                           </tr>       
                            <tr>  
                               <td width="39%" align="justify">5. Metodología: El equipo de trabajo adopto una metodología de desarrollo del proyecto.</td>  
                               <td width="8%" align="center"><input name="valoracion7" id="valoracion7" class="form-control" value="10" readonly="true" /></td> 
                               <td width="8%">
                                  <form:input path="calificacion7" id="calificacion7" type="number" class="form-control" min="0" max="5.0" step="0.01" required ="true" onchange="actualizarResultado()"/>
                                </td>  
                               <td width="45%" align="center"><form:textarea path="observacion7" class="form-control" required ="true"/></td>                     
                           </tr>   
                           <tr>  
                               <td width="39%" align="justify">6. Gestión: ejecución de las acciones dentro del marco de una programación determinada.</td>  
                               <td width="8%" align="center"><input name="valoracion8" type="number" id="valoracion8" class="form-control" value="10" readonly="true" /></td> 
                               <td width="8%">
                                  <form:input path="calificacion8" id="calificacion8" class="form-control" min="0" max="5.0" step="0.01" required ="true" onchange="actualizarResultado()"/>
                                </td>  
                               <td width="45%" align="center"><form:textarea path="observacion8" class="form-control" required ="true"/></td>
                           </tr>                            
                           <tr>  
                               <td width="39%" align="justify">7. Trabajo en equipo: Se evidencia la  apropiación de la temática por parte de todos los miembros del equipo de trabajo.</td>  
                               <td width="8%" align="center"><input name="valoracion9" type="number" id="valoracion9" class="form-control" value="10" readonly="true" /></td> 
                               <td width="8%">
                                  <form:input path="calificacion9" id="calificacion9" class="form-control" min="0" max="5.0" step="0.01" required ="true" onchange="actualizarResultado()"/>
                                </td>  
                               <td width="45%" align="center"><form:textarea path="observacion9" class="form-control" required ="true"/></td>                   
                           </tr>   
                           <tr>  
                               <td width="39%" align="justify">PUNTUACIÓN OBTENIDA (Se debe sumar los puntos obtenidos en cada criterio para obtener la puntuación total)</td>  
                               <td width="8%" align="center"><input name="valoracion10" id="valoracion10" class="form-control" value="100" readonly="true" /></td> 
                               <td width="8%">
                                  <form:input path="calificacion10" id="calificacion10" type="number" class="form-control"  step="0.01" min="0" max="5.0" required ="true" readonly="true"/>
                                </td>  
                               <td width="45%" align="center"><form:textarea path="observacion10" class="form-control" required ="true"/></td>                     
                           </tr>                              
                      </table>



                <div class="box-footer">
                    <button type="submit" class="btn btn-primary">Evaluar proyecto</button>
                </div>


                </form:form>

                </div>
              </div>

            </div><!--/.col (left) -->
            <!-- right column -->
            <div class="col-md-6">
              <!-- general form elements disabled -->


            </div><!--/.col (right) -->
          </div>   <!-- /.row -->
        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->


    </div><!-- ./wrapper -->

    <!-- jQuery 2.1.3 -->
    <script src="https://code.jquery.com/jquery-2.1.3.min.js" type="text/javascript"></script>
    <!-- Bootstrap 3.3.2 JS -->
    <script src="resources/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- FastClick -->
    <script src='https://cdnjs.cloudflare.com/ajax/libs/fastclick/1.0.6/fastclick.min.js' type="text/javascript"></script>
    <!-- AdminLTE App -->
    <script src="resources/js/app.min.js" type="text/javascript"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="resources/js/demo.js" type="text/javascript"></script>



  </body>
</html>

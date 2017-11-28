
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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

    <%
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        String t =String.valueOf(request.getAttribute("token"));
        String nombre = (String)request.getSession().getAttribute("user");
    %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    
    <div class="wrapper">
      
      <header class="main-header">
        <a href="${contextPath}/ufps-feria/indexEvaluador?t=<%=t%>" class="logo"><b>Feria De Poroyectos</b></a>
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
              <a href="${contextPath}/ufps-feria/evaluarProyectos?t=<%=t%>">
                <i class="fa fa-check-square-o"></i><span> Evaluar proyectos</span>
              </a>
              <a href="${contextPath}/ufps-feria/visualizarProyectos?t=<%=t%>">
                <i class="fa fa-eye"></i> <span> Ver proyectos evaluados</span>
              </a>
              <a href="${contextPath}/ufps-feria/logout?t=<%=t%>">
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


              <div class="box box-danger">
                <div class="box-header">

                  
              </div>

                <form:form action="evaluarProyecto" method="post" modelAttribute="proyecto">

                  <div class="box-body">
                  <div class="row">

                     <p> "Presentación (20 Puntos) </p>

                    <div class="col-xs-3">
                      <label class="form-control-label">CRITERIO DE EVALUACIÓN</label>
                     </div>

                     <div class="col-xs-1">
                      <label class="form-control-label">Valoración</label>
                     </div>

                     <div class="col-xs-3">
                      <label class="form-control-label">Calificación</label>
                     </div>

                     <div class="col-xs-3">
                      <label class="form-control-label">Observaciones</label>
                     </div>


                  </div>
                </div><!-- /.box-body -->


                <div class="box-body">
                  <div class="row">

                    <div class="col-xs-3">
                      <label class="form-control-label">1. Creatividad y Diseño: el evaluador debe determinar 
                                                        si presenta una organización y diseño que faciliten la 
                                                        presentación del proyecto de aula.</label>
                     </div>


                     <div class="col-xs-1">
                      <label class="form-control-label">10</label>
                     </div>

                    <div class="col-xs-3">
                      <input type="text" class="form-control" placeholder="">
                    </div>

                    <div class="col-xs-3">
                      
                    <form:textarea path="resumen" class="form-control" placeholder=""/>
                  </div>

                  </div>
                </div><!-- /.box-body -->




                 <div class="box-body">
                  <div class="row">

                    <div class="col-xs-3">
                      <label class="form-control-label">2.Puntualidad y Responsabilidad: Todos los participantes  deben  estar    presentes en la evaluación </label>
                     </div>


                     <div class="col-xs-1">
                      <label class="form-control-label">10</label>
                     </div>

                    <div class="col-xs-3">
                      <input type="text" class="form-control" placeholder="">
                    </div>

                    <div class="col-xs-3">
                      
                    <form:textarea path="resumen" class="form-control" placeholder=""/>
                  </div>

                  </div>
                </div><!-- /.box-body -->



                 <div class="box-body">
                  <div class="row">

                  <p> Proyecto de Aula (80 Puntos)</p>

                    <div class="col-xs-3">
                      <label class="form-control-label">1. Pertinencia: adecuación de los objetivos a las necesidades de la asignatura impartida </label>
                     </div>


                     <div class="col-xs-1">
                      <label class="form-control-label">10</label>
                     </div>

                    <div class="col-xs-3">
                      <input type="text" class="form-control" placeholder="">
                    </div>

                    <div class="col-xs-3">
                      
                    <form:textarea path="resumen" class="form-control" placeholder=""/>
                  </div>


                  </div>
                </div><!-- /.box-body -->


                <div class="box-body">
                  <div class="row">

                    <div class="col-xs-3">
                      <label class="form-control-label">2.Participación: Se evidencia la participación del docente en el seguimiento al proyecto de aula. </label>
                     </div>


                     <div class="col-xs-1">
                      <label class="form-control-label">10</label>
                     </div>

                    <div class="col-xs-3">
                      <input type="text" class="form-control" placeholder="">
                    </div>

                    <div class="col-xs-3">
                      
                    <form:textarea path="resumen" class="form-control" placeholder=""/>
                  </div>
                  

                  </div>
                </div><!-- /.box-body -->


                <div class="box-body">
                  <div class="row">

                    <div class="col-xs-3">
                      <label class="form-control-label">3.Utilidad: grado de aprovechamiento pedagógico de las experiencias y resultados del proyecto.</label>
                     </div>


                     <div class="col-xs-1">
                      <label class="form-control-label">20</label>
                     </div>

                    <div class="col-xs-3">
                      <input type="text" class="form-control" placeholder="">
                    </div>

                    <div class="col-xs-3">
                      
                    <form:textarea path="resumen" class="form-control" placeholder=""/>
                  </div>
                  

                  </div>
                </div><!-- /.box-body -->



                <div class="box-body">
                  <div class="row">

                    <div class="col-xs-3">
                      <label class="form-control-label">4. Programación: capacidad para organizar y racionalizar todos los pasos preestablecidos.</label>
                     </div>


                     <div class="col-xs-1">
                      <label class="form-control-label">10</label>
                     </div>

                    <div class="col-xs-3">
                      <input type="text" class="form-control" placeholder="">
                    </div>

                    <div class="col-xs-3">
                      
                    <form:textarea path="resumen" class="form-control" placeholder=""/>
                  </div>
                  

                  </div>
                </div><!-- /.box-body -->




                <div class="box-body">
                  <div class="row">

                    <div class="col-xs-3">
                      <label class="form-control-label">5. Metodología: El equipo de trabajo adopto una metodología de desarrollo del proyecto.</label>
                     </div>


                     <div class="col-xs-1">
                      <label class="form-control-label">10</label>
                     </div>

                    <div class="col-xs-3">
                      <input type="text" class="form-control" placeholder="">
                    </div>

                    <div class="col-xs-3">
                      
                    <form:textarea path="resumen" class="form-control" placeholder=""/>
                  </div>
                  

                  </div>
                </div><!-- /.box-body -->

                 <div class="box-body">
                  <div class="row">

                    <div class="col-xs-3">
                      <label class="form-control-label">6. Gestión: ejecución de las acciones dentro del marco de una programación determinada.</label>
                     </div>


                     <div class="col-xs-1">
                      <label class="form-control-label">10</label>
                     </div>

                    <div class="col-xs-3">
                      <input type="text" class="form-control" placeholder="">
                    </div>

                    <div class="col-xs-3">
                      
                    <form:textarea path="resumen" class="form-control" placeholder=""/>
                  </div>
                  

                  </div>
                </div><!-- /.box-body -->

                 <div class="box-body">
                  <div class="row">

                    <div class="col-xs-3">
                      <label class="form-control-label">7. Trabajo en equipo: Se evidencia la  apropiación de la temática por parte de todos los miembros del equipo de trabajo.</label>
                     </div>


                     <div class="col-xs-1">
                      <label class="form-control-label">10</label>
                     </div>

                    <div class="col-xs-3">
                      <input type="text" class="form-control" placeholder="">
                    </div>

                    <div class="col-xs-3">
                      
                    <form:textarea path="resumen" class="form-control" placeholder=""/>
                  </div>
                  

                  </div>
                </div><!-- /.box-body -->


                 <div class="box-body">
                  <div class="row">

                    <div class="col-xs-3">
                      <label class="form-control-label">PUNTUACIÓN OBTENIDA (Se debe sumar los puntos obtenidos en cada criterio para obtener la puntuación total)</label>
                     </div>


                    <div class="col-xs-1">
                      <input type="text" class="form-control" placeholder="">
                    </div>


                    <div class="col-xs-3">
                      <input type="text" class="form-control" placeholder="">
                    </div>



                    
                  

                  </div>
                </div><!-- /.box-body -->


                <div class="box-footer">
                    <button type="submit" class="btn btn-primary">Enviar Evaluacion</button>
                </div>


                </form:form>


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
    <script src="../../plugins/jQuery/jQuery-2.1.3.min.js"></script>
    <!-- Bootstrap 3.3.2 JS -->
    <script src="resources/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- FastClick -->
    <script src='../../plugins/fastclick/fastclick.min.js'></script>
    <!-- AdminLTE App -->
    <script src="resources/js/app.min.js" type="text/javascript"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="resources/js/demo.js" type="text/javascript"></script>
  </body>
</html>

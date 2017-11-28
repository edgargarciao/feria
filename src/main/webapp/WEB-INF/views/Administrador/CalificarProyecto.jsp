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
        <a href="${contextPath}/ufps-feria/indexAdmin?t=<%=t%>" class="logo"><b>Feria De Proyectos</b></a>
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
              <img src="resources/img/administrador.jpg" class="img-circle" alt="User Image" />
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
            <li class="header">Opciones Del Administrador</li>

            <li class="treeview">
              <a href="${contextPath}/ufps-feria/registrarEvaluador?t=<%=t%>">
                <i class="fa fa-pencil"></i><span> Registrar Evaluador</span>
              </a>
              <a href="${contextPath}/ufps-feria/asignarProyectos?t=<%=t%>">
                <i class="fa fa-share-square-o"></i> <span> Asignar Proyecto</span>
              </a>
              <a href="${contextPath}/ufps-feria/calificarProyectos?t=<%=t%>">
                <i class="fa fa-check-square-o"></i> <span> Calificar Proyecto</span>
              </a>
              <a href="${contextPath}/ufps-feria/registrarLinea?t=<%=t%>">
                <i class="fa fa-list"></i> <span> Registrar Lineas</span>
              </a>
              <a href="${contextPath}/ufps-feria/asignarHorarios?t=<%=t%>">
                <i class="fa fa-calendar"></i> <span> Asignar Horario</span>
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
             CALIFICAR PROYECTO
           
          </h1>
         
        </section>

        <!-- Main content -->
        <section class="content">
          <div class="row">
            <!-- left column -->
            <div class="col-md-12">
              <!-- general form elements -->

              <!-- Input addon -->

              <div class="box box-info">
                <div class="box-header">
                  <h3 class="box-title">A continuacion puede calificar un proyecto a un estudiante.</h3>
                </div>

                <form:form action="guardarEvaluadores" method="post" modelAttribute="evaluador">
                <div class="box-body">

                 <div class="form-group">
                      <label for="exampleInputEmail1">Codigo</label>
                      <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email">
                  </div>

                  </div>

                  <div class="box-footer">
                    <button type="submit" class="btn btn-primary">Calificar proyecto</button>

                  </div>


             </form:form>

               
                </div><!-- /.box-body -->

              </div><!-- /.box -->

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

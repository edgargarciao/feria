
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
  <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <div class="wrapper">
      
      <header class="main-header">
        <a href="../../index2.html" class="logo"><b>Admin</b>LTE</a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top" role="navigation">
          <!-- Sidebar toggle button-->
          <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
              

             
              <li class="dropdown user user-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <img src="resources/img/der.jpg" class="user-image" alt="User Image"/>
                  <span class="hidden-xs">Derly Angel</span>
                </a>
                <ul class="dropdown-menu">
                  <!-- User image -->
                  <li class="user-header">
                    <img src="resources/img/der.jpg" class="img-circle" alt="User Image" />
                    <p>
                      Derly Angel - Administradora
                      <small>Member since Nov. 2012</small>
                    </p>
                  </li>
                  <!-- Menu Body -->
                  <li class="user-body">
                    <div class="col-xs-4 text-center">
                      <a href="#">Followers</a>
                    </div>
                    <div class="col-xs-4 text-center">
                      <a href="#">Sales</a>
                    </div>
                    <div class="col-xs-4 text-center">
                      <a href="#">Friends</a>
                    </div>
                  </li>
                  <!-- Menu Footer-->
                  <li class="user-footer">
                    <div class="pull-left">
                      <a href="#" class="btn btn-default btn-flat">Profile</a>
                    </div>
                    <div class="pull-right">
                      <a href="#" class="btn btn-default btn-flat">Sign out</a>
                    </div>
                  </li>
                </ul>
              </li>

              
            </ul>
          </div>
        </nav>
      </header>
      <!-- Left side column. contains the logo and sidebar -->
      <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
          <!-- Sidebar user panel -->
          <div class="user-panel">
            <div class="pull-left image">
              <img src="resources/img/user2-160x160.jpg" class="img-circle" alt="User Image" />
            </div>
            <div class="pull-left info">
              <p>Alexander Pierce</p>

              <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
          </div>
          <!-- search form -->
          <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
              <input type="text" name="q" class="form-control" placeholder="Search"/>
              <span class="input-group-btn">
                <button type='submit' name='seach' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i></button>
              </span>
            </div>
          </form>
          <!-- /.search form -->
          <!-- sidebar menu: : style can be found in sidebar.less -->
          <ul class="sidebar-menu">
            <li class="header">Opciones del estudiante</li>
            <li class="treeview">
              <a href="${contextPath}/ufps-feria/registrarProyecto">
                <i class="fa fa-pencil"></i><span> Registrar proyecto</span>
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
            REGISTRO DE PROYECTOS
          
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="#">Forms</a></li>
            <li class="active">General Elements</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          <div class="row">
            <!-- left column -->
            <div class="col-md-12">

            </div><!--/.col (left) -->
           
           
            <div class="col-md-12">
              <!-- general form elements disabled -->
              <div class="box box-warning">
                <div class="box-header">
                  <h3 class="box-title">A continuación puede registrar el proyecto.</h3>
                </div><!-- /.box-header -->
                <div class="box-body">

                <form:form action="guardarProyecto" method="post" modelAttribute="proyecto">
                    <!-- text input -->

                    <div class="form-group">
                      <label class="form-control-label">Titulo</label>
                      <form:input path="titulo" class="form-control" placeholder="La gran base de datos"/>
                    </div>

                   
                     <div class="form-group">
                      <label class="form-control-label">Resumen</label>
                      <form:input path="resumen" class="form-control" placeholder="La gran base de datos es un articulo publicado en el año 1990 y trata acerca de..."/>
                    </div>


                    <div class="form-group">
                      <label class="form-control-label">Objetivo General</label>
                      <form:input path="objetivoGeneral" class="form-control" placeholder="Analizar las base de datos..."/>
                    </div>


                     <div class="form-group">
                      <label class="form-control-label">Objetivos Especificos</label>
                      <form:textarea path="objetivoEspecifico" rows="3" class="form-control" placeholder="Analizar las base de datos..."/>
                    </div>

                     <div class="form-group">
                      <label class="form-control-label">Alcance</label>
                      <form:textarea path="alcance" rows="3" class="form-control" placeholder="Este proyecto solo abarca las investigaciones sobre la creacion de DML y el..."/>
                    </div>


                    <div class="form-group">
                      <label class="form-control-label">Docente Guia</label>
                       <form:input path="docenteGuia" class="form-control" placeholder="Oscar Gallardo"/>
                    </div>


                     <div class="form-group">

                     <form:select path="linea">
                      <form:option value="" label="Seleccione la linea" />
                      <form:options items="${lineas}"/>
                    </form:select>

                   
                    </div>


                    <div class="form-group">
                      <label class="form-control-label">Vincular Integrantes</label>
                      <textarea class="form-control" rows="3" placeholder="Enter ..."></textarea>
                    </div>


                    <div class="form-group">
                      <label class="form-control-label">Adjuntar Archivo</label>
                      <input type="file" id="exampleInputFile">
                      <p class="help-block">Example block-level help text here.</p>
                    </div>

                    <div class="box-footer">
                    <button type="submit" class="btn btn-primary">Registrar</button>
                  </div>

                 </form:form>
                </div><!-- /.box-body -->
              </div><!-- /.box -->
            </div><!--/.col (right) -->
          </div>   <!-- /.row -->
        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->
      <footer class="main-footer">
        <div class="pull-right hidden-xs">
          <b>Version</b> 2.0
        </div>
        <strong>Copyright &copy; 2014-2015 <a href="http://almsaeedstudio.com">Almsaeed Studio</a>.</strong> All rights reserved.
      </footer>
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

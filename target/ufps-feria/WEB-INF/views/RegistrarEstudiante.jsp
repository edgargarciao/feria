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

  </head>
  <body class="skin-blue">

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
              <img src="resources/img/der.jpg" class="img-circle" alt="User Image" />
            </div>
            <div class="pull-left info">
              <p>Derly Angel</p>

              <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
          </div>
          <!-- search form -->
          <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
              <input type="text" name="q" class="form-control" placeholder="Search..."/>
              <span class="input-group-btn">
                <button type='submit' name='seach' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i></button>
              </span>
            </div>
          </form>


          <!-- /.search form -->
          <!-- sidebar menu: : style can be found in sidebar.less -->
          <ul class="sidebar-menu">
            <li class="header">MAIN NAVIGATION</li>
            <li class="treeview">
              <a href="#">
                <i class="fa fa-dashboard"></i> <span>INFORMACION FERIA</span> <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="../../index.html"><i class="fa fa-circle-o"></i> MISION</a></li>
                <li><a href="../../index2.html"><i class="fa fa-circle-o"></i> VISION</a></li>
              </ul>
            </li>

            <li class="treeview active">
              <a href="#">
                <i class="fa fa-edit"></i> <span>ESTUDIANTE</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li class="active"><a href="general.html"><i class="fa fa-circle-o"></i> Registrar Estudiante</a></li>
                <li><a href="advanced.html"><i class="fa fa-circle-o"></i> Registrar Proyecto</a></li>
                
              </ul>
            </li>


            <li class="treeview">
              <a href="#">
                <i class="fa fa-table"></i> <span>EVALUADOR</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="../tables/simple.html"><i class="fa fa-circle-o"></i> Evaluar Proyectos</a></li>
                
              </ul>
            </li>
            <li class="treeview">
              <a href="#">
                <i class="fa fa-folder"></i> <span>ACCESO ESTUDIANTE</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="../examples/login.html"><i class="fa fa-circle-o"></i> Login</a></li>
            
              </ul>
            </li>




            <li class="treeview">
              <a href="#">
                <i class="fa fa-share"></i> <span>ADMINISTRADOR</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>

              <ul class="treeview-menu">

                <li><a href="#"><i class="fa fa-circle-o"></i> Registrar Evaluador</a></li>
                <li><a href="#"><i class="fa fa-circle-o"></i> Asignar Proyecto</a></li>

                <li><a href="#"><i class="fa fa-circle-o"></i> Calificar Proyecto</a></li>
                <li><a href="#"><i class="fa fa-circle-o"></i> Registrar Lineas</a></li>
                <li><a href="#"><i class="fa fa-circle-o"></i> AsignarHorario</a></li>
                
              </ul>
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
            REGISTRO DE ESTUDIANTES
            
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="#">Forms</a></li>
            <li class="active">Registrar Estudiante</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          <div class="row">
            <!-- left column -->
            <div class="col-md-12">
              <!-- general form elements -->
              <div class="box box-primary">
                <div class="box-header">
                  <h3 class="box-title">A continuación puede registrar al estudiante lider del proyecto.</h3>
                </div><!-- /.box-header -->
                <!-- form start -->
                
                <form:form action="guardarEstudiante" method="post" modelAttribute="estudiante">
                  <div class="box-body">

                    <div class="form-group">
                      <label class="form-control-label">Codigo</label>
                       <form:input path="codigo" class="form-control" placeholder="1165409"/>                  
                    </div>

                    <div class="form-group">
                      <label class="form-control-label">Nombre</label>
                      <form:input path="nombre" class="form-control" placeholder="Juan jose"/>
                    </div>

                    <div class="form-group">
                      <label class="form-control-label">Apellido</label>
                      <form:input path="apellido" class="form-control" placeholder="Angel Marin"/>                    
                    </div>

                    <div class="form-group">
                      <label class="form-control-label">Correo</label>
                      <form:input type="email" path="email" class="form-control" placeholder="juanJoseAM@ufps.edu.co"/>
                    </div>

                    <div class="form-group">
                      <label class="form-control-label">Telefono</label>
                      <form:input type="tel"  path="telefono" class="form-control" placeholder="3203804554"/>                    
                    </div>

                    <div class="form-group">
                      <label class="form-control-label">Semestre</label>
                      <form:input path="semestre" class="form-control" placeholder="1,2,3,4..." />                    
                    </div>

                    <div class="form-group">
                      <label class="form-control-label">Contraseña</label>
                      <form:password path="contrasena" class="form-control" placeholder="Password1234"/>
                    </div>
                   
                    
                  </div><!-- /.box-body -->

                  <div class="box-footer">
                    <button type="submit" class="btn btn-primary">Registrar</button>
                  </div>


                </form:form>


              </div><!-- /.box -->

            </div><!--/.col (left) -->


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

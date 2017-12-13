
<%@ page language="java" contentType="text/html; application/octet-stream;charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Feria de Proyectos</title>
<meta name="description" content="">
<meta name="author" content="">


<!-- Favicons
    ================================================== -->
<link rel="shortcut icon" href="resources/main/img/favicon.ico" type="image/x-icon">
<link rel="apple-touch-icon" href="resources/main/img/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72" href="resources/main/img/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114" href="resources/main/img/apple-touch-icon-114x114.png">

<!-- Bootstrap -->
<link rel="stylesheet" type="text/css"  href="resources/main/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="resources/main/fonts/font-awesome/css/font-awesome.css">

<!-- Login -->
<link rel="stylesheet" type="text/css"  href="resources/main/css/login.css">

<!-- Stylesheet
    ================================================== -->
<link rel="stylesheet" type="text/css"  href="resources/main/css/style.css">
<link rel="stylesheet" type="text/css" href="resources/main/css/prettyPhoto.css">
<link href='http://fonts.googleapis.com/css?family=Lato:400,700,900,300' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800,600,300' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="resources/main/js/modernizr.custom.js"></script>




<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<!-- Navigation
    ==========================================-->
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<% 
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0. 
%>
<nav id="menu" class="navbar navbar-default navbar-fixed-top">
  <div class="container"> 
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
      <a class="navbar-brand" href="${contextPath}/index">UFPS</a> </div>
    
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#home" class="page-scroll">Inicio</a></li>
        <li><a href="#services-what" class="page-scroll">Qué es ?</a></li>
        <li><a href="#about-section" class="page-scroll">Objetivos</a></li>

        <li><a href="#services-section" class="page-scroll">Importancia</a></li>

        <li><a href="#works-section" class="page-scroll">Galeria</a></li>
        <!--
        <li><a href="#team-section" class="page-scroll">Team</a></li>-->
        <li><a href="#contact-section" class="page-scroll">Participar</a></li>

        <li><a href="${contextPath}/login" class="page-scroll">Login</a></li>
        

        </li>
      </ul>
    </div>
    <!-- /.navbar-collapse --> 
  </div>
  <!-- /.container-fluid --> 
</nav>

<!-- Header -->
<header class="text-center" name="home">
  <div class="intro-text">
    <h1>Feria De <span class="color">Proyectos</span></h1>
    <p>Charlas y Proyectos en Modalidad Posters </p>
    <div class="clearfix"></div>
    <a href="${contextPath}/descargarHorario" class="btn btn-default btn-lg page-scroll">Descargar horario</a> </div>
</header>

<!-- Services Section -->
<div id="services-what">

  <div class="container">
    <div class="section-title">
    <br>
    <br>
    <br>
      <h2>Qué es?</h2>
      <hr>
  </div>

<p>Proyectos de aula es una actividad universitaria de la carrera de ingeniería de sistemas de la universidad francisco de paula Santander que se enfoca en propiciar el desarrollo de las competencias e integrar las habilidades y conocimientos adquiridos en los estudiantes de las demás asignaturas a lo largo del semestre y de la carrera. 
En el marco de las asignaturas de la carrera de Ingeniería de Sistemas guiadas en el semestre, los estudiantes de la carrera desarrollan proyectos de aula, en los cuales integran sus habilidades y conocimientos adquiridos en las demás asignaturas.
</p>

  </div>
</div>  

<!-- About Section -->
<div id="about-section">
  <div class="container">
    <div class="section-title">
      <h2>OBJETIVOS</h2>
      <hr>
    </div>
    <div class="space"></div>
    <div class="row">
      <div class="col-md-4">
        <h4>Objetivo General</h4>

        <p>Dar visibilidad a los trabajos de aula realizados por los estudiantes de los distintos semestres del programa de Ingeniería de Sistemas, trabajos guiados por los docentes, pretendiendo retroalimentar a los demás estudiantes y exponiendo los resultados de sus proyectos a la comunidad académica en general, aprovechando el espacio para recibir aportes que ayuden en la formación del estudiante.</p>

      </div>
      <div class="col-md-4">
        <h4>Objetivos Especificos</h4>

        <p> • Brindar un espacio a los estudiantes para que socialicen los resultados de sus proyectos ante la comunidad académica y general</p>

        <p> • Incentivar a los estudiantes de otros semestres a trabajar por proyectos y a buscar el componente investigativo en cada uno de sus trabajos académicos </p>

      </div>
    </div>
  </div>
</div>
<!-- Services Section -->
<div id="services-section">

  <div class="container">
    <div class="section-title">
      <h2>Importancia</h2>
      <hr>
  </div>

<p>Una de las herramientas que los docentes tienen para lograr que los alumnos se apropien de un aprendizaje significativo, son los proyectos de aula, de aprendizaje o ahora los proyectos productivos. Estos permiten al docente y alumnos, solucionar situaciones dentro y fuera del aula y al mismo tiempo desarrollan habilidades cognitivas que facilita el aprendizaje de los contenidos básico del semestre.

Los proyectos permiten al docente globalizar o integrar las áreas académicas a través de una temática especifica escogida por los alumnos según sus intereses y necesidades.

Una herramienta de aprendizaje tiene la ventajas de organizar los contenidos con los cuales el docente puede trabajar según el tema y al mismo tiempo desarrolla el entusiasmo por la investigación a los alumnos como al docente.

Durante el semestre academico se pueden realizar varios proyectos cortos según la época, o situaciones relevantes que sean del interés del alumno y docente.

Es importante resaltar que los proyectos largos son tediosos y aburridos, de ahí que cuando se hacen cortos, los alumnos nunca pierden el entusiasmo.

Una de las características de los proyectos de aula es que son innumerables las actividades practicas que se pueden hacer de todas las áreas académicas.

En la actualidad se deben promover el desarrollo de proyectos productivos a partir de las necesidades de la Universidad y comunidad, en los cuales se involucren todos los integrantes de la comunidad educativa. Durante muchos años la práctica pedagógica ha sido con proyectos, mejorando considerablemente la comprension de los temas por parte de los estudiantes.</p>

  </div>


</div>
<!-- Portfolio Section -->

<div id="works-section">
  <div class="container"> <!-- Container -->
    <div class="section-title">
      <h2>GALERIA</h2>
      <hr>
      <div class="clearfix"></div>
    </div>
    <div class="categories">
      <div class="clearfix"></div>
    </div>
    <div class="row">
      <div class="portfolio-items">
        <div class="col-sm-6 col-md-3 col-lg-3 web">
          <div class="portfolio-item">
            <div class="hover-bg"> <a href="resources/01.jpg" rel="prettyPhoto">
              <div class="hover-text">
                <div class="clearfix"></div>
              </div>
              <img src="resources/01.jpg" class="img-responsive" alt="Project Title"> </a> </div>
          </div>
        </div>
        <div class="col-sm-6 col-md-3 col-lg-3 app">
          <div class="portfolio-item">
            <div class="hover-bg"> <a href="resources/02.jpg" rel="prettyPhoto">
              <div class="hover-text">
                <div class="clearfix"></div>
              </div>
              <img src="resources/02.jpg" class="img-responsive" alt="Project Title"> </a> </div>
          </div>
        </div>
        <div class="col-sm-6 col-md-3 col-lg-3 web">
          <div class="portfolio-item">
            <div class="hover-bg"> <a href="resources/03.jpg" rel="prettyPhoto">
              <div class="hover-text">
                <div class="clearfix"></div>
              </div>
              <img src="resources/03.jpg" class="img-responsive" alt="Project Title"> </a> </div>
          </div>
        </div>
        <div class="col-sm-6 col-md-3 col-lg-3 web">
          <div class="portfolio-item">
            <div class="hover-bg"> <a href="resources/04.jpg" rel="prettyPhoto">
              <div class="hover-text">
                <div class="clearfix"></div>
              </div>
              <img src="resources/04.jpg" class="img-responsive" alt="Project Title"> </a> </div>
          </div>
        </div>
        <div class="col-sm-6 col-md-3 col-lg-3 app">
          <div class="portfolio-item">
            <div class="hover-bg"> <a href="resources/05.jpg" rel="prettyPhoto">
              <div class="hover-text">
                <div class="clearfix"></div>
              </div>
              <img src="resources/05.jpg" class="img-responsive" alt="Project Title"> </a> </div>
          </div>
        </div>
        <div class="col-sm-6 col-md-3 col-lg-3 branding">
          <div class="portfolio-item">
            <div class="hover-bg"> <a href="resources/06.jpg" rel="prettyPhoto">
              <div class="hover-text">
                <div class="clearfix"></div>
              </div>
              <img src="resources/06.jpg" class="img-responsive" alt="Project Title"> </a> </div>
          </div>
        </div>
        <div class="col-sm-6 col-md-3 col-lg-3 branding app">
          <div class="portfolio-item">
            <div class="hover-bg"> <a href="resources/07.jpg" rel="prettyPhoto">
              <div class="hover-text">
                <div class="clearfix"></div>
              </div>
              <img src="resources/07.jpg" class="img-responsive" alt="Project Title"> </a> </div>
          </div>
        </div>
        <div class="col-sm-6 col-md-3 col-lg-3 web">
          <div class="portfolio-item">
            <div class="hover-bg"> <a href="resources/08.jpg" rel="prettyPhoto">
              <div class="hover-text">
                <div class="clearfix"></div>
              </div>
              <img src="resources/08.jpg" class="img-responsive" alt="Project Title"> </a> </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- Contact Section -->
<div id="contact-section">
  <div class="container">
    <div class="section-title center">
      <h2>Contáctenos</h2>
      <hr>
    </div>
    <div class="col-md-4">
      <h4>Información de contacto</h4>
      <div class="space"></div>
      <p><i class="fa fa-map-marker"></i>Avenida Gran Colombia No. 12E-96,<br>
        Cúcuta, Norte de Santander</p>
      <div class="space"></div>
      <p><i class="fa fa-envelope-o"></i>oficinadeprensa@ufps.edu.co</p>
      <div class="space"></div>
      <p><i class="fa fa-phone"></i>(057)(7) 5776655 </p>
    </div>
    <div class="col-md-8">
      <h4>Inscribir participante</h4>

              <c:if test="${not empty result}">
                <div class="alert alert-success alert-dismissable">
                      <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                      <h4>  <i class="icon fa fa-check"></i> Estudiante registrado.</h4>
                      El estudiante ha sido registrado satisfactoriamente.
                </div>
              </c:if>
              <c:if test="${not empty wrong}">
                  <div class="alert alert-warning alert-dismissable">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    <h4><i class="icon fa fa-warning"></i> El estudiante ya ha sido registrado anteriormente.</h4>
                    Por favor contactar al administrador para reestablecer la contraseña.
                  </div>
              </c:if>
      <form:form id="formEst" action="guardarEstudiante" method="post" modelAttribute="estudiante">
        <div class="row">
          <div class="col-md-6">
            <div class="form-group">
               <form:input path="codigo" id="codigo" type="text" class="form-control" placeholder="Codigo" required="true"/>     <p class="help-block text-danger"></p>              
            </div>
          </div>
          <div class="col-md-6">
            <div class="form-group">
              <form:input path="nombre" id="nombre" class="form-control" placeholder="Nombre" required="true"/>
              <p class="help-block text-danger"></p>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-md-6">
            <div class="form-group">
              <form:input path="apellido" id = "apellido" class="form-control" placeholder="Apellidos" required="true"/>                    
              <p class="help-block text-danger"></p>
            </div>
          </div>
          <div class="col-md-6">
            <div class="form-group">
              <form:input type="email" path="email" id = "email" class="form-control" placeholder="Email"  required="true"/>
              <p class="help-block text-danger"></p>
            </div>
          </div>
        </div>
        
        <div class="row">
          <div class="col-md-6">
            <div class="form-group">
              <form:input type="tel"  path="telefono" id="telefono" class="form-control" placeholder="Celular" required="true"/>
              <p class="help-block text-danger"></p>
            </div>
          </div>
          <div class="col-md-6">
            <div class="form-group">
              <form:input path="semestre" id="semestre" class="form-control" placeholder="Semestre" required="true"/>
              <p class="help-block text-danger"></p>
            </div>
          </div>
        </div>        

        <div class="row">
          <div class="col-md-6">
            <div class="form-group">
              <form:password path="contrasena" id="contrasena" class="form-control" placeholder="Contraseña" required="true"/>
              <p class="help-block text-danger"></p>
            </div>
          </div>
          <div class="col-md-6">
            <div class="form-group">
             <!-- <form:password path="contrasena" id="contrasena2" class="form-control" placeholder="Repita la contraseña"/> -->
             <input id="contrasena2" type="password" name="contrasena2" class="form-control" placeholder="Repita la contraseña" required="true">
              <p class="help-block text-danger"></p>
            </div>
          </div>
        </div>    

        <button id="submit" type="submit" class="btn btn-default">Registrar solicitud</button>
      </form:form>
    </div>
  </div>
</div>
<div id="social-section">
  <div class="container">
    <div class="social">
      <ul>
        <li><a href="#"><i class="fa fa-facebook"></i></a></li>
        <li><a href="#"><i class="fa fa-twitter"></i></a></li>
        <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
        <li><a href="#"><i class="fa fa-github"></i></a></li>
        <li><a href="#"><i class="fa fa-instagram"></i></a></li>
        <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
      </ul>
    </div>
  </div>
</div>
<div id="footer">
  <div class="container">
    <p>Copyright &copy; Optics. Designed by <a href="http://www.templatewire.com" rel="nofollow">TemplateWire</a></p>
  </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> 

<!-- Include all compiled plugins (below), or include individual files as needed --> 
<script type="text/javascript" src="resources/main/js/bootstrap.js"></script> 
<script type="text/javascript" src="resources/main/js/SmoothScroll.js"></script> 
<script type="text/javascript" src="resources/main/js/jquery.prettyPhoto.js"></script> 
<script type="text/javascript" src="resources/main/js/jquery.isotope.js"></script> 
<script type="text/javascript" src="resources/main/js/jqBootstrapValidation.js"></script> 
<!-- <script type="text/javascript" src="resources/main/js/estudiante.js"></script> -->




<!-- Javascripts
    ================================================== --> 
<script type="text/javascript" src="resources/main/js/main.js"></script>
</body>
</html>
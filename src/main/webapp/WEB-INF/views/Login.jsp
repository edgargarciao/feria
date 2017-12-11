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
    <!-- Theme style -->
    <link href="resources/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <!-- iCheck -->
    <link href="resources/js/iCheck/square/blue.css" rel="stylesheet" type="text/css" />

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>
  <body background="resources/fondo.jpg" >
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <div class="login-box">
      <div class="login-logo">
        <a><b>LOGIN</b>
      </div><!-- /.login-logo -->
      <div class="login-box-body">
        <p class="login-box-msg">Inicia sesion </p>

            <c:if test="${not empty wrong}">
                  <div class="alert alert-warning alert-dismissable">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    <h4><i class="icon fa fa-warning"></i> Error</h4>
                    <c:out value='${wrong}' />
                  </div>
              </c:if>
         <form:form action="autenticar" method="post" modelAttribute="login">
          <div class="form-group has-feedback">
            <form:input path="codigo" type="text" class="form-control" placeholder="1165409"/>                       
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
          </div>
          <div class="form-group has-feedback">
            <form:password path="contraseña" class="form-control" placeholder="Password1234"/>            
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
          </div>

          <div class="row">
          
          
            <div class="col-xs-12">  
                <div class="col-xs-15">
                  <a href="${contextPath}/index"> Volver Atrás</a>
                  <button type="submit" class="btn btn-success btn-block btn-flat">Sign In</button>
                </div><!-- /.col -->
            </div>

          </div>


        </form:form>

          
        <!--   
        <div class="social-auth-links text-center">
          <p>- OR -</p>
          <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Sign in using Facebook</a>
          <a href="#" class="btn btn-block btn-social btn-google-plus btn-flat"><i class="fa fa-google-plus"></i> Sign in using Google+</a>
        </div>



        <!--<a href="#">I forgot my password</a><br>
        <a href="register.html" class="text-center">Register a new membership</a>
        -->

      </div><!-- /.login-box-body -->
    </div><!-- /.login-box -->


    <!-- jQuery 2.1.3 -->
    <script src="https://code.jquery.com/jquery-2.1.3.min.js" type="text/javascript"></script>
    <!-- Bootstrap 3.3.2 JS -->
    <script src="resources/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- iCheck -->
    <script src="resources/js/iCheck/icheck.min.js" type="text/javascript"></script>
    <script>
      $(function () {
        $('input').iCheck({
          checkboxClass: 'icheckbox_square-blue',
          radioClass: 'iradio_square-blue',
          increaseArea: '20%' // optional
        });
      });
    </script>
  </body>
</html>
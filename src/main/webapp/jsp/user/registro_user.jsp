<%-- 
    Document   : registro_user
    Created on : 15-feb-2020, 16:06:54
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Registro</title>
        <link rel="icon" type="image/vnd.microsoft.icon" href="../../img/icono.png">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <link href="../../css/estilos.css" rel="stylesheet" type="text/css"/>
    </head>

    <nav class="navbar navbar-expand-lg">
        <div class="container">

            <a class="navbar-brand" href="../../index.jsp"><img src="../../img/Logo.png" alt="Logo" class="logo-brand"/></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"><img src="../../img/menu.png" alt="menu_bar"/></span>   
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active">
                        <a class="menu nav-link" href="../../index.jsp">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a class="menu nav-link" href="#">Contácta con nostros</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link btn btn-outline-secondary" href="../login.jsp" role="button">Iniciar sesión</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container espaciado">
        <form>
            <h1 class="text-center"><u>Registro</u></h1>
            <h2><small class="text-muted">Datos personales</small></h2>
            <div class="row">
                <div class="col-12">
                    <div class="form-group">
                        <label for="FormControlInput">Nombre completo</label>
                        <div class="row">
                            <div class="col">
                                <input type="text" class="form-control" id="nombre" placeholder="Nombre">
                            </div>
                            <div class="col">
                                <input type="text" class="form-control" id="apellidos" placeholder="Apellidos">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-6">
                    <div class="form-group">
                        <label for="FormControlInput">DNI</label>
                        <input type="text" class="form-control" id="dni" placeholder="Ej. 12345678A">
                    </div>
                </div>
                <div class="col-6">
                    <div class="form-group">
                        <label for="FormControlInput">Fecha de nacimiento</label>
                        <input class="form-control" type="date" value="2020-02-15" id="example-date-input">
                    </div>
                </div>
                <div class="col-12">
                    <div class="form-group">
                        <label for="FormControlInput">Dirección</label>
                        <input type="text" class="form-control" id="direccion" placeholder="Ej. Avenida de Madrid, 5">
                    </div>
                </div>
            </div>
            <h2><small class="text-muted">Datos de usuario</small></h2>
            <div class="row">
                <div class="col-6">
                    <div class="form-group">
                        <label for="FormControlInput">Usuario</label>
                        <input type="text" class="form-control" id="usuario" placeholder="Usuario">
                    </div>
                </div>
                <div class="col-6">
                    <div class="form-group">
                        <label for="FormControlInput">Correo electrónico</label>
                        <input type="text" class="form-control" id="email" placeholder="nombre@ejemplo.es">
                    </div>
                </div>
                <div class="col-12">
                    <div class="form-group">
                        <label for="FormControlInput">Contraseña</label>
                        <div class="row">
                            <div class="col">
                                <input type="text" class="form-control" placeholder="Contraseña">
                            </div>
                            <div class="col">
                                <input type="text" class="form-control" placeholder="Repite la contraseña">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="espMen">
                <!--para el formulario hace falta boton type="submit"-->
                <a class="eBoton btn btn-secondary btn-lg btn-block" href="../../index.jsp">Registrarse</a>
            </div>
        </form>
        
        <%@include file="../../WEB-INF/jspf/footer.jspf" %>

</html>

<%-- 
    Document   : login
    Created on : 15-feb-2020, 23:14:06
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Iniciar sesión</title>
        <link rel="icon" type="image/vnd.microsoft.icon" href="../img/icono.png">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <link href="../css/estilos.css" rel="stylesheet" type="text/css"/>
    </head>

    <nav class="navbar navbar-expand-lg">
        <div class="container">

            <a class="navbar-brand" href="../index.jsp"><img src="../img/Logo.png" alt="Logo" class="logo-brand"/></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"><img src="../img/menu.png" alt="menu_bar"/></span>   
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active">
                        <a class="menu nav-link" href="../index.jsp">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a class="menu nav-link" href="#">Contácta con nostros</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="user/registro_user.jsp">Registrarse</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <body>
        <div class="container espaciado">
            <form>
                <div class="form-group">
                    <h3 class="text-center"><label for="InputUser">Usuario</label></h3>
                    <input type="text" class="form-control" id="InputUser" aria-describedby="Usuario">
                </div>
                <div class="form-group">
                    <h3 class="text-center"><label for="exampleInputPassword1">Contraseña</label></h3>
                    <input type="password" class="form-control" id="InputPassword">
                </div>
                <!--para el formulario hace falta boton type="submit"-->
                <a class="eBoton btn btn-primary btn-lg btn-block espaciado" href="user/inicio_user.jsp">Iniciar sesión</a>
                <a class="eBoton btn btn-secondary btn-lg btn-block" href="admin/inicio_admin.jsp">Iniciar sesión veterinario</a>
            </form>
        </div>
        
        <%@include file="../WEB-INF/jspf/footer.jspf" %>
    </body>
</html>

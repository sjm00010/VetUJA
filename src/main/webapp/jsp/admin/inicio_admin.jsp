<%-- 
    Document   : inicio_admin
    Created on : 16-feb-2020, 12:26:15
    Author     : sjm00010
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>VetUJA</title>
        <link rel="icon" type="image/vnd.microsoft.icon" href="../../img/icono.png">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <link href="../../css/estilos.css" rel="stylesheet" type="text/css"/>
    </head>

    <%@include file="../../WEB-INF/jspf/cabecera_admin.jspf" %>

    <body>
        <main class="espaciado">
            <div class="container">
                <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#carousel" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel" data-slide-to="1"></li>
                        <li data-target="#carousel" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="../../img/carrusel1.png" class="d-block w-100" alt="noticia">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>Llega el coronavirus</h5>
                                <p>Protege a tu mascocota contra el coronavirus, consulta con nuestros especialistas.</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="../../img/carrusel2.png" class="d-block w-100" alt="noticia">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>Un equipo de profesionales</h5>
                                <p>En nuestra clínica tu mascota solo recibira los mejores cuidados.</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="../../img/carrusel3.png" class="d-block w-100" alt="noticia">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>¡Registrate!</h5>
                                <p color>Empieza a disfrutar de los servicios que tiene nuestra web.</p>
                            </div>
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>
        </main>   

        <%@include file="../../WEB-INF/jspf/footer.jspf" %>
    </body>
</html>
